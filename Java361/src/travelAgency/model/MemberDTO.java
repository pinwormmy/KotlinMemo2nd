package travelAgency.model;

public class MemberDTO {
    
    private int userNumber;
    private String userId = "";
    private String userPassword;
    private String userNickname;
    private int userLevel = -1;
    
    
    public int getUserNumber() {
        return userNumber;
    }
    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserNickname() {
        return userNickname;
    }
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    public int getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

}
