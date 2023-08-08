import Shared.FootballPlayer;
import database.DatabaseConnection.DatabaseConnection;
import database.FootballPlayerCommands.FootballPlayerDbCommands;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestFootballPlayerDbCommands {

    public FootballPlayerDbCommands footballPlayerDbCommands;
    public DatabaseConnection connection;

    @BeforeEach
    void setUp(){
        footballPlayerDbCommands = new FootballPlayerDbCommands();
        connection = new DatabaseConnection();

    }

    @Test
    void test1_getAllFootballPlayers_Success(){
        //Opret liste og hent spillere fra databasen
        List<FootballPlayer> players = null;
        players = footballPlayerDbCommands.getAllFootballPlayers(connection.getConnection());

        //Tjek for null
        assertNotEquals(null, players);

        //Tjek at den indeholder typen FootballPlayer
        FootballPlayer player = null;
        player = players.get(0);
        assertTrue(player instanceof FootballPlayer);
    }

    @Test
    void test2_createFootballPlayer_Success(){
        //Bevis at spilleren ikke findes i forvejen
        FootballPlayer foundPlayer = footballPlayerDbCommands.getPlayerByUsername(connection.getConnection(),"test1_createFootballPlayer_Success");
        assertNull(foundPlayer);

        //Indsæt spilleren
        FootballPlayer testPlayer = new FootballPlayer(
                "test1_createFootballPlayer_Success",
                new java.sql.Date(new Date().getTime()),
                "test@mail.com",
                "test",
                null,
                "test");
        footballPlayerDbCommands.createFootballPlayer(connection.getConnection(), testPlayer);

        //Vis at spilleren findes
        foundPlayer = footballPlayerDbCommands.getPlayerByUsername(
                connection.getConnection(),
                "test1_createFootballPlayer_Success");

        testPlayer.setId(foundPlayer.getId());
        assertEquals(foundPlayer.toString(), testPlayer.toString());

        //Ryd op
        footballPlayerDbCommands.deleteFootballPlayer(connection.getConnection(), foundPlayer.getId());
    }

}
