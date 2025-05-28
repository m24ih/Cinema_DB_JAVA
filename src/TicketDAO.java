import java.sql.*;

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

    public void selectTicket() throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM Tickets";

        try (Connection connection = helper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println("Ticket Id: " + resultSet.getInt("id"));
                System.out.println("Session Id: " + resultSet.getInt("session_id"));
                System.out.println("Seat Id: " + resultSet.getInt("seat_id"));
                System.out.println("Price: " + resultSet.getDouble("price"));
                System.out.println("Sold: " + resultSet.getBoolean("is_sold"));
                System.out.println("---------------------------");
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }


    public void selectTicketsBySoldStatus(boolean isSold) throws SQLException {
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM Tickets WHERE is_sold = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBoolean(1, isSold);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("Ticket ID: %d, Session ID: %d, Seat ID: %d, Price: %.2f, Sold: %b%n",
                        resultSet.getInt("id"),
                        resultSet.getInt("session_id"),
                        resultSet.getInt("seat_id"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("is_sold"));
            }
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
