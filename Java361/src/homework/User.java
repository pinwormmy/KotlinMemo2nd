package homework;

public class User {
    
    String userId;
    String userPwd;
    String userName;
    String address;
    String phone;
    
    
    char gender;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPw) {
        this.userPwd = userPw;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String adress) {
        this.address = adress;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    } 
    
    void User(){
        print();
    }
    
    void User(String userId, String userPwd){
        
        setUserId(userId);
        setUserPwd(userPwd);
        
        print();
    }

    void User(String userId, String userPwd, String userName, String address, String phone, char gender){
        
        setUserId(userId);
        setUserPwd(userPwd);
        setUserName(userName);
        setAddress(address);
        setPhone(phone);
        setGender(gender);
        
        print();
    }
    
    void print(){
        System.out.println("사용자 ID: " + getUserId());
        System.out.println("사용자 비밀번호: " + getUserPwd());
        System.out.println("사용자 이름: " + getUserName());
        System.out.println("사용자 주소: " + getAddress());
        System.out.println("사용자 연락처: " + getPhone());
        System.out.println("사용자 성별: " + getGender());
    }
}
