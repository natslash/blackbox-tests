package com.axoom.qrecords.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import com.axoom.qrecords.Qrecords;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: qrecords.proto")
public final class QRecordsGrpc {

  private QRecordsGrpc() {}

  public static final String SERVICE_NAME = "qrecords.QRecords";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Qrecords.RecordStreamRequest,
      Qrecords.QRecord> getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = Qrecords.RecordStreamRequest.class,
      responseType = Qrecords.QRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Qrecords.RecordStreamRequest,
      Qrecords.QRecord> getGetStreamMethod() {
    io.grpc.MethodDescriptor<Qrecords.RecordStreamRequest, Qrecords.QRecord> getGetStreamMethod;
    if ((getGetStreamMethod = QRecordsGrpc.getGetStreamMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getGetStreamMethod = QRecordsGrpc.getGetStreamMethod) == null) {
          QRecordsGrpc.getGetStreamMethod = getGetStreamMethod = 
              io.grpc.MethodDescriptor.<Qrecords.RecordStreamRequest, Qrecords.QRecord>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "qrecords.QRecords", "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Qrecords.RecordStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Qrecords.QRecord.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("GetStream"))
                  .build();
          }
        }
     }
     return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Qrecords.RecordRequest,
      Qrecords.QRecord> getGetMaterializedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMaterialized",
      requestType = Qrecords.RecordRequest.class,
      responseType = Qrecords.QRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Qrecords.RecordRequest,
      Qrecords.QRecord> getGetMaterializedMethod() {
    io.grpc.MethodDescriptor<Qrecords.RecordRequest, Qrecords.QRecord> getGetMaterializedMethod;
    if ((getGetMaterializedMethod = QRecordsGrpc.getGetMaterializedMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getGetMaterializedMethod = QRecordsGrpc.getGetMaterializedMethod) == null) {
          QRecordsGrpc.getGetMaterializedMethod = getGetMaterializedMethod = 
              io.grpc.MethodDescriptor.<Qrecords.RecordRequest, Qrecords.QRecord>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "qrecords.QRecords", "GetMaterialized"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Qrecords.RecordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Qrecords.QRecord.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("GetMaterialized"))
                  .build();
          }
        }
     }
     return getGetMaterializedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Qrecords.RecordListRequest,
      Qrecords.QRecord> getListHistoricalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHistorical",
      requestType = Qrecords.RecordListRequest.class,
      responseType = Qrecords.QRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Qrecords.RecordListRequest,
      Qrecords.QRecord> getListHistoricalMethod() {
    io.grpc.MethodDescriptor<Qrecords.RecordListRequest, Qrecords.QRecord> getListHistoricalMethod;
    if ((getListHistoricalMethod = QRecordsGrpc.getListHistoricalMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getListHistoricalMethod = QRecordsGrpc.getListHistoricalMethod) == null) {
          QRecordsGrpc.getListHistoricalMethod = getListHistoricalMethod = 
              io.grpc.MethodDescriptor.<Qrecords.RecordListRequest, Qrecords.QRecord>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "qrecords.QRecords", "ListHistorical"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Qrecords.RecordListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Qrecords.QRecord.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("ListHistorical"))
                  .build();
          }
        }
     }
     return getListHistoricalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Qrecords.RecordRequest,
      Qrecords.QRecord> getGetLatestHistoricalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatestHistorical",
      requestType = Qrecords.RecordRequest.class,
      responseType = Qrecords.QRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Qrecords.RecordRequest,
      Qrecords.QRecord> getGetLatestHistoricalMethod() {
    io.grpc.MethodDescriptor<Qrecords.RecordRequest, Qrecords.QRecord> getGetLatestHistoricalMethod;
    if ((getGetLatestHistoricalMethod = QRecordsGrpc.getGetLatestHistoricalMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getGetLatestHistoricalMethod = QRecordsGrpc.getGetLatestHistoricalMethod) == null) {
          QRecordsGrpc.getGetLatestHistoricalMethod = getGetLatestHistoricalMethod = 
              io.grpc.MethodDescriptor.<Qrecords.RecordRequest, Qrecords.QRecord>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "qrecords.QRecords", "GetLatestHistorical"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Qrecords.RecordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Qrecords.QRecord.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("GetLatestHistorical"))
                  .build();
          }
        }
     }
     return getGetLatestHistoricalMethod;
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
     * GetStream returns an unbounded data stream for the requested data composition. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(Qrecords.RecordStreamRequest request,
        io.grpc.stub.StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetMaterialized returns the materialized view of the requested data composition.
     * </pre>
     */
    public void getMaterialized(Qrecords.RecordRequest request,
        io.grpc.stub.StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMaterializedMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded data stream for the requested data composition.
     * The stream ends either when the specified limit exceeded or when there are no more records stored in the specified time range.
     * </pre>
     */
    public void listHistorical(Qrecords.RecordListRequest request,
        io.grpc.stub.StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnimplementedUnaryCall(getListHistoricalMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetLatestHistorical returns the latest historical known record.
     * </pre>
     */
    public void getLatestHistorical(Qrecords.RecordRequest request,
        io.grpc.stub.StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLatestHistoricalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                Qrecords.RecordStreamRequest,
                Qrecords.QRecord>(
                  this, METHODID_GET_STREAM)))
          .addMethod(
            getGetMaterializedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Qrecords.RecordRequest,
                Qrecords.QRecord>(
                  this, METHODID_GET_MATERIALIZED)))
          .addMethod(
            getListHistoricalMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                Qrecords.RecordListRequest,
                Qrecords.QRecord>(
                  this, METHODID_LIST_HISTORICAL)))
          .addMethod(
            getGetLatestHistoricalMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Qrecords.RecordRequest,
                Qrecords.QRecord>(
                  this, METHODID_GET_LATEST_HISTORICAL)))
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
     * GetStream returns an unbounded data stream for the requested data composition. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(Qrecords.RecordStreamRequest request,
        io.grpc.stub.StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetMaterialized returns the materialized view of the requested data composition.
     * </pre>
     */
    public void getMaterialized(Qrecords.RecordRequest request,
        io.grpc.stub.StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMaterializedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded data stream for the requested data composition.
     * The stream ends either when the specified limit exceeded or when there are no more records stored in the specified time range.
     * </pre>
     */
    public void listHistorical(Qrecords.RecordListRequest request,
        io.grpc.stub.StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListHistoricalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetLatestHistorical returns the latest historical known record.
     * </pre>
     */
    public void getLatestHistorical(Qrecords.RecordRequest request,
        io.grpc.stub.StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLatestHistoricalMethod(), getCallOptions()), request, responseObserver);
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
     * GetStream returns an unbounded data stream for the requested data composition. The stream endures at max. 30 min.
     * </pre>
     */
    public java.util.Iterator<Qrecords.QRecord> getStream(
        Qrecords.RecordStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetMaterialized returns the materialized view of the requested data composition.
     * </pre>
     */
    public Qrecords.QRecord getMaterialized(Qrecords.RecordRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMaterializedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded data stream for the requested data composition.
     * The stream ends either when the specified limit exceeded or when there are no more records stored in the specified time range.
     * </pre>
     */
    public java.util.Iterator<Qrecords.QRecord> listHistorical(
        Qrecords.RecordListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListHistoricalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetLatestHistorical returns the latest historical known record.
     * </pre>
     */
    public Qrecords.QRecord getLatestHistorical(Qrecords.RecordRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLatestHistoricalMethod(), getCallOptions(), request);
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
     * GetMaterialized returns the materialized view of the requested data composition.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Qrecords.QRecord> getMaterialized(
        Qrecords.RecordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMaterializedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetLatestHistorical returns the latest historical known record.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Qrecords.QRecord> getLatestHistorical(
        Qrecords.RecordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLatestHistoricalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STREAM = 0;
  private static final int METHODID_GET_MATERIALIZED = 1;
  private static final int METHODID_LIST_HISTORICAL = 2;
  private static final int METHODID_GET_LATEST_HISTORICAL = 3;

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
        case METHODID_GET_STREAM:
          serviceImpl.getStream((Qrecords.RecordStreamRequest) request,
              (io.grpc.stub.StreamObserver<Qrecords.QRecord>) responseObserver);
          break;
        case METHODID_GET_MATERIALIZED:
          serviceImpl.getMaterialized((Qrecords.RecordRequest) request,
              (io.grpc.stub.StreamObserver<Qrecords.QRecord>) responseObserver);
          break;
        case METHODID_LIST_HISTORICAL:
          serviceImpl.listHistorical((Qrecords.RecordListRequest) request,
              (io.grpc.stub.StreamObserver<Qrecords.QRecord>) responseObserver);
          break;
        case METHODID_GET_LATEST_HISTORICAL:
          serviceImpl.getLatestHistorical((Qrecords.RecordRequest) request,
              (io.grpc.stub.StreamObserver<Qrecords.QRecord>) responseObserver);
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
      return Qrecords.getDescriptor();
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
              .addMethod(getGetStreamMethod())
              .addMethod(getGetMaterializedMethod())
              .addMethod(getListHistoricalMethod())
              .addMethod(getGetLatestHistoricalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
