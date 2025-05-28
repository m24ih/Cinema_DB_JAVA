import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {

    public void addMovie(String title, String genre, int duration, String director, String description) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "INSERT INTO Movies (title, genre, duration, director, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, title);
            statement.setString(2, genre);
            statement.setInt(3, duration);
            statement.setString(4, director);
            statement.setString(5, description);
            int result = statement.executeUpdate();

            System.out.println("Insert completed. Affected rows: " + result);
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public void selectMovie() throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM Movies";

        try (Connection connection = helper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println("Movie ID: " + resultSet.getInt("id"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Genre: " + resultSet.getString("genre"));
                System.out.println("Duration: " + resultSet.getInt("duration"));
                System.out.println("Director: " + resultSet.getString("director"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("---------------------------");
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }


    public void selectMoviesByGenre(String genre) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM Movies WHERE genre = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, genre);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("Movie ID: %d, Title: %s, Genre: %s, Duration: %d, Director: %s, Description: %s%n",
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getInt("duration"),
                        resultSet.getString("director"),
                        resultSet.getString("description"));
            }
        }
    }


    public void updateMovie(int id, String newTitle) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "UPDATE Movies SET title = ? WHERE id = ?";
        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newTitle);
            statement.setInt(2, id);
            int result = statement.executeUpdate();

            System.out.println("Update completed. Affected rows: " + result);
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public void deleteMovie(int id) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "DELETE FROM Movies WHERE id = ?";
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
