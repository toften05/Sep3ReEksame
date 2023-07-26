import Domain.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;


public class StartServer
{
  public static void main(String[] args)
      throws IOException, InterruptedException
  {
    Server server = ServerBuilder
            .forPort(9090)
            .addService(new FootballPlayerServiceImpl())
            .build()
            .start();
    System.out.println("Server Started");
    server.awaitTermination();
/*
      ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
              .usePlaintext()
              .build();

      FootballPlayerServiceGrpc.FootballPlayerServiceBlockingStub stub =
              FootballPlayerServiceGrpc.newBlockingStub(channel);

      // Test getAllPlayers
      ListPlayerMessage listPlayerMessage = stub.getAllPlayers(AllPlayersRequest.newBuilder().build());
      listPlayerMessage.getPlayersList().forEach(player -> System.out.println(player.getName()));

      // Test createPlayer
      PlayerMessage createdPlayer = stub.createPlayer(PlayerCreationDTOMessage.newBuilder().setName("Lerby").build());
      System.out.println("Created player: " + createdPlayer.getName());

      // Test getByUsername
      PlayerMessage playerByUsername = stub.getByUsername(StringRequest.newBuilder().setString("Lerby").build());
      System.out.println("Retrieved player by username: " + playerByUsername.getName());

      channel.shutdownNow();

      /*

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();

    FootballPlayerServiceGrpc.FootballPlayerServiceBlockingStub stub =
            FootballPlayerServiceGrpc.newBlockingStub(channel);

    // Test getAllPlayers
    ListPlayerMessage listPlayerMessage = stub.getAllPlayers(AllPlayersRequest.newBuilder().build());
    listPlayerMessage.getPlayersList().forEach(player -> System.out.println(player.getName()));

    // Test createPlayer
    PlayerMessage createdPlayer = stub.createPlayer(PlayerCreationDTOMessage.newBuilder().setName("Test Player").build());
    System.out.println("Created player: " + createdPlayer.getName());

    // Test deletePlayer
    stub.deletePlayer(PlayerMessage.newBuilder().setId(createdPlayer.getId()).build());
    System.out.println("Deleted player: " + createdPlayer.getName());

    // Test getAllPlayers again to see if player is deleted
    ListPlayerMessage listPlayerMessageAfterDeletion = stub.getAllPlayers(AllPlayersRequest.newBuilder().build());
    listPlayerMessageAfterDeletion.getPlayersList().forEach(player -> System.out.println(player.getName()));

    channel.shutdownNow(); */
  }


  }

