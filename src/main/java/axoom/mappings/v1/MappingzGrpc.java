package axoom.mappings.v1;

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
    comments = "Source: mappingz_service.proto")
public final class MappingzGrpc {

  private MappingzGrpc() {}

  public static final String SERVICE_NAME = "axoom.mappingz.v1.Mappingz";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.CreateMappingRequest,
      axoom.mappings.v1.MappingzService.CreateMappingResponse> getCreateMappingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMapping",
      requestType = axoom.mappings.v1.MappingzService.CreateMappingRequest.class,
      responseType = axoom.mappings.v1.MappingzService.CreateMappingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.CreateMappingRequest,
      axoom.mappings.v1.MappingzService.CreateMappingResponse> getCreateMappingMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.CreateMappingRequest, axoom.mappings.v1.MappingzService.CreateMappingResponse> getCreateMappingMethod;
    if ((getCreateMappingMethod = MappingzGrpc.getCreateMappingMethod) == null) {
      synchronized (MappingzGrpc.class) {
        if ((getCreateMappingMethod = MappingzGrpc.getCreateMappingMethod) == null) {
          MappingzGrpc.getCreateMappingMethod = getCreateMappingMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingzService.CreateMappingRequest, axoom.mappings.v1.MappingzService.CreateMappingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappingz.v1.Mappingz", "CreateMapping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingzService.CreateMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingzService.CreateMappingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingzMethodDescriptorSupplier("CreateMapping"))
                  .build();
          }
        }
     }
     return getCreateMappingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.MappingStreamRequest,
      axoom.mappings.v1.MappingzService.MappingEvent> getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = axoom.mappings.v1.MappingzService.MappingStreamRequest.class,
      responseType = axoom.mappings.v1.MappingzService.MappingEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.MappingStreamRequest,
      axoom.mappings.v1.MappingzService.MappingEvent> getGetStreamMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.MappingStreamRequest, axoom.mappings.v1.MappingzService.MappingEvent> getGetStreamMethod;
    if ((getGetStreamMethod = MappingzGrpc.getGetStreamMethod) == null) {
      synchronized (MappingzGrpc.class) {
        if ((getGetStreamMethod = MappingzGrpc.getGetStreamMethod) == null) {
          MappingzGrpc.getGetStreamMethod = getGetStreamMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingzService.MappingStreamRequest, axoom.mappings.v1.MappingzService.MappingEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappingz.v1.Mappingz", "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingzService.MappingStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingzService.MappingEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingzMethodDescriptorSupplier("GetStream"))
                  .build();
          }
        }
     }
     return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.MappingListRequest,
      axoom.mappings.v1.MappingzService.MappingListResponse> getGetAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAll",
      requestType = axoom.mappings.v1.MappingzService.MappingListRequest.class,
      responseType = axoom.mappings.v1.MappingzService.MappingListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.MappingListRequest,
      axoom.mappings.v1.MappingzService.MappingListResponse> getGetAllMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.MappingListRequest, axoom.mappings.v1.MappingzService.MappingListResponse> getGetAllMethod;
    if ((getGetAllMethod = MappingzGrpc.getGetAllMethod) == null) {
      synchronized (MappingzGrpc.class) {
        if ((getGetAllMethod = MappingzGrpc.getGetAllMethod) == null) {
          MappingzGrpc.getGetAllMethod = getGetAllMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingzService.MappingListRequest, axoom.mappings.v1.MappingzService.MappingListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappingz.v1.Mappingz", "GetAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingzService.MappingListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingzService.MappingListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingzMethodDescriptorSupplier("GetAll"))
                  .build();
          }
        }
     }
     return getGetAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.GetRequest,
      axoom.mappings.v1.MappingzService.GetResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = axoom.mappings.v1.MappingzService.GetRequest.class,
      responseType = axoom.mappings.v1.MappingzService.GetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.GetRequest,
      axoom.mappings.v1.MappingzService.GetResponse> getGetMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingzService.GetRequest, axoom.mappings.v1.MappingzService.GetResponse> getGetMethod;
    if ((getGetMethod = MappingzGrpc.getGetMethod) == null) {
      synchronized (MappingzGrpc.class) {
        if ((getGetMethod = MappingzGrpc.getGetMethod) == null) {
          MappingzGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingzService.GetRequest, axoom.mappings.v1.MappingzService.GetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappingz.v1.Mappingz", "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingzService.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingzService.GetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingzMethodDescriptorSupplier("Get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MappingzStub newStub(io.grpc.Channel channel) {
    return new MappingzStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MappingzBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MappingzBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MappingzFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MappingzFutureStub(channel);
  }

  /**
   */
  public static abstract class MappingzImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateMapping creates the given Mapping
     * If there is a mapping ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createMapping(axoom.mappings.v1.MappingzService.CreateMappingRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.CreateMappingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMappingMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded mapping event stream. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.mappings.v1.MappingzService.MappingStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.MappingEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetAll returns all known mappings.
     * </pre>
     */
    public void getAll(axoom.mappings.v1.MappingzService.MappingListRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.MappingListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get returns the requested Mapping
     * </pre>
     */
    public void get(axoom.mappings.v1.MappingzService.GetRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.GetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMappingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingzService.CreateMappingRequest,
                axoom.mappings.v1.MappingzService.CreateMappingResponse>(
                  this, METHODID_CREATE_MAPPING)))
          .addMethod(
            getGetStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingzService.MappingStreamRequest,
                axoom.mappings.v1.MappingzService.MappingEvent>(
                  this, METHODID_GET_STREAM)))
          .addMethod(
            getGetAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingzService.MappingListRequest,
                axoom.mappings.v1.MappingzService.MappingListResponse>(
                  this, METHODID_GET_ALL)))
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingzService.GetRequest,
                axoom.mappings.v1.MappingzService.GetResponse>(
                  this, METHODID_GET)))
          .build();
    }
  }

  /**
   */
  public static final class MappingzStub extends io.grpc.stub.AbstractStub<MappingzStub> {
    private MappingzStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MappingzStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MappingzStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MappingzStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateMapping creates the given Mapping
     * If there is a mapping ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createMapping(axoom.mappings.v1.MappingzService.CreateMappingRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.CreateMappingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMappingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded mapping event stream. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.mappings.v1.MappingzService.MappingStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.MappingEvent> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetAll returns all known mappings.
     * </pre>
     */
    public void getAll(axoom.mappings.v1.MappingzService.MappingListRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.MappingListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get returns the requested Mapping
     * </pre>
     */
    public void get(axoom.mappings.v1.MappingzService.GetRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.GetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MappingzBlockingStub extends io.grpc.stub.AbstractStub<MappingzBlockingStub> {
    private MappingzBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MappingzBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MappingzBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MappingzBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateMapping creates the given Mapping
     * If there is a mapping ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public axoom.mappings.v1.MappingzService.CreateMappingResponse createMapping(axoom.mappings.v1.MappingzService.CreateMappingRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMappingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetStream returns an unbounded mapping event stream. The stream endures at max. 30 min.
     * </pre>
     */
    public java.util.Iterator<axoom.mappings.v1.MappingzService.MappingEvent> getStream(
        axoom.mappings.v1.MappingzService.MappingStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetAll returns all known mappings.
     * </pre>
     */
    public axoom.mappings.v1.MappingzService.MappingListResponse getAll(axoom.mappings.v1.MappingzService.MappingListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get returns the requested Mapping
     * </pre>
     */
    public axoom.mappings.v1.MappingzService.GetResponse get(axoom.mappings.v1.MappingzService.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MappingzFutureStub extends io.grpc.stub.AbstractStub<MappingzFutureStub> {
    private MappingzFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MappingzFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MappingzFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MappingzFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateMapping creates the given Mapping
     * If there is a mapping ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.mappings.v1.MappingzService.CreateMappingResponse> createMapping(
        axoom.mappings.v1.MappingzService.CreateMappingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMappingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetAll returns all known mappings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.mappings.v1.MappingzService.MappingListResponse> getAll(
        axoom.mappings.v1.MappingzService.MappingListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get returns the requested Mapping
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.mappings.v1.MappingzService.GetResponse> get(
        axoom.mappings.v1.MappingzService.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MAPPING = 0;
  private static final int METHODID_GET_STREAM = 1;
  private static final int METHODID_GET_ALL = 2;
  private static final int METHODID_GET = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MappingzImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MappingzImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_MAPPING:
          serviceImpl.createMapping((axoom.mappings.v1.MappingzService.CreateMappingRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.CreateMappingResponse>) responseObserver);
          break;
        case METHODID_GET_STREAM:
          serviceImpl.getStream((axoom.mappings.v1.MappingzService.MappingStreamRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.MappingEvent>) responseObserver);
          break;
        case METHODID_GET_ALL:
          serviceImpl.getAll((axoom.mappings.v1.MappingzService.MappingListRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.MappingListResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((axoom.mappings.v1.MappingzService.GetRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingzService.GetResponse>) responseObserver);
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

  private static abstract class MappingzBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MappingzBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.mappings.v1.MappingzService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Mappingz");
    }
  }

  private static final class MappingzFileDescriptorSupplier
      extends MappingzBaseDescriptorSupplier {
    MappingzFileDescriptorSupplier() {}
  }

  private static final class MappingzMethodDescriptorSupplier
      extends MappingzBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MappingzMethodDescriptorSupplier(String methodName) {
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
      synchronized (MappingzGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MappingzFileDescriptorSupplier())
              .addMethod(getCreateMappingMethod())
              .addMethod(getGetStreamMethod())
              .addMethod(getGetAllMethod())
              .addMethod(getGetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
