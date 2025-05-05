import java.sql.*;

public class Main {
    public static void main(String[] args) {

        MovieDAO movieDAO = new MovieDAO();
        SessionsDAO sessionsDAO = new SessionsDAO();

        try {
            // Add movie
            //movieDAO.addMovie("Back to the Future", "Sci-Fi", 116, "Robert Zemeckis", "Time travel adventure");
            // Select movies
            movieDAO.selectMovie();
            // Update movie title
            //movieDAO.updateMovie(17, "Updated Title");
            // Delete movie by ID
            //movieDAO.deleteMovie(2);

            // Add session
            //sessionsDAO.addSession(2,3,Timestamp.valueOf("2025-05-06 15:00:00"));
            // Select sessions
            sessionsDAO.selectSession();
            // Update session times
            //sessionsDAO.updateSessionTime(5,Timestamp.valueOf("2025-05-10 20:30:00"));
            // Delete session by ID
            //sessionsDAO.deleteSession(2);




        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
