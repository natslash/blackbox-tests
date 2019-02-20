package com.axoom.qrecords.grpc;

import io.grpc.*;
import io.grpc.MethodDescriptor.MethodType;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import java.util.Iterator;
import javax.annotation.Generated;
import com.axoom.qrecords.Qrecords;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Descriptors;
import io.grpc.protobuf.ProtoFileDescriptorSupplier;
import io.grpc.protobuf.ProtoMethodDescriptorSupplier;
import io.grpc.protobuf.ProtoServiceDescriptorSupplier;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ServerCalls.*;
import io.grpc.stub.*;
import io.grpc.stub.annotations.RpcMethod;

/**
 */
@Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: qrecords.proto")
public final class QRecordsGrpc {

  private QRecordsGrpc() {}

  public static final String SERVICE_NAME = "com.axoom.qrecords.QRecords";

  // Static method descriptors that strictly reflect the proto.
  private static volatile MethodDescriptor<Qrecords.RecordStreamRequest,
      Qrecords.QRecord> getGetStreamMethod;

  @RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = Qrecords.RecordStreamRequest.class,
      responseType = Qrecords.QRecord.class,
      methodType = MethodType.SERVER_STREAMING)
  public static MethodDescriptor<Qrecords.RecordStreamRequest,
      Qrecords.QRecord> getGetStreamMethod() {
    MethodDescriptor<Qrecords.RecordStreamRequest, Qrecords.QRecord> getGetStreamMethod;
    if ((getGetStreamMethod = QRecordsGrpc.getGetStreamMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getGetStreamMethod = QRecordsGrpc.getGetStreamMethod) == null) {
          QRecordsGrpc.getGetStreamMethod = getGetStreamMethod = 
              MethodDescriptor.<Qrecords.RecordStreamRequest, Qrecords.QRecord>newBuilder()
              .setType(MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.axoom.qrecords.QRecords", "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(ProtoUtils.marshaller(
                  Qrecords.RecordStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(
                  Qrecords.QRecord.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("GetStream"))
                  .build();
          }
        }
     }
     return getGetStreamMethod;
  }

  private static volatile MethodDescriptor<Qrecords.RecordRequest,
      Qrecords.QRecord> getGetMaterializedMethod;

  @RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMaterialized",
      requestType = Qrecords.RecordRequest.class,
      responseType = Qrecords.QRecord.class,
      methodType = MethodType.UNARY)
  public static MethodDescriptor<Qrecords.RecordRequest,
      Qrecords.QRecord> getGetMaterializedMethod() {
    MethodDescriptor<Qrecords.RecordRequest, Qrecords.QRecord> getGetMaterializedMethod;
    if ((getGetMaterializedMethod = QRecordsGrpc.getGetMaterializedMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getGetMaterializedMethod = QRecordsGrpc.getGetMaterializedMethod) == null) {
          QRecordsGrpc.getGetMaterializedMethod = getGetMaterializedMethod = 
              MethodDescriptor.<Qrecords.RecordRequest, Qrecords.QRecord>newBuilder()
              .setType(MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.axoom.qrecords.QRecords", "GetMaterialized"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(ProtoUtils.marshaller(
                  Qrecords.RecordRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(
                  Qrecords.QRecord.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("GetMaterialized"))
                  .build();
          }
        }
     }
     return getGetMaterializedMethod;
  }

  private static volatile MethodDescriptor<Qrecords.RecordListRequest,
      Qrecords.QRecord> getListHistoricalMethod;

  @RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHistorical",
      requestType = Qrecords.RecordListRequest.class,
      responseType = Qrecords.QRecord.class,
      methodType = MethodType.SERVER_STREAMING)
  public static MethodDescriptor<Qrecords.RecordListRequest,
      Qrecords.QRecord> getListHistoricalMethod() {
    MethodDescriptor<Qrecords.RecordListRequest, Qrecords.QRecord> getListHistoricalMethod;
    if ((getListHistoricalMethod = QRecordsGrpc.getListHistoricalMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getListHistoricalMethod = QRecordsGrpc.getListHistoricalMethod) == null) {
          QRecordsGrpc.getListHistoricalMethod = getListHistoricalMethod = 
              MethodDescriptor.<Qrecords.RecordListRequest, Qrecords.QRecord>newBuilder()
              .setType(MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.axoom.qrecords.QRecords", "ListHistorical"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(ProtoUtils.marshaller(
                  Qrecords.RecordListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(
                  Qrecords.QRecord.getDefaultInstance()))
                  .setSchemaDescriptor(new QRecordsMethodDescriptorSupplier("ListHistorical"))
                  .build();
          }
        }
     }
     return getListHistoricalMethod;
  }

  private static volatile MethodDescriptor<Qrecords.RecordRequest,
      Qrecords.QRecord> getGetLatestHistoricalMethod;

  @RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatestHistorical",
      requestType = Qrecords.RecordRequest.class,
      responseType = Qrecords.QRecord.class,
      methodType = MethodType.UNARY)
  public static MethodDescriptor<Qrecords.RecordRequest,
      Qrecords.QRecord> getGetLatestHistoricalMethod() {
    MethodDescriptor<Qrecords.RecordRequest, Qrecords.QRecord> getGetLatestHistoricalMethod;
    if ((getGetLatestHistoricalMethod = QRecordsGrpc.getGetLatestHistoricalMethod) == null) {
      synchronized (QRecordsGrpc.class) {
        if ((getGetLatestHistoricalMethod = QRecordsGrpc.getGetLatestHistoricalMethod) == null) {
          QRecordsGrpc.getGetLatestHistoricalMethod = getGetLatestHistoricalMethod = 
              MethodDescriptor.<Qrecords.RecordRequest, Qrecords.QRecord>newBuilder()
              .setType(MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.axoom.qrecords.QRecords", "GetLatestHistorical"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(ProtoUtils.marshaller(
                  Qrecords.RecordRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(
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
  public static QRecordsStub newStub(Channel channel) {
    return new QRecordsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QRecordsBlockingStub newBlockingStub(
      Channel channel) {
    return new QRecordsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static QRecordsFutureStub newFutureStub(
      Channel channel) {
    return new QRecordsFutureStub(channel);
  }

  /**
   */
  public static abstract class QRecordsImplBase implements BindableService {

    /**
     * <pre>
     * GetStream returns an unbounded data stream for the requested data composition. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(Qrecords.RecordStreamRequest request,
        StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetMaterialized returns the materialized view of the requested data composition
     * </pre>
     */
    public void getMaterialized(Qrecords.RecordRequest request,
        StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMaterializedMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListHistorical returns a bounded data stream for the requested data composition.
     * The stream ends either when the specified limit exceeded or when there are no more records stored in the specified time range.
     * </pre>
     */
    public void listHistorical(Qrecords.RecordListRequest request,
        StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnimplementedUnaryCall(getListHistoricalMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetLatestHistorical returns the latest historical known record
     * </pre>
     */
    public void getLatestHistorical(Qrecords.RecordRequest request,
        StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLatestHistoricalMethod(), responseObserver);
    }

    @Override public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(getServiceDescriptor())
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
  public static final class QRecordsStub extends AbstractStub<QRecordsStub> {
    private QRecordsStub(Channel channel) {
      super(channel);
    }

    private QRecordsStub(Channel channel,
        CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected QRecordsStub build(Channel channel,
        CallOptions callOptions) {
      return new QRecordsStub(channel, callOptions);
    }

    /**
     * <pre>
     * GetStream returns an unbounded data stream for the requested data composition. The stream endures at max. 30 min.
     * </pre>
     */
    public void getStream(Qrecords.RecordStreamRequest request,
        StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetMaterialized returns the materialized view of the requested data composition
     * </pre>
     */
    public void getMaterialized(Qrecords.RecordRequest request,
        StreamObserver<Qrecords.QRecord> responseObserver) {
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
        StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListHistoricalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetLatestHistorical returns the latest historical known record
     * </pre>
     */
    public void getLatestHistorical(Qrecords.RecordRequest request,
        StreamObserver<Qrecords.QRecord> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLatestHistoricalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class QRecordsBlockingStub extends AbstractStub<QRecordsBlockingStub> {
    private QRecordsBlockingStub(Channel channel) {
      super(channel);
    }

    private QRecordsBlockingStub(Channel channel,
        CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected QRecordsBlockingStub build(Channel channel,
        CallOptions callOptions) {
      return new QRecordsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * GetStream returns an unbounded data stream for the requested data composition. The stream endures at max. 30 min.
     * </pre>
     */
    public Iterator<Qrecords.QRecord> getStream(
        Qrecords.RecordStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetMaterialized returns the materialized view of the requested data composition
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
    public Iterator<Qrecords.QRecord> listHistorical(
        Qrecords.RecordListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListHistoricalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetLatestHistorical returns the latest historical known record
     * </pre>
     */
    public Qrecords.QRecord getLatestHistorical(Qrecords.RecordRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLatestHistoricalMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class QRecordsFutureStub extends AbstractStub<QRecordsFutureStub> {
    private QRecordsFutureStub(Channel channel) {
      super(channel);
    }

    private QRecordsFutureStub(Channel channel,
        CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected QRecordsFutureStub build(Channel channel,
        CallOptions callOptions) {
      return new QRecordsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * GetMaterialized returns the materialized view of the requested data composition
     * </pre>
     */
    public ListenableFuture<Qrecords.QRecord> getMaterialized(
        Qrecords.RecordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMaterializedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetLatestHistorical returns the latest historical known record
     * </pre>
     */
    public ListenableFuture<Qrecords.QRecord> getLatestHistorical(
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
      UnaryMethod<Req, Resp>,
      ServerStreamingMethod<Req, Resp>,
      ClientStreamingMethod<Req, Resp>,
      BidiStreamingMethod<Req, Resp> {
    private final QRecordsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(QRecordsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STREAM:
          serviceImpl.getStream((Qrecords.RecordStreamRequest) request,
              (StreamObserver<Qrecords.QRecord>) responseObserver);
          break;
        case METHODID_GET_MATERIALIZED:
          serviceImpl.getMaterialized((Qrecords.RecordRequest) request,
              (StreamObserver<Qrecords.QRecord>) responseObserver);
          break;
        case METHODID_LIST_HISTORICAL:
          serviceImpl.listHistorical((Qrecords.RecordListRequest) request,
              (StreamObserver<Qrecords.QRecord>) responseObserver);
          break;
        case METHODID_GET_LATEST_HISTORICAL:
          serviceImpl.getLatestHistorical((Qrecords.RecordRequest) request,
              (StreamObserver<Qrecords.QRecord>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public StreamObserver<Req> invoke(
        StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class QRecordsBaseDescriptorSupplier
      implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
    QRecordsBaseDescriptorSupplier() {}

    @Override
    public Descriptors.FileDescriptor getFileDescriptor() {
      return Qrecords.getDescriptor();
    }

    @Override
    public Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("QRecords");
    }
  }

  private static final class QRecordsFileDescriptorSupplier
      extends QRecordsBaseDescriptorSupplier {
    QRecordsFileDescriptorSupplier() {}
  }

  private static final class QRecordsMethodDescriptorSupplier
      extends QRecordsBaseDescriptorSupplier
      implements ProtoMethodDescriptorSupplier {
    private final String methodName;

    QRecordsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile ServiceDescriptor serviceDescriptor;

  public static ServiceDescriptor getServiceDescriptor() {
    ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (QRecordsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = ServiceDescriptor.newBuilder(SERVICE_NAME)
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
