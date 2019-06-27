package axoom.records.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: records/v1/records_service.proto")
public final class RecordsGrpc {

  private RecordsGrpc() {}

  public static final String SERVICE_NAME = "axoom.records.v1.Records";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest,
      axoom.records.v1.Records.RecordsSubscription> getCreateRecordsSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecordsSubscription",
      requestType = axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest.class,
      responseType = axoom.records.v1.Records.RecordsSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest,
      axoom.records.v1.Records.RecordsSubscription> getCreateRecordsSubscriptionMethod() {
    io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest, axoom.records.v1.Records.RecordsSubscription> getCreateRecordsSubscriptionMethod;
    if ((getCreateRecordsSubscriptionMethod = RecordsGrpc.getCreateRecordsSubscriptionMethod) == null) {
      synchronized (RecordsGrpc.class) {
        if ((getCreateRecordsSubscriptionMethod = RecordsGrpc.getCreateRecordsSubscriptionMethod) == null) {
          RecordsGrpc.getCreateRecordsSubscriptionMethod = getCreateRecordsSubscriptionMethod = 
              io.grpc.MethodDescriptor.<axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest, axoom.records.v1.Records.RecordsSubscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.records.v1.Records", "CreateRecordsSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Records.RecordsSubscription.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordsMethodDescriptorSupplier("CreateRecordsSubscription"))
                  .build();
          }
        }
     }
     return getCreateRecordsSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest,
      axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse> getListRecordsSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRecordsSubscriptions",
      requestType = axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest.class,
      responseType = axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest,
      axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse> getListRecordsSubscriptionsMethod() {
    io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest, axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse> getListRecordsSubscriptionsMethod;
    if ((getListRecordsSubscriptionsMethod = RecordsGrpc.getListRecordsSubscriptionsMethod) == null) {
      synchronized (RecordsGrpc.class) {
        if ((getListRecordsSubscriptionsMethod = RecordsGrpc.getListRecordsSubscriptionsMethod) == null) {
          RecordsGrpc.getListRecordsSubscriptionsMethod = getListRecordsSubscriptionsMethod = 
              io.grpc.MethodDescriptor.<axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest, axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.records.v1.Records", "ListRecordsSubscriptions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordsMethodDescriptorSupplier("ListRecordsSubscriptions"))
                  .build();
          }
        }
     }
     return getListRecordsSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.WatchRecordsRequest,
      axoom.records.v1.Records.Record> getWatchRecordsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WatchRecords",
      requestType = axoom.records.v1.RecordsService.WatchRecordsRequest.class,
      responseType = axoom.records.v1.Records.Record.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.WatchRecordsRequest,
      axoom.records.v1.Records.Record> getWatchRecordsMethod() {
    io.grpc.MethodDescriptor<axoom.records.v1.RecordsService.WatchRecordsRequest, axoom.records.v1.Records.Record> getWatchRecordsMethod;
    if ((getWatchRecordsMethod = RecordsGrpc.getWatchRecordsMethod) == null) {
      synchronized (RecordsGrpc.class) {
        if ((getWatchRecordsMethod = RecordsGrpc.getWatchRecordsMethod) == null) {
          RecordsGrpc.getWatchRecordsMethod = getWatchRecordsMethod = 
              io.grpc.MethodDescriptor.<axoom.records.v1.RecordsService.WatchRecordsRequest, axoom.records.v1.Records.Record>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.records.v1.Records", "WatchRecords"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.RecordsService.WatchRecordsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Records.Record.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordsMethodDescriptorSupplier("WatchRecords"))
                  .build();
          }
        }
     }
     return getWatchRecordsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecordsStub newStub(io.grpc.Channel channel) {
    return new RecordsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecordsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RecordsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecordsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RecordsFutureStub(channel);
  }

  /**
   */
  public static abstract class RecordsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateRecordsSubscription registers a RecordsSubscription for all Records of the requested SubjectType.
     * This RecordsSubscription should be used in WatchRecords.
     * </pre>
     */
    public void createRecordsSubscription(axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.RecordsSubscription> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRecordsSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListRecordsSubscriptions returns all active RecordsSubscription of the requesting client
     * </pre>
     */
    public void listRecordsSubscriptions(axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListRecordsSubscriptionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * WatchRecords returns an unbounded stream of Records matching the given Subscription. 
     * The stream closes automatically when the OAuth token expires and returns gRPC status `ResourceExhausted`.
     * Using the same Subscription from more processes leads to work stealing.
     * </pre>
     */
    public void watchRecords(axoom.records.v1.RecordsService.WatchRecordsRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record> responseObserver) {
      asyncUnimplementedUnaryCall(getWatchRecordsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateRecordsSubscriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest,
                axoom.records.v1.Records.RecordsSubscription>(
                  this, METHODID_CREATE_RECORDS_SUBSCRIPTION)))
          .addMethod(
            getListRecordsSubscriptionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest,
                axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse>(
                  this, METHODID_LIST_RECORDS_SUBSCRIPTIONS)))
          .addMethod(
            getWatchRecordsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.records.v1.RecordsService.WatchRecordsRequest,
                axoom.records.v1.Records.Record>(
                  this, METHODID_WATCH_RECORDS)))
          .build();
    }
  }

  /**
   */
  public static final class RecordsStub extends io.grpc.stub.AbstractStub<RecordsStub> {
    private RecordsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordsStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordsSubscription registers a RecordsSubscription for all Records of the requested SubjectType.
     * This RecordsSubscription should be used in WatchRecords.
     * </pre>
     */
    public void createRecordsSubscription(axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.RecordsSubscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRecordsSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListRecordsSubscriptions returns all active RecordsSubscription of the requesting client
     * </pre>
     */
    public void listRecordsSubscriptions(axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListRecordsSubscriptionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * WatchRecords returns an unbounded stream of Records matching the given Subscription. 
     * The stream closes automatically when the OAuth token expires and returns gRPC status `ResourceExhausted`.
     * Using the same Subscription from more processes leads to work stealing.
     * </pre>
     */
    public void watchRecords(axoom.records.v1.RecordsService.WatchRecordsRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getWatchRecordsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecordsBlockingStub extends io.grpc.stub.AbstractStub<RecordsBlockingStub> {
    private RecordsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordsSubscription registers a RecordsSubscription for all Records of the requested SubjectType.
     * This RecordsSubscription should be used in WatchRecords.
     * </pre>
     */
    public axoom.records.v1.Records.RecordsSubscription createRecordsSubscription(axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRecordsSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListRecordsSubscriptions returns all active RecordsSubscription of the requesting client
     * </pre>
     */
    public axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse listRecordsSubscriptions(axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListRecordsSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * WatchRecords returns an unbounded stream of Records matching the given Subscription. 
     * The stream closes automatically when the OAuth token expires and returns gRPC status `ResourceExhausted`.
     * Using the same Subscription from more processes leads to work stealing.
     * </pre>
     */
    public java.util.Iterator<axoom.records.v1.Records.Record> watchRecords(
        axoom.records.v1.RecordsService.WatchRecordsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getWatchRecordsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecordsFutureStub extends io.grpc.stub.AbstractStub<RecordsFutureStub> {
    private RecordsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordsSubscription registers a RecordsSubscription for all Records of the requested SubjectType.
     * This RecordsSubscription should be used in WatchRecords.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.records.v1.Records.RecordsSubscription> createRecordsSubscription(
        axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRecordsSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ListRecordsSubscriptions returns all active RecordsSubscription of the requesting client
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse> listRecordsSubscriptions(
        axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListRecordsSubscriptionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RECORDS_SUBSCRIPTION = 0;
  private static final int METHODID_LIST_RECORDS_SUBSCRIPTIONS = 1;
  private static final int METHODID_WATCH_RECORDS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecordsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecordsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RECORDS_SUBSCRIPTION:
          serviceImpl.createRecordsSubscription((axoom.records.v1.RecordsService.CreateRecordsSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<axoom.records.v1.Records.RecordsSubscription>) responseObserver);
          break;
        case METHODID_LIST_RECORDS_SUBSCRIPTIONS:
          serviceImpl.listRecordsSubscriptions((axoom.records.v1.RecordsService.ListRecordsSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<axoom.records.v1.RecordsService.ListRecordsSubscriptionsResponse>) responseObserver);
          break;
        case METHODID_WATCH_RECORDS:
          serviceImpl.watchRecords((axoom.records.v1.RecordsService.WatchRecordsRequest) request,
              (io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RecordsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecordsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.records.v1.RecordsService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Records");
    }
  }

  private static final class RecordsFileDescriptorSupplier
      extends RecordsBaseDescriptorSupplier {
    RecordsFileDescriptorSupplier() {}
  }

  private static final class RecordsMethodDescriptorSupplier
      extends RecordsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecordsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RecordsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecordsFileDescriptorSupplier())
              .addMethod(getCreateRecordsSubscriptionMethod())
              .addMethod(getListRecordsSubscriptionsMethod())
              .addMethod(getWatchRecordsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
