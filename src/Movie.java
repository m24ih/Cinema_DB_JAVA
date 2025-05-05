public class Movie {
    private int id;
    private String title;
    private String genre;
    private int duration;
    private String director;
    private String description;

    public Movie(int id, String title, String genre, int duration,String director, String description){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Movie Title: " + title + ", " +
                "Genre: " + genre + ", " +
                "Duration: " + duration + " mins, " +
                "Director: " + director + ","+
                "Description: " + description;
    }

}
