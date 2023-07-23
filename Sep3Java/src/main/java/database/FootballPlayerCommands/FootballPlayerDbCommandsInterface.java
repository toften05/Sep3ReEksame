package database.FootballPlayerCommands;

import Shared.FootballPlayer;


import java.sql.Connection;

public interface FootballPlayerDbCommandsInterface
{
  void createFootballPlayer(Connection connection, FootballPlayer player);
}
