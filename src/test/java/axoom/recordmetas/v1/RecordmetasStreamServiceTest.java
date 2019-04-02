package axoom.recordmetas.v1;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.Iterator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import axoom.recordmetas.v1.Recordmetas.RecordMeta;
import axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest;
import axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest;
import axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;

public class RecordmetasStreamServiceTest {
  private GrpcCleanupRule grpcCleanup;

  @BeforeMethod
  public void setUp() {
    grpcCleanup = new GrpcCleanupRule();
  }


  @Test
  public void getRecordMetaStream() {
    // Generate a unique in-process server name.
    String serverName = InProcessServerBuilder.generateName();

    // Create a server, add service, start, and register for automatic graceful shutdown.
    try {
      grpcCleanup.register(InProcessServerBuilder.forName(serverName).directExecutor()
          .addService(new RecordMetasImpl()).build().start());
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Create a client channel and register for automatic graceful shutdown.
    RecordMetasGrpc.RecordMetasBlockingStub blockingStub = RecordMetasGrpc.newBlockingStub(
        grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

    Iterator<RecordMeta> recordMetas =
        blockingStub.getStream(RecordMetaStreamRequest.newBuilder().setSubscriptionId("1").build());
    assertEquals(true, recordMetas != null);
  }
  
  @Test
  public void getRecordMetaHistoricalList() {
    // Generate a unique in-process server name.
    String serverName = InProcessServerBuilder.generateName();

    // Create a server, add service, start, and register for automatic graceful shutdown.
    try {
      grpcCleanup.register(InProcessServerBuilder.forName(serverName).directExecutor()
          .addService(new RecordMetasImpl()).build().start());
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Create a client channel and register for automatic graceful shutdown.
    RecordMetasGrpc.RecordMetasBlockingStub blockingStub = RecordMetasGrpc.newBlockingStub(
        grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

    Iterator<RecordMeta> recordMetas =
        blockingStub.listHistorical(RecordMetaListRequest.newBuilder().setSubjectId("1").build());
    assertEquals(true, recordMetas != null);
  }
}
