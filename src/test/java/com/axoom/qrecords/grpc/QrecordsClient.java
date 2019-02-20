package com.axoom.qrecords.grpc;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.axoom.qrecords.Qrecords;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class QrecordsClient {
  private static final Logger logger = Logger.getLogger(QrecordsClient.class.getName());
  
  private final ManagedChannel channel;
  private final QRecordsGrpc.QRecordsBlockingStub blockingStub;

  /** Construct client connecting to Qrecords server at {@code host:port}. */
  public QrecordsClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext().build());    
  }

  /** Construct client for accessing Qrecords server using the existing channel. */
  QrecordsClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = QRecordsGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }


  public void getRecordStream() {

    Qrecords.RecordStreamRequest request = Qrecords.RecordStreamRequest.newBuilder().build();
    Iterator<Qrecords.QRecord> response;
    try {
      response = blockingStub.getStream(request);
      while (response.hasNext()) {
        System.out.println(response.next().getPayload());
      }
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
  }

  public static void main(String[] args) throws Exception {
    QrecordsClient client = new QrecordsClient("qrecords.dev.myaxoom.com", 443);
    try {
      client.getRecordStream();
    } finally {
      client.shutdown();
    }
  }
}
