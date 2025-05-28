import java.sql.SQLException;
import java.util.Scanner;

public class MovieUpdateHandler {
    public static void updateMovieTitleFromInput(MovieDAO movieDAO) throws SQLException{
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Movie ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new movie title: ");
        String newTitle = scanner.nextLine();

        try {
            movieDAO.updateMovie(id, newTitle);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
