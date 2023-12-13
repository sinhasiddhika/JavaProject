package employeepayrollsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static Conn connection;
    private Connection jdbcConnection;

    // Private constructor to prevent instanti0ation from outside the class
    private Conn() {
        initializeConnection();
    }

    // Public method to get the connection instance
    public static Conn getConnection() {
        if (connection == null) {
            connection = new Conn();
        }
        return connection;
    }

    private void initializeConnection() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/employee";
            String user = "root";
            String password = "daksh@sql";
    
            // Create the connection
            jdbcConnection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }
    
    // Public method to get the JDBC connection
    public Connection getJdbcConnection() {
        return jdbcConnection;
    }
}
