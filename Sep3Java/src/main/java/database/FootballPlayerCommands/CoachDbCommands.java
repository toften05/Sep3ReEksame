package database.FootballPlayerCommands;

import Shared.FootballCoach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoachDbCommands {

    public void createFootballCoach(Connection connection, FootballCoach coach){
        String sql = "INSERT INTO FootBallCoach(fullname, dateofbirth, email, role, initials) VALUES(?,?,?,?,?);";

        PreparedStatement preparedStatement;

       try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, coach.getFullName());
            preparedStatement.setString(2, coach.getBirthday());
           preparedStatement.setString(3, coach.getEmail());
           preparedStatement.setString(4, coach.getRole());
           preparedStatement.setString(5, coach.getInitials());
           preparedStatement.executeUpdate();

            System.out.println("Football coach created");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
