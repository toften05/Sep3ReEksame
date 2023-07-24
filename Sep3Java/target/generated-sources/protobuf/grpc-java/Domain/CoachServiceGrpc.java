package Domain;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: FootballManagement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CoachServiceGrpc {

  private CoachServiceGrpc() {}

  public static final String SERVICE_NAME = "Domain.CoachService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Domain.CoachCreationDtoMessage,
      Domain.CoachMessage> getCreateCoachMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCoach",
      requestType = Domain.CoachCreationDtoMessage.class,
      responseType = Domain.CoachMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Domain.CoachCreationDtoMessage,
      Domain.CoachMessage> getCreateCoachMethod() {
    io.grpc.MethodDescriptor<Domain.CoachCreationDtoMessage, Domain.CoachMessage> getCreateCoachMethod;
    if ((getCreateCoachMethod = CoachServiceGrpc.getCreateCoachMethod) == null) {
      synchronized (CoachServiceGrpc.class) {
        if ((getCreateCoachMethod = CoachServiceGrpc.getCreateCoachMethod) == null) {
          CoachServiceGrpc.getCreateCoachMethod = getCreateCoachMethod =
              io.grpc.MethodDescriptor.<Domain.CoachCreationDtoMessage, Domain.CoachMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCoach"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.CoachCreationDtoMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.CoachMessage.getDefaultInstance()))
              .setSchemaDescriptor(new CoachServiceMethodDescriptorSupplier("CreateCoach"))
              .build();
        }
      }
    }
    return getCreateCoachMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Domain.StringRequest,
      Domain.CoachMessage> getGetByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByName",
      requestType = Domain.StringRequest.class,
      responseType = Domain.CoachMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Domain.StringRequest,
      Domain.CoachMessage> getGetByNameMethod() {
    io.grpc.MethodDescriptor<Domain.StringRequest, Domain.CoachMessage> getGetByNameMethod;
    if ((getGetByNameMethod = CoachServiceGrpc.getGetByNameMethod) == null) {
      synchronized (CoachServiceGrpc.class) {
        if ((getGetByNameMethod = CoachServiceGrpc.getGetByNameMethod) == null) {
          CoachServiceGrpc.getGetByNameMethod = getGetByNameMethod =
              io.grpc.MethodDescriptor.<Domain.StringRequest, Domain.CoachMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.CoachMessage.getDefaultInstance()))
              .setSchemaDescriptor(new CoachServiceMethodDescriptorSupplier("getByName"))
              .build();
        }
      }
    }
    return getGetByNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CoachServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoachServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoachServiceStub>() {
        @java.lang.Override
        public CoachServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoachServiceStub(channel, callOptions);
        }
      };
    return CoachServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CoachServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoachServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoachServiceBlockingStub>() {
        @java.lang.Override
        public CoachServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoachServiceBlockingStub(channel, callOptions);
        }
      };
    return CoachServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CoachServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoachServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoachServiceFutureStub>() {
        @java.lang.Override
        public CoachServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoachServiceFutureStub(channel, callOptions);
        }
      };
    return CoachServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CoachServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCoach(Domain.CoachCreationDtoMessage request,
        io.grpc.stub.StreamObserver<Domain.CoachMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCoachMethod(), responseObserver);
    }

    /**
     */
    public void getByName(Domain.StringRequest request,
        io.grpc.stub.StreamObserver<Domain.CoachMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCoachMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Domain.CoachCreationDtoMessage,
                Domain.CoachMessage>(
                  this, METHODID_CREATE_COACH)))
          .addMethod(
            getGetByNameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Domain.StringRequest,
                Domain.CoachMessage>(
                  this, METHODID_GET_BY_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class CoachServiceStub extends io.grpc.stub.AbstractAsyncStub<CoachServiceStub> {
    private CoachServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoachServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoachServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCoach(Domain.CoachCreationDtoMessage request,
        io.grpc.stub.StreamObserver<Domain.CoachMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCoachMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByName(Domain.StringRequest request,
        io.grpc.stub.StreamObserver<Domain.CoachMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CoachServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CoachServiceBlockingStub> {
    private CoachServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoachServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoachServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Domain.CoachMessage createCoach(Domain.CoachCreationDtoMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCoachMethod(), getCallOptions(), request);
    }

    /**
     */
    public Domain.CoachMessage getByName(Domain.StringRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CoachServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CoachServiceFutureStub> {
    private CoachServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoachServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoachServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Domain.CoachMessage> createCoach(
        Domain.CoachCreationDtoMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCoachMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Domain.CoachMessage> getByName(
        Domain.StringRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COACH = 0;
  private static final int METHODID_GET_BY_NAME = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CoachServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CoachServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_COACH:
          serviceImpl.createCoach((Domain.CoachCreationDtoMessage) request,
              (io.grpc.stub.StreamObserver<Domain.CoachMessage>) responseObserver);
          break;
        case METHODID_GET_BY_NAME:
          serviceImpl.getByName((Domain.StringRequest) request,
              (io.grpc.stub.StreamObserver<Domain.CoachMessage>) responseObserver);
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

  private static abstract class CoachServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CoachServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Domain.FootballManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CoachService");
    }
  }

  private static final class CoachServiceFileDescriptorSupplier
      extends CoachServiceBaseDescriptorSupplier {
    CoachServiceFileDescriptorSupplier() {}
  }

  private static final class CoachServiceMethodDescriptorSupplier
      extends CoachServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CoachServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CoachServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CoachServiceFileDescriptorSupplier())
              .addMethod(getCreateCoachMethod())
              .addMethod(getGetByNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
