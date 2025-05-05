import java.sql.*;

public class Main {
    public static void main(String[] args) {

        MovieDAO movieDAO = new MovieDAO();

        try {
            // Add movie
            //movieDAO.addMovie("Back to the Future", "Sci-Fi", 116, "Robert Zemeckis", "Time travel adventure");
            // Select movies
            movieDAO.selectMovie();
            // Update movie title
            //movieDAO.updateMovie(17, "Updated Title");
            // Delete movie by ID
            //movieDAO.deleteMovie(2);




        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
