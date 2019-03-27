package axoom.records.v1;

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
    comments = "Source: qrecords.proto")
public final class QRecordsGrpc {

  private QRecordsGrpc() {}

  public static final String SERVICE_NAME = "axoom.records.v1.QRecords";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.SubscriptionRequest,
      axoom.records.v1.Qrecords.Subscription> getCreateRecordsSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRecordsSubscription",
      requestType = axoom.records.v1.Qrecords.SubscriptionRequest.class,
      responseType = axoom.records.v1.Qrecords.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.SubscriptionRequest,
      axoom.records.v1.Qrecords.Subscription> getCreateRecordsSubscriptionMethod() {
    io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.SubscriptionRequest, axoom.records.v1.Qrecords.Subscription> getCreateRecordsSubscriptionMethod;
    if ((getCreateRecordsSubscriptionMethod = QRecordsGrpc.getCreateRecordsSubscriptionMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getCreateRecordsSubscriptionMethod = QRecordsGrpc.getCreateRecordsSubscriptionMethod) == null) {
          QRecordsGrpc.getCreateRecordsSubscriptionMethod = getCreateRecordsSubscriptionMethod = 
              io.grpc.MethodDescriptor.<axoom.records.v1.Qrecords.SubscriptionRequest, axoom.records.v1.Qrecords.Subscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.records.v1.QRecords", "CreateRecordsSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Qrecords.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Qrecords.Subscription.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("CreateRecordsSubscription"))
                  .build();
          }
        }
     }
     return getCreateRecordsSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordStreamRequest,
      axoom.records.v1.Records.Record> getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = axoom.records.v1.Qrecords.RecordStreamRequest.class,
      responseType = axoom.records.v1.Records.Record.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordStreamRequest,
      axoom.records.v1.Records.Record> getGetStreamMethod() {
    io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordStreamRequest, axoom.records.v1.Records.Record> getGetStreamMethod;
    if ((getGetStreamMethod = QRecordsGrpc.getGetStreamMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getGetStreamMethod = QRecordsGrpc.getGetStreamMethod) == null) {
          QRecordsGrpc.getGetStreamMethod = getGetStreamMethod = 
              io.grpc.MethodDescriptor.<axoom.records.v1.Qrecords.RecordStreamRequest, axoom.records.v1.Records.Record>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.records.v1.QRecords", "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Qrecords.RecordStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Records.Record.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("GetStream"))
                  .build();
          }
        }
     }
     return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordListRequest,
      axoom.records.v1.Records.Record> getListHistoricalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHistorical",
      requestType = axoom.records.v1.Qrecords.RecordListRequest.class,
      responseType = axoom.records.v1.Records.Record.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordListRequest,
      axoom.records.v1.Records.Record> getListHistoricalMethod() {
    io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordListRequest, axoom.records.v1.Records.Record> getListHistoricalMethod;
    if ((getListHistoricalMethod = QRecordsGrpc.getListHistoricalMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getListHistoricalMethod = QRecordsGrpc.getListHistoricalMethod) == null) {
          QRecordsGrpc.getListHistoricalMethod = getListHistoricalMethod = 
              io.grpc.MethodDescriptor.<axoom.records.v1.Qrecords.RecordListRequest, axoom.records.v1.Records.Record>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.records.v1.QRecords", "ListHistorical"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Qrecords.RecordListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Records.Record.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("ListHistorical"))
                  .build();
          }
        }
     }
     return getListHistoricalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordRequest,
      axoom.records.v1.Records.Record> getGetLatestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatest",
      requestType = axoom.records.v1.Qrecords.RecordRequest.class,
      responseType = axoom.records.v1.Records.Record.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordRequest,
      axoom.records.v1.Records.Record> getGetLatestMethod() {
    io.grpc.MethodDescriptor<axoom.records.v1.Qrecords.RecordRequest, axoom.records.v1.Records.Record> getGetLatestMethod;
    if ((getGetLatestMethod = QRecordsGrpc.getGetLatestMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getGetLatestMethod = QRecordsGrpc.getGetLatestMethod) == null) {
          QRecordsGrpc.getGetLatestMethod = getGetLatestMethod = 
              io.grpc.MethodDescriptor.<axoom.records.v1.Qrecords.RecordRequest, axoom.records.v1.Records.Record>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.records.v1.QRecords", "GetLatest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Qrecords.RecordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.records.v1.Records.Record.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("GetLatest"))
                  .build();
          }
        }
     }
     return getGetLatestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static QRecordsStub newStub(io.grpc.Channel channel) {
    return new QRecordsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QRecordsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new QRecordsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static QRecordsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new QRecordsFutureStub(channel);
  }

  /**
   */
  public static abstract class QRecordsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateRecordsSubscription registers a Subscription for all Records of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public void createRecordsSubscription(axoom.records.v1.Qrecords.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Qrecords.Subscription> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateRecordsSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded Record stream of beeing requested in the given Subscription. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.records.v1.Qrecords.RecordStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded Record stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more Records stored in the specified time range.
     * </pre>
     */
    public void listHistorical(axoom.records.v1.Qrecords.RecordListRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record> responseObserver) {
      asyncUnimplementedUnaryCall(getListHistoricalMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetLatest returns the latest Record of the given Subject
     * </pre>
     */
    public void getLatest(axoom.records.v1.Qrecords.RecordRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLatestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateRecordsSubscriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.records.v1.Qrecords.SubscriptionRequest,
                axoom.records.v1.Qrecords.Subscription>(
                  this, METHODID_CREATE_RECORDS_SUBSCRIPTION)))
          .addMethod(
            getGetStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.records.v1.Qrecords.RecordStreamRequest,
                axoom.records.v1.Records.Record>(
                  this, METHODID_GET_STREAM)))
          .addMethod(
            getListHistoricalMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.records.v1.Qrecords.RecordListRequest,
                axoom.records.v1.Records.Record>(
                  this, METHODID_LIST_HISTORICAL)))
          .addMethod(
            getGetLatestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.records.v1.Qrecords.RecordRequest,
                axoom.records.v1.Records.Record>(
                  this, METHODID_GET_LATEST)))
          .build();
    }
  }

  /**
   */
  public static final class QRecordsStub extends io.grpc.stub.AbstractStub<QRecordsStub> {
    private QRecordsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private QRecordsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QRecordsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new QRecordsStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordsSubscription registers a Subscription for all Records of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public void createRecordsSubscription(axoom.records.v1.Qrecords.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Qrecords.Subscription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateRecordsSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetStream returns an unbounded Record stream of beeing requested in the given Subscription. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(axoom.records.v1.Qrecords.RecordStreamRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded Record stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more Records stored in the specified time range.
     * </pre>
     */
    public void listHistorical(axoom.records.v1.Qrecords.RecordListRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListHistoricalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetLatest returns the latest Record of the given Subject
     * </pre>
     */
    public void getLatest(axoom.records.v1.Qrecords.RecordRequest request,
        io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLatestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class QRecordsBlockingStub extends io.grpc.stub.AbstractStub<QRecordsBlockingStub> {
    private QRecordsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private QRecordsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QRecordsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new QRecordsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordsSubscription registers a Subscription for all Records of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public axoom.records.v1.Qrecords.Subscription createRecordsSubscription(axoom.records.v1.Qrecords.SubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateRecordsSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetStream returns an unbounded Record stream of beeing requested in the given Subscription. The stream endures at max. 30 min.
     * </pre>
     */
    public java.util.Iterator<axoom.records.v1.Records.Record> getStream(
        axoom.records.v1.Qrecords.RecordStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded Record stream of the requested Subject.
     * The stream ends either when the specified limit exceeded or when there are no more Records stored in the specified time range.
     * </pre>
     */
    public java.util.Iterator<axoom.records.v1.Records.Record> listHistorical(
        axoom.records.v1.Qrecords.RecordListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListHistoricalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetLatest returns the latest Record of the given Subject
     * </pre>
     */
    public axoom.records.v1.Records.Record getLatest(axoom.records.v1.Qrecords.RecordRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLatestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class QRecordsFutureStub extends io.grpc.stub.AbstractStub<QRecordsFutureStub> {
    private QRecordsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private QRecordsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QRecordsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new QRecordsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateRecordsSubscription registers a Subscription for all Records of the requested SubjectType.
     * This Subscription should be used in GetStream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.records.v1.Qrecords.Subscription> createRecordsSubscription(
        axoom.records.v1.Qrecords.SubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateRecordsSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetLatest returns the latest Record of the given Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.records.v1.Records.Record> getLatest(
        axoom.records.v1.Qrecords.RecordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLatestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RECORDS_SUBSCRIPTION = 0;
  private static final int METHODID_GET_STREAM = 1;
  private static final int METHODID_LIST_HISTORICAL = 2;
  private static final int METHODID_GET_LATEST = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final QRecordsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(QRecordsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RECORDS_SUBSCRIPTION:
          serviceImpl.createRecordsSubscription((axoom.records.v1.Qrecords.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<axoom.records.v1.Qrecords.Subscription>) responseObserver);
          break;
        case METHODID_GET_STREAM:
          serviceImpl.getStream((axoom.records.v1.Qrecords.RecordStreamRequest) request,
              (io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record>) responseObserver);
          break;
        case METHODID_LIST_HISTORICAL:
          serviceImpl.listHistorical((axoom.records.v1.Qrecords.RecordListRequest) request,
              (io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record>) responseObserver);
          break;
        case METHODID_GET_LATEST:
          serviceImpl.getLatest((axoom.records.v1.Qrecords.RecordRequest) request,
              (io.grpc.stub.StreamObserver<axoom.records.v1.Records.Record>) responseObserver);
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

  private static abstract class QRecordsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    QRecordsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.records.v1.Qrecords.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("QRecords");
    }
  }

  private static final class QRecordsFileDescriptorSupplier
      extends QRecordsBaseDescriptorSupplier {
    QRecordsFileDescriptorSupplier() {}
  }

  private static final class QRecordsMethodDescriptorSupplier
      extends QRecordsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    QRecordsMethodDescriptorSupplier(String methodName) {
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
      synchronized (QRecordsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new QRecordsFileDescriptorSupplier())
              .addMethod(getCreateRecordsSubscriptionMethod())
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
