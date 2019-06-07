package axoom.recordz.v1;

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
    comments = "Source: recordz_service.proto")
public final class RecordzGrpc {

  private RecordzGrpc() {}

  public static final String SERVICE_NAME = "axoom.recordz.v1.Recordz";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.SubscriptionRequest,
      axoom.recordz.v1.RecordzService.Subscription> getCreateRecordzSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecordzSubscription",
      requestType = axoom.recordz.v1.RecordzService.SubscriptionRequest.class,
      responseType = axoom.recordz.v1.RecordzService.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.SubscriptionRequest,
      axoom.recordz.v1.RecordzService.Subscription> getCreateRecordzSubscriptionMethod() {
    io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.SubscriptionRequest, axoom.recordz.v1.RecordzService.Subscription> getCreateRecordzSubscriptionMethod;
    if ((getCreateRecordzSubscriptionMethod = RecordzGrpc.getCreateRecordzSubscriptionMethod) == null) {
      synchronized (RecordzGrpc.class) {
        if ((getCreateRecordzSubscriptionMethod = RecordzGrpc.getCreateRecordzSubscriptionMethod) == null) {
          RecordzGrpc.getCreateRecordzSubscriptionMethod = getCreateRecordzSubscriptionMethod = 
              io.grpc.MethodDescriptor.<axoom.recordz.v1.RecordzService.SubscriptionRequest, axoom.recordz.v1.RecordzService.Subscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordz.v1.Recordz", "CreateRecordzSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordz.v1.RecordzService.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordz.v1.RecordzService.Subscription.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordzMethodDescriptorSupplier("CreateRecordzSubscription"))
                  .build();
          }
        }
     }
     return getCreateRecordzSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordStreamRequest,
      axoom.recordz.v1.Recordz.Record> getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = axoom.recordz.v1.RecordzService.RecordStreamRequest.class,
      responseType = axoom.recordz.v1.Recordz.Record.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordStreamRequest,
      axoom.recordz.v1.Recordz.Record> getGetStreamMethod() {
    io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordStreamRequest, axoom.recordz.v1.Recordz.Record> getGetStreamMethod;
    if ((getGetStreamMethod = RecordzGrpc.getGetStreamMethod) == null) {
      synchronized (RecordzGrpc.class) {
        if ((getGetStreamMethod = RecordzGrpc.getGetStreamMethod) == null) {
          RecordzGrpc.getGetStreamMethod = getGetStreamMethod = 
              io.grpc.MethodDescriptor.<axoom.recordz.v1.RecordzService.RecordStreamRequest, axoom.recordz.v1.Recordz.Record>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordz.v1.Recordz", "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordz.v1.RecordzService.RecordStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordz.v1.Recordz.Record.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordzMethodDescriptorSupplier("GetStream"))
                  .build();
          }
        }
     }
     return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordListRequest,
      axoom.recordz.v1.Recordz.Record> getListHistoricalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHistorical",
      requestType = axoom.recordz.v1.RecordzService.RecordListRequest.class,
      responseType = axoom.recordz.v1.Recordz.Record.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordListRequest,
      axoom.recordz.v1.Recordz.Record> getListHistoricalMethod() {
    io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordListRequest, axoom.recordz.v1.Recordz.Record> getListHistoricalMethod;
    if ((getListHistoricalMethod = RecordzGrpc.getListHistoricalMethod) == null) {
      synchronized (RecordzGrpc.class) {
        if ((getListHistoricalMethod = RecordzGrpc.getListHistoricalMethod) == null) {
          RecordzGrpc.getListHistoricalMethod = getListHistoricalMethod = 
              io.grpc.MethodDescriptor.<axoom.recordz.v1.RecordzService.RecordListRequest, axoom.recordz.v1.Recordz.Record>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordz.v1.Recordz", "ListHistorical"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordz.v1.RecordzService.RecordListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordz.v1.Recordz.Record.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordzMethodDescriptorSupplier("ListHistorical"))
                  .build();
          }
        }
     }
     return getListHistoricalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordRequest,
      axoom.recordz.v1.Recordz.Record> getGetLatestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatest",
      requestType = axoom.recordz.v1.RecordzService.RecordRequest.class,
      responseType = axoom.recordz.v1.Recordz.Record.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordRequest,
      axoom.recordz.v1.Recordz.Record> getGetLatestMethod() {
    io.grpc.MethodDescriptor<axoom.recordz.v1.RecordzService.RecordRequest, axoom.recordz.v1.Recordz.Record> getGetLatestMethod;
    if ((getGetLatestMethod = RecordzGrpc.getGetLatestMethod) == null) {
      synchronized (RecordzGrpc.class) {
        if ((getGetLatestMethod = RecordzGrpc.getGetLatestMethod) == null) {
          RecordzGrpc.getGetLatestMethod = getGetLatestMethod = 
              io.grpc.MethodDescriptor.<axoom.recordz.v1.RecordzService.RecordRequest, axoom.recordz.v1.Recordz.Record>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.recordz.v1.Recordz", "GetLatest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordz.v1.RecordzService.RecordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.recordz.v1.Recordz.Record.getDefaultInstance()))
                  .setSchemaDescriptor(new RecordzMethodDescriptorSupplier("GetLatest"))
                  .build();
          }
        }
     }
     return getGetLatestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecordzStub newStub(io.grpc.Channel channel) {
    return new RecordzStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecordzBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RecordzBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecordzFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RecordzFutureStub(channel);
  }

