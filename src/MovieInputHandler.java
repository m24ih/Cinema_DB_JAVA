import java.util.Scanner;
import java.sql.*;

public class MovieInputHandler {
    public static void addMovieFromInput(MovieDAO movieDAO) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Movie Title: ");
        String title = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Duration (time): ");
        int duration = Integer.parseInt(scanner.nextLine());

        System.out.print("Director: ");
        String director = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        try {
            movieDAO.addMovie(title, genre, duration, director, description);
        } catch (Exception exception) {
            System.err.println("An error occurred while adding movie: " + exception.getMessage());
        }
    }
}
