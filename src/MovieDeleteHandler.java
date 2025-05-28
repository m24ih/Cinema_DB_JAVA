import java.sql.SQLException;
import java.util.Scanner;

public class MovieDeleteHandler {
    public static void deleteMovieFromInput(MovieDAO movieDAO) throws  SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Movie ID to delete: ");
        int id = scanner.nextInt();

        try {
            movieDAO.deleteMovie(id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
