import Domain.*;
import Shared.FootballCoach;
import Shared.FootballPlayer;
import com.google.protobuf.Timestamp;
import database.DatabaseConnection.DatabaseConnection;
import database.FootballPlayerCommands.CoachDbCommands;
import database.FootballPlayerCommands.FootballPlayerDbCommands;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class FootballCoachImpl extends  CoachServiceGrpc.CoachServiceImplBase{
    public void createCoach(CoachCreationDtoMessage request, StreamObserver<CoachMessage> responseObserver) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        CoachDbCommands dbCommands = new CoachDbCommands();
        FootballCoach coach = new FootballCoach(request.getName(), request.getBirthday(),request.getInitials(), request.getEmail(), request.getRole());

        dbCommands.createFootballCoach(connection, coach);

        CoachMessage response = CoachMessage.newBuilder()
                .setId(coach.getId())
                .setName(coach.getFullName())
                .setInitials(coach.getInitials())
                .setEmail(coach.getEmail())
                .setRole(coach.getRole())
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
    public void getAllCoaches(AllCoachesRequest request, StreamObserver<ListCoachMessage> responseObserver) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        CoachDbCommands dbCommands = new CoachDbCommands();

        ListCoachMessage.Builder response = ListCoachMessage.newBuilder();

        for (FootballCoach coach : dbCommands.getAllCoaches(connection)) {
            String name = coach.getFullName();
            String birthday = coach.getBirthday();
            String initials = coach.getInitials();
            String email = coach.getEmail();
            String role = coach.getRole();

            CoachMessage.Builder coachMessageBuilder = CoachMessage.newBuilder();

            if (name != null) {
                coachMessageBuilder.setName(name);
            }

            if (birthday != null) {
                coachMessageBuilder.setBirthday(birthday);
            }

            if (initials != null) {
                coachMessageBuilder.setInitials(initials);
            }


            if (email != null) {
                coachMessageBuilder.setEmail(email);
            }

            if (role != null) {
                coachMessageBuilder.setRole(role);
            }


           // coachMessageBuilder.setId(id);

            CoachMessage coachMessage = coachMessageBuilder.build();
            response.addCoaches(coachMessage);
        }


        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
