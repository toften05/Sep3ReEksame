package database.FootballPlayerCommands;

import Shared.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TeamDbCommands {

    public void createTeam(Connection connection, Team team){
        String sql = "INSERT INTO FootballTeam(teamname, initials, division) VALUES(?,?,?); ";
        PreparedStatement preparedStatement;

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, team.getTeamName());
            preparedStatement.setString(2, team.getInitials());
            preparedStatement.setString(3, team.getDivision());

            preparedStatement.executeUpdate();
            System.out.println("Team Created");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Team> getAllTeams(Connection connection) {
        String sql = "SELECT * FROM FootballTeam;";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Team> teams = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("teamname");
                String initals = resultSet.getString("initials");
                String division = resultSet.getString("division");


                Team team = new Team(name, initals, division);
                teams.add(team);
                System.out.println(team);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return teams;
    }
}