  /**
   */
  public static abstract class RecordzImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateRecordzSubscription registers a Subscription for all Records of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public void createRecordzSubscription(axoom.recordz.v1.RecordzService.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.recordz.v1.RecordzService.Subscription> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRecordzSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded Record stream of beeing requested in the given Subscription. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.recordz.v1.RecordzService.RecordStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded Record stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more Records stored in the specified time range.
     * </pre>
     */
    public void listHistorical(axoom.recordz.v1.RecordzService.RecordListRequest request,
        io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record> responseObserver) {
      asyncUnimplementedUnaryCall(getListHistoricalMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetLatest returns the latest Record of the given Subject
     * </pre>
     */
    public void getLatest(axoom.recordz.v1.RecordzService.RecordRequest request,
        io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLatestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateRecordzSubscriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordz.v1.RecordzService.SubscriptionRequest,
                axoom.recordz.v1.RecordzService.Subscription>(
                  this, METHODID_CREATE_RECORDZ_SUBSCRIPTION)))
          .addMethod(
            getGetStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.recordz.v1.RecordzService.RecordStreamRequest,
                axoom.recordz.v1.Recordz.Record>(
                  this, METHODID_GET_STREAM)))
          .addMethod(
            getListHistoricalMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.recordz.v1.RecordzService.RecordListRequest,
                axoom.recordz.v1.Recordz.Record>(
                  this, METHODID_LIST_HISTORICAL)))
          .addMethod(
            getGetLatestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.recordz.v1.RecordzService.RecordRequest,
                axoom.recordz.v1.Recordz.Record>(
                  this, METHODID_GET_LATEST)))
          .build();
    }
  }

  /**
   */
  public static final class RecordzStub extends io.grpc.stub.AbstractStub<RecordzStub> {
    private RecordzStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordzStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordzStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordzStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordzSubscription registers a Subscription for all Records of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public void createRecordzSubscription(axoom.recordz.v1.RecordzService.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.recordz.v1.RecordzService.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRecordzSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded Record stream of beeing requested in the given Subscription. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.recordz.v1.RecordzService.RecordStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded Record stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more Records stored in the specified time range.
     * </pre>
     */
    public void listHistorical(axoom.recordz.v1.RecordzService.RecordListRequest request,
        io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListHistoricalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetLatest returns the latest Record of the given Subject
     * </pre>
     */
    public void getLatest(axoom.recordz.v1.RecordzService.RecordRequest request,
        io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLatestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecordzBlockingStub extends io.grpc.stub.AbstractStub<RecordzBlockingStub> {
    private RecordzBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordzBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordzBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordzBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordzSubscription registers a Subscription for all Records of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public axoom.recordz.v1.RecordzService.Subscription createRecordzSubscription(axoom.recordz.v1.RecordzService.SubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRecordzSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetStream returns an unbounded Record stream of beeing requested in the given Subscription. The stream endures at max. 30 min.
     * </pre>
     */
    public java.util.Iterator<axoom.recordz.v1.Recordz.Record> getStream(
        axoom.recordz.v1.RecordzService.RecordStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded Record stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more Records stored in the specified time range.
     * </pre>
     */
    public java.util.Iterator<axoom.recordz.v1.Recordz.Record> listHistorical(
        axoom.recordz.v1.RecordzService.RecordListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListHistoricalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetLatest returns the latest Record of the given Subject
     * </pre>
     */
    public axoom.recordz.v1.Recordz.Record getLatest(axoom.recordz.v1.RecordzService.RecordRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLatestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecordzFutureStub extends io.grpc.stub.AbstractStub<RecordzFutureStub> {
    private RecordzFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecordzFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecordzFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecordzFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordzSubscription registers a Subscription for all Records of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordz.v1.RecordzService.Subscription> createRecordzSubscription(
        axoom.recordz.v1.RecordzService.SubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRecordzSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetLatest returns the latest Record of the given Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.recordz.v1.Recordz.Record> getLatest(
        axoom.recordz.v1.RecordzService.RecordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLatestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RECORDZ_SUBSCRIPTION = 0;
  private static final int METHODID_GET_STREAM = 1;
  private static final int METHODID_LIST_HISTORICAL = 2;
  private static final int METHODID_GET_LATEST = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecordzImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecordzImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RECORDZ_SUBSCRIPTION:
          serviceImpl.createRecordzSubscription((axoom.recordz.v1.RecordzService.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordz.v1.RecordzService.Subscription>) responseObserver);
          break;
        case METHODID_GET_STREAM:
          serviceImpl.getStream((axoom.recordz.v1.RecordzService.RecordStreamRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record>) responseObserver);
          break;
        case METHODID_LIST_HISTORICAL:
          serviceImpl.listHistorical((axoom.recordz.v1.RecordzService.RecordListRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record>) responseObserver);
          break;
        case METHODID_GET_LATEST:
          serviceImpl.getLatest((axoom.recordz.v1.RecordzService.RecordRequest) request,
              (io.grpc.stub.StreamObserver<axoom.recordz.v1.Recordz.Record>) responseObserver);
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

  private static abstract class RecordzBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecordzBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.recordz.v1.RecordzService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Recordz");
    }
  }

  private static final class RecordzFileDescriptorSupplier
      extends RecordzBaseDescriptorSupplier {
    RecordzFileDescriptorSupplier() {}
  }

  private static final class RecordzMethodDescriptorSupplier
      extends RecordzBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecordzMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecordzGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecordzFileDescriptorSupplier())
              .addMethod(getCreateRecordzSubscriptionMethod())
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
