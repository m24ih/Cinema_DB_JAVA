import java.sql.*;

public class DbHelper {

    private String url = "jdbc:mysql://localhost:3306/cinema_db";
    private String user = "root";
    private String password = "MyNewPass4!";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void showErrorMessage(SQLException exception) {
        System.out.println("Error = " + exception.getMessage());
        System.out.println("Error Code = " + exception.getErrorCode());
    }
}
