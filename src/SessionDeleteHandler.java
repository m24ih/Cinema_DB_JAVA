import java.sql.SQLException;
import java.util.Scanner;

public class SessionDeleteHandler {
    public static void deleteSessionFromInput(SessionsDAO sessionsDAO) throws  SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Session ID to delete: ");
        int id = scanner.nextInt();

        try {
            sessionsDAO.deleteSession(id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
