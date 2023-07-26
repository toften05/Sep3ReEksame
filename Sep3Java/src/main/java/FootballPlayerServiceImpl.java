import Domain.*;
import Shared.FootballPlayer;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import database.DatabaseConnection.DatabaseConnection;
import database.FootballPlayerCommands.FootballPlayerDbCommands;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;
import java.util.Date;

public class FootballPlayerServiceImpl extends FootballPlayerServiceGrpc.FootballPlayerServiceImplBase {


    @Override
    public void getAllPlayers(AllPlayersRequest request, StreamObserver<ListPlayerMessage> responseObserver) {
        System.out.println("getAllPlayers called");
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        FootballPlayerDbCommands dbCommands = new FootballPlayerDbCommands();

        ListPlayerMessage.Builder response = ListPlayerMessage.newBuilder();

        for (FootballPlayer player : dbCommands.getAllFootballPlayers(connection)) {
            // Get player attributes
            Date dateOfBirth = player.getBirthday();
            String email = player.getEmail();
            String role = player.getRole();
            String teamName = player.getTeamName();
            String position = player.getPosition();
            int id = player.getId();  // assuming ID is an int
            String name = player.getName();

            // Create builder for PlayerMessage
            PlayerMessage.Builder playerMessageBuilder = PlayerMessage.newBuilder();

            // Check each attribute for null and set it if not null
            if (dateOfBirth != null) {
                Timestamp timestampBirthDay = Timestamp.newBuilder()
                        .setSeconds(dateOfBirth.getTime() / 1000)
                        .build();
                playerMessageBuilder.setBirthday(timestampBirthDay);
            }

            if (email != null) {
                playerMessageBuilder.setEmail(email);
            }

            if (role != null) {
                playerMessageBuilder.setRolle(role);
            }

            if (teamName != null) {
                playerMessageBuilder.setTeamName(teamName);
            }

            if (position != null) {
                playerMessageBuilder.setPosition(position);
            }

            if (name != null) {
                playerMessageBuilder.setName(name);
            }

            playerMessageBuilder.setId(id);  // assuming ID can't be null

            PlayerMessage playerMessage = playerMessageBuilder.build();
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

        long seconds = request.getBirthday().getSeconds();
        Date sqlDate = new Date(seconds * 1000);
        FootballPlayer player = new FootballPlayer
                (request.getName(),
                        sqlDate,
                        request.getEmail(),
                        request.getRolle(),
                        request.getTeamName(),
                        request.getPosition());
        request.getTeamName();
        request.getPosition();
        System.out.println(player);

        dbCommands.createFootballPlayer(connection, player);

        long responseSeconds = player.getBirthday().getTime() / 1000;
        Timestamp responseTimestamp = Timestamp.newBuilder().setSeconds(responseSeconds).build();
        PlayerMessage response = PlayerMessage.newBuilder()
                .setId(player.getId())
                .setName(player.getName())
                .setBirthday(responseTimestamp)
                .setRolle(player.getRole())
                .setTeamName(player.getTeamName())
                .setPosition(player.getPosition())
                .build();
        System.out.println(response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


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
    }


    public void deletePlayer(PlayerMessage request, StreamObserver<Empty> responseObserver) {
        System.out.println("deletePlayer called");
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        FootballPlayerDbCommands dbCommands = new FootballPlayerDbCommands();

        dbCommands.deleteFootballPlayer(connection, request.getId());

        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();


    }
}





