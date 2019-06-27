package axoom.recordmetas.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: recordmetas/v1/recordmetas_service.proto")
public final class RecordMetasGrpc {

  private RecordMetasGrpc() {}

  public static final String SERVICE_NAME = "axoom.recordmetas.v1.RecordMetas";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getCreateRecordMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecordMeta",
      requestType = axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest.class,
      responseType = axoom.recordmetas.v1.Recordmetas.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getCreateRecordMetaMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta> getCreateRecordMetaMethod;
    if ((getCreateRecordMetaMethod = RecordMetasGrpc.getCreateRecordMetaMethod) == null) {
      synchronized (RecordMetasGrpc.class) {
        if ((getCreateRecordMetaMethod = RecordMetasGrpc.getCreateRecordMetaMethod) == null) {
          RecordMetasGrpc.getCreateRecordMetaMethod = getCreateRecordMetaMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetas.v1.RecordMetas", "CreateRecordMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.Recordmetas.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetasMethodDescriptorSupplier("CreateRecordMeta"))
                  .build();
          }
        }
     }
     return getCreateRecordMetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetLatestRecordMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatestRecordMeta",
      requestType = axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest.class,
      responseType = axoom.recordmetas.v1.Recordmetas.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetLatestRecordMetaMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetLatestRecordMetaMethod;
    if ((getGetLatestRecordMetaMethod = RecordMetasGrpc.getGetLatestRecordMetaMethod) == null) {
      synchronized (RecordMetasGrpc.class) {
        if ((getGetLatestRecordMetaMethod = RecordMetasGrpc.getGetLatestRecordMetaMethod) == null) {
          RecordMetasGrpc.getGetLatestRecordMetaMethod = getGetLatestRecordMetaMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetas.v1.RecordMetas", "GetLatestRecordMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.Recordmetas.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetasMethodDescriptorSupplier("GetLatestRecordMeta"))
                  .build();
          }
        }
     }
     return getGetLatestRecordMetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetRecordMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecordMeta",
      requestType = axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest.class,
      responseType = axoom.recordmetas.v1.Recordmetas.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetRecordMetaMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetRecordMetaMethod;
    if ((getGetRecordMetaMethod = RecordMetasGrpc.getGetRecordMetaMethod) == null) {
      synchronized (RecordMetasGrpc.class) {
        if ((getGetRecordMetaMethod = RecordMetasGrpc.getGetRecordMetaMethod) == null) {
          RecordMetasGrpc.getGetRecordMetaMethod = getGetRecordMetaMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetas.v1.RecordMetas", "GetRecordMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.Recordmetas.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetasMethodDescriptorSupplier("GetRecordMeta"))
                  .build();
          }
        }
     }
     return getGetRecordMetaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecordMetasStub newStub(io.grpc.Channel channel) {
    return new RecordMetasStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecordMetasBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RecordMetasBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecordMetasFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RecordMetasFutureStub(channel);
  }

  /**
   */
  public static abstract class RecordMetasImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateRecordMeta creates a new RecordMeta with the given Data for the given Subject
     * </pre>
     */
    public void createRecordMeta(axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRecordMetaMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetLatestRecordMeta returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public void getLatestRecordMeta(axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLatestRecordMetaMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetRecordMeta returns the requested RecordMeta
     * </pre>
     */
    public void getRecordMeta(axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRecordMetaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateRecordMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest,
                axoom.recordmetas.v1.Recordmetas.RecordMeta>(
                  this, METHODID_CREATE_RECORD_META)))
          .addMethod(
            getGetLatestRecordMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest,
                axoom.recordmetas.v1.Recordmetas.RecordMeta>(
                  this, METHODID_GET_LATEST_RECORD_META)))
          .addMethod(
            getGetRecordMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest,
                axoom.recordmetas.v1.Recordmetas.RecordMeta>(
                  this, METHODID_GET_RECORD_META)))
          .build();
    }
  }

  /**
   */
  public static final class RecordMetasStub extends io.grpc.stub.AbstractStub<RecordMetasStub> {
    private RecordMetasStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordMetasStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordMetasStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordMetasStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordMeta creates a new RecordMeta with the given Data for the given Subject
     * </pre>
     */
    public void createRecordMeta(axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRecordMetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetLatestRecordMeta returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public void getLatestRecordMeta(axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLatestRecordMetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetRecordMeta returns the requested RecordMeta
     * </pre>
     */
    public void getRecordMeta(axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRecordMetaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecordMetasBlockingStub extends io.grpc.stub.AbstractStub<RecordMetasBlockingStub> {
    private RecordMetasBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordMetasBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordMetasBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordMetasBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordMeta creates a new RecordMeta with the given Data for the given Subject
     * </pre>
     */
    public axoom.recordmetas.v1.Recordmetas.RecordMeta createRecordMeta(axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRecordMetaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetLatestRecordMeta returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public axoom.recordmetas.v1.Recordmetas.RecordMeta getLatestRecordMeta(axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLatestRecordMetaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetRecordMeta returns the requested RecordMeta
     * </pre>
     */
    public axoom.recordmetas.v1.Recordmetas.RecordMeta getRecordMeta(axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRecordMetaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecordMetasFutureStub extends io.grpc.stub.AbstractStub<RecordMetasFutureStub> {
    private RecordMetasFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordMetasFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordMetasFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordMetasFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordMeta creates a new RecordMeta with the given Data for the given Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetas.v1.Recordmetas.RecordMeta> createRecordMeta(
        axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRecordMetaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetLatestRecordMeta returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetas.v1.Recordmetas.RecordMeta> getLatestRecordMeta(
        axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLatestRecordMetaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetRecordMeta returns the requested RecordMeta
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetas.v1.Recordmetas.RecordMeta> getRecordMeta(
        axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRecordMetaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RECORD_META = 0;
  private static final int METHODID_GET_LATEST_RECORD_META = 1;
  private static final int METHODID_GET_RECORD_META = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecordMetasImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecordMetasImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RECORD_META:
          serviceImpl.createRecordMeta((axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta>) responseObserver);
          break;
        case METHODID_GET_LATEST_RECORD_META:
          serviceImpl.getLatestRecordMeta((axoom.recordmetas.v1.RecordmetasService.GetLatestRecordMetaRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta>) responseObserver);
          break;
        case METHODID_GET_RECORD_META:
          serviceImpl.getRecordMeta((axoom.recordmetas.v1.RecordmetasService.GetRecordMetaRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta>) responseObserver);
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

  private static abstract class RecordMetasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecordMetasBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.recordmetas.v1.RecordmetasService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecordMetas");
    }
  }

  private static final class RecordMetasFileDescriptorSupplier
      extends RecordMetasBaseDescriptorSupplier {
    RecordMetasFileDescriptorSupplier() {}
  }

  private static final class RecordMetasMethodDescriptorSupplier
      extends RecordMetasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecordMetasMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecordMetasGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecordMetasFileDescriptorSupplier())
              .addMethod(getCreateRecordMetaMethod())
              .addMethod(getGetLatestRecordMetaMethod())
              .addMethod(getGetRecordMetaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
