import java.sql.SQLException;
import java.util.Scanner;

public class TicketSelectHandler {
    public static void selectTicketsBySoldStatus(TicketDAO ticketDAO) throws  SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to see sold tickets? (true/false): ");
        boolean isSold = scanner.nextBoolean();

        try {
            ticketDAO.selectTicketsBySoldStatus(isSold);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
