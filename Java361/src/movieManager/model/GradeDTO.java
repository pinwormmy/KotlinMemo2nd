package movieManager.model;

// 평점 

public class GradeDTO {

    private int gradeNumber;
    private int memberNumber;
    private int movieNumber;
    private int gradeScore;
    private String comment;
    
    
    public int getGradeNumber() {
        return gradeNumber;
    }
    public void setGradeNumber(int gradeNumber) {
        this.gradeNumber = gradeNumber;
    }
    public int getMemberNumber() {
        return memberNumber;
    }
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }
    public int getMovieNumber() {
        return movieNumber;
    }
    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }
    public int getGradeScore() {
        return gradeScore;
    }
    public void setGradeScore(int gradeScore) {
        this.gradeScore = gradeScore;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
