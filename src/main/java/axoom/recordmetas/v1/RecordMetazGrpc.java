package axoom.recordmetaz.v1;

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
    comments = "Source: recordmetaz_service.proto")
public final class RecordMetazGrpc {

  private RecordMetazGrpc() {}

  public static final String SERVICE_NAME = "axoom.recordmetaz.v1.RecordMetaz";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest,
      axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse> getCreateRecordMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecordMeta",
      requestType = axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest.class,
      responseType = axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest,
      axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse> getCreateRecordMetaMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest, axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse> getCreateRecordMetaMethod;
    if ((getCreateRecordMetaMethod = RecordMetazGrpc.getCreateRecordMetaMethod) == null) {
      synchronized (RecordMetazGrpc.class) {
        if ((getCreateRecordMetaMethod = RecordMetazGrpc.getCreateRecordMetaMethod) == null) {
          RecordMetazGrpc.getCreateRecordMetaMethod = getCreateRecordMetaMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest, axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetaz.v1.RecordMetaz", "CreateRecordMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetazMethodDescriptorSupplier("CreateRecordMeta"))
                  .build();
          }
        }
     }
     return getCreateRecordMetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest,
      axoom.recordmetaz.v1.RecordmetazService.Subscription> getCreateRecordMetasSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecordMetasSubscription",
      requestType = axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest.class,
      responseType = axoom.recordmetaz.v1.RecordmetazService.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest,
      axoom.recordmetaz.v1.RecordmetazService.Subscription> getCreateRecordMetasSubscriptionMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest, axoom.recordmetaz.v1.RecordmetazService.Subscription> getCreateRecordMetasSubscriptionMethod;
    if ((getCreateRecordMetasSubscriptionMethod = RecordMetazGrpc.getCreateRecordMetasSubscriptionMethod) == null) {
      synchronized (RecordMetazGrpc.class) {
        if ((getCreateRecordMetasSubscriptionMethod = RecordMetazGrpc.getCreateRecordMetasSubscriptionMethod) == null) {
          RecordMetazGrpc.getCreateRecordMetasSubscriptionMethod = getCreateRecordMetasSubscriptionMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest, axoom.recordmetaz.v1.RecordmetazService.Subscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetaz.v1.RecordMetaz", "CreateRecordMetasSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.RecordmetazService.Subscription.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetazMethodDescriptorSupplier("CreateRecordMetasSubscription"))
                  .build();
          }
        }
     }
     return getCreateRecordMetasSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest,
      axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest.class,
      responseType = axoom.recordmetaz.v1.Recordmetaz.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest,
      axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getGetStreamMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest, axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getGetStreamMethod;
    if ((getGetStreamMethod = RecordMetazGrpc.getGetStreamMethod) == null) {
      synchronized (RecordMetazGrpc.class) {
        if ((getGetStreamMethod = RecordMetazGrpc.getGetStreamMethod) == null) {
          RecordMetazGrpc.getGetStreamMethod = getGetStreamMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest, axoom.recordmetaz.v1.Recordmetaz.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetaz.v1.RecordMetaz", "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.Recordmetaz.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetazMethodDescriptorSupplier("GetStream"))
                  .build();
          }
        }
     }
     return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest,
      axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getListHistoricalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHistorical",
      requestType = axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest.class,
      responseType = axoom.recordmetaz.v1.Recordmetaz.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest,
      axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getListHistoricalMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest, axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getListHistoricalMethod;
    if ((getListHistoricalMethod = RecordMetazGrpc.getListHistoricalMethod) == null) {
      synchronized (RecordMetazGrpc.class) {
        if ((getListHistoricalMethod = RecordMetazGrpc.getListHistoricalMethod) == null) {
          RecordMetazGrpc.getListHistoricalMethod = getListHistoricalMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest, axoom.recordmetaz.v1.Recordmetaz.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetaz.v1.RecordMetaz", "ListHistorical"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.Recordmetaz.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetazMethodDescriptorSupplier("ListHistorical"))
                  .build();
          }
        }
     }
     return getListHistoricalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest,
      axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getGetLatestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatest",
      requestType = axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest.class,
      responseType = axoom.recordmetaz.v1.Recordmetaz.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest,
      axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getGetLatestMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest, axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getGetLatestMethod;
    if ((getGetLatestMethod = RecordMetazGrpc.getGetLatestMethod) == null) {
      synchronized (RecordMetazGrpc.class) {
        if ((getGetLatestMethod = RecordMetazGrpc.getGetLatestMethod) == null) {
          RecordMetazGrpc.getGetLatestMethod = getGetLatestMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest, axoom.recordmetaz.v1.Recordmetaz.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetaz.v1.RecordMetaz", "GetLatest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetaz.v1.Recordmetaz.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetazMethodDescriptorSupplier("GetLatest"))
                  .build();
          }
        }
     }
     return getGetLatestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecordMetazStub newStub(io.grpc.Channel channel) {
    return new RecordMetazStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecordMetazBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RecordMetazBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecordMetazFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RecordMetazFutureStub(channel);
  }

  /**
   */
  public static abstract class RecordMetazImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateRecordMeta creates the given RecordMeta.
     * If there is a RecordMeta ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createRecordMeta(axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRecordMetaMethod(), responseObserver);
    }

    /**
     * <pre>
     * CreateRecordMetasSubscription registers a Subscription for all RecordMetas of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public void createRecordMetasSubscription(axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.RecordmetazService.Subscription> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRecordMetasSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded RecordMeta stream of the requested Subject type. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded RecordMeta stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more RecordMetas stored in the specified time range.
     * </pre>
     */
    public void listHistorical(axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getListHistoricalMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetLatest returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public void getLatest(axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLatestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateRecordMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest,
                axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse>(
                  this, METHODID_CREATE_RECORD_META)))
          .addMethod(
            getCreateRecordMetasSubscriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest,
                axoom.recordmetaz.v1.RecordmetazService.Subscription>(
                  this, METHODID_CREATE_RECORD_METAS_SUBSCRIPTION)))
          .addMethod(
            getGetStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest,
                axoom.recordmetaz.v1.Recordmetaz.RecordMeta>(
                  this, METHODID_GET_STREAM)))
          .addMethod(
            getListHistoricalMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest,
                axoom.recordmetaz.v1.Recordmetaz.RecordMeta>(
                  this, METHODID_LIST_HISTORICAL)))
          .addMethod(
            getGetLatestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest,
                axoom.recordmetaz.v1.Recordmetaz.RecordMeta>(
                  this, METHODID_GET_LATEST)))
          .build();
    }
  }

  /**
   */
  public static final class RecordMetazStub extends io.grpc.stub.AbstractStub<RecordMetazStub> {
    private RecordMetazStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordMetazStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordMetazStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordMetazStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordMeta creates the given RecordMeta.
     * If there is a RecordMeta ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createRecordMeta(axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRecordMetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CreateRecordMetasSubscription registers a Subscription for all RecordMetas of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public void createRecordMetasSubscription(axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.RecordmetazService.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRecordMetasSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded RecordMeta stream of the requested Subject type. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded RecordMeta stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more RecordMetas stored in the specified time range.
     * </pre>
     */
    public void listHistorical(axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListHistoricalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetLatest returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public void getLatest(axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLatestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecordMetazBlockingStub extends io.grpc.stub.AbstractStub<RecordMetazBlockingStub> {
    private RecordMetazBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordMetazBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordMetazBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordMetazBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordMeta creates the given RecordMeta.
     * If there is a RecordMeta ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse createRecordMeta(axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRecordMetaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * CreateRecordMetasSubscription registers a Subscription for all RecordMetas of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public axoom.recordmetaz.v1.RecordmetazService.Subscription createRecordMetasSubscription(axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRecordMetasSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetStream returns an unbounded RecordMeta stream of the requested Subject type. The stream endures at max. 30 min.
     * </pre>
     */
    public java.util.Iterator<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getStream(
        axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded RecordMeta stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more RecordMetas stored in the specified time range.
     * </pre>
     */
    public java.util.Iterator<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> listHistorical(
        axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListHistoricalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetLatest returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public axoom.recordmetaz.v1.Recordmetaz.RecordMeta getLatest(axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLatestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecordMetazFutureStub extends io.grpc.stub.AbstractStub<RecordMetazFutureStub> {
    private RecordMetazFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordMetazFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordMetazFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordMetazFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordMeta creates the given RecordMeta.
     * If there is a RecordMeta ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse> createRecordMeta(
        axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRecordMetaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * CreateRecordMetasSubscription registers a Subscription for all RecordMetas of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetaz.v1.RecordmetazService.Subscription> createRecordMetasSubscription(
        axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRecordMetasSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetLatest returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetaz.v1.Recordmetaz.RecordMeta> getLatest(
        axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLatestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RECORD_META = 0;
  private static final int METHODID_CREATE_RECORD_METAS_SUBSCRIPTION = 1;
  private static final int METHODID_GET_STREAM = 2;
  private static final int METHODID_LIST_HISTORICAL = 3;
  private static final int METHODID_GET_LATEST = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecordMetazImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecordMetazImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RECORD_META:
          serviceImpl.createRecordMeta((axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.RecordmetazService.CreateRecordMetaResponse>) responseObserver);
          break;
        case METHODID_CREATE_RECORD_METAS_SUBSCRIPTION:
          serviceImpl.createRecordMetasSubscription((axoom.recordmetaz.v1.RecordmetazService.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.RecordmetazService.Subscription>) responseObserver);
          break;
        case METHODID_GET_STREAM:
          serviceImpl.getStream((axoom.recordmetaz.v1.RecordmetazService.RecordMetaStreamRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta>) responseObserver);
          break;
        case METHODID_LIST_HISTORICAL:
          serviceImpl.listHistorical((axoom.recordmetaz.v1.RecordmetazService.RecordMetaListRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta>) responseObserver);
          break;
        case METHODID_GET_LATEST:
          serviceImpl.getLatest((axoom.recordmetaz.v1.RecordmetazService.RecordMetaRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetaz.v1.Recordmetaz.RecordMeta>) responseObserver);
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

  private static abstract class RecordMetazBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecordMetazBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.recordmetaz.v1.RecordmetazService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecordMetaz");
    }
  }

  private static final class RecordMetazFileDescriptorSupplier
      extends RecordMetazBaseDescriptorSupplier {
    RecordMetazFileDescriptorSupplier() {}
  }

  private static final class RecordMetazMethodDescriptorSupplier
      extends RecordMetazBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecordMetazMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecordMetazGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecordMetazFileDescriptorSupplier())
              .addMethod(getCreateRecordMetaMethod())
              .addMethod(getCreateRecordMetasSubscriptionMethod())
              .addMethod(getGetStreamMethod())
              .addMethod(getListHistoricalMethod())
              .addMethod(getGetLatestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
