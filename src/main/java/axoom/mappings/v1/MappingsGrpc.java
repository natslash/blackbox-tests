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
 * <pre>
 * The service that an application uses to manipulate Mappings.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: mappings_service.proto")
public final class MappingsGrpc {

  private MappingsGrpc() {}

  public static final String SERVICE_NAME = "axoom.mappings.v1.Mappings";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.CreateMappingRequest,
      axoom.mappings.v1.Mappings.Mapping> getCreateMappingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMapping",
      requestType = axoom.mappings.v1.MappingsService.CreateMappingRequest.class,
      responseType = axoom.mappings.v1.Mappings.Mapping.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.CreateMappingRequest,
      axoom.mappings.v1.Mappings.Mapping> getCreateMappingMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.CreateMappingRequest, axoom.mappings.v1.Mappings.Mapping> getCreateMappingMethod;
    if ((getCreateMappingMethod = MappingsGrpc.getCreateMappingMethod) == null) {
      synchronized (MappingsGrpc.class) {
        if ((getCreateMappingMethod = MappingsGrpc.getCreateMappingMethod) == null) {
          MappingsGrpc.getCreateMappingMethod = getCreateMappingMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingsService.CreateMappingRequest, axoom.mappings.v1.Mappings.Mapping>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappings.v1.Mappings", "CreateMapping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.CreateMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.Mappings.Mapping.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingsMethodDescriptorSupplier("CreateMapping"))
                  .build();
          }
        }
     }
     return getCreateMappingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.ListMappingsRequest,
      axoom.mappings.v1.MappingsService.ListMappingsResponse> getListMappingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMappings",
      requestType = axoom.mappings.v1.MappingsService.ListMappingsRequest.class,
      responseType = axoom.mappings.v1.MappingsService.ListMappingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.ListMappingsRequest,
      axoom.mappings.v1.MappingsService.ListMappingsResponse> getListMappingsMethod() {
    io.grpc.MethodDescriptor<axoom.mappings.v1.MappingsService.ListMappingsRequest, axoom.mappings.v1.MappingsService.ListMappingsResponse> getListMappingsMethod;
    if ((getListMappingsMethod = MappingsGrpc.getListMappingsMethod) == null) {
      synchronized (MappingsGrpc.class) {
        if ((getListMappingsMethod = MappingsGrpc.getListMappingsMethod) == null) {
          MappingsGrpc.getListMappingsMethod = getListMappingsMethod = 
              io.grpc.MethodDescriptor.<axoom.mappings.v1.MappingsService.ListMappingsRequest, axoom.mappings.v1.MappingsService.ListMappingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.mappings.v1.Mappings", "ListMappings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.ListMappingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.mappings.v1.MappingsService.ListMappingsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MappingsMethodDescriptorSupplier("ListMappings"))
                  .build();
          }
        }
     }
     return getListMappingsMethod;
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
   * <pre>
   * The service that an application uses to manipulate Mappings.
   * </pre>
   */
  public static abstract class MappingsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateMapping creates the given Mapping.
     * </pre>
     */
    public void createMapping(axoom.mappings.v1.MappingsService.CreateMappingRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.Mappings.Mapping> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMappingMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListMappings returns all Mappings matching the specified MappingFilter.
     * </pre>
     */
    public void listMappings(axoom.mappings.v1.MappingsService.ListMappingsRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.ListMappingsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListMappingsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMappingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingsService.CreateMappingRequest,
                axoom.mappings.v1.Mappings.Mapping>(
                  this, METHODID_CREATE_MAPPING)))
          .addMethod(
            getListMappingsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.mappings.v1.MappingsService.ListMappingsRequest,
                axoom.mappings.v1.MappingsService.ListMappingsResponse>(
                  this, METHODID_LIST_MAPPINGS)))
          .build();
    }
  }

  /**
   * <pre>
   * The service that an application uses to manipulate Mappings.
   * </pre>
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
     * CreateMapping creates the given Mapping.
     * </pre>
     */
    public void createMapping(axoom.mappings.v1.MappingsService.CreateMappingRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.Mappings.Mapping> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMappingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListMappings returns all Mappings matching the specified MappingFilter.
     * </pre>
     */
    public void listMappings(axoom.mappings.v1.MappingsService.ListMappingsRequest request,
        io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.ListMappingsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListMappingsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service that an application uses to manipulate Mappings.
   * </pre>
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
     * CreateMapping creates the given Mapping.
     * </pre>
     */
    public axoom.mappings.v1.Mappings.Mapping createMapping(axoom.mappings.v1.MappingsService.CreateMappingRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMappingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListMappings returns all Mappings matching the specified MappingFilter.
     * </pre>
     */
    public axoom.mappings.v1.MappingsService.ListMappingsResponse listMappings(axoom.mappings.v1.MappingsService.ListMappingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListMappingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service that an application uses to manipulate Mappings.
   * </pre>
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
     * CreateMapping creates the given Mapping.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.mappings.v1.Mappings.Mapping> createMapping(
        axoom.mappings.v1.MappingsService.CreateMappingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMappingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ListMappings returns all Mappings matching the specified MappingFilter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.mappings.v1.MappingsService.ListMappingsResponse> listMappings(
        axoom.mappings.v1.MappingsService.ListMappingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListMappingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MAPPING = 0;
  private static final int METHODID_LIST_MAPPINGS = 1;

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
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.Mappings.Mapping>) responseObserver);
          break;
        case METHODID_LIST_MAPPINGS:
          serviceImpl.listMappings((axoom.mappings.v1.MappingsService.ListMappingsRequest) request,
              (io.grpc.stub.StreamObserver<axoom.mappings.v1.MappingsService.ListMappingsResponse>) responseObserver);
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
              .addMethod(getListMappingsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
