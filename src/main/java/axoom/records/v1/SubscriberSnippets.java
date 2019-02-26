package axoom.records.v1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.pubsub.v1.stub.GrpcSubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.ReceivedMessage;

/** This class contains snippets for the {@link Subscriber} interface. */
public class SubscriberSnippets {

  private final ProjectSubscriptionName subscriptionName;

  private final MessageReceiver receiver;

  private final ApiFuture<Void> done;

  public SubscriberSnippets(ProjectSubscriptionName subscriptionName, MessageReceiver receiver,
      ApiFuture<Void> done) {
    this.subscriptionName = subscriptionName;
    this.receiver = receiver;
    this.done = done;
  }

  // [TARGET startAsync()]
  public void startAndWait() throws Exception {
    Subscriber subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
    ExecutorService pool = Executors.newCachedThreadPool();
    subscriber.addListener(new Subscriber.Listener() {
      public void failed(Subscriber.State from, Throwable failure) {
        // Handle error.
      }
    }, pool);
    subscriber.startAsync();

    // Wait for a stop signal.
    // In a server, this might be a signal to stop serving.
    // In this example, the signal is just a dummy Future.
    //
    // By default, Subscriber uses daemon threads (see
    // https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html).
    // Consequently, once other threads have terminated, Subscriber will not stop the JVM from
    // exiting.
    // If the Subscriber should simply run forever, either use the setExecutorProvider method in
    // Subscriber.Builder
    // to use non-daemon threads or run
    // for (;;) {
    // Thread.sleep(Long.MAX_VALUE);
    // }
    // at the end of main() to previent the main thread from exiting.
    done.get();
    pool.shutdown();
    subscriber.stopAsync().awaitTerminated();
  }

