import Domain.CoachCreationDtoMessage;
import Domain.CoachMessage;
import Domain.FootballPlayerServiceGrpc;
import Shared.FootballCoach;
import database.DatabaseConnection.DatabaseConnection;
import database.FootballPlayerCommands.CoachDbCommands;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;

public class FootballCoachImpl extends FootballPlayerServiceGrpc.FootballPlayerServiceImplBase
{
    public void createCoach(CoachCreationDtoMessage request, StreamObserver<CoachMessage> responseObserver){
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        CoachDbCommands dbCommands = new CoachDbCommands();
        FootballCoach coach = new FootballCoach(request.getName(), request.getBirthday(),request.getInitials(), request.getName(), request.getRole());

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


    }
}
