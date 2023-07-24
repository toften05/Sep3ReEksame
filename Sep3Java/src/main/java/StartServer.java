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
            .addService(new TeamServiceImpl())
        .build()
        .start();
        System.out.println("Server Started");
        server.awaitTermination();
/*
    DatabaseConnection dbconnection = new DatabaseConnection();
    Connection connection = dbconnection.getConnection();
    FootballPlayerDbCommands dbCommands = new FootballPlayerDbCommands();


   // System.out.println("Testing createFootballPlayer:");
    // FootballPlayer newPlayer = new FootballPlayer("Lerby");
   // dbCommands.createFootballPlayer(connection, newPlayer);

    System.out.println("Testing getAllFootballPlayers:");
    List<FootballPlayer> players = dbCommands.getAllFootballPlayers(connection);
    for (FootballPlayer player : players) {
      System.out.println("Player name: " + player.getName());
    }

    System.out.println("Testing getPlayerByUsername:");
    FootballPlayer player = dbCommands.getPlayerByUsername(connection, "newPlayer");
    System.out.println("Player name: " + player.getName());




    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
        .usePlaintext()
        .build();

    FootballPlayerServiceGrpc.FootballPlayerServiceBlockingStub stub =
        FootballPlayerServiceGrpc.newBlockingStub(channel);

    // Test getAllPlayers
    ListPlayerMessage listPlayerMessage = stub.getAllPlayers(
        AllPlayersRequest.newBuilder().build());
    listPlayerMessage.getPlayersList().forEach(player -> System.out.println(player.getName()));

    // Test createPlayer
    PlayerMessage createdPlayer = stub.createPlayer(
        PlayerCreationDTOMessage.newBuilder().setName("Lerby").build());
    System.out.println("Created player: " + createdPlayer.getName());

    // Test getByUsername
    PlayerMessage playerByUsername = stub.getByUsername(StringRequest.newBuilder().setString("Lerby").build());
    System.out.println("Retrieved player by username: " + playerByUsername.getName());

    channel.shutdownNow();
*/
  }
}
