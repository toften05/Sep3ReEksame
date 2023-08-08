package DbCommands;

import Shared.FootballTeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TeamDbCommands {

    public void createTeam(Connection connection, FootballTeam footballTeam) {
        String sql = "INSERT INTO FootballTeam(teamname, initials, division) VALUES(?,?,?); ";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, footballTeam.getTeamName());
            preparedStatement.setString(2, footballTeam.getInitials());
            preparedStatement.setString(3, footballTeam.getDivision());

            preparedStatement.executeUpdate();
            System.out.println("Team Created");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FootballTeam> getAllTeams(Connection connection) {
        String sql = "SELECT * FROM FootballTeam;";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<FootballTeam> footballTeams = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("teamname");
                String initals = resultSet.getString("initials");
                String division = resultSet.getString("division");


                FootballTeam footballTeam = new FootballTeam(name, initals, division);
                footballTeams.add(footballTeam);
                System.out.println(footballTeam);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Football Team returned");
        return footballTeams;
    }
}
