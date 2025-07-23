package ca.spacehippie.epicboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection (singleton).
 */
public class DBConnection {
    /**
     * Active connection.
     */
    private static Connection instance = null;

    /**
     * Create a new connection.
     * 
     * @throws SQLException On failure.
     */
    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(Login.URL, Login.USER, Login.PASS);
    }

    /**
     * Get the DB connection.
     * 
     * @return Active connection.
     * @throws SQLException On failure.
     */
    public static Connection instance() throws SQLException {
        if(instance == null) {
            instance = createConnection();
        }

        return instance;
    }

    /**
     * Close the connection.
     * 
     * @throws SQLException On failure.
     */
    public static void close() throws SQLException {
        instance.close();
    }
}
