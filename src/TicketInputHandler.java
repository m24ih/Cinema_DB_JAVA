import java.util.Scanner;
import java.sql.*;


public class TicketInputHandler {
    public static void addTicketFromInput(TicketDAO ticketDAO) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Session ID: ");
            int sessionId = Integer.parseInt(scanner.nextLine());

            System.out.print("Seat ID: ");
            int seatId = Integer.parseInt(scanner.nextLine());

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Is Sold (true/false): ");
            boolean isSold = Boolean.parseBoolean(scanner.nextLine());

            ticketDAO.addTicket(sessionId, seatId, price, isSold);
        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
