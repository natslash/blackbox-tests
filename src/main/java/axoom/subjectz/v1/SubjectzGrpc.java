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
      axoom.subjectz.v1.SubjectzService.CreateSubjectResponse> getCreateSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubject",
      requestType = axoom.subjectz.v1.SubjectzService.CreateSubjectRequest.class,
      responseType = axoom.subjectz.v1.SubjectzService.CreateSubjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectRequest,
      axoom.subjectz.v1.SubjectzService.CreateSubjectResponse> getCreateSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectRequest, axoom.subjectz.v1.SubjectzService.CreateSubjectResponse> getCreateSubjectMethod;
    if ((getCreateSubjectMethod = SubjectzGrpc.getCreateSubjectMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getCreateSubjectMethod = SubjectzGrpc.getCreateSubjectMethod) == null) {
          SubjectzGrpc.getCreateSubjectMethod = getCreateSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.CreateSubjectRequest, axoom.subjectz.v1.SubjectzService.CreateSubjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "CreateSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.CreateSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.CreateSubjectResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("CreateSubject"))
                  .build();
          }
        }
     }
     return getCreateSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest,
      axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse> getCreateSubjectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubjectType",
      requestType = axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest.class,
      responseType = axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest,
      axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse> getCreateSubjectTypeMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest, axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse> getCreateSubjectTypeMethod;
    if ((getCreateSubjectTypeMethod = SubjectzGrpc.getCreateSubjectTypeMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getCreateSubjectTypeMethod = SubjectzGrpc.getCreateSubjectTypeMethod) == null) {
          SubjectzGrpc.getCreateSubjectTypeMethod = getCreateSubjectTypeMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest, axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "CreateSubjectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("CreateSubjectType"))
                  .build();
          }
        }
     }
     return getCreateSubjectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectRequest,
      axoom.subjectz.v1.SubjectzService.GetSubjectResponse> getGetSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubject",
      requestType = axoom.subjectz.v1.SubjectzService.GetSubjectRequest.class,
      responseType = axoom.subjectz.v1.SubjectzService.GetSubjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectRequest,
      axoom.subjectz.v1.SubjectzService.GetSubjectResponse> getGetSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectRequest, axoom.subjectz.v1.SubjectzService.GetSubjectResponse> getGetSubjectMethod;
    if ((getGetSubjectMethod = SubjectzGrpc.getGetSubjectMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetSubjectMethod = SubjectzGrpc.getGetSubjectMethod) == null) {
          SubjectzGrpc.getGetSubjectMethod = getGetSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetSubjectRequest, axoom.subjectz.v1.SubjectzService.GetSubjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetSubject"))
                  .build();
          }
        }
     }
     return getGetSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest,
      axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse> getGetAllSubjectzMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllSubjectz",
      requestType = axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest.class,
      responseType = axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest,
      axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse> getGetAllSubjectzMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest, axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse> getGetAllSubjectzMethod;
    if ((getGetAllSubjectzMethod = SubjectzGrpc.getGetAllSubjectzMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetAllSubjectzMethod = SubjectzGrpc.getGetAllSubjectzMethod) == null) {
          SubjectzGrpc.getGetAllSubjectzMethod = getGetAllSubjectzMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest, axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetAllSubjectz"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetAllSubjectz"))
                  .build();
          }
        }
     }
     return getGetAllSubjectzMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest,
      axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse> getGetSubjectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectType",
      requestType = axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest.class,
      responseType = axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest,
      axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse> getGetSubjectTypeMethod() {
    io.grpc.MethodDescriptor<axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest, axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse> getGetSubjectTypeMethod;
    if ((getGetSubjectTypeMethod = SubjectzGrpc.getGetSubjectTypeMethod) == null) {
      synchronized (SubjectzGrpc.class) {
        if ((getGetSubjectTypeMethod = SubjectzGrpc.getGetSubjectTypeMethod) == null) {
          SubjectzGrpc.getGetSubjectTypeMethod = getGetSubjectTypeMethod = 
              io.grpc.MethodDescriptor.<axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest, axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjectz.v1.Subjectz", "GetSubjectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectzMethodDescriptorSupplier("GetSubjectType"))
                  .build();
          }
        }
     }
     return getGetSubjectTypeMethod;
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
     * If there is a subject ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createSubject(axoom.subjectz.v1.SubjectzService.CreateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.CreateSubjectResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType.
     * SubjectTypes cannot be modified. If an ID is part of the request, it will be omitted.
     * </pre>
     */
    public void createSubjectType(axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSubjectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject
     * </pre>
     */
    public void getSubject(axoom.subjectz.v1.SubjectzService.GetSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetSubjectResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetAllSubjectz returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public void getAllSubjectz(axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllSubjectzMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType
     * </pre>
     */
    public void getSubjectType(axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectTypeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.CreateSubjectRequest,
                axoom.subjectz.v1.SubjectzService.CreateSubjectResponse>(
                  this, METHODID_CREATE_SUBJECT)))
          .addMethod(
            getCreateSubjectTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest,
                axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse>(
                  this, METHODID_CREATE_SUBJECT_TYPE)))
          .addMethod(
            getGetSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetSubjectRequest,
                axoom.subjectz.v1.SubjectzService.GetSubjectResponse>(
                  this, METHODID_GET_SUBJECT)))
          .addMethod(
            getGetAllSubjectzMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest,
                axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse>(
                  this, METHODID_GET_ALL_SUBJECTZ)))
          .addMethod(
            getGetSubjectTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest,
                axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse>(
                  this, METHODID_GET_SUBJECT_TYPE)))
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
     * If there is a subject ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createSubject(axoom.subjectz.v1.SubjectzService.CreateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.CreateSubjectResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType.
     * SubjectTypes cannot be modified. If an ID is part of the request, it will be omitted.
     * </pre>
     */
    public void createSubjectType(axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSubjectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject
     * </pre>
     */
    public void getSubject(axoom.subjectz.v1.SubjectzService.GetSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetSubjectResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetAllSubjectz returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public void getAllSubjectz(axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllSubjectzMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType
     * </pre>
     */
    public void getSubjectType(axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectTypeMethod(), getCallOptions()), request, responseObserver);
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
     * If there is a subject ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public axoom.subjectz.v1.SubjectzService.CreateSubjectResponse createSubject(axoom.subjectz.v1.SubjectzService.CreateSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType.
     * SubjectTypes cannot be modified. If an ID is part of the request, it will be omitted.
     * </pre>
     */
    public axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse createSubjectType(axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSubjectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject
     * </pre>
     */
    public axoom.subjectz.v1.SubjectzService.GetSubjectResponse getSubject(axoom.subjectz.v1.SubjectzService.GetSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetAllSubjectz returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse getAllSubjectz(axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllSubjectzMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType
     * </pre>
     */
    public axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse getSubjectType(axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectTypeMethod(), getCallOptions(), request);
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
     * If there is a subject ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.SubjectzService.CreateSubjectResponse> createSubject(
        axoom.subjectz.v1.SubjectzService.CreateSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType.
     * SubjectTypes cannot be modified. If an ID is part of the request, it will be omitted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse> createSubjectType(
        axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSubjectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.SubjectzService.GetSubjectResponse> getSubject(
        axoom.subjectz.v1.SubjectzService.GetSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetAllSubjectz returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse> getAllSubjectz(
        axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllSubjectzMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse> getSubjectType(
        axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectTypeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBJECT = 0;
  private static final int METHODID_CREATE_SUBJECT_TYPE = 1;
  private static final int METHODID_GET_SUBJECT = 2;
  private static final int METHODID_GET_ALL_SUBJECTZ = 3;
  private static final int METHODID_GET_SUBJECT_TYPE = 4;

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
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.CreateSubjectResponse>) responseObserver);
          break;
        case METHODID_CREATE_SUBJECT_TYPE:
          serviceImpl.createSubjectType((axoom.subjectz.v1.SubjectzService.CreateSubjectTypeRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.CreateSubjectTypeResponse>) responseObserver);
          break;
        case METHODID_GET_SUBJECT:
          serviceImpl.getSubject((axoom.subjectz.v1.SubjectzService.GetSubjectRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetSubjectResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_SUBJECTZ:
          serviceImpl.getAllSubjectz((axoom.subjectz.v1.SubjectzService.GetAllSubjectzRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetAllSubjectzResponse>) responseObserver);
          break;
        case METHODID_GET_SUBJECT_TYPE:
          serviceImpl.getSubjectType((axoom.subjectz.v1.SubjectzService.GetSubjectTypeRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjectz.v1.SubjectzService.GetSubjectTypeResponse>) responseObserver);
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
              .addMethod(getCreateSubjectTypeMethod())
              .addMethod(getGetSubjectMethod())
              .addMethod(getGetAllSubjectzMethod())
              .addMethod(getGetSubjectTypeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
