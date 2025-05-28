import java.sql.*;

public class Main {
    public static void main(String[] args) {

        MovieDAO movieDAO = new MovieDAO();
        SessionsDAO sessionsDAO = new SessionsDAO();
        TicketDAO ticketDAO = new TicketDAO();

        try {

            // For adding elements to database
            //MovieInputHandler.addMovieFromInput(movieDAO);
            //SessionInputHandler.addSessionFromInput(sessionsDAO);
            //TicketInputHandler.addTicketFromInput(ticketDAO);

            // For updating elements at the database
            //MovieUpdateHandler.updateMovieTitleFromInput(movieDAO);
            //SessionUpdateHandler.updateSessionTimeFromInput(sessionsDAO);
            //TicketUpdateHandler.updateTicketSeatFromInput(ticketDAO);

            // For deleting elements from the database
            //MovieDeleteHandler.deleteMovieFromInput(movieDAO);
            //SessionDeleteHandler.deleteSessionFromInput(sessionsDAO);
            //TicketDeleteHandler.deleteTicketFromInput(ticketDAO);

            // For printing database elements with specifications
            //MovieSelectHandler.selectMoviesByGenre(movieDAO);
            //SessionSelectHandler.selectSessionsByMovieId(sessionsDAO);
            //TicketSelectHandler.selectTicketsBySoldStatus(ticketDAO);

            // For printing all database elements
            movieDAO.selectMovie();
            ticketDAO.selectTicket();
            sessionsDAO.selectSession();


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
