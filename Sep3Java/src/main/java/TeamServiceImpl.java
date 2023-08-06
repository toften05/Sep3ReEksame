import Domain.*;
import Shared.Team;
import database.DatabaseConnection.DatabaseConnection;
import database.FootballPlayerCommands.TeamDbCommands;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;
import java.sql.SQLException;

public class TeamServiceImpl extends TeamServiceGrpc.TeamServiceImplBase {

    @Override
    public void createTeam(TeamCreationDTOMessage request, StreamObserver<TeamMessage> responseObserver) {
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

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllTeams(AllTeamsRequest request, StreamObserver<ListTeamMessage> responseObserver) {
        System.out.println("getAllTeams called");
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        TeamDbCommands dbCommands = new TeamDbCommands();

        ListTeamMessage.Builder response = ListTeamMessage.newBuilder();

        for (Team teams : dbCommands.getAllTeams(connection)) {
            String teamName = teams.getTeamName();
            String initials = teams.getInitials();
            String division = teams.getDivision();


            TeamMessage.Builder teamMessageBuilder = TeamMessage.newBuilder();

            if (teamName != null) {
                teamMessageBuilder.setTeamName(teamName);
            }

            if (initials != null) {
                teamMessageBuilder.setInitials(initials);
            }

            if (division != null) {
                teamMessageBuilder.setDivision(division);
            }


            TeamMessage teamMessage = teamMessageBuilder.build();
            response.addTeams(teamMessage);

        }


        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
