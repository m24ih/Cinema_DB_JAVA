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

        try {
            Connection connection = helper.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Movies";
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Movie> movies = new ArrayList<Movie>();
            while (resultSet.next()) {
                movies.add(new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getInt("duration"),
                        resultSet.getString("director"),
                        resultSet.getString("description")));
            }
            for (Movie m : movies) {
                System.out.println(m);
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
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
