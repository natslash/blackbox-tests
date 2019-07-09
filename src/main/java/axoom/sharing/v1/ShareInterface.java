package axoom.sharing.v1;

import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;

public interface ShareInterface {

  public void shutdown() throws InterruptedException;
  
  public GeneratedMessageV3 createShare(GeneratedMessageV3 share);
  
  public Empty deleteShare(GeneratedMessageV3 share);  
}
