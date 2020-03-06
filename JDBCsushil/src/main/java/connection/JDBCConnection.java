package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
    String url;
    String user;
    String password;

    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sushil";
        String user = "root";
        String password = "";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
