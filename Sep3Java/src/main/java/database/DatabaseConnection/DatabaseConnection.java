package database.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection implements DatabaseConnectionInterface {
    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://snuffleupagus.db.elephantsql.com:5432/rrlolsrq", "rrlolsrq", "3CROcMiyt-f7hushyf-9hcttaMyGQCSz");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
