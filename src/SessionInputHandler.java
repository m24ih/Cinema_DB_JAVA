import java.sql.Timestamp;
import java.util.Scanner;
import java.sql.*;


public class SessionInputHandler {
    public static void addSessionFromInput(SessionsDAO sessionsDAO) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Movie ID: ");
            int movieId = Integer.parseInt(scanner.nextLine());

            System.out.print("Salon ID: ");
            int salonId = Integer.parseInt(scanner.nextLine());

            System.out.print("Session Time (YYYY-MM-DD HH:MM:SS): ");
            String timeStr = scanner.nextLine();
            Timestamp sessionTime = Timestamp.valueOf(timeStr);

            sessionsDAO.addSession(movieId, salonId, sessionTime);
        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
