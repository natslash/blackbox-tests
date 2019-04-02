package axoom.recordmetas.v1;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import axoom.recordmetas.v1.Recordmetas.RecordMeta;
import axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;

public class RecordmetasServiceTest {
  private GrpcCleanupRule grpcCleanup;

  @BeforeMethod
  public void setUp() {
    grpcCleanup = new GrpcCleanupRule();
  }

  @Test
  public void getLatestRecordMeta() {
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
    RecordMetaRequest request = RecordMetaRequest.newBuilder().setSubjectId("1").build(); 
    RecordMeta recordMeta =
        blockingStub.getLatest(request);
    assertEquals(true, recordMeta != null);
  }
}
