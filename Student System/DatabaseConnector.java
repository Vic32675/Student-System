import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnector {
    private static final String URL = "jdbc:mariadb://127.0.0.1:3306/studentsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Ud415zAs";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
