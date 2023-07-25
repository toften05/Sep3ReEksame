package Domain;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: FootballManagement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TeamServiceGrpc {

  private TeamServiceGrpc() {}

  public static final String SERVICE_NAME = "Domain.TeamService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Domain.TeamCreationDTOMessage,
      Domain.TeamMessage> getCreateTeamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTeam",
      requestType = Domain.TeamCreationDTOMessage.class,
      responseType = Domain.TeamMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Domain.TeamCreationDTOMessage,
      Domain.TeamMessage> getCreateTeamMethod() {
    io.grpc.MethodDescriptor<Domain.TeamCreationDTOMessage, Domain.TeamMessage> getCreateTeamMethod;
    if ((getCreateTeamMethod = TeamServiceGrpc.getCreateTeamMethod) == null) {
      synchronized (TeamServiceGrpc.class) {
        if ((getCreateTeamMethod = TeamServiceGrpc.getCreateTeamMethod) == null) {
          TeamServiceGrpc.getCreateTeamMethod = getCreateTeamMethod =
              io.grpc.MethodDescriptor.<Domain.TeamCreationDTOMessage, Domain.TeamMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTeam"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.TeamCreationDTOMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Domain.TeamMessage.getDefaultInstance()))
              .setSchemaDescriptor(new TeamServiceMethodDescriptorSupplier("CreateTeam"))
              .build();
        }
      }
    }
    return getCreateTeamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TeamServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TeamServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TeamServiceStub>() {
        @java.lang.Override
        public TeamServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TeamServiceStub(channel, callOptions);
        }
      };
    return TeamServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TeamServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TeamServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TeamServiceBlockingStub>() {
        @java.lang.Override
        public TeamServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TeamServiceBlockingStub(channel, callOptions);
        }
      };
    return TeamServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TeamServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TeamServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TeamServiceFutureStub>() {
        @java.lang.Override
        public TeamServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TeamServiceFutureStub(channel, callOptions);
        }
      };
    return TeamServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TeamServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createTeam(Domain.TeamCreationDTOMessage request,
        io.grpc.stub.StreamObserver<Domain.TeamMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTeamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTeamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Domain.TeamCreationDTOMessage,
                Domain.TeamMessage>(
                  this, METHODID_CREATE_TEAM)))
          .build();
    }
  }

  /**
   */
  public static final class TeamServiceStub extends io.grpc.stub.AbstractAsyncStub<TeamServiceStub> {
    private TeamServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeamServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TeamServiceStub(channel, callOptions);
    }

    /**
     */
    public void createTeam(Domain.TeamCreationDTOMessage request,
        io.grpc.stub.StreamObserver<Domain.TeamMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTeamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TeamServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TeamServiceBlockingStub> {
    private TeamServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeamServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TeamServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Domain.TeamMessage createTeam(Domain.TeamCreationDTOMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTeamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TeamServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TeamServiceFutureStub> {
    private TeamServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeamServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TeamServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Domain.TeamMessage> createTeam(
        Domain.TeamCreationDTOMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTeamMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TEAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TeamServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TeamServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TEAM:
          serviceImpl.createTeam((Domain.TeamCreationDTOMessage) request,
              (io.grpc.stub.StreamObserver<Domain.TeamMessage>) responseObserver);
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

  private static abstract class TeamServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TeamServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Domain.FootballManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TeamService");
    }
  }

  private static final class TeamServiceFileDescriptorSupplier
      extends TeamServiceBaseDescriptorSupplier {
    TeamServiceFileDescriptorSupplier() {}
  }

  private static final class TeamServiceMethodDescriptorSupplier
      extends TeamServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TeamServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TeamServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TeamServiceFileDescriptorSupplier())
              .addMethod(getCreateTeamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
