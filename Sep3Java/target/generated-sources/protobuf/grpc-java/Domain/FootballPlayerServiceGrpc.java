package Domain;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: FootballManagement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FootballPlayerServiceGrpc {

  private FootballPlayerServiceGrpc() {}

  public static final String SERVICE_NAME = "Domain.FootballPlayerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Domain.PlayerCreationDTOMessage,
      Domain.PlayerMessage> getCreatePlayerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePlayer",
      requestType = Domain.PlayerCreationDTOMessage.class,
      responseType = Domain.PlayerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Domain.PlayerCreationDTOMessage,
      Domain.PlayerMessage> getCreatePlayerMethod() {
    io.grpc.MethodDescriptor<Domain.PlayerCreationDTOMessage, Domain.PlayerMessage> getCreatePlayerMethod;
    if ((getCreatePlayerMethod = FootballPlayerServiceGrpc.getCreatePlayerMethod) == null) {
      synchronized (FootballPlayerServiceGrpc.class) {
        if ((getCreatePlayerMethod = FootballPlayerServiceGrpc.getCreatePlayerMethod) == null) {
          FootballPlayerServiceGrpc.getCreatePlayerMethod = getCreatePlayerMethod =
              io.grpc.MethodDescriptor.<Domain.PlayerCreationDTOMessage, Domain.PlayerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePlayer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.PlayerCreationDTOMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.PlayerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new FootballPlayerServiceMethodDescriptorSupplier("CreatePlayer"))
              .build();
        }
      }
    }
    return getCreatePlayerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Domain.AllPlayersRequest,
      Domain.ListPlayerMessage> getGetAllPlayersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllPlayers",
      requestType = Domain.AllPlayersRequest.class,
      responseType = Domain.ListPlayerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Domain.AllPlayersRequest,
      Domain.ListPlayerMessage> getGetAllPlayersMethod() {
    io.grpc.MethodDescriptor<Domain.AllPlayersRequest, Domain.ListPlayerMessage> getGetAllPlayersMethod;
    if ((getGetAllPlayersMethod = FootballPlayerServiceGrpc.getGetAllPlayersMethod) == null) {
      synchronized (FootballPlayerServiceGrpc.class) {
        if ((getGetAllPlayersMethod = FootballPlayerServiceGrpc.getGetAllPlayersMethod) == null) {
          FootballPlayerServiceGrpc.getGetAllPlayersMethod = getGetAllPlayersMethod =
              io.grpc.MethodDescriptor.<Domain.AllPlayersRequest, Domain.ListPlayerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllPlayers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.AllPlayersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.ListPlayerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new FootballPlayerServiceMethodDescriptorSupplier("getAllPlayers"))
              .build();
        }
      }
    }
    return getGetAllPlayersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Domain.StringRequest,
      Domain.PlayerMessage> getGetByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByUsername",
      requestType = Domain.StringRequest.class,
      responseType = Domain.PlayerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Domain.StringRequest,
      Domain.PlayerMessage> getGetByUsernameMethod() {
    io.grpc.MethodDescriptor<Domain.StringRequest, Domain.PlayerMessage> getGetByUsernameMethod;
    if ((getGetByUsernameMethod = FootballPlayerServiceGrpc.getGetByUsernameMethod) == null) {
      synchronized (FootballPlayerServiceGrpc.class) {
        if ((getGetByUsernameMethod = FootballPlayerServiceGrpc.getGetByUsernameMethod) == null) {
          FootballPlayerServiceGrpc.getGetByUsernameMethod = getGetByUsernameMethod =
              io.grpc.MethodDescriptor.<Domain.StringRequest, Domain.PlayerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.PlayerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new FootballPlayerServiceMethodDescriptorSupplier("getByUsername"))
              .build();
        }
      }
    }
    return getGetByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Domain.PlayerMessage,
      Domain.PlayerMessage> getEditPlayerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EditPlayer",
      requestType = Domain.PlayerMessage.class,
      responseType = Domain.PlayerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Domain.PlayerMessage,
      Domain.PlayerMessage> getEditPlayerMethod() {
    io.grpc.MethodDescriptor<Domain.PlayerMessage, Domain.PlayerMessage> getEditPlayerMethod;
    if ((getEditPlayerMethod = FootballPlayerServiceGrpc.getEditPlayerMethod) == null) {
      synchronized (FootballPlayerServiceGrpc.class) {
        if ((getEditPlayerMethod = FootballPlayerServiceGrpc.getEditPlayerMethod) == null) {
          FootballPlayerServiceGrpc.getEditPlayerMethod = getEditPlayerMethod =
              io.grpc.MethodDescriptor.<Domain.PlayerMessage, Domain.PlayerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EditPlayer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.PlayerMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.PlayerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new FootballPlayerServiceMethodDescriptorSupplier("EditPlayer"))
              .build();
        }
      }
    }
    return getEditPlayerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FootballPlayerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FootballPlayerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FootballPlayerServiceStub>() {
        @java.lang.Override
        public FootballPlayerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FootballPlayerServiceStub(channel, callOptions);
        }
      };
    return FootballPlayerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FootballPlayerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FootballPlayerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FootballPlayerServiceBlockingStub>() {
        @java.lang.Override
        public FootballPlayerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FootballPlayerServiceBlockingStub(channel, callOptions);
        }
      };
    return FootballPlayerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FootballPlayerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FootballPlayerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FootballPlayerServiceFutureStub>() {
        @java.lang.Override
        public FootballPlayerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FootballPlayerServiceFutureStub(channel, callOptions);
        }
      };
    return FootballPlayerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FootballPlayerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createPlayer(Domain.PlayerCreationDTOMessage request,
        io.grpc.stub.StreamObserver<Domain.PlayerMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePlayerMethod(), responseObserver);
    }

    /**
     */
    public void getAllPlayers(Domain.AllPlayersRequest request,
        io.grpc.stub.StreamObserver<Domain.ListPlayerMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllPlayersMethod(), responseObserver);
    }

    /**
     */
    public void getByUsername(Domain.StringRequest request,
        io.grpc.stub.StreamObserver<Domain.PlayerMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByUsernameMethod(), responseObserver);
    }

    /**
     */
    public void editPlayer(Domain.PlayerMessage request,
        io.grpc.stub.StreamObserver<Domain.PlayerMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEditPlayerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreatePlayerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Domain.PlayerCreationDTOMessage,
                Domain.PlayerMessage>(
                  this, METHODID_CREATE_PLAYER)))
          .addMethod(
            getGetAllPlayersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Domain.AllPlayersRequest,
                Domain.ListPlayerMessage>(
                  this, METHODID_GET_ALL_PLAYERS)))
          .addMethod(
            getGetByUsernameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Domain.StringRequest,
                Domain.PlayerMessage>(
                  this, METHODID_GET_BY_USERNAME)))
          .addMethod(
            getEditPlayerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Domain.PlayerMessage,
                Domain.PlayerMessage>(
                  this, METHODID_EDIT_PLAYER)))
          .build();
    }
  }

  /**
   */
  public static final class FootballPlayerServiceStub extends io.grpc.stub.AbstractAsyncStub<FootballPlayerServiceStub> {
    private FootballPlayerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FootballPlayerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FootballPlayerServiceStub(channel, callOptions);
    }

    /**
     */
    public void createPlayer(Domain.PlayerCreationDTOMessage request,
        io.grpc.stub.StreamObserver<Domain.PlayerMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePlayerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllPlayers(Domain.AllPlayersRequest request,
        io.grpc.stub.StreamObserver<Domain.ListPlayerMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllPlayersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByUsername(Domain.StringRequest request,
        io.grpc.stub.StreamObserver<Domain.PlayerMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editPlayer(Domain.PlayerMessage request,
        io.grpc.stub.StreamObserver<Domain.PlayerMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEditPlayerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FootballPlayerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FootballPlayerServiceBlockingStub> {
    private FootballPlayerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FootballPlayerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FootballPlayerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Domain.PlayerMessage createPlayer(Domain.PlayerCreationDTOMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePlayerMethod(), getCallOptions(), request);
    }

    /**
     */
    public Domain.ListPlayerMessage getAllPlayers(Domain.AllPlayersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllPlayersMethod(), getCallOptions(), request);
    }

    /**
     */
    public Domain.PlayerMessage getByUsername(Domain.StringRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public Domain.PlayerMessage editPlayer(Domain.PlayerMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEditPlayerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FootballPlayerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FootballPlayerServiceFutureStub> {
    private FootballPlayerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FootballPlayerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FootballPlayerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Domain.PlayerMessage> createPlayer(
        Domain.PlayerCreationDTOMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePlayerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Domain.ListPlayerMessage> getAllPlayers(
        Domain.AllPlayersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllPlayersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Domain.PlayerMessage> getByUsername(
        Domain.StringRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByUsernameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Domain.PlayerMessage> editPlayer(
        Domain.PlayerMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEditPlayerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PLAYER = 0;
  private static final int METHODID_GET_ALL_PLAYERS = 1;
  private static final int METHODID_GET_BY_USERNAME = 2;
  private static final int METHODID_EDIT_PLAYER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FootballPlayerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FootballPlayerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PLAYER:
          serviceImpl.createPlayer((Domain.PlayerCreationDTOMessage) request,
              (io.grpc.stub.StreamObserver<Domain.PlayerMessage>) responseObserver);
          break;
        case METHODID_GET_ALL_PLAYERS:
          serviceImpl.getAllPlayers((Domain.AllPlayersRequest) request,
              (io.grpc.stub.StreamObserver<Domain.ListPlayerMessage>) responseObserver);
          break;
        case METHODID_GET_BY_USERNAME:
          serviceImpl.getByUsername((Domain.StringRequest) request,
              (io.grpc.stub.StreamObserver<Domain.PlayerMessage>) responseObserver);
          break;
        case METHODID_EDIT_PLAYER:
          serviceImpl.editPlayer((Domain.PlayerMessage) request,
              (io.grpc.stub.StreamObserver<Domain.PlayerMessage>) responseObserver);
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

  private static abstract class FootballPlayerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FootballPlayerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Domain.FootballManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FootballPlayerService");
    }
  }

  private static final class FootballPlayerServiceFileDescriptorSupplier
      extends FootballPlayerServiceBaseDescriptorSupplier {
    FootballPlayerServiceFileDescriptorSupplier() {}
  }

  private static final class FootballPlayerServiceMethodDescriptorSupplier
      extends FootballPlayerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FootballPlayerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FootballPlayerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FootballPlayerServiceFileDescriptorSupplier())
              .addMethod(getCreatePlayerMethod())
              .addMethod(getGetAllPlayersMethod())
              .addMethod(getGetByUsernameMethod())
              .addMethod(getEditPlayerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
