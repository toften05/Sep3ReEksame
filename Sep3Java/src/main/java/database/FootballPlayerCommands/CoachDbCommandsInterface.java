package database.FootballPlayerCommands;

import Shared.FootballCoach;
import Shared.FootballPlayer;

import java.sql.Connection;

public interface CoachDbCommandsInterface {

    void createFootCoach(Connection connection, FootballCoach coach);
}
