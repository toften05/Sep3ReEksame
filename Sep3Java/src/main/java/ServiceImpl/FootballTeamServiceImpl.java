package ServiceImpl;

import Domain.*;
import Shared.FootballTeam;
import DbConnection.DatabaseConnection;
import DbCommands.TeamDbCommands;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;
import java.sql.SQLException;

public class FootballTeamServiceImpl extends TeamServiceGrpc.TeamServiceImplBase {

    @Override
    public void createTeam(TeamCreationDTOMessage request, StreamObserver<TeamMessage> responseObserver) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();
        TeamDbCommands dbCommands = new TeamDbCommands();
        FootballTeam footballTeam = new FootballTeam(request.getTeamName(), request.getInitials(), request.getDivision());

        dbCommands.createTeam(connection, footballTeam);

        TeamMessage response = TeamMessage.newBuilder()
                .setTeamName(footballTeam.getTeamName())
                .setDivision(footballTeam.getDivision())
                .setInitials(footballTeam.getInitials())
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

        for (FootballTeam teams : dbCommands.getAllTeams(connection)) {
            String teamName = teams.getTeamName();
            String initials = teams.getInitials();
            String division = teams.getDivision();


            TeamMessage.Builder teamMessageBuilder = TeamMessage.newBuilder();
            teamMessageBuilder.setTeamName(teamName);
            teamMessageBuilder.setInitials(initials);
            teamMessageBuilder.setDivision(division);

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
