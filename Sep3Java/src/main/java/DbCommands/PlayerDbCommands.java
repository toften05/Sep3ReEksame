package DbCommands;

import Shared.FootballPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerDbCommands {

    public List<FootballPlayer> getAllFootballPlayers(Connection connection) {
        String sql = "SELECT * FROM FootballPlayer;";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<FootballPlayer> footballPlayers = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("playerid");
                String teamName = resultSet.getString("teamname");
                String name = resultSet.getString("fullname");
                Date birthday = resultSet.getDate("birthday");
                String position = resultSet.getString("position");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");

                FootballPlayer footballPlayer = new FootballPlayer(name, birthday, email, role, teamName, position);
                footballPlayer.setId(id);
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
        String sql = "INSERT INTO FootballPlayer(teamname, fullname, birthday, position, email, role) VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getTeamName());
            preparedStatement.setString(2, player.getName());
            preparedStatement.setDate(3, new java.sql.Date(player.getBirthday().getTime()));
            preparedStatement.setString(4, player.getPosition());
            preparedStatement.setString(5, player.getEmail());
            preparedStatement.setString(6, player.getRole());

            preparedStatement.executeUpdate();
            System.out.println("Football player created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public FootballPlayer getPlayerByUsername(Connection connection, String username) {
        String sql = "SELECT * FROM FootballPlayer WHERE fullname = ?;";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        FootballPlayer footballPlayer = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("playerid");
                String teamName = resultSet.getString("teamname");
                String name = resultSet.getString("fullname");
                Date birthday = resultSet.getDate("birthday");
                String position = resultSet.getString("position");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");


                footballPlayer = new FootballPlayer(name, birthday, email, role, teamName, position);
                footballPlayer.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return footballPlayer;
    }

    public void deleteFootballPlayer(Connection connection, int playerId) {
        String sql = "DELETE FROM FootballPlayer WHERE playerid = ?;";
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

    public void editFootballPlayer(Connection connection, FootballPlayer player) {
        String sql = "update footballplayer \n" +
                "set fullname = ?, \n" +
                "birthday = ?, \n" +
                "email = ?, \n" +
                "role = ?, \n" +
                "teamname = ?, \n" +
                "position = ? \n" +
                "where playerid = ?;";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getName());
            preparedStatement.setDate(2, new java.sql.Date(player.getBirthday().getTime()));
            preparedStatement.setString(3, player.getEmail());
            preparedStatement.setString(4, player.getRole());
            preparedStatement.setString(5, player.getTeamName());
            preparedStatement.setString(6, player.getPosition());
            preparedStatement.setInt(7, player.getId());

            preparedStatement.executeUpdate();
            System.out.println("Football player edited");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
