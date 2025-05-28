import java.sql.*;
import java.util.ArrayList;

public class SessionsDAO {

    public void addSession(int movieId, int salonId, Timestamp sessionTime) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "INSERT INTO Sessions (movie_id, salon_id, session_time) VALUES (?, ?, ?)";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, movieId);
            statement.setInt(2, salonId);
            statement.setTimestamp(3, sessionTime);

            int result = statement.executeUpdate();
            System.out.println("Session added successfully. Affected rows: " + result);
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public void selectSession() throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM Sessions";

        try (Connection connection = helper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println("Session Id: " + resultSet.getInt("id"));
                System.out.println("Movie Id: " + resultSet.getInt("movie_id"));
                System.out.println("Hall Id: " + resultSet.getInt("hall_id"));
                System.out.println("Session Time: " + resultSet.getTimestamp("session_time"));
                System.out.println("---------------------------");
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }


    public void selectSessionsByMovieId(int movieId) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM Sessions WHERE movieId = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, movieId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("Session ID: %d, Movie ID: %d, Hall ID: %d, Time: %s%n",
                        resultSet.getInt("id"),
                        resultSet.getInt("movieId"),
                        resultSet.getInt("hallId"),
                        resultSet.getTimestamp("time"));
            }
        }
    }


    public void updateSessionTime(int sessionId, Timestamp newSessionTime) {
        DbHelper helper = new DbHelper();
        String sql = "UPDATE Sessions SET session_time = ? WHERE id = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTimestamp(1, newSessionTime);
            statement.setInt(2, sessionId);

            int result = statement.executeUpdate();
            System.out.println("Update completed. Affected rows: " + result);

        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
    }


    public void deleteSession(int id) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "DELETE FROM Sessions WHERE id = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int result = statement.executeUpdate();
            System.out.println("Delete completed. Affected rows: " + result);
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }
}
