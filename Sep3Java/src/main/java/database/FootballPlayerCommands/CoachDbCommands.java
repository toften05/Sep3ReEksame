package database.FootballPlayerCommands;

import Shared.FootballCoach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoachDbCommands {

    public void createFootballCoach(Connection connection, FootballCoach coach) {

        String sql = "INSERT INTO footballcoach(fullname, dateofbirth, email, role, teamname, initials) VALUES(?,?,?,?,?,?);";


        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, coach.getFullName());
            preparedStatement.setDate(2, new java.sql.Date(coach.getBirthday().getTime()));
            preparedStatement.setString(3, coach.getEmail());
            preparedStatement.setString(4, coach.getRole());
            preparedStatement.setString(5, coach.getTeamName());
            preparedStatement.setString(6, coach.getInitials());
            preparedStatement.executeUpdate();

            System.out.println("Football coach created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FootballCoach> getAllCoaches(Connection connection) {
        String sql = "SELECT * FROM footballcoach;";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<FootballCoach> footballCoaches = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("fullname");
                Date birthday = resultSet.getDate("dateofbirth"); // birthday eller dateOfBirth??
                String initials = resultSet.getString("initials");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                String teamName = resultSet.getString("teamname");
                int id = resultSet.getInt("coachid");


                FootballCoach footballCoach = new FootballCoach(name, birthday, initials, email, role, teamName);
                footballCoach.setId(id);
                footballCoaches.add(footballCoach);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Football Coaches returned");
        System.out.println(footballCoaches);
        return footballCoaches;
    }
}
