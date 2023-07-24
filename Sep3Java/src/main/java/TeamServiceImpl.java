import Domain.TeamCreationDTOMessage;
import Domain.TeamMessage;
import Domain.TeamServiceGrpc;
import Shared.Team;
import database.DatabaseConnection.DatabaseConnection;
import database.FootballPlayerCommands.FootballPlayerDbCommands;
import database.FootballPlayerCommands.TeamDbCommands;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;

public class TeamServiceImpl extends TeamServiceGrpc.TeamServiceImplBase {

    @Override
    public void createTeam(TeamCreationDTOMessage request, StreamObserver<TeamMessage> responseObserver)
    {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        TeamDbCommands dbCommands = new TeamDbCommands();
        Team team = new Team(request.getTeamName(), request.getDivision(), request.getInitials());

        dbCommands.createTeam(connection, team);

        TeamMessage response = TeamMessage.newBuilder()
                .setTeamName(team.getTeamName())
                .setDivision(team.getDivision())
                .setInitials(team.getInitials())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

}
