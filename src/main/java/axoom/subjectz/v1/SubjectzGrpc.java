package axoom.subjectz.v1;

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
    comments = "Source: subjectz_service.proto")
public final class SubjectzGrpc {

  private SubjectzGrpc() {}

  public static final String SERVICE_NAME = "axoom.subjectz.v1.Subjectz";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectRequest,
      axoom.subjectz.v1.Subjectz.Subject> getCreateSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubject",
      requestType = axoom.subjectz.v1.SubjectzService.CreateSubjectRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectRequest,
      axoom.subjectz.v1.Subjectz.Subject> getCreateSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectRequest, axoom.subjectz.v1.Subjectz.Subject> getCreateSubjectMethod;
    if ((getCreateSubjectMethod = SubjectzGrpc.getCreateSubjectMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getCreateSubjectMethod = SubjectzGrpc.getCreateSubjectMethod) == null) {
          SubjectzGrpc.getCreateSubjectMethod = getCreateSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.CreateSubjectRequest, axoom.subjectz.v1.Subjectz.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "CreateSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.CreateSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("CreateSubject"))
                  .build();
          }
        }
     }
     return getCreateSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectRequest,
      axoom.subjectz.v1.Subjectz.Subject> getGetSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubject",
      requestType = axoom.subjectz.v1.SubjectzService.GetSubjectRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectRequest,
      axoom.subjectz.v1.Subjectz.Subject> getGetSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectRequest, axoom.subjectz.v1.Subjectz.Subject> getGetSubjectMethod;
    if ((getGetSubjectMethod = SubjectzGrpc.getGetSubjectMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetSubjectMethod = SubjectzGrpc.getGetSubjectMethod) == null) {
          SubjectzGrpc.getGetSubjectMethod = getGetSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetSubjectRequest, axoom.subjectz.v1.Subjectz.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetSubject"))
                  .build();
          }
        }
     }
     return getGetSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest,
      axoom.subjectz.v1.Subjectz.SubjectContext> getGetSubjectContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectContext",
      requestType = axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.SubjectContext.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest,
      axoom.subjectz.v1.Subjectz.SubjectContext> getGetSubjectContextMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest, axoom.subjectz.v1.Subjectz.SubjectContext> getGetSubjectContextMethod;
    if ((getGetSubjectContextMethod = SubjectzGrpc.getGetSubjectContextMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetSubjectContextMethod = SubjectzGrpc.getGetSubjectContextMethod) == null) {
          SubjectzGrpc.getGetSubjectContextMethod = getGetSubjectContextMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest, axoom.subjectz.v1.Subjectz.SubjectContext>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetSubjectContext"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.SubjectContext.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetSubjectContext"))
                  .build();
          }
        }
     }
     return getGetSubjectContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectzRequest,
      axoom.subjectz.v1.Subjectz.Subject> getGetSubjectzMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectz",
      requestType = axoom.subjectz.v1.SubjectzService.GetSubjectzRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectzRequest,
      axoom.subjectz.v1.Subjectz.Subject> getGetSubjectzMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectzRequest, axoom.subjectz.v1.Subjectz.Subject> getGetSubjectzMethod;
    if ((getGetSubjectzMethod = SubjectzGrpc.getGetSubjectzMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetSubjectzMethod = SubjectzGrpc.getGetSubjectzMethod) == null) {
          SubjectzGrpc.getGetSubjectzMethod = getGetSubjectzMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetSubjectzRequest, axoom.subjectz.v1.Subjectz.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetSubjectz"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectzRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetSubjectz"))
                  .build();
          }
        }
     }
     return getGetSubjectzMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest,
      axoom.subjectz.v1.Subjectz.Subject> getUpdateSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubject",
      requestType = axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest,
      axoom.subjectz.v1.Subjectz.Subject> getUpdateSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest, axoom.subjectz.v1.Subjectz.Subject> getUpdateSubjectMethod;
    if ((getUpdateSubjectMethod = SubjectzGrpc.getUpdateSubjectMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getUpdateSubjectMethod = SubjectzGrpc.getUpdateSubjectMethod) == null) {
          SubjectzGrpc.getUpdateSubjectMethod = getUpdateSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest, axoom.subjectz.v1.Subjectz.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "UpdateSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("UpdateSubject"))
                  .build();
          }
        }
     }
     return getUpdateSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest,
      axoom.subjectz.v1.Subjectz.SubjectType> getCreateSubjectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubjectType",
      requestType = axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.SubjectType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest,
      axoom.subjectz.v1.Subjectz.SubjectType> getCreateSubjectTypeMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest, axoom.subjectz.v1.Subjectz.SubjectType> getCreateSubjectTypeMethod;
    if ((getCreateSubjectTypeMethod = SubjectzGrpc.getCreateSubjectTypeMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getCreateSubjectTypeMethod = SubjectzGrpc.getCreateSubjectTypeMethod) == null) {
          SubjectzGrpc.getCreateSubjectTypeMethod = getCreateSubjectTypeMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest, axoom.subjectz.v1.Subjectz.SubjectType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "CreateSubjectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.SubjectType.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("CreateSubjectType"))
                  .build();
          }
        }
     }
     return getCreateSubjectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest,
      axoom.subjectz.v1.Subjectz.SubjectType> getGetSubjectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectType",
      requestType = axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.SubjectType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest,
      axoom.subjectz.v1.Subjectz.SubjectType> getGetSubjectTypeMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest, axoom.subjectz.v1.Subjectz.SubjectType> getGetSubjectTypeMethod;
    if ((getGetSubjectTypeMethod = SubjectzGrpc.getGetSubjectTypeMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetSubjectTypeMethod = SubjectzGrpc.getGetSubjectTypeMethod) == null) {
          SubjectzGrpc.getGetSubjectTypeMethod = getGetSubjectTypeMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest, axoom.subjectz.v1.Subjectz.SubjectType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetSubjectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.SubjectType.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetSubjectType"))
                  .build();
          }
        }
     }
     return getGetSubjectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest,
      axoom.subjectz.v1.Subjectz.SubjectTypeContext> getGetSubjectTypeContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectTypeContext",
      requestType = axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.SubjectTypeContext.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest,
      axoom.subjectz.v1.Subjectz.SubjectTypeContext> getGetSubjectTypeContextMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest, axoom.subjectz.v1.Subjectz.SubjectTypeContext> getGetSubjectTypeContextMethod;
    if ((getGetSubjectTypeContextMethod = SubjectzGrpc.getGetSubjectTypeContextMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetSubjectTypeContextMethod = SubjectzGrpc.getGetSubjectTypeContextMethod) == null) {
          SubjectzGrpc.getGetSubjectTypeContextMethod = getGetSubjectTypeContextMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest, axoom.subjectz.v1.Subjectz.SubjectTypeContext>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetSubjectTypeContext"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.SubjectTypeContext.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetSubjectTypeContext"))
                  .build();
          }
        }
     }
     return getGetSubjectTypeContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest,
      axoom.subjectz.v1.Subjectz.SubjectType> getGetSubjectTypezMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectTypez",
      requestType = axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest.class,
      responseType = axoom.subjectz.v1.Subjectz.SubjectType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest,
      axoom.subjectz.v1.Subjectz.SubjectType> getGetSubjectTypezMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest, axoom.subjectz.v1.Subjectz.SubjectType> getGetSubjectTypezMethod;
    if ((getGetSubjectTypezMethod = SubjectzGrpc.getGetSubjectTypezMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetSubjectTypezMethod = SubjectzGrpc.getGetSubjectTypezMethod) == null) {
          SubjectzGrpc.getGetSubjectTypezMethod = getGetSubjectTypezMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest, axoom.subjectz.v1.Subjectz.SubjectType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetSubjectTypez"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.Subjectz.SubjectType.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetSubjectTypez"))
                  .build();
          }
        }
     }
     return getGetSubjectTypezMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SubjectzStub newStub(io.grpc.Channel channel) {
    return new SubjectzStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubjectzBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SubjectzBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SubjectzFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SubjectzFutureStub(channel);
  }

  /**
   */
  public static abstract class SubjectzImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateSubject creates the given Subject.
     * </pre>
     */
    public void createSubject(axoom.subjectz.v1.SubjectzService.CreateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject.
     * </pre>
     */
    public void getSubject(axoom.subjectz.v1.SubjectzService.GetSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectContext returns the requested Subject including the traversed graph of instances.
     * </pre>
     */
    public void getSubjectContext(axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectContext> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectContextMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectz returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public void getSubjectz(axoom.subjectz.v1.SubjectzService.GetSubjectzRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectzMethod(), responseObserver);
    }

    /**
     * <pre>
     * UpdateSubject updates a subject given by the provided ID.
     * The complete list of `instance_of` must be provided. Removal of an instance is not allowed.
     * </pre>
     */
    public void updateSubject(axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType.
     * </pre>
     */
    public void createSubjectType(axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSubjectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType.
     * </pre>
     */
    public void getSubjectType(axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectTypeContext returns the requested SubjectType including the traversed graph of implementations.
     * </pre>
     */
    public void getSubjectTypeContext(axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectTypeContext> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectTypeContextMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectTypez returns a list of all accessible Subject Types.
     * </pre>
     */
    public void getSubjectTypez(axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectTypezMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.CreateSubjectRequest,
                axoom.subjectz.v1.Subjectz.Subject>(
                  this, METHODID_CREATE_SUBJECT)))
          .addMethod(
            getGetSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetSubjectRequest,
                axoom.subjectz.v1.Subjectz.Subject>(
                  this, METHODID_GET_SUBJECT)))
          .addMethod(
            getGetSubjectContextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest,
                axoom.subjectz.v1.Subjectz.SubjectContext>(
                  this, METHODID_GET_SUBJECT_CONTEXT)))
          .addMethod(
            getGetSubjectzMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetSubjectzRequest,
                axoom.subjectz.v1.Subjectz.Subject>(
                  this, METHODID_GET_SUBJECTZ)))
          .addMethod(
            getUpdateSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest,
                axoom.subjectz.v1.Subjectz.Subject>(
                  this, METHODID_UPDATE_SUBJECT)))
          .addMethod(
            getCreateSubjectTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest,
                axoom.subjectz.v1.Subjectz.SubjectType>(
                  this, METHODID_CREATE_SUBJECT_TYPE)))
          .addMethod(
            getGetSubjectTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest,
                axoom.subjectz.v1.Subjectz.SubjectType>(
                  this, METHODID_GET_SUBJECT_TYPE)))
          .addMethod(
            getGetSubjectTypeContextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest,
                axoom.subjectz.v1.Subjectz.SubjectTypeContext>(
                  this, METHODID_GET_SUBJECT_TYPE_CONTEXT)))
          .addMethod(
            getGetSubjectTypezMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest,
                axoom.subjectz.v1.Subjectz.SubjectType>(
                  this, METHODID_GET_SUBJECT_TYPEZ)))
          .build();
    }
  }

  /**
   */
  public static final class SubjectzStub extends io.grpc.stub.AbstractStub<SubjectzStub> {
    private SubjectzStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubjectzStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubjectzStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubjectzStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateSubject creates the given Subject.
     * </pre>
     */
    public void createSubject(axoom.subjectz.v1.SubjectzService.CreateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject.
     * </pre>
     */
    public void getSubject(axoom.subjectz.v1.SubjectzService.GetSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectContext returns the requested Subject including the traversed graph of instances.
     * </pre>
     */
    public void getSubjectContext(axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectContext> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectContextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectz returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public void getSubjectz(axoom.subjectz.v1.SubjectzService.GetSubjectzRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetSubjectzMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UpdateSubject updates a subject given by the provided ID.
     * The complete list of `instance_of` must be provided. Removal of an instance is not allowed.
     * </pre>
     */
    public void updateSubject(axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType.
     * </pre>
     */
    public void createSubjectType(axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSubjectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType.
     * </pre>
     */
    public void getSubjectType(axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectTypeContext returns the requested SubjectType including the traversed graph of implementations.
     * </pre>
     */
    public void getSubjectTypeContext(axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectTypeContext> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectTypeContextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectTypez returns a list of all accessible Subject Types.
     * </pre>
     */
    public void getSubjectTypez(axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetSubjectTypezMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SubjectzBlockingStub extends io.grpc.stub.AbstractStub<SubjectzBlockingStub> {
    private SubjectzBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubjectzBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubjectzBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubjectzBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateSubject creates the given Subject.
     * </pre>
     */
    public axoom.subjectz.v1.Subjectz.Subject createSubject(axoom.subjectz.v1.SubjectzService.CreateSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject.
     * </pre>
     */
    public axoom.subjectz.v1.Subjectz.Subject getSubject(axoom.subjectz.v1.SubjectzService.GetSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectContext returns the requested Subject including the traversed graph of instances.
     * </pre>
     */
    public axoom.subjectz.v1.Subjectz.SubjectContext getSubjectContext(axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectContextMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectz returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public java.util.Iterator<axoom.subjectz.v1.Subjectz.Subject> getSubjectz(
        axoom.subjectz.v1.SubjectzService.GetSubjectzRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetSubjectzMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * UpdateSubject updates a subject given by the provided ID.
     * The complete list of `instance_of` must be provided. Removal of an instance is not allowed.
     * </pre>
     */
    public axoom.subjectz.v1.Subjectz.Subject updateSubject(axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType.
     * </pre>
     */
    public axoom.subjectz.v1.Subjectz.SubjectType createSubjectType(axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSubjectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType.
     * </pre>
     */
    public axoom.subjectz.v1.Subjectz.SubjectType getSubjectType(axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectTypeContext returns the requested SubjectType including the traversed graph of implementations.
     * </pre>
     */
    public axoom.subjectz.v1.Subjectz.SubjectTypeContext getSubjectTypeContext(axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectTypeContextMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectTypez returns a list of all accessible Subject Types.
     * </pre>
     */
    public java.util.Iterator<axoom.subjectz.v1.Subjectz.SubjectType> getSubjectTypez(
        axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetSubjectTypezMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SubjectzFutureStub extends io.grpc.stub.AbstractStub<SubjectzFutureStub> {
    private SubjectzFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubjectzFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubjectzFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubjectzFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateSubject creates the given Subject.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.Subjectz.Subject> createSubject(
        axoom.subjectz.v1.SubjectzService.CreateSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.Subjectz.Subject> getSubject(
        axoom.subjectz.v1.SubjectzService.GetSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubjectContext returns the requested Subject including the traversed graph of instances.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.Subjectz.SubjectContext> getSubjectContext(
        axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectContextMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * UpdateSubject updates a subject given by the provided ID.
     * The complete list of `instance_of` must be provided. Removal of an instance is not allowed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.Subjectz.Subject> updateSubject(
        axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.Subjectz.SubjectType> createSubjectType(
        axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSubjectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.Subjectz.SubjectType> getSubjectType(
        axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubjectTypeContext returns the requested SubjectType including the traversed graph of implementations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.Subjectz.SubjectTypeContext> getSubjectTypeContext(
        axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectTypeContextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBJECT = 0;
  private static final int METHODID_GET_SUBJECT = 1;
  private static final int METHODID_GET_SUBJECT_CONTEXT = 2;
  private static final int METHODID_GET_SUBJECTZ = 3;
  private static final int METHODID_UPDATE_SUBJECT = 4;
  private static final int METHODID_CREATE_SUBJECT_TYPE = 5;
  private static final int METHODID_GET_SUBJECT_TYPE = 6;
  private static final int METHODID_GET_SUBJECT_TYPE_CONTEXT = 7;
  private static final int METHODID_GET_SUBJECT_TYPEZ = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SubjectzImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SubjectzImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SUBJECT:
          serviceImpl.createSubject((axoom.subjectz.v1.SubjectzService.CreateSubjectRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject>) responseObserver);
          break;
        case METHODID_GET_SUBJECT:
          serviceImpl.getSubject((axoom.subjectz.v1.SubjectzService.GetSubjectRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject>) responseObserver);
          break;
        case METHODID_GET_SUBJECT_CONTEXT:
          serviceImpl.getSubjectContext((axoom.subjectz.v1.SubjectzService.GetSubjectContextRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectContext>) responseObserver);
          break;
        case METHODID_GET_SUBJECTZ:
          serviceImpl.getSubjectz((axoom.subjectz.v1.SubjectzService.GetSubjectzRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject>) responseObserver);
          break;
        case METHODID_UPDATE_SUBJECT:
          serviceImpl.updateSubject((axoom.subjectz.v1.SubjectzService.UpdateSubjectRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.Subject>) responseObserver);
          break;
        case METHODID_CREATE_SUBJECT_TYPE:
          serviceImpl.createSubjectType((axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType>) responseObserver);
          break;
        case METHODID_GET_SUBJECT_TYPE:
          serviceImpl.getSubjectType((axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType>) responseObserver);
          break;
        case METHODID_GET_SUBJECT_TYPE_CONTEXT:
          serviceImpl.getSubjectTypeContext((axoom.subjectz.v1.SubjectzService.GetSubjectTypeContextRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectTypeContext>) responseObserver);
          break;
        case METHODID_GET_SUBJECT_TYPEZ:
          serviceImpl.getSubjectTypez((axoom.subjectz.v1.SubjectzService.GetSubjectTypezRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.Subjectz.SubjectType>) responseObserver);
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

  private static abstract class SubjectzBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubjectzBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.subjectz.v1.SubjectzService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Subjectz");
    }
  }

  private static final class SubjectzFileDescriptorSupplier
      extends SubjectzBaseDescriptorSupplier {
    SubjectzFileDescriptorSupplier() {}
  }

  private static final class SubjectzMethodDescriptorSupplier
      extends SubjectzBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SubjectzMethodDescriptorSupplier(String methodName) {
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
      synchronized (SubjectzGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SubjectzFileDescriptorSupplier())
              .addMethod(getCreateSubjectMethod())
              .addMethod(getGetSubjectMethod())
              .addMethod(getGetSubjectContextMethod())
              .addMethod(getGetSubjectzMethod())
              .addMethod(getUpdateSubjectMethod())
              .addMethod(getCreateSubjectTypeMethod())
              .addMethod(getGetSubjectTypeMethod())
              .addMethod(getGetSubjectTypeContextMethod())
              .addMethod(getGetSubjectTypezMethod())
              .build();
        }
      }
    }
    return result;
  }
}
