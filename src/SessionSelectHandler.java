import java.sql.SQLException;
import java.util.Scanner;

public class SessionSelectHandler {
    public static void selectSessionsByMovieId(SessionsDAO sessionsDAO) throws  SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie ID to see its sessions: ");
        int movieId = scanner.nextInt();

        try {
            sessionsDAO.selectSessionsByMovieId(movieId);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
