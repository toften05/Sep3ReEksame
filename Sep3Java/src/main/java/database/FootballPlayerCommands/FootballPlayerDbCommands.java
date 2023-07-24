package database.FootballPlayerCommands;

import Shared.FootballPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FootballPlayerDbCommands
{

  public void createFootballPlayer(Connection connection, FootballPlayer player) {
    String sql = "INSERT INTO SoccerPlayer(name) VALUES(?);";
    PreparedStatement preparedStatement;

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, player.getName());
      preparedStatement.executeUpdate();
      System.out.println("Football player created");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public FootballPlayer getPlayerByUsername(Connection connection, String username) {
    String sql = "SELECT * FROM SoccerPlayer WHERE name = ?;";
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    FootballPlayer footballPlayer = null;

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, username);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
    String name =  resultSet.getString("name");

    footballPlayer = new FootballPlayer(name);
    }
  }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    } return footballPlayer;
  }
}
