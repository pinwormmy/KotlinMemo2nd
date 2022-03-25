package movieManager.model;

// 상영 정보

public class ScreenDTO {

    private int screenNumber;
    private int movieNumber;
    private int theaterNumber;
    private String screenTime;
    
    
    public int getScreenNumber() {
        return screenNumber;
    }
    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }
    public int getMovieNumber() {
        return movieNumber;
    }
    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }
    public int getTheaterNumber() {
        return theaterNumber;
    }
    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }
    public String getScreenTime() {
        return screenTime;
    }
    public void setScreenTime(String screenTime) {
        this.screenTime = screenTime;
    }
    
}
