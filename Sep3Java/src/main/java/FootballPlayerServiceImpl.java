import Domain.*;
import Shared.FootballPlayer;
import database.DatabaseConnection.DatabaseConnection;
import database.FootballPlayerCommands.FootballPlayerDbCommands;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;
import java.sql.SQLException;


public class FootballPlayerServiceImpl extends FootballPlayerServiceGrpc.FootballPlayerServiceImplBase {

  @Override
  public void getAllPlayers(AllPlayersRequest request, StreamObserver<ListPlayerMessage> responseObserver) {
    System.out.println("getAllPlayers called");
    DatabaseConnection db = new DatabaseConnection();
    Connection connection = db.getConnection();
    FootballPlayerDbCommands dbCommands = new FootballPlayerDbCommands();

    ListPlayerMessage.Builder response = ListPlayerMessage.newBuilder();

    for (FootballPlayer player : dbCommands.getAllFootballPlayers(connection)) {
      PlayerMessage playerMessage = PlayerMessage.newBuilder()
              .setId(player.getId())
              .setName(player.getName())
              .build();
      response.addPlayers(playerMessage);
    }

    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void createPlayer(PlayerCreationDTOMessage request, StreamObserver<PlayerMessage> responseObserver) {

    DatabaseConnection db = new DatabaseConnection();
    Connection connection = db.getConnection();
    FootballPlayerDbCommands dbCommands = new FootballPlayerDbCommands();
    FootballPlayer player = new FootballPlayer(request.getName());

    dbCommands.createFootballPlayer(connection, player);

    PlayerMessage response = PlayerMessage.newBuilder()
        .setId(player.getId())
        .setName(player.getName())
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();

    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void getByUsername(StringRequest request, StreamObserver<PlayerMessage> responseObserver) {
    DatabaseConnection db = new DatabaseConnection();
    Connection connection = db.getConnection();
    FootballPlayerDbCommands dbCommands = new FootballPlayerDbCommands();

    FootballPlayer player = dbCommands.getPlayerByUsername(connection, request.getString());

    if (player != null) {
      PlayerMessage response = PlayerMessage.newBuilder()
          .setId(player.getId())
          .setName(player.getName())
          .build();

      responseObserver.onNext(response);
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND
          .withDescription("Player with username " + request.getString() + " not found")
          .asRuntimeException());
    }

    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}





