package database.FootballPlayerCommands;

import Shared.FootballPlayer;
import Shared.Team;

import java.sql.Connection;

public interface ITeamDbCommand {

    void createTeam(Connection connection, Team team);
}
