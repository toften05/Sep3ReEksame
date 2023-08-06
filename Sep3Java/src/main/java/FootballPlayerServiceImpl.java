import Domain.*;
import Shared.FootballPlayer;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import database.DatabaseConnection.DatabaseConnection;
import database.FootballPlayerCommands.FootballPlayerDbCommands;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;
import java.sql.SQLException;
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
            Date dateOfBirth = player.getBirthday();
            String email = player.getEmail();
            String role = player.getRole();
            String teamName = player.getTeamName();
            String position = player.getPosition();
            int id = player.getId();
            String name = player.getName();

            PlayerMessage.Builder playerMessageBuilder = PlayerMessage.newBuilder();

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

            playerMessageBuilder.setId(id);

            PlayerMessage playerMessage = playerMessageBuilder.build();
            response.addPlayers(playerMessage);
        }


        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createPlayer(PlayerCreationDTOMessage request, StreamObserver<PlayerMessage> responseObserver) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        FootballPlayerDbCommands dbCommands = new FootballPlayerDbCommands();

        long seconds = request.getBirthday().getSeconds();
        Date sqlDate = new Date(seconds * 1000);
        FootballPlayer player = new FootballPlayer(request.getName(), sqlDate, request.getEmail(), request.getRolle(), request.getTeamName(), request.getPosition());

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
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editPlayer(PlayerMessage request, StreamObserver<PlayerMessage> responseObserver) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        FootballPlayerDbCommands dbCommands = new FootballPlayerDbCommands();

        long seconds = request.getBirthday().getSeconds();
        Date sqlDate = new Date(seconds * 1000);
        FootballPlayer player = new FootballPlayer(request.getName(), sqlDate, request.getEmail(), request.getRolle(), request.getTeamName(), request.getPosition());
        player.setId(request.getId());

        dbCommands.editFootballPlayer(connection, player);

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
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





