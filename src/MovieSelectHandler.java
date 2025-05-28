import java.sql.SQLException;
import java.util.Scanner;

public class MovieSelectHandler {
    public static void selectMoviesByGenre(MovieDAO movieDAO) throws  SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter genre to filter: ");
        String genre = scanner.nextLine();

        try {
            movieDAO.selectMoviesByGenre(genre);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
