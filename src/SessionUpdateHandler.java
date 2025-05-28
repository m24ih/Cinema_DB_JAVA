import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class SessionUpdateHandler {
    public static void updateSessionTimeFromInput(SessionsDAO sessionsDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Session ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // buffer temizle

        System.out.print("Enter new session time (yyyy-MM-dd HH:mm:ss): ");
        String newTime = scanner.nextLine();

        try {
            Timestamp timestamp = Timestamp.valueOf(newTime);
            sessionsDAO.updateSessionTime(id, timestamp);
        } catch (IllegalArgumentException exception) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd HH:mm:ss");
        }
    }
}
