import java.sql.*;
import java.util.ArrayList;

public class TicketDAO {
    public void addTicket(int session_id, int seat_id, double price, boolean is_sold) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "INSERT INTO Tickets (session_id, seat_id, price, is_sold) VALUES (?,?,?,?)";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, session_id);
            statement.setInt(2, seat_id);
            statement.setDouble(3, price);
            statement.setBoolean(4, is_sold);

            int result = statement.executeUpdate();
            System.out.println("Ticket added. Affected rows: "+result);
        } catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }

    public void selectTicket() throws SQLException{
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM Tickets";

        try (Connection connection = helper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ){
            ArrayList<Tickets> tickets = new ArrayList<>();
            while (resultSet.next()){
                tickets.add(new Tickets(resultSet.getInt("id"),
                        resultSet.getInt("session_id"),
                        resultSet.getInt("seat_id"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("is_sold")
                ));
            }
            for (Tickets ticket:tickets){
                System.out.println(ticket);
            }
        } catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }

    public void updateTicket(int id, int seat_id) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "UPDATE Tickets SET seat_id = ? WHERE id = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.setInt(2,seat_id);
            int result = statement.executeUpdate();
            System.out.println("Update completed. Affected rows: " + result);


        } catch (SQLException exception){
            helper.showErrorMessage(exception);
        }

    }

    public void deleteTicket(int id) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "DELETE FROM Tickets WHERE id = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            int result = statement.executeUpdate();
            System.out.println("Delete completed. Affected rows: " + result);


        } catch (SQLException exception){
            helper.showErrorMessage(exception);
        }

    }
}
