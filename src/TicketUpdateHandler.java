import java.sql.SQLException;
import java.util.Scanner;

public class TicketUpdateHandler {
    public static void updateTicketSeatFromInput(TicketDAO ticketDAO) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Ticket ID to update: ");
        int id = scanner.nextInt();

        System.out.print("Enter new seat ID: ");
        int newSeatId = scanner.nextInt();

        try {
            ticketDAO.updateTicket(id, newSeatId);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