  private static void createSubscriber(String projectId, String subscriptionId) throws Exception {
    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);
    // Instantiate an asynchronous message receiver
    MessageReceiver receiver = new MessageReceiver() {
      @Override
      public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
        // handle incoming message, then ack/nack the received message
        System.out.println("Id : " + message.getMessageId());
        System.out.println("Data : " + message.getData().toStringUtf8());
        consumer.ack();
      }
    };

    Subscriber subscriber = null;
    try {
      // Create a subscriber for "my-subscription-id" bound to the message receiver
      subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
      subscriber.startAsync();
      // ...
    } finally {
      // stop receiving messages
      if (subscriber != null) {
        subscriber.stopAsync();
      }
    }
    // [END pubsub_subscriber_async_pull]
  }

  private Subscriber createSubscriberWithErrorListener(Subscriber subscriber) throws Exception {
    // [START pubsub_subscriber_error_listener]
    subscriber.addListener(new Subscriber.Listener() {
      public void failed(Subscriber.State from, Throwable failure) {
        // Handle error.
      }
    }, MoreExecutors.directExecutor());
    // [END pubsub_subscriber_error_listener]
    return subscriber;
  }

  private Subscriber createSingleThreadedSubscriber() throws Exception {
    // [START pubsub_subscriber_concurrency_control]
    // provide a separate executor service for polling
    ExecutorProvider executorProvider =
        InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build();

    Subscriber subscriber = Subscriber.newBuilder(subscriptionName, receiver)
        .setExecutorProvider(executorProvider).build();
    // [END pubsub_subscriber_concurrency_control]
    return subscriber;
  }

  private Subscriber createSubscriberWithCustomFlowSettings() throws Exception {
    // [START pubsub_subscriber_flow_settings]
    FlowControlSettings flowControlSettings =
        FlowControlSettings.newBuilder().setMaxOutstandingElementCount(10_000L)
            .setMaxOutstandingRequestBytes(1_000_000_000L).build();
    Subscriber subscriber = Subscriber.newBuilder(subscriptionName, receiver)
        .setFlowControlSettings(flowControlSettings).build();
    // [END pubsub_subscriber_flow_settings]
    return subscriber;
  }

  private Subscriber createSubscriberWithCustomCredentials() throws Exception {
    // [START pubsub_subscriber_custom_credentials]
    CredentialsProvider credentialsProvider = FixedCredentialsProvider
        .create(ServiceAccountCredentials.fromStream(new FileInputStream("credentials.json")));

    Subscriber subscriber = Subscriber.newBuilder(subscriptionName, receiver)
        .setCredentialsProvider(credentialsProvider).build();
    // [END pubsub_subscriber_custom_credentials]
    return subscriber;
  }

  static List<ReceivedMessage> createSubscriberWithSyncPull(String projectId, String subscriptionId,
      int numOfMessages) throws Exception {
    // [START pubsub_subscriber_sync_pull]
    SubscriberStubSettings subscriberStubSettings = SubscriberStubSettings.newBuilder()
        .setTransportChannelProvider(SubscriberStubSettings.defaultGrpcTransportProviderBuilder()
            .setMaxInboundMessageSize(20 << 20) // 20MB
            .build())
        .build();

    try (SubscriberStub subscriber = GrpcSubscriberStub.create(subscriberStubSettings)) {
      // String projectId = "my-project-id";
      // String subscriptionId = "my-subscription-id";
      // int numOfMessages = 10; // max number of messages to be pulled
      String subscriptionName = ProjectSubscriptionName.format(projectId, subscriptionId);
      PullRequest pullRequest =
          PullRequest.newBuilder().setMaxMessages(numOfMessages).setReturnImmediately(false) // return
                                                                                             // immediately
                                                                                             // if
                                                                                             // messages
                                                                                             // are
                                                                                             // not
                                                                                             // available
              .setSubscription(subscriptionName).build();

      // use pullCallable().futureCall to asynchronously perform this operation
      PullResponse pullResponse = subscriber.pullCallable().call(pullRequest);
      List<String> ackIds = new ArrayList<>();
      for (ReceivedMessage message : pullResponse.getReceivedMessagesList()) {
        // handle received message
        // ...
        ackIds.add(message.getAckId());
      }
      // acknowledge received messages
      AcknowledgeRequest acknowledgeRequest = AcknowledgeRequest.newBuilder()
          .setSubscription(subscriptionName).addAllAckIds(ackIds).build();
      // use acknowledgeCallable().futureCall to asynchronously perform this operation
      subscriber.acknowledgeCallable().call(acknowledgeRequest);
      return pullResponse.getReceivedMessagesList();
    }
    // [END pubsub_subscriber_sync_pull]
  }

  public static List<ReceivedMessage> synchronousPull(String projectId, String subscriptionId,
      int numOfMessages) {
    SubscriberStubSettings subscriberStubSettings;
    try {
      subscriberStubSettings = SubscriberStubSettings.newBuilder()
          .setTransportChannelProvider(SubscriberStubSettings.defaultGrpcTransportProviderBuilder()
              .setMaxInboundMessageSize(20 << 20) // 20MB
              .build())
          .build();

      try (SubscriberStub subscriber = GrpcSubscriberStub.create(subscriberStubSettings)) {
        // String projectId = "my-project-id";
        // String subscriptionId = "my-subscription-id";
        // int numOfMessages = 10; // max number of messages to be pulled
        String subscriptionName = ProjectSubscriptionName.format(projectId, subscriptionId);
        PullRequest pullRequest =
            PullRequest.newBuilder().setMaxMessages(numOfMessages).setReturnImmediately(false) // return
                                                                                               // immediately
                                                                                               // if
                                                                                               // messages
                                                                                               // are
                                                                                               // not
                                                                                               // available
                .setSubscription(subscriptionName).build();

        // use pullCallable().futureCall to asynchronously perform this operation
        PullResponse pullResponse = subscriber.pullCallable().call(pullRequest);
        List<String> ackIds = new ArrayList<>();
        for (ReceivedMessage message : pullResponse.getReceivedMessagesList()) {
          // handle received message
          // ...
          ackIds.add(message.getAckId());
        }
        // acknowledge received messages
        AcknowledgeRequest acknowledgeRequest = AcknowledgeRequest.newBuilder()
            .setSubscription(subscriptionName).addAllAckIds(ackIds).build();
        // use acknowledgeCallable().futureCall to asynchronously perform this operation
        subscriber.acknowledgeCallable().call(acknowledgeRequest);
        return pullResponse.getReceivedMessagesList();
      }
    } catch (IOException e) {      
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    try {
      createSubscriber("mvp-iotcore-eval", "blackboxtest01-shovel");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
