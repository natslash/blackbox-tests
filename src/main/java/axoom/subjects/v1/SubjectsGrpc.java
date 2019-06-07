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
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: subjects_service.proto")
public final class SubjectsGrpc {

  private SubjectsGrpc() {}

  public static final String SERVICE_NAME = "axoom.subjects.v1.Subjects";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectRequest,
      axoom.subjects.v1.Subjects.Subject> getCreateSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubject",
      requestType = axoom.subjects.v1.SubjectsService.CreateSubjectRequest.class,
      responseType = axoom.subjects.v1.Subjects.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectRequest,
      axoom.subjects.v1.Subjects.Subject> getCreateSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectRequest, axoom.subjects.v1.Subjects.Subject> getCreateSubjectMethod;
    if ((getCreateSubjectMethod = SubjectsGrpc.getCreateSubjectMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getCreateSubjectMethod = SubjectsGrpc.getCreateSubjectMethod) == null) {
          SubjectsGrpc.getCreateSubjectMethod = getCreateSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.CreateSubjectRequest, axoom.subjects.v1.Subjects.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "CreateSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.CreateSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("CreateSubject"))
                  .build();
          }
        }
     }
     return getCreateSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectRequest,
      axoom.subjects.v1.Subjects.Subject> getGetSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubject",
      requestType = axoom.subjects.v1.SubjectsService.GetSubjectRequest.class,
      responseType = axoom.subjects.v1.Subjects.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectRequest,
      axoom.subjects.v1.Subjects.Subject> getGetSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectRequest, axoom.subjects.v1.Subjects.Subject> getGetSubjectMethod;
    if ((getGetSubjectMethod = SubjectsGrpc.getGetSubjectMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getGetSubjectMethod = SubjectsGrpc.getGetSubjectMethod) == null) {
          SubjectsGrpc.getGetSubjectMethod = getGetSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.GetSubjectRequest, axoom.subjects.v1.Subjects.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "GetSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("GetSubject"))
                  .build();
          }
        }
     }
     return getGetSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.UpdateSubjectRequest,
      axoom.subjects.v1.Subjects.Subject> getUpdateSubjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubject",
      requestType = axoom.subjects.v1.SubjectsService.UpdateSubjectRequest.class,
      responseType = axoom.subjects.v1.Subjects.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.UpdateSubjectRequest,
      axoom.subjects.v1.Subjects.Subject> getUpdateSubjectMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.UpdateSubjectRequest, axoom.subjects.v1.Subjects.Subject> getUpdateSubjectMethod;
    if ((getUpdateSubjectMethod = SubjectsGrpc.getUpdateSubjectMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getUpdateSubjectMethod = SubjectsGrpc.getUpdateSubjectMethod) == null) {
          SubjectsGrpc.getUpdateSubjectMethod = getUpdateSubjectMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.UpdateSubjectRequest, axoom.subjects.v1.Subjects.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "UpdateSubject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.UpdateSubjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("UpdateSubject"))
                  .build();
          }
        }
     }
     return getUpdateSubjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.ListSubjectsRequest,
      axoom.subjects.v1.SubjectsService.ListSubjectsResponse> getListSubjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubjects",
      requestType = axoom.subjects.v1.SubjectsService.ListSubjectsRequest.class,
      responseType = axoom.subjects.v1.SubjectsService.ListSubjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.ListSubjectsRequest,
      axoom.subjects.v1.SubjectsService.ListSubjectsResponse> getListSubjectsMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.ListSubjectsRequest, axoom.subjects.v1.SubjectsService.ListSubjectsResponse> getListSubjectsMethod;
    if ((getListSubjectsMethod = SubjectsGrpc.getListSubjectsMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getListSubjectsMethod = SubjectsGrpc.getListSubjectsMethod) == null) {
          SubjectsGrpc.getListSubjectsMethod = getListSubjectsMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.ListSubjectsRequest, axoom.subjects.v1.SubjectsService.ListSubjectsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "ListSubjects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.ListSubjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.ListSubjectsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("ListSubjects"))
                  .build();
          }
        }
     }
     return getListSubjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest,
      axoom.subjects.v1.Subjects.Subject> getSetSubjectLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetSubjectLabels",
      requestType = axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest.class,
      responseType = axoom.subjects.v1.Subjects.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest,
      axoom.subjects.v1.Subjects.Subject> getSetSubjectLabelsMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest, axoom.subjects.v1.Subjects.Subject> getSetSubjectLabelsMethod;
    if ((getSetSubjectLabelsMethod = SubjectsGrpc.getSetSubjectLabelsMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getSetSubjectLabelsMethod = SubjectsGrpc.getSetSubjectLabelsMethod) == null) {
          SubjectsGrpc.getSetSubjectLabelsMethod = getSetSubjectLabelsMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest, axoom.subjects.v1.Subjects.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "SetSubjectLabels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("SetSubjectLabels"))
                  .build();
          }
        }
     }
     return getSetSubjectLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest,
      axoom.subjects.v1.Subjects.Subject> getRemoveSubjectLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveSubjectLabels",
      requestType = axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest.class,
      responseType = axoom.subjects.v1.Subjects.Subject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest,
      axoom.subjects.v1.Subjects.Subject> getRemoveSubjectLabelsMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest, axoom.subjects.v1.Subjects.Subject> getRemoveSubjectLabelsMethod;
    if ((getRemoveSubjectLabelsMethod = SubjectsGrpc.getRemoveSubjectLabelsMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getRemoveSubjectLabelsMethod = SubjectsGrpc.getRemoveSubjectLabelsMethod) == null) {
          SubjectsGrpc.getRemoveSubjectLabelsMethod = getRemoveSubjectLabelsMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest, axoom.subjects.v1.Subjects.Subject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "RemoveSubjectLabels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.Subject.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("RemoveSubjectLabels"))
                  .build();
          }
        }
     }
     return getRemoveSubjectLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectContextRequest,
      axoom.subjects.v1.Subjects.SubjectContext> getGetSubjectContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectContext",
      requestType = axoom.subjects.v1.SubjectsService.GetSubjectContextRequest.class,
      responseType = axoom.subjects.v1.Subjects.SubjectContext.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectContextRequest,
      axoom.subjects.v1.Subjects.SubjectContext> getGetSubjectContextMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectContextRequest, axoom.subjects.v1.Subjects.SubjectContext> getGetSubjectContextMethod;
    if ((getGetSubjectContextMethod = SubjectsGrpc.getGetSubjectContextMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getGetSubjectContextMethod = SubjectsGrpc.getGetSubjectContextMethod) == null) {
          SubjectsGrpc.getGetSubjectContextMethod = getGetSubjectContextMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.GetSubjectContextRequest, axoom.subjects.v1.Subjects.SubjectContext>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "GetSubjectContext"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetSubjectContextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.SubjectContext.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("GetSubjectContext"))
                  .build();
          }
        }
     }
     return getGetSubjectContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.AddImplementationRequest,
      axoom.subjects.v1.Subjects.SubjectContext> getAddImplementationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddImplementation",
      requestType = axoom.subjects.v1.SubjectsService.AddImplementationRequest.class,
      responseType = axoom.subjects.v1.Subjects.SubjectContext.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.AddImplementationRequest,
      axoom.subjects.v1.Subjects.SubjectContext> getAddImplementationMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.AddImplementationRequest, axoom.subjects.v1.Subjects.SubjectContext> getAddImplementationMethod;
    if ((getAddImplementationMethod = SubjectsGrpc.getAddImplementationMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getAddImplementationMethod = SubjectsGrpc.getAddImplementationMethod) == null) {
          SubjectsGrpc.getAddImplementationMethod = getAddImplementationMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.AddImplementationRequest, axoom.subjects.v1.Subjects.SubjectContext>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "AddImplementation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.AddImplementationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.SubjectContext.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("AddImplementation"))
                  .build();
          }
        }
     }
     return getAddImplementationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest,
      axoom.subjects.v1.Subjects.SubjectType> getCreateSubjectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubjectType",
      requestType = axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest.class,
      responseType = axoom.subjects.v1.Subjects.SubjectType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest,
      axoom.subjects.v1.Subjects.SubjectType> getCreateSubjectTypeMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest, axoom.subjects.v1.Subjects.SubjectType> getCreateSubjectTypeMethod;
    if ((getCreateSubjectTypeMethod = SubjectsGrpc.getCreateSubjectTypeMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getCreateSubjectTypeMethod = SubjectsGrpc.getCreateSubjectTypeMethod) == null) {
          SubjectsGrpc.getCreateSubjectTypeMethod = getCreateSubjectTypeMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest, axoom.subjects.v1.Subjects.SubjectType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "CreateSubjectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.SubjectType.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("CreateSubjectType"))
                  .build();
          }
        }
     }
     return getCreateSubjectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest,
      axoom.subjects.v1.Subjects.SubjectType> getGetSubjectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectType",
      requestType = axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest.class,
      responseType = axoom.subjects.v1.Subjects.SubjectType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest,
      axoom.subjects.v1.Subjects.SubjectType> getGetSubjectTypeMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest, axoom.subjects.v1.Subjects.SubjectType> getGetSubjectTypeMethod;
    if ((getGetSubjectTypeMethod = SubjectsGrpc.getGetSubjectTypeMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getGetSubjectTypeMethod = SubjectsGrpc.getGetSubjectTypeMethod) == null) {
          SubjectsGrpc.getGetSubjectTypeMethod = getGetSubjectTypeMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest, axoom.subjects.v1.Subjects.SubjectType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "GetSubjectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.SubjectType.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("GetSubjectType"))
                  .build();
          }
        }
     }
     return getGetSubjectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest,
      axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse> getListSubjectTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubjectTypes",
      requestType = axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest.class,
      responseType = axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest,
      axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse> getListSubjectTypesMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest, axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse> getListSubjectTypesMethod;
    if ((getListSubjectTypesMethod = SubjectsGrpc.getListSubjectTypesMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getListSubjectTypesMethod = SubjectsGrpc.getListSubjectTypesMethod) == null) {
          SubjectsGrpc.getListSubjectTypesMethod = getListSubjectTypesMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest, axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "ListSubjectTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("ListSubjectTypes"))
                  .build();
          }
        }
     }
     return getListSubjectTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest,
      axoom.subjects.v1.Subjects.SubjectType> getSetSubjectTypeLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetSubjectTypeLabels",
      requestType = axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest.class,
      responseType = axoom.subjects.v1.Subjects.SubjectType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest,
      axoom.subjects.v1.Subjects.SubjectType> getSetSubjectTypeLabelsMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest, axoom.subjects.v1.Subjects.SubjectType> getSetSubjectTypeLabelsMethod;
    if ((getSetSubjectTypeLabelsMethod = SubjectsGrpc.getSetSubjectTypeLabelsMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getSetSubjectTypeLabelsMethod = SubjectsGrpc.getSetSubjectTypeLabelsMethod) == null) {
          SubjectsGrpc.getSetSubjectTypeLabelsMethod = getSetSubjectTypeLabelsMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest, axoom.subjects.v1.Subjects.SubjectType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "SetSubjectTypeLabels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.SubjectType.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("SetSubjectTypeLabels"))
                  .build();
          }
        }
     }
     return getSetSubjectTypeLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest,
      axoom.subjects.v1.Subjects.SubjectType> getRemoveSubjectTypeLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveSubjectTypeLabels",
      requestType = axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest.class,
      responseType = axoom.subjects.v1.Subjects.SubjectType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest,
      axoom.subjects.v1.Subjects.SubjectType> getRemoveSubjectTypeLabelsMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest, axoom.subjects.v1.Subjects.SubjectType> getRemoveSubjectTypeLabelsMethod;
    if ((getRemoveSubjectTypeLabelsMethod = SubjectsGrpc.getRemoveSubjectTypeLabelsMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getRemoveSubjectTypeLabelsMethod = SubjectsGrpc.getRemoveSubjectTypeLabelsMethod) == null) {
          SubjectsGrpc.getRemoveSubjectTypeLabelsMethod = getRemoveSubjectTypeLabelsMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest, axoom.subjects.v1.Subjects.SubjectType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "RemoveSubjectTypeLabels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.SubjectType.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("RemoveSubjectTypeLabels"))
                  .build();
          }
        }
     }
     return getRemoveSubjectTypeLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest,
      axoom.subjects.v1.Subjects.SubjectTypeContext> getGetSubjectTypeContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubjectTypeContext",
      requestType = axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest.class,
      responseType = axoom.subjects.v1.Subjects.SubjectTypeContext.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest,
      axoom.subjects.v1.Subjects.SubjectTypeContext> getGetSubjectTypeContextMethod() {
    io.grpc.MethodDescriptor<axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest, axoom.subjects.v1.Subjects.SubjectTypeContext> getGetSubjectTypeContextMethod;
    if ((getGetSubjectTypeContextMethod = SubjectsGrpc.getGetSubjectTypeContextMethod) == null) {
      synchronized (SubjectsGrpc.class) {
        if ((getGetSubjectTypeContextMethod = SubjectsGrpc.getGetSubjectTypeContextMethod) == null) {
          SubjectsGrpc.getGetSubjectTypeContextMethod = getGetSubjectTypeContextMethod = 
              io.grpc.MethodDescriptor.<axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest, axoom.subjects.v1.Subjects.SubjectTypeContext>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "axoom.subjects.v1.Subjects", "GetSubjectTypeContext"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  axoom.subjects.v1.Subjects.SubjectTypeContext.getDefaultInstance()))
                  .setSchemaDescriptor(new SubjectsMethodDescriptorSupplier("GetSubjectTypeContext"))
                  .build();
          }
        }
     }
     return getGetSubjectTypeContextMethod;
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
     * CreateSubject creates the given Subject
     * </pre>
     */
    public void createSubject(axoom.subjects.v1.SubjectsService.CreateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject
     * </pre>
     */
    public void getSubject(axoom.subjects.v1.SubjectsService.GetSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * UpdateSubject updates a subject given by the provided subject ID
     * </pre>
     */
    public void updateSubject(axoom.subjects.v1.SubjectsService.UpdateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSubjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListSubjects returns a list of all accessible Subjects
     * </pre>
     */
    public void listSubjects(axoom.subjects.v1.SubjectsService.ListSubjectsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.ListSubjectsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListSubjectsMethod(), responseObserver);
    }

    /**
     * <pre>
     * SetSubjectLabels sets labels on the subject given by the provided ID
     * </pre>
     */
    public void setSubjectLabels(axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getSetSubjectLabelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * RemoveSubjectLabels removes labels from the subject given by the provided ID
     * </pre>
     */
    public void removeSubjectLabels(axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveSubjectLabelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectContext returns the requested Subject including the traversed graph of subject types
     * </pre>
     */
    public void getSubjectContext(axoom.subjects.v1.SubjectsService.GetSubjectContextRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectContext> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectContextMethod(), responseObserver);
    }

    /**
     * <pre>
     * AddImplementation adds an implemented SubjectType for the Subject given by the provided ID
     * </pre>
     */
    public void addImplementation(axoom.subjects.v1.SubjectsService.AddImplementationRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectContext> responseObserver) {
      asyncUnimplementedUnaryCall(getAddImplementationMethod(), responseObserver);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType
     * </pre>
     */
    public void createSubjectType(axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSubjectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType
     * </pre>
     */
    public void getSubjectType(axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListSubjectTypes returns a list of all accessible Subject Types
     * </pre>
     */
    public void listSubjectTypes(axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListSubjectTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * SetSubjectTypeLabel sets labels on the subject type given by the provided name
     * </pre>
     */
    public void setSubjectTypeLabels(axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType> responseObserver) {
      asyncUnimplementedUnaryCall(getSetSubjectTypeLabelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * RemoveSubjectLabels removes labels from the subject type given by the provided name
     * </pre>
     */
    public void removeSubjectTypeLabels(axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveSubjectTypeLabelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetSubjectTypeContext returns the requested SubjectType including the traversed graph of implementations
     * </pre>
     */
    public void getSubjectTypeContext(axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectTypeContext> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSubjectTypeContextMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.CreateSubjectRequest,
                axoom.subjects.v1.Subjects.Subject>(
                  this, METHODID_CREATE_SUBJECT)))
          .addMethod(
            getGetSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.GetSubjectRequest,
                axoom.subjects.v1.Subjects.Subject>(
                  this, METHODID_GET_SUBJECT)))
          .addMethod(
            getUpdateSubjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.UpdateSubjectRequest,
                axoom.subjects.v1.Subjects.Subject>(
                  this, METHODID_UPDATE_SUBJECT)))
          .addMethod(
            getListSubjectsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.ListSubjectsRequest,
                axoom.subjects.v1.SubjectsService.ListSubjectsResponse>(
                  this, METHODID_LIST_SUBJECTS)))
          .addMethod(
            getSetSubjectLabelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest,
                axoom.subjects.v1.Subjects.Subject>(
                  this, METHODID_SET_SUBJECT_LABELS)))
          .addMethod(
            getRemoveSubjectLabelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest,
                axoom.subjects.v1.Subjects.Subject>(
                  this, METHODID_REMOVE_SUBJECT_LABELS)))
          .addMethod(
            getGetSubjectContextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.GetSubjectContextRequest,
                axoom.subjects.v1.Subjects.SubjectContext>(
                  this, METHODID_GET_SUBJECT_CONTEXT)))
          .addMethod(
            getAddImplementationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.AddImplementationRequest,
                axoom.subjects.v1.Subjects.SubjectContext>(
                  this, METHODID_ADD_IMPLEMENTATION)))
          .addMethod(
            getCreateSubjectTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest,
                axoom.subjects.v1.Subjects.SubjectType>(
                  this, METHODID_CREATE_SUBJECT_TYPE)))
          .addMethod(
            getGetSubjectTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest,
                axoom.subjects.v1.Subjects.SubjectType>(
                  this, METHODID_GET_SUBJECT_TYPE)))
          .addMethod(
            getListSubjectTypesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest,
                axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse>(
                  this, METHODID_LIST_SUBJECT_TYPES)))
          .addMethod(
            getSetSubjectTypeLabelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest,
                axoom.subjects.v1.Subjects.SubjectType>(
                  this, METHODID_SET_SUBJECT_TYPE_LABELS)))
          .addMethod(
            getRemoveSubjectTypeLabelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest,
                axoom.subjects.v1.Subjects.SubjectType>(
                  this, METHODID_REMOVE_SUBJECT_TYPE_LABELS)))
          .addMethod(
            getGetSubjectTypeContextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest,
                axoom.subjects.v1.Subjects.SubjectTypeContext>(
                  this, METHODID_GET_SUBJECT_TYPE_CONTEXT)))
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
     * CreateSubject creates the given Subject
     * </pre>
     */
    public void createSubject(axoom.subjects.v1.SubjectsService.CreateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject
     * </pre>
     */
    public void getSubject(axoom.subjects.v1.SubjectsService.GetSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UpdateSubject updates a subject given by the provided subject ID
     * </pre>
     */
    public void updateSubject(axoom.subjects.v1.SubjectsService.UpdateSubjectRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSubjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListSubjects returns a list of all accessible Subjects
     * </pre>
     */
    public void listSubjects(axoom.subjects.v1.SubjectsService.ListSubjectsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.ListSubjectsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSubjectsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * SetSubjectLabels sets labels on the subject given by the provided ID
     * </pre>
     */
    public void setSubjectLabels(axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetSubjectLabelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RemoveSubjectLabels removes labels from the subject given by the provided ID
     * </pre>
     */
    public void removeSubjectLabels(axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveSubjectLabelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectContext returns the requested Subject including the traversed graph of subject types
     * </pre>
     */
    public void getSubjectContext(axoom.subjects.v1.SubjectsService.GetSubjectContextRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectContext> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectContextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * AddImplementation adds an implemented SubjectType for the Subject given by the provided ID
     * </pre>
     */
    public void addImplementation(axoom.subjects.v1.SubjectsService.AddImplementationRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectContext> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddImplementationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType
     * </pre>
     */
    public void createSubjectType(axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSubjectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType
     * </pre>
     */
    public void getSubjectType(axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListSubjectTypes returns a list of all accessible Subject Types
     * </pre>
     */
    public void listSubjectTypes(axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSubjectTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * SetSubjectTypeLabel sets labels on the subject type given by the provided name
     * </pre>
     */
    public void setSubjectTypeLabels(axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetSubjectTypeLabelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RemoveSubjectLabels removes labels from the subject type given by the provided name
     * </pre>
     */
    public void removeSubjectTypeLabels(axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveSubjectTypeLabelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetSubjectTypeContext returns the requested SubjectType including the traversed graph of implementations
     * </pre>
     */
    public void getSubjectTypeContext(axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest request,
        io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectTypeContext> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSubjectTypeContextMethod(), getCallOptions()), request, responseObserver);
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
     * CreateSubject creates the given Subject
     * </pre>
     */
    public axoom.subjects.v1.Subjects.Subject createSubject(axoom.subjects.v1.SubjectsService.CreateSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject
     * </pre>
     */
    public axoom.subjects.v1.Subjects.Subject getSubject(axoom.subjects.v1.SubjectsService.GetSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * UpdateSubject updates a subject given by the provided subject ID
     * </pre>
     */
    public axoom.subjects.v1.Subjects.Subject updateSubject(axoom.subjects.v1.SubjectsService.UpdateSubjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateSubjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListSubjects returns a list of all accessible Subjects
     * </pre>
     */
    public axoom.subjects.v1.SubjectsService.ListSubjectsResponse listSubjects(axoom.subjects.v1.SubjectsService.ListSubjectsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListSubjectsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * SetSubjectLabels sets labels on the subject given by the provided ID
     * </pre>
     */
    public axoom.subjects.v1.Subjects.Subject setSubjectLabels(axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetSubjectLabelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RemoveSubjectLabels removes labels from the subject given by the provided ID
     * </pre>
     */
    public axoom.subjects.v1.Subjects.Subject removeSubjectLabels(axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveSubjectLabelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectContext returns the requested Subject including the traversed graph of subject types
     * </pre>
     */
    public axoom.subjects.v1.Subjects.SubjectContext getSubjectContext(axoom.subjects.v1.SubjectsService.GetSubjectContextRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectContextMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * AddImplementation adds an implemented SubjectType for the Subject given by the provided ID
     * </pre>
     */
    public axoom.subjects.v1.Subjects.SubjectContext addImplementation(axoom.subjects.v1.SubjectsService.AddImplementationRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddImplementationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType
     * </pre>
     */
    public axoom.subjects.v1.Subjects.SubjectType createSubjectType(axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSubjectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType
     * </pre>
     */
    public axoom.subjects.v1.Subjects.SubjectType getSubjectType(axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListSubjectTypes returns a list of all accessible Subject Types
     * </pre>
     */
    public axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse listSubjectTypes(axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListSubjectTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * SetSubjectTypeLabel sets labels on the subject type given by the provided name
     * </pre>
     */
    public axoom.subjects.v1.Subjects.SubjectType setSubjectTypeLabels(axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetSubjectTypeLabelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RemoveSubjectLabels removes labels from the subject type given by the provided name
     * </pre>
     */
    public axoom.subjects.v1.Subjects.SubjectType removeSubjectTypeLabels(axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveSubjectTypeLabelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetSubjectTypeContext returns the requested SubjectType including the traversed graph of implementations
     * </pre>
     */
    public axoom.subjects.v1.Subjects.SubjectTypeContext getSubjectTypeContext(axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSubjectTypeContextMethod(), getCallOptions(), request);
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
     * CreateSubject creates the given Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.Subject> createSubject(
        axoom.subjects.v1.SubjectsService.CreateSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubject returns the requested Subject
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.Subject> getSubject(
        axoom.subjects.v1.SubjectsService.GetSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * UpdateSubject updates a subject given by the provided subject ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.Subject> updateSubject(
        axoom.subjects.v1.SubjectsService.UpdateSubjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSubjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ListSubjects returns a list of all accessible Subjects
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.SubjectsService.ListSubjectsResponse> listSubjects(
        axoom.subjects.v1.SubjectsService.ListSubjectsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListSubjectsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * SetSubjectLabels sets labels on the subject given by the provided ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.Subject> setSubjectLabels(
        axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetSubjectLabelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RemoveSubjectLabels removes labels from the subject given by the provided ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.Subject> removeSubjectLabels(
        axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveSubjectLabelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubjectContext returns the requested Subject including the traversed graph of subject types
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.SubjectContext> getSubjectContext(
        axoom.subjects.v1.SubjectsService.GetSubjectContextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectContextMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * AddImplementation adds an implemented SubjectType for the Subject given by the provided ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.SubjectContext> addImplementation(
        axoom.subjects.v1.SubjectsService.AddImplementationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddImplementationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * CreateSubjectType creates the given SubjectType
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.SubjectType> createSubjectType(
        axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSubjectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubjectType returns the requested SubjectType
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.SubjectType> getSubjectType(
        axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ListSubjectTypes returns a list of all accessible Subject Types
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse> listSubjectTypes(
        axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListSubjectTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * SetSubjectTypeLabel sets labels on the subject type given by the provided name
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.SubjectType> setSubjectTypeLabels(
        axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetSubjectTypeLabelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RemoveSubjectLabels removes labels from the subject type given by the provided name
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.SubjectType> removeSubjectTypeLabels(
        axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveSubjectTypeLabelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetSubjectTypeContext returns the requested SubjectType including the traversed graph of implementations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<axoom.subjects.v1.Subjects.SubjectTypeContext> getSubjectTypeContext(
        axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSubjectTypeContextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBJECT = 0;
  private static final int METHODID_GET_SUBJECT = 1;
  private static final int METHODID_UPDATE_SUBJECT = 2;
  private static final int METHODID_LIST_SUBJECTS = 3;
  private static final int METHODID_SET_SUBJECT_LABELS = 4;
  private static final int METHODID_REMOVE_SUBJECT_LABELS = 5;
  private static final int METHODID_GET_SUBJECT_CONTEXT = 6;
  private static final int METHODID_ADD_IMPLEMENTATION = 7;
  private static final int METHODID_CREATE_SUBJECT_TYPE = 8;
  private static final int METHODID_GET_SUBJECT_TYPE = 9;
  private static final int METHODID_LIST_SUBJECT_TYPES = 10;
  private static final int METHODID_SET_SUBJECT_TYPE_LABELS = 11;
  private static final int METHODID_REMOVE_SUBJECT_TYPE_LABELS = 12;
  private static final int METHODID_GET_SUBJECT_TYPE_CONTEXT = 13;

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
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject>) responseObserver);
          break;
        case METHODID_GET_SUBJECT:
          serviceImpl.getSubject((axoom.subjects.v1.SubjectsService.GetSubjectRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject>) responseObserver);
          break;
        case METHODID_UPDATE_SUBJECT:
          serviceImpl.updateSubject((axoom.subjects.v1.SubjectsService.UpdateSubjectRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject>) responseObserver);
          break;
        case METHODID_LIST_SUBJECTS:
          serviceImpl.listSubjects((axoom.subjects.v1.SubjectsService.ListSubjectsRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.ListSubjectsResponse>) responseObserver);
          break;
        case METHODID_SET_SUBJECT_LABELS:
          serviceImpl.setSubjectLabels((axoom.subjects.v1.SubjectsService.SetSubjectLabelsRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject>) responseObserver);
          break;
        case METHODID_REMOVE_SUBJECT_LABELS:
          serviceImpl.removeSubjectLabels((axoom.subjects.v1.SubjectsService.RemoveSubjectLabelsRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.Subject>) responseObserver);
          break;
        case METHODID_GET_SUBJECT_CONTEXT:
          serviceImpl.getSubjectContext((axoom.subjects.v1.SubjectsService.GetSubjectContextRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectContext>) responseObserver);
          break;
        case METHODID_ADD_IMPLEMENTATION:
          serviceImpl.addImplementation((axoom.subjects.v1.SubjectsService.AddImplementationRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectContext>) responseObserver);
          break;
        case METHODID_CREATE_SUBJECT_TYPE:
          serviceImpl.createSubjectType((axoom.subjects.v1.SubjectsService.CreateSubjectTypeRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType>) responseObserver);
          break;
        case METHODID_GET_SUBJECT_TYPE:
          serviceImpl.getSubjectType((axoom.subjects.v1.SubjectsService.GetSubjectTypeRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType>) responseObserver);
          break;
        case METHODID_LIST_SUBJECT_TYPES:
          serviceImpl.listSubjectTypes((axoom.subjects.v1.SubjectsService.ListSubjectTypesRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.SubjectsService.ListSubjectTypesResponse>) responseObserver);
          break;
        case METHODID_SET_SUBJECT_TYPE_LABELS:
          serviceImpl.setSubjectTypeLabels((axoom.subjects.v1.SubjectsService.SetSubjectTypeLabelsRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType>) responseObserver);
          break;
        case METHODID_REMOVE_SUBJECT_TYPE_LABELS:
          serviceImpl.removeSubjectTypeLabels((axoom.subjects.v1.SubjectsService.RemoveSubjectTypeLabelsRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectType>) responseObserver);
          break;
        case METHODID_GET_SUBJECT_TYPE_CONTEXT:
          serviceImpl.getSubjectTypeContext((axoom.subjects.v1.SubjectsService.GetSubjectTypeContextRequest) request,
              (io.grpc.stub.StreamObserver<axoom.subjects.v1.Subjects.SubjectTypeContext>) responseObserver);
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
              .addMethod(getGetSubjectMethod())
              .addMethod(getUpdateSubjectMethod())
              .addMethod(getListSubjectsMethod())
              .addMethod(getSetSubjectLabelsMethod())
              .addMethod(getRemoveSubjectLabelsMethod())
              .addMethod(getGetSubjectContextMethod())
              .addMethod(getAddImplementationMethod())
              .addMethod(getCreateSubjectTypeMethod())
              .addMethod(getGetSubjectTypeMethod())
              .addMethod(getListSubjectTypesMethod())
              .addMethod(getSetSubjectTypeLabelsMethod())
              .addMethod(getRemoveSubjectTypeLabelsMethod())
              .addMethod(getGetSubjectTypeContextMethod())
              .build();
        }
      }
    }
    return result;
  }
}
