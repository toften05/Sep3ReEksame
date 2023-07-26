  package database.FootballPlayerCommands;

  import Shared.FootballPlayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FootballPlayerDbCommands {

    public List<FootballPlayer> getAllFootballPlayers(Connection connection) {
        String sql = "SELECT * FROM SoccerPlayer;";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<FootballPlayer> footballPlayers = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Date birthday = resultSet.getDate("birthday");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                String teamName = resultSet.getString("teamname");
                String position = resultSet.getString("position");

                FootballPlayer footballPlayer = new FootballPlayer(name, birthday, email, role, teamName, position);
                footballPlayers.add(footballPlayer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Football players returned");
        System.out.println(footballPlayers);
        return footballPlayers;
    }

    public void createFootballPlayer(Connection connection, FootballPlayer player) {
        String sql = "INSERT INTO soccerplayer(name, birthday, email, role, teamname, position ) VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getName());
            preparedStatement.setDate(2, new java.sql.Date(player.getBirthday().getTime()));
            preparedStatement.setString(3, player.getEmail());
            preparedStatement.setString(4, player.getRole());
            preparedStatement.setString(5, player.getTeamName());
            preparedStatement.setString(6, player.getPosition());

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
                Integer id = resultSet.getInt("playerid");
                String name = resultSet.getString("name");
                Date birthday = resultSet.getDate("birthday");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                String teamName = resultSet.getString("teamname");
                String position = resultSet.getString("position");


                footballPlayer = new FootballPlayer( name, birthday, email, role, teamName, position);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return footballPlayer;
    }

    public void deleteFootballPlayer(Connection connection, int playerId) {
        String sql = "DELETE FROM SoccerPlayer WHERE id = ?;";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, playerId);
            preparedStatement.executeUpdate();
            System.out.println("Football player deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
=======
  public class FootballPlayerDbCommands
  {

    public List<FootballPlayer> getAllFootballPlayers(Connection connection){
      String sql = "SELECT * FROM SoccerPlayer;";
      PreparedStatement preparedStatement;
      ResultSet resultSet;
      List<FootballPlayer> footballPlayers = new ArrayList<>();

      try {
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
          String name = resultSet.getString("name");

          FootballPlayer footballPlayer = new FootballPlayer(name);
          footballPlayers.add(footballPlayer);
        }
      }
      catch (SQLException e)
      {
        throw new RuntimeException(e);
      }
      System.out.println("Football players returned");
      System.out.println(footballPlayers);
      return footballPlayers;
    }

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

