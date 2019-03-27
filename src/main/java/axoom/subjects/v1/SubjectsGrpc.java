package axoom.subjects.v1;

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
    comments = "Source: subjects_service.proto")
public final class SubjectsGrpc {

  private SubjectsGrpc() {}

  public static final String SERVICE_NAME = "axoom.subjects.v1.Subjects";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectRequest,
      axoom.subjects.v1.SubjectsService.CreateSubjectResponse> getCreateSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubject",
      requestType = axoom.subjects.v1.SubjectsService.CreateSubjectRequest.class,
      responseType = axoom.subjects.v1.SubjectsService.CreateSubjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectRequest,
      axoom.subjects.v1.SubjectsService.CreateSubjectResponse> getCreateSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectRequest, axoom.subjects.v1.SubjectsService.CreateSubjectResponse> getCreateSubjectMethod;
    if ((getCreateSubjectMethod = SubjectsGrpc.getCreateSubjectMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getCreateSubjectMethod = SubjectsGrpc.getCreateSubjectMethod) == null) {
          SubjectsGrpc.getCreateSubjectMethod = getCreateSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.CreateSubjectRequest, axoom.subjects.v1.SubjectsService.CreateSubjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "CreateSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.CreateSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.CreateSubjectResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("CreateSubject"))
                  .build();
          }
        }
     }
     return getCreateSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetAllTypesRequest,
      axoom.subjects.v1.SubjectsService.GetAllTypesResponse> getGetAllTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllTypes",
      requestType = axoom.subjects.v1.SubjectsService.GetAllTypesRequest.class,
      responseType = axoom.subjects.v1.SubjectsService.GetAllTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetAllTypesRequest,
      axoom.subjects.v1.SubjectsService.GetAllTypesResponse> getGetAllTypesMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetAllTypesRequest, axoom.subjects.v1.SubjectsService.GetAllTypesResponse> getGetAllTypesMethod;
    if ((getGetAllTypesMethod = SubjectsGrpc.getGetAllTypesMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getGetAllTypesMethod = SubjectsGrpc.getGetAllTypesMethod) == null) {
          SubjectsGrpc.getGetAllTypesMethod = getGetAllTypesMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.GetAllTypesRequest, axoom.subjects.v1.SubjectsService.GetAllTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "GetAllTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetAllTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetAllTypesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("GetAllTypes"))
                  .build();
          }
        }
     }
     return getGetAllTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetAllRequest,
      axoom.subjects.v1.SubjectsService.GetAllResponse> getGetAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAll",
      requestType = axoom.subjects.v1.SubjectsService.GetAllRequest.class,
      responseType = axoom.subjects.v1.SubjectsService.GetAllResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetAllRequest,
      axoom.subjects.v1.SubjectsService.GetAllResponse> getGetAllMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetAllRequest, axoom.subjects.v1.SubjectsService.GetAllResponse> getGetAllMethod;
    if ((getGetAllMethod = SubjectsGrpc.getGetAllMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getGetAllMethod = SubjectsGrpc.getGetAllMethod) == null) {
          SubjectsGrpc.getGetAllMethod = getGetAllMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.GetAllRequest, axoom.subjects.v1.SubjectsService.GetAllResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "GetAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetAllRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetAllResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("GetAll"))
                  .build();
          }
        }
     }
     return getGetAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetRequest,
      axoom.subjects.v1.SubjectsService.GetResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = axoom.subjects.v1.SubjectsService.GetRequest.class,
      responseType = axoom.subjects.v1.SubjectsService.GetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetRequest,
      axoom.subjects.v1.SubjectsService.GetResponse> getGetMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetRequest, axoom.subjects.v1.SubjectsService.GetResponse> getGetMethod;
    if ((getGetMethod = SubjectsGrpc.getGetMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getGetMethod = SubjectsGrpc.getGetMethod) == null) {
          SubjectsGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.GetRequest, axoom.subjects.v1.SubjectsService.GetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("Get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SubjectsStub newStub(io.grpc.Channel channel) {
    return new SubjectsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubjectsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SubjectsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SubjectsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SubjectsFutureStub(channel);
  }

  /**
   */
  public static abstract class SubjectsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateSubject creates the given Subject.
     * If there is a subject ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createSubject(axoom.subjects.v1.SubjectsService.CreateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.CreateSubjectResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetAllTypes returns a list of all accessible SubjectTypes.
     * </pre>
     */
    public void getAllTypes(axoom.subjects.v1.SubjectsService.GetAllTypesRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetAllTypesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetAll returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public void getAll(axoom.subjects.v1.SubjectsService.GetAllRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetAllResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get returns the requested Subject
     * </pre>
     */
    public void get(axoom.subjects.v1.SubjectsService.GetRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.CreateSubjectRequest,
                axoom.subjects.v1.SubjectsService.CreateSubjectResponse>(
                  this, METHODID_CREATE_SUBJECT)))
          .addMethod(
            getGetAllTypesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.GetAllTypesRequest,
                axoom.subjects.v1.SubjectsService.GetAllTypesResponse>(
                  this, METHODID_GET_ALL_TYPES)))
          .addMethod(
            getGetAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.GetAllRequest,
                axoom.subjects.v1.SubjectsService.GetAllResponse>(
                  this, METHODID_GET_ALL)))
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.GetRequest,
                axoom.subjects.v1.SubjectsService.GetResponse>(
                  this, METHODID_GET)))
          .build();
    }
  }

  /**
   */
  public static final class SubjectsStub extends io.grpc.stub.AbstractStub<SubjectsStub> {
    private SubjectsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubjectsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubjectsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubjectsStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateSubject creates the given Subject.
     * If there is a subject ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public void createSubject(axoom.subjects.v1.SubjectsService.CreateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.CreateSubjectResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetAllTypes returns a list of all accessible SubjectTypes.
     * </pre>
     */
    public void getAllTypes(axoom.subjects.v1.SubjectsService.GetAllTypesRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetAllTypesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetAll returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public void getAll(axoom.subjects.v1.SubjectsService.GetAllRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetAllResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get returns the requested Subject
     * </pre>
     */
    public void get(axoom.subjects.v1.SubjectsService.GetRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SubjectsBlockingStub extends io.grpc.stub.AbstractStub<SubjectsBlockingStub> {
    private SubjectsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubjectsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubjectsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubjectsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateSubject creates the given Subject.
     * If there is a subject ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public axoom.subjects.v1.SubjectsService.CreateSubjectResponse createSubject(axoom.subjects.v1.SubjectsService.CreateSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetAllTypes returns a list of all accessible SubjectTypes.
     * </pre>
     */
    public axoom.subjects.v1.SubjectsService.GetAllTypesResponse getAllTypes(axoom.subjects.v1.SubjectsService.GetAllTypesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetAll returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public axoom.subjects.v1.SubjectsService.GetAllResponse getAll(axoom.subjects.v1.SubjectsService.GetAllRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get returns the requested Subject
     * </pre>
     */
    public axoom.subjects.v1.SubjectsService.GetResponse get(axoom.subjects.v1.SubjectsService.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SubjectsFutureStub extends io.grpc.stub.AbstractStub<SubjectsFutureStub> {
    private SubjectsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SubjectsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubjectsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SubjectsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateSubject creates the given Subject.
     * If there is a subject ID part of the request, this one will be omitted and overriden by the Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.SubjectsService.CreateSubjectResponse> createSubject(
        axoom.subjects.v1.SubjectsService.CreateSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetAllTypes returns a list of all accessible SubjectTypes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.SubjectsService.GetAllTypesResponse> getAllTypes(
        axoom.subjects.v1.SubjectsService.GetAllTypesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetAll returns a list of all accessible Subjects belonging to the given SubjectType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.SubjectsService.GetAllResponse> getAll(
        axoom.subjects.v1.SubjectsService.GetAllRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get returns the requested Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.SubjectsService.GetResponse> get(
        axoom.subjects.v1.SubjectsService.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBJECT = 0;
  private static final int METHODID_GET_ALL_TYPES = 1;
  private static final int METHODID_GET_ALL = 2;
  private static final int METHODID_GET = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SubjectsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SubjectsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SUBJECT:
          serviceImpl.createSubject((axoom.subjects.v1.SubjectsService.CreateSubjectRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.CreateSubjectResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_TYPES:
          serviceImpl.getAllTypes((axoom.subjects.v1.SubjectsService.GetAllTypesRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetAllTypesResponse>) responseObserver);
          break;
        case METHODID_GET_ALL:
          serviceImpl.getAll((axoom.subjects.v1.SubjectsService.GetAllRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetAllResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((axoom.subjects.v1.SubjectsService.GetRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.GetResponse>) responseObserver);
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

  private static abstract class SubjectsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubjectsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return axoom.subjects.v1.SubjectsService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Subjects");
    }
  }

  private static final class SubjectsFileDescriptorSupplier
      extends SubjectsBaseDescriptorSupplier {
    SubjectsFileDescriptorSupplier() {}
  }

  private static final class SubjectsMethodDescriptorSupplier
      extends SubjectsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SubjectsMethodDescriptorSupplier(String methodName) {
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
      synchronized (SubjectsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SubjectsFileDescriptorSupplier())
              .addMethod(getCreateSubjectMethod())
              .addMethod(getGetAllTypesMethod())
              .addMethod(getGetAllMethod())
              .addMethod(getGetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
