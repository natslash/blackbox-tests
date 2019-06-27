package axoom.sharing.v1;

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
    comments = "Source: sharing/v1/sharing_service.proto")
public final class SharingGrpc {

  private SharingGrpc() {}

  public static final String SERVICE_NAME = "axoom.sharing.v1.Sharing";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.CreateClientShareRequest,
      axoom.sharing.v1.Sharing.ClientShare> getCreateClientShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateClientShare",
      requestType = axoom.sharing.v1.SharingService.CreateClientShareRequest.class,
      responseType = axoom.sharing.v1.Sharing.ClientShare.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.CreateClientShareRequest,
      axoom.sharing.v1.Sharing.ClientShare> getCreateClientShareMethod() {
    io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.CreateClientShareRequest, axoom.sharing.v1.Sharing.ClientShare> getCreateClientShareMethod;
    if ((getCreateClientShareMethod = SharingGrpc.getCreateClientShareMethod) == null) {
      synchronized (SharingGrpc.class) {
        if ((getCreateClientShareMethod = SharingGrpc.getCreateClientShareMethod) == null) {
          SharingGrpc.getCreateClientShareMethod = getCreateClientShareMethod = 
              io.grpc.MethodDescriptor.<axoom.sharing.v1.SharingService.CreateClientShareRequest, axoom.sharing.v1.Sharing.ClientShare>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.sharing.v1.Sharing", "CreateClientShare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.SharingService.CreateClientShareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.Sharing.ClientShare.getDefaultInstance()))
                  .setSchemaDescriptor(new SharingMethodDescriptorSupplier("CreateClientShare"))
                  .build();
          }
        }
     }
     return getCreateClientShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.ListClientSharesRequest,
      axoom.sharing.v1.SharingService.ListClientSharesResponse> getListClientSharesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClientShares",
      requestType = axoom.sharing.v1.SharingService.ListClientSharesRequest.class,
      responseType = axoom.sharing.v1.SharingService.ListClientSharesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.ListClientSharesRequest,
      axoom.sharing.v1.SharingService.ListClientSharesResponse> getListClientSharesMethod() {
    io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.ListClientSharesRequest, axoom.sharing.v1.SharingService.ListClientSharesResponse> getListClientSharesMethod;
    if ((getListClientSharesMethod = SharingGrpc.getListClientSharesMethod) == null) {
      synchronized (SharingGrpc.class) {
        if ((getListClientSharesMethod = SharingGrpc.getListClientSharesMethod) == null) {
          SharingGrpc.getListClientSharesMethod = getListClientSharesMethod = 
              io.grpc.MethodDescriptor.<axoom.sharing.v1.SharingService.ListClientSharesRequest, axoom.sharing.v1.SharingService.ListClientSharesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.sharing.v1.Sharing", "ListClientShares"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.SharingService.ListClientSharesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.SharingService.ListClientSharesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SharingMethodDescriptorSupplier("ListClientShares"))
                  .build();
          }
        }
     }
     return getListClientSharesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.CreateTenantShareRequest,
      axoom.sharing.v1.Sharing.TenantShare> getCreateTenantShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTenantShare",
      requestType = axoom.sharing.v1.SharingService.CreateTenantShareRequest.class,
      responseType = axoom.sharing.v1.Sharing.TenantShare.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.CreateTenantShareRequest,
      axoom.sharing.v1.Sharing.TenantShare> getCreateTenantShareMethod() {
    io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.CreateTenantShareRequest, axoom.sharing.v1.Sharing.TenantShare> getCreateTenantShareMethod;
    if ((getCreateTenantShareMethod = SharingGrpc.getCreateTenantShareMethod) == null) {
      synchronized (SharingGrpc.class) {
        if ((getCreateTenantShareMethod = SharingGrpc.getCreateTenantShareMethod) == null) {
          SharingGrpc.getCreateTenantShareMethod = getCreateTenantShareMethod = 
              io.grpc.MethodDescriptor.<axoom.sharing.v1.SharingService.CreateTenantShareRequest, axoom.sharing.v1.Sharing.TenantShare>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.sharing.v1.Sharing", "CreateTenantShare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.SharingService.CreateTenantShareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.Sharing.TenantShare.getDefaultInstance()))
                  .setSchemaDescriptor(new SharingMethodDescriptorSupplier("CreateTenantShare"))
                  .build();
          }
        }
     }
     return getCreateTenantShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.ListTenantSharesRequest,
      axoom.sharing.v1.SharingService.ListTenantSharesResponse> getListTenantSharesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTenantShares",
      requestType = axoom.sharing.v1.SharingService.ListTenantSharesRequest.class,
      responseType = axoom.sharing.v1.SharingService.ListTenantSharesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.ListTenantSharesRequest,
      axoom.sharing.v1.SharingService.ListTenantSharesResponse> getListTenantSharesMethod() {
    io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.ListTenantSharesRequest, axoom.sharing.v1.SharingService.ListTenantSharesResponse> getListTenantSharesMethod;
    if ((getListTenantSharesMethod = SharingGrpc.getListTenantSharesMethod) == null) {
      synchronized (SharingGrpc.class) {
        if ((getListTenantSharesMethod = SharingGrpc.getListTenantSharesMethod) == null) {
          SharingGrpc.getListTenantSharesMethod = getListTenantSharesMethod = 
              io.grpc.MethodDescriptor.<axoom.sharing.v1.SharingService.ListTenantSharesRequest, axoom.sharing.v1.SharingService.ListTenantSharesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.sharing.v1.Sharing", "ListTenantShares"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.SharingService.ListTenantSharesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.SharingService.ListTenantSharesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SharingMethodDescriptorSupplier("ListTenantShares"))
                  .build();
          }
        }
     }
     return getListTenantSharesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.DeleteClientShareRequest,
      com.google.protobuf.Empty> getDeleteClientShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteClientShare",
      requestType = axoom.sharing.v1.SharingService.DeleteClientShareRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.DeleteClientShareRequest,
      com.google.protobuf.Empty> getDeleteClientShareMethod() {
    io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.DeleteClientShareRequest, com.google.protobuf.Empty> getDeleteClientShareMethod;
    if ((getDeleteClientShareMethod = SharingGrpc.getDeleteClientShareMethod) == null) {
      synchronized (SharingGrpc.class) {
        if ((getDeleteClientShareMethod = SharingGrpc.getDeleteClientShareMethod) == null) {
          SharingGrpc.getDeleteClientShareMethod = getDeleteClientShareMethod = 
              io.grpc.MethodDescriptor.<axoom.sharing.v1.SharingService.DeleteClientShareRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.sharing.v1.Sharing", "DeleteClientShare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.SharingService.DeleteClientShareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new SharingMethodDescriptorSupplier("DeleteClientShare"))
                  .build();
          }
        }
     }
     return getDeleteClientShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.DeleteTenantShareRequest,
      com.google.protobuf.Empty> getDeleteTenantShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTenantShare",
      requestType = axoom.sharing.v1.SharingService.DeleteTenantShareRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.DeleteTenantShareRequest,
      com.google.protobuf.Empty> getDeleteTenantShareMethod() {
    io.grpc.MethodDescriptor<axoom.sharing.v1.SharingService.DeleteTenantShareRequest, com.google.protobuf.Empty> getDeleteTenantShareMethod;
    if ((getDeleteTenantShareMethod = SharingGrpc.getDeleteTenantShareMethod) == null) {
      synchronized (SharingGrpc.class) {
        if ((getDeleteTenantShareMethod = SharingGrpc.getDeleteTenantShareMethod) == null) {
          SharingGrpc.getDeleteTenantShareMethod = getDeleteTenantShareMethod = 
              io.grpc.MethodDescriptor.<axoom.sharing.v1.SharingService.DeleteTenantShareRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.sharing.v1.Sharing", "DeleteTenantShare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.sharing.v1.SharingService.DeleteTenantShareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new SharingMethodDescriptorSupplier("DeleteTenantShare"))
                  .build();
          }
        }
     }
     return getDeleteTenantShareMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SharingStub newStub(io.grpc.Channel channel) {
    return new SharingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SharingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SharingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SharingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SharingFutureStub(channel);
  }

  /**
   */
  public static abstract class SharingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateClientShare creates the given ClientShare. ##
     * </pre>
     */
    public void createClientShare(axoom.sharing.v1.SharingService.CreateClientShareRequest request,
        io.grpc.stub.StreamObserver<axoom.sharing.v1.Sharing.ClientShare> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClientShareMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListClientShares returns the requested ClientShares by the provided client ID and tenant ID. ##
     * </pre>
     */
    public void listClientShares(axoom.sharing.v1.SharingService.ListClientSharesRequest request,
        io.grpc.stub.StreamObserver<axoom.sharing.v1.SharingService.ListClientSharesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListClientSharesMethod(), responseObserver);
    }

    /**
     * <pre>
     * CreateTenantShare creates the given tenant_share. ##
     * </pre>
     */
    public void createTenantShare(axoom.sharing.v1.SharingService.CreateTenantShareRequest request,
        io.grpc.stub.StreamObserver<axoom.sharing.v1.Sharing.TenantShare> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTenantShareMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListTenantShares returns the requested TenantShares by the provided tenant ID.
     * </pre>
     */
    public void listTenantShares(axoom.sharing.v1.SharingService.ListTenantSharesRequest request,
        io.grpc.stub.StreamObserver<axoom.sharing.v1.SharingService.ListTenantSharesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTenantSharesMethod(), responseObserver);
    }

    /**
     * <pre>
     * DeleteClientShare deletes the client share defined by the client ID.
     * </pre>
     */
    public void deleteClientShare(axoom.sharing.v1.SharingService.DeleteClientShareRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteClientShareMethod(), responseObserver);
    }

    /**
     * <pre>
     * DeleteTenantShare removes the tenantshare defined by the tenant ID.
     * </pre>
     */
    public void deleteTenantShare(axoom.sharing.v1.SharingService.DeleteTenantShareRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTenantShareMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateClientShareMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.sharing.v1.SharingService.CreateClientShareRequest,
                axoom.sharing.v1.Sharing.ClientShare>(
                  this, METHODID_CREATE_CLIENT_SHARE)))
          .addMethod(
            getListClientSharesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.sharing.v1.SharingService.ListClientSharesRequest,
                axoom.sharing.v1.SharingService.ListClientSharesResponse>(
                  this, METHODID_LIST_CLIENT_SHARES)))
          .addMethod(
            getCreateTenantShareMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.sharing.v1.SharingService.CreateTenantShareRequest,
                axoom.sharing.v1.Sharing.TenantShare>(
                  this, METHODID_CREATE_TENANT_SHARE)))
          .addMethod(
            getListTenantSharesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.sharing.v1.SharingService.ListTenantSharesRequest,
                axoom.sharing.v1.SharingService.ListTenantSharesResponse>(
                  this, METHODID_LIST_TENANT_SHARES)))
          .addMethod(
            getDeleteClientShareMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.sharing.v1.SharingService.DeleteClientShareRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_CLIENT_SHARE)))
          .addMethod(
            getDeleteTenantShareMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.sharing.v1.SharingService.DeleteTenantShareRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_TENANT_SHARE)))
          .build();
    }
  }

  /**
   */
  public static final class SharingStub extends io.grpc.stub.AbstractStub<SharingStub> {
    private SharingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SharingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SharingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SharingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateClientShare creates the given ClientShare. ##
     * </pre>
     */
    public void createClientShare(axoom.sharing.v1.SharingService.CreateClientShareRequest request,
        io.grpc.stub.StreamObserver<axoom.sharing.v1.Sharing.ClientShare> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateClientShareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListClientShares returns the requested ClientShares by the provided client ID and tenant ID. ##
     * </pre>
     */
    public void listClientShares(axoom.sharing.v1.SharingService.ListClientSharesRequest request,
        io.grpc.stub.StreamObserver<axoom.sharing.v1.SharingService.ListClientSharesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListClientSharesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CreateTenantShare creates the given tenant_share. ##
     * </pre>
     */
    public void createTenantShare(axoom.sharing.v1.SharingService.CreateTenantShareRequest request,
        io.grpc.stub.StreamObserver<axoom.sharing.v1.Sharing.TenantShare> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTenantShareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListTenantShares returns the requested TenantShares by the provided tenant ID.
     * </pre>
     */
    public void listTenantShares(axoom.sharing.v1.SharingService.ListTenantSharesRequest request,
        io.grpc.stub.StreamObserver<axoom.sharing.v1.SharingService.ListTenantSharesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTenantSharesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * DeleteClientShare deletes the client share defined by the client ID.
     * </pre>
     */
    public void deleteClientShare(axoom.sharing.v1.SharingService.DeleteClientShareRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteClientShareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * DeleteTenantShare removes the tenantshare defined by the tenant ID.
     * </pre>
     */
    public void deleteTenantShare(axoom.sharing.v1.SharingService.DeleteTenantShareRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTenantShareMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SharingBlockingStub extends io.grpc.stub.AbstractStub<SharingBlockingStub> {
    private SharingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SharingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SharingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SharingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateClientShare creates the given ClientShare. ##
     * </pre>
     */
    public axoom.sharing.v1.Sharing.ClientShare createClientShare(axoom.sharing.v1.SharingService.CreateClientShareRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateClientShareMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListClientShares returns the requested ClientShares by the provided client ID and tenant ID. ##
     * </pre>
     */
    public axoom.sharing.v1.SharingService.ListClientSharesResponse listClientShares(axoom.sharing.v1.SharingService.ListClientSharesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListClientSharesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * CreateTenantShare creates the given tenant_share. ##
     * </pre>
     */
    public axoom.sharing.v1.Sharing.TenantShare createTenantShare(axoom.sharing.v1.SharingService.CreateTenantShareRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTenantShareMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListTenantShares returns the requested TenantShares by the provided tenant ID.
     * </pre>
     */
    public axoom.sharing.v1.SharingService.ListTenantSharesResponse listTenantShares(axoom.sharing.v1.SharingService.ListTenantSharesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTenantSharesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * DeleteClientShare deletes the client share defined by the client ID.
     * </pre>
     */
    public com.google.protobuf.Empty deleteClientShare(axoom.sharing.v1.SharingService.DeleteClientShareRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteClientShareMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * DeleteTenantShare removes the tenantshare defined by the tenant ID.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTenantShare(axoom.sharing.v1.SharingService.DeleteTenantShareRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTenantShareMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SharingFutureStub extends io.grpc.stub.AbstractStub<SharingFutureStub> {
    private SharingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SharingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SharingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SharingFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateClientShare creates the given ClientShare. ##
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.sharing.v1.Sharing.ClientShare> createClientShare(
        axoom.sharing.v1.SharingService.CreateClientShareRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateClientShareMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ListClientShares returns the requested ClientShares by the provided client ID and tenant ID. ##
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.sharing.v1.SharingService.ListClientSharesResponse> listClientShares(
        axoom.sharing.v1.SharingService.ListClientSharesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListClientSharesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * CreateTenantShare creates the given tenant_share. ##
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.sharing.v1.Sharing.TenantShare> createTenantShare(
        axoom.sharing.v1.SharingService.CreateTenantShareRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTenantShareMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ListTenantShares returns the requested TenantShares by the provided tenant ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.sharing.v1.SharingService.ListTenantSharesResponse> listTenantShares(
        axoom.sharing.v1.SharingService.ListTenantSharesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTenantSharesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * DeleteClientShare deletes the client share defined by the client ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteClientShare(
        axoom.sharing.v1.SharingService.DeleteClientShareRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteClientShareMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * DeleteTenantShare removes the tenantshare defined by the tenant ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTenantShare(
        axoom.sharing.v1.SharingService.DeleteTenantShareRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTenantShareMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CLIENT_SHARE = 0;
  private static final int METHODID_LIST_CLIENT_SHARES = 1;
  private static final int METHODID_CREATE_TENANT_SHARE = 2;
  private static final int METHODID_LIST_TENANT_SHARES = 3;
  private static final int METHODID_DELETE_CLIENT_SHARE = 4;
  private static final int METHODID_DELETE_TENANT_SHARE = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SharingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SharingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CLIENT_SHARE:
          serviceImpl.createClientShare((axoom.sharing.v1.SharingService.CreateClientShareRequest) request,
              (io.grpc.stub.StreamObserver<axoom.sharing.v1.Sharing.ClientShare>) responseObserver);
          break;
        case METHODID_LIST_CLIENT_SHARES:
          serviceImpl.listClientShares((axoom.sharing.v1.SharingService.ListClientSharesRequest) request,
              (io.grpc.stub.StreamObserver<axoom.sharing.v1.SharingService.ListClientSharesResponse>) responseObserver);
          break;
        case METHODID_CREATE_TENANT_SHARE:
          serviceImpl.createTenantShare((axoom.sharing.v1.SharingService.CreateTenantShareRequest) request,
              (io.grpc.stub.StreamObserver<axoom.sharing.v1.Sharing.TenantShare>) responseObserver);
          break;
        case METHODID_LIST_TENANT_SHARES:
          serviceImpl.listTenantShares((axoom.sharing.v1.SharingService.ListTenantSharesRequest) request,
              (io.grpc.stub.StreamObserver<axoom.sharing.v1.SharingService.ListTenantSharesResponse>) responseObserver);
          break;
        case METHODID_DELETE_CLIENT_SHARE:
          serviceImpl.deleteClientShare((axoom.sharing.v1.SharingService.DeleteClientShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_TENANT_SHARE:
          serviceImpl.deleteTenantShare((axoom.sharing.v1.SharingService.DeleteTenantShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class SharingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SharingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.sharing.v1.SharingService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Sharing");
    }
  }

  private static final class SharingFileDescriptorSupplier
      extends SharingBaseDescriptorSupplier {
    SharingFileDescriptorSupplier() {}
  }

  private static final class SharingMethodDescriptorSupplier
      extends SharingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SharingMethodDescriptorSupplier(String methodName) {
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
      synchronized (SharingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SharingFileDescriptorSupplier())
              .addMethod(getCreateClientShareMethod())
              .addMethod(getListClientSharesMethod())
              .addMethod(getCreateTenantShareMethod())
              .addMethod(getListTenantSharesMethod())
              .addMethod(getDeleteClientShareMethod())
              .addMethod(getDeleteTenantShareMethod())
              .build();
        }
      }
    }
    return result;
  }
}
