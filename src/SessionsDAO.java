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

        try {
            Connection connection = helper.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Sessions";
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Sessions> sessions = new ArrayList<>();
            while (resultSet.next()) {
                sessions.add(new Sessions(
                        resultSet.getInt("id"),
                        resultSet.getInt("movie_id"),
                        resultSet.getInt("salon_id"),
                        resultSet.getTimestamp("session_time")));
            }
            for (Sessions s : sessions) {
                System.out.println(s);
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
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
