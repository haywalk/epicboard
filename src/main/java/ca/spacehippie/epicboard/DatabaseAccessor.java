package ca.spacehippie.epicboard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAccessor {

    public static String getThread(String threadId) {
                
        ResultSet result;

        try {
            result = query("SELECT * FROM posts WHERE thread_id = " + threadId);
        } catch (SQLException e) {
            return "Failed to retrieve thread.";
        }

        return resultSetToJSON(result);
    }

    public static String getBoard(String board) {

        ResultSet result;

        try {
            result = query("SELECT * FROM posts WHERE board = " + board);
        } catch (SQLException e){
            return "Failed to retrieve board";
        }

        return resultSetToJSON(result);
    }

    private static ResultSet query(String query) throws SQLException {
        Connection conn = DBConnection.instance();
        Statement statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    private static String resultSetToJSON(ResultSet resultSet) {
        return resultSet.toString();
    }
}
