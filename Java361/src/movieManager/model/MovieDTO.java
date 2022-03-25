package movieManager.model;

public class MovieDTO {
    
    private int movieNumber;
    private String movieTitle;
    private String storyLine;
    private int movieRating;
    
    
    public int getMovieNumber() {
        return movieNumber;
    }
    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }
    public String getMovieTitle() {
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    public String getStoryLine() {
        return storyLine;
    }
    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }
    public int getMovieRating() {
        return movieRating;
    }
    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
