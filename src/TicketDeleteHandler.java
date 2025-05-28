import java.sql.SQLException;
import java.util.Scanner;

public class TicketDeleteHandler {
    public static void deleteTicketFromInput(TicketDAO ticketDAO) throws  SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Ticket ID to delete: ");
        int id = scanner.nextInt();

        try {
            ticketDAO.deleteTicket(id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
