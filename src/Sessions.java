import java.sql.*;

public class Sessions {
    private int id;
    private int movie_id;
    private int salon_id;
    private Timestamp session_time;

    // Constructor
    public Sessions(int id, int movie_id, int salon_id, Timestamp session_time) {
        this.id = id;
        this.movie_id = movie_id;
        this.salon_id = salon_id;
        this.session_time = session_time;
    }
    @Override
    public String toString() {
        return "Session{id=" + id + ", " +
                "movieId=" + movie_id + ", " +
                "salonId=" + salon_id + ", " +
                "sessionTime=" + session_time + '}';
    }

}
