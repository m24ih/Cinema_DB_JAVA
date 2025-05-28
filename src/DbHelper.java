import java.sql.*;

public class DbHelper {

    private String url = "jdbc:mysql://127.0.0.1:3306/cinema_db";
    private String user = "root";
    private String password = "usBu6XjaMaMdjY9VWatv";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void showErrorMessage(SQLException exception) {
        System.out.println("Error = " + exception.getMessage());
        System.out.println("Error Code = " + exception.getErrorCode());
    }
}
