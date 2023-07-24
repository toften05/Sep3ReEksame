package database.FootballPlayerCommands;

import Shared.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TeamDbCommands {

    public void createTeam(Connection connection, Team team){
        String sql = "INSERT INTO SoccerTeam(teamName) VALUES(?); " +
                     "INSERT INTO SoccerTeam(division) VALUES (?);" +
                     "INSERT INTO SoccerTeam(initials) VALUES (?);";
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
}
