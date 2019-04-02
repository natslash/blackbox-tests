package axoom.recordmetas.v1;

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
    comments = "Source: recordmetas_service.proto")
public class RecordMetasGrpc {

  RecordMetasGrpc() {}

  public static final String SERVICE_NAME = "axoom.recordmetas.v1.RecordMetas";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest,
      axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse> getCreateRecordMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecordMeta",
      requestType = axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest.class,
      responseType = axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest,
      axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse> getCreateRecordMetaMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest, axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse> getCreateRecordMetaMethod;
    if ((getCreateRecordMetaMethod = RecordMetasGrpc.getCreateRecordMetaMethod) == null) {
      synchronized (RecordMetasGrpc.class) {
        if ((getCreateRecordMetaMethod = RecordMetasGrpc.getCreateRecordMetaMethod) == null) {
          RecordMetasGrpc.getCreateRecordMetaMethod = getCreateRecordMetaMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest, axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetas.v1.RecordMetas", "CreateRecordMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetasMethodDescriptorSupplier("CreateRecordMeta"))
                  .build();
          }
        }
     }
     return getCreateRecordMetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest,
      axoom.recordmetas.v1.RecordmetasService.Subscription> getCreateRecordMetasSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecordMetasSubscription",
      requestType = axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest.class,
      responseType = axoom.recordmetas.v1.RecordmetasService.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest,
      axoom.recordmetas.v1.RecordmetasService.Subscription> getCreateRecordMetasSubscriptionMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest, axoom.recordmetas.v1.RecordmetasService.Subscription> getCreateRecordMetasSubscriptionMethod;
    if ((getCreateRecordMetasSubscriptionMethod = RecordMetasGrpc.getCreateRecordMetasSubscriptionMethod) == null) {
      synchronized (RecordMetasGrpc.class) {
        if ((getCreateRecordMetasSubscriptionMethod = RecordMetasGrpc.getCreateRecordMetasSubscriptionMethod) == null) {
          RecordMetasGrpc.getCreateRecordMetasSubscriptionMethod = getCreateRecordMetasSubscriptionMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest, axoom.recordmetas.v1.RecordmetasService.Subscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetas.v1.RecordMetas", "CreateRecordMetasSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.Subscription.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetasMethodDescriptorSupplier("CreateRecordMetasSubscription"))
                  .build();
          }
        }
     }
     return getCreateRecordMetasSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest.class,
      responseType = axoom.recordmetas.v1.Recordmetas.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetStreamMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetStreamMethod;
    if ((getGetStreamMethod = RecordMetasGrpc.getGetStreamMethod) == null) {
      synchronized (RecordMetasGrpc.class) {
        if ((getGetStreamMethod = RecordMetasGrpc.getGetStreamMethod) == null) {
          RecordMetasGrpc.getGetStreamMethod = getGetStreamMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetas.v1.RecordMetas", "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.Recordmetas.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetasMethodDescriptorSupplier("GetStream"))
                  .build();
          }
        }
     }
     return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getListHistoricalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHistorical",
      requestType = axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest.class,
      responseType = axoom.recordmetas.v1.Recordmetas.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getListHistoricalMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta> getListHistoricalMethod;
    if ((getListHistoricalMethod = RecordMetasGrpc.getListHistoricalMethod) == null) {
      synchronized (RecordMetasGrpc.class) {
        if ((getListHistoricalMethod = RecordMetasGrpc.getListHistoricalMethod) == null) {
          RecordMetasGrpc.getListHistoricalMethod = getListHistoricalMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetas.v1.RecordMetas", "ListHistorical"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.Recordmetas.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetasMethodDescriptorSupplier("ListHistorical"))
                  .build();
          }
        }
     }
     return getListHistoricalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetLatestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatest",
      requestType = axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest.class,
      responseType = axoom.recordmetas.v1.Recordmetas.RecordMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest,
      axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetLatestMethod() {
    io.grpc.MethodDescriptor<axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta> getGetLatestMethod;
    if ((getGetLatestMethod = RecordMetasGrpc.getGetLatestMethod) == null) {
      synchronized (RecordMetasGrpc.class) {
        if ((getGetLatestMethod = RecordMetasGrpc.getGetLatestMethod) == null) {
          RecordMetasGrpc.getGetLatestMethod = getGetLatestMethod = 
              io.grpc.MethodDescriptor.<axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest, axoom.recordmetas.v1.Recordmetas.RecordMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordmetas.v1.RecordMetas", "GetLatest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordmetas.v1.Recordmetas.RecordMeta.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordMetasMethodDescriptorSupplier("GetLatest"))
                  .build();
          }
        }
     }
     return getGetLatestMethod;
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
     * CreateRecordMeta creates the given RecordMeta.
     * If there is a RecordMeta ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createRecordMeta(axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRecordMetaMethod(), responseObserver);
    }

    /**
     * <pre>
     * CreateRecordMetasSubscription registers a Subscription for all RecordMetas of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public void createRecordMetasSubscription(axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.RecordmetasService.Subscription> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRecordMetasSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded RecordMeta stream of the requested Subject type. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded RecordMeta stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more RecordMetas stored in the specified time range.
     * </pre>
     */
    public void listHistorical(axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getListHistoricalMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetLatest returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public void getLatest(axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLatestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateRecordMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest,
                axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse>(
                  this, METHODID_CREATE_RECORD_META)))
          .addMethod(
            getCreateRecordMetasSubscriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest,
                axoom.recordmetas.v1.RecordmetasService.Subscription>(
                  this, METHODID_CREATE_RECORD_METAS_SUBSCRIPTION)))
          .addMethod(
            getGetStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest,
                axoom.recordmetas.v1.Recordmetas.RecordMeta>(
                  this, METHODID_GET_STREAM)))
          .addMethod(
            getListHistoricalMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest,
                axoom.recordmetas.v1.Recordmetas.RecordMeta>(
                  this, METHODID_LIST_HISTORICAL)))
          .addMethod(
            getGetLatestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest,
                axoom.recordmetas.v1.Recordmetas.RecordMeta>(
                  this, METHODID_GET_LATEST)))
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
     * CreateRecordMeta creates the given RecordMeta.
     * If there is a RecordMeta ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createRecordMeta(axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRecordMetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CreateRecordMetasSubscription registers a Subscription for all RecordMetas of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public void createRecordMetasSubscription(axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.RecordmetasService.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRecordMetasSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded RecordMeta stream of the requested Subject type. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded RecordMeta stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more RecordMetas stored in the specified time range.
     * </pre>
     */
    public void listHistorical(axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListHistoricalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetLatest returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public void getLatest(axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest request,
        io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLatestMethod(), getCallOptions()), request, responseObserver);
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
     * CreateRecordMeta creates the given RecordMeta.
     * If there is a RecordMeta ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse createRecordMeta(axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRecordMetaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * CreateRecordMetasSubscription registers a Subscription for all RecordMetas of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public axoom.recordmetas.v1.RecordmetasService.Subscription createRecordMetasSubscription(axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRecordMetasSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetStream returns an unbounded RecordMeta stream of the requested Subject type. The stream endures at max. 30 min.
     * </pre>
     */
    public java.util.Iterator<axoom.recordmetas.v1.Recordmetas.RecordMeta> getStream(
        axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded RecordMeta stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more RecordMetas stored in the specified time range.
     * </pre>
     */
    public java.util.Iterator<axoom.recordmetas.v1.Recordmetas.RecordMeta> listHistorical(
        axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListHistoricalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetLatest returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public axoom.recordmetas.v1.Recordmetas.RecordMeta getLatest(axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLatestMethod(), getCallOptions(), request);
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
     * CreateRecordMeta creates the given RecordMeta.
     * If there is a RecordMeta ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse> createRecordMeta(
        axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRecordMetaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * CreateRecordMetasSubscription registers a Subscription for all RecordMetas of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetas.v1.RecordmetasService.Subscription> createRecordMetasSubscription(
        axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRecordMetasSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetLatest returns the latest RecordMeta of the given Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordmetas.v1.Recordmetas.RecordMeta> getLatest(
        axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest request) {
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
              (io.grpc.stub.StreamObserver<axoom.recordmetas.v1.RecordmetasService.CreateRecordMetaResponse>) responseObserver);
          break;
        case METHODID_CREATE_RECORD_METAS_SUBSCRIPTION:
          serviceImpl.createRecordMetasSubscription((axoom.recordmetas.v1.RecordmetasService.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetas.v1.RecordmetasService.Subscription>) responseObserver);
          break;
        case METHODID_GET_STREAM:
          serviceImpl.getStream((axoom.recordmetas.v1.RecordmetasService.RecordMetaStreamRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta>) responseObserver);
          break;
        case METHODID_LIST_HISTORICAL:
          serviceImpl.listHistorical((axoom.recordmetas.v1.RecordmetasService.RecordMetaListRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordmetas.v1.Recordmetas.RecordMeta>) responseObserver);
          break;
        case METHODID_GET_LATEST:
          serviceImpl.getLatest((axoom.recordmetas.v1.RecordmetasService.RecordMetaRequest) request,
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


