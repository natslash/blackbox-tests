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
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: mappings_service.proto")
public final class MappingsGrpc {

  private MappingsGrpc() {}

  public static final String SERVICE_NAME = "axoom.mappings.v1.Mappings";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.CreateMappingRequest,
      axoom.mappings.v1.MappingsService.CreateMappingResponse> getCreateMappingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMapping",
      requestType = axoom.mappings.v1.MappingsService.CreateMappingRequest.class,
      responseType = axoom.mappings.v1.MappingsService.CreateMappingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.CreateMappingRequest,
      axoom.mappings.v1.MappingsService.CreateMappingResponse> getCreateMappingMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.CreateMappingRequest, axoom.mappings.v1.MappingsService.CreateMappingResponse> getCreateMappingMethod;
    if ((getCreateMappingMethod = MappingsGrpc.getCreateMappingMethod) == null) {
      synchronized (MappingsGrpc.class) {
        if ((getCreateMappingMethod = MappingsGrpc.getCreateMappingMethod) == null) {
          MappingsGrpc.getCreateMappingMethod = getCreateMappingMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingsService.CreateMappingRequest, axoom.mappings.v1.MappingsService.CreateMappingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappings.v1.Mappings", "CreateMapping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.CreateMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.CreateMappingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingsMethodDescriptorSupplier("CreateMapping"))
                  .build();
          }
        }
     }
     return getCreateMappingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.MappingStreamRequest,
      axoom.mappings.v1.MappingsService.MappingEvent> getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = axoom.mappings.v1.MappingsService.MappingStreamRequest.class,
      responseType = axoom.mappings.v1.MappingsService.MappingEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.MappingStreamRequest,
      axoom.mappings.v1.MappingsService.MappingEvent> getGetStreamMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.MappingStreamRequest, axoom.mappings.v1.MappingsService.MappingEvent> getGetStreamMethod;
    if ((getGetStreamMethod = MappingsGrpc.getGetStreamMethod) == null) {
      synchronized (MappingsGrpc.class) {
        if ((getGetStreamMethod = MappingsGrpc.getGetStreamMethod) == null) {
          MappingsGrpc.getGetStreamMethod = getGetStreamMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingsService.MappingStreamRequest, axoom.mappings.v1.MappingsService.MappingEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappings.v1.Mappings", "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.MappingStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.MappingEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingsMethodDescriptorSupplier("GetStream"))
                  .build();
          }
        }
     }
     return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.MappingListRequest,
      axoom.mappings.v1.MappingsService.MappingListResponse> getGetAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAll",
      requestType = axoom.mappings.v1.MappingsService.MappingListRequest.class,
      responseType = axoom.mappings.v1.MappingsService.MappingListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.MappingListRequest,
      axoom.mappings.v1.MappingsService.MappingListResponse> getGetAllMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.MappingListRequest, axoom.mappings.v1.MappingsService.MappingListResponse> getGetAllMethod;
    if ((getGetAllMethod = MappingsGrpc.getGetAllMethod) == null) {
      synchronized (MappingsGrpc.class) {
        if ((getGetAllMethod = MappingsGrpc.getGetAllMethod) == null) {
          MappingsGrpc.getGetAllMethod = getGetAllMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingsService.MappingListRequest, axoom.mappings.v1.MappingsService.MappingListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappings.v1.Mappings", "GetAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.MappingListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.MappingListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingsMethodDescriptorSupplier("GetAll"))
                  .build();
          }
        }
     }
     return getGetAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.GetRequest,
      axoom.mappings.v1.MappingsService.GetResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = axoom.mappings.v1.MappingsService.GetRequest.class,
      responseType = axoom.mappings.v1.MappingsService.GetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.GetRequest,
      axoom.mappings.v1.MappingsService.GetResponse> getGetMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.GetRequest, axoom.mappings.v1.MappingsService.GetResponse> getGetMethod;
    if ((getGetMethod = MappingsGrpc.getGetMethod) == null) {
      synchronized (MappingsGrpc.class) {
        if ((getGetMethod = MappingsGrpc.getGetMethod) == null) {
          MappingsGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingsService.GetRequest, axoom.mappings.v1.MappingsService.GetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappings.v1.Mappings", "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.GetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingsMethodDescriptorSupplier("Get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MappingsStub newStub(io.grpc.Channel channel) {
    return new MappingsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MappingsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MappingsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MappingsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MappingsFutureStub(channel);
  }

  /**
   */
  public static abstract class MappingsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateMapping creates the given Mapping
     * If there is a mapping ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createMapping(axoom.mappings.v1.MappingsService.CreateMappingRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.CreateMappingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMappingMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded mapping event stream. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.mappings.v1.MappingsService.MappingStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.MappingEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetAll returns all known mappings.
     * </pre>
     */
    public void getAll(axoom.mappings.v1.MappingsService.MappingListRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.MappingListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get returns the requested Mapping
     * </pre>
     */
    public void get(axoom.mappings.v1.MappingsService.GetRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.GetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMappingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingsService.CreateMappingRequest,
                axoom.mappings.v1.MappingsService.CreateMappingResponse>(
                  this, METHODID_CREATE_MAPPING)))
          .addMethod(
            getGetStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingsService.MappingStreamRequest,
                axoom.mappings.v1.MappingsService.MappingEvent>(
                  this, METHODID_GET_STREAM)))
          .addMethod(
            getGetAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingsService.MappingListRequest,
                axoom.mappings.v1.MappingsService.MappingListResponse>(
                  this, METHODID_GET_ALL)))
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingsService.GetRequest,
                axoom.mappings.v1.MappingsService.GetResponse>(
                  this, METHODID_GET)))
          .build();
    }
  }

  /**
   */
  public static final class MappingsStub extends io.grpc.stub.AbstractStub<MappingsStub> {
    private MappingsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MappingsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MappingsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MappingsStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateMapping creates the given Mapping
     * If there is a mapping ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createMapping(axoom.mappings.v1.MappingsService.CreateMappingRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.CreateMappingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMappingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded mapping event stream. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.mappings.v1.MappingsService.MappingStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.MappingEvent> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetAll returns all known mappings.
     * </pre>
     */
    public void getAll(axoom.mappings.v1.MappingsService.MappingListRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.MappingListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get returns the requested Mapping
     * </pre>
     */
    public void get(axoom.mappings.v1.MappingsService.GetRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.GetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MappingsBlockingStub extends io.grpc.stub.AbstractStub<MappingsBlockingStub> {
    private MappingsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MappingsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MappingsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MappingsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateMapping creates the given Mapping
     * If there is a mapping ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public axoom.mappings.v1.MappingsService.CreateMappingResponse createMapping(axoom.mappings.v1.MappingsService.CreateMappingRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMappingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetStream returns an unbounded mapping event stream. The stream endures at max. 30 min.
     * </pre>
     */
    public java.util.Iterator<axoom.mappings.v1.MappingsService.MappingEvent> getStream(
        axoom.mappings.v1.MappingsService.MappingStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetAll returns all known mappings.
     * </pre>
     */
    public axoom.mappings.v1.MappingsService.MappingListResponse getAll(axoom.mappings.v1.MappingsService.MappingListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get returns the requested Mapping
     * </pre>
     */
    public axoom.mappings.v1.MappingsService.GetResponse get(axoom.mappings.v1.MappingsService.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MappingsFutureStub extends io.grpc.stub.AbstractStub<MappingsFutureStub> {
    private MappingsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MappingsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MappingsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MappingsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateMapping creates the given Mapping
     * If there is a mapping ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.mappings.v1.MappingsService.CreateMappingResponse> createMapping(
        axoom.mappings.v1.MappingsService.CreateMappingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMappingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetAll returns all known mappings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.mappings.v1.MappingsService.MappingListResponse> getAll(
        axoom.mappings.v1.MappingsService.MappingListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get returns the requested Mapping
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.mappings.v1.MappingsService.GetResponse> get(
        axoom.mappings.v1.MappingsService.GetRequest request) {
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
    private final MappingsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MappingsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_MAPPING:
          serviceImpl.createMapping((axoom.mappings.v1.MappingsService.CreateMappingRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.CreateMappingResponse>) responseObserver);
          break;
        case METHODID_GET_STREAM:
          serviceImpl.getStream((axoom.mappings.v1.MappingsService.MappingStreamRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.MappingEvent>) responseObserver);
          break;
        case METHODID_GET_ALL:
          serviceImpl.getAll((axoom.mappings.v1.MappingsService.MappingListRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.MappingListResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((axoom.mappings.v1.MappingsService.GetRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.GetResponse>) responseObserver);
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

  private static abstract class MappingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MappingsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.mappings.v1.MappingsService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Mappings");
    }
  }

  private static final class MappingsFileDescriptorSupplier
      extends MappingsBaseDescriptorSupplier {
    MappingsFileDescriptorSupplier() {}
  }

  private static final class MappingsMethodDescriptorSupplier
      extends MappingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MappingsMethodDescriptorSupplier(String methodName) {
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
      synchronized (MappingsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MappingsFileDescriptorSupplier())
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
