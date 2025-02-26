import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Manages database connection

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    //Establishes and returns a connection with the local database

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + USER + PASSWORD);
    }
}
