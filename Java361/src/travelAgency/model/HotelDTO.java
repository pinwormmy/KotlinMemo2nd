package travelAgency.model;

// 상영 정보

public class HotelDTO {

    private int hotelNumber;
    private String hotelName;
    private String hotelLocation;
    private int hotelGrade;
    private String hotelPhoneNumber;
    
    
    public int getHotelNumber() {
        return hotelNumber;
    }
    public void setHotelNumber(int hotelNumber) {
        this.hotelNumber = hotelNumber;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public String getHotelLocation() {
        return hotelLocation;
    }
    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }
    public int getHotelGrade() {
        return hotelGrade;
    }
    public void setHotelGrade(int hotelGrade) {
        this.hotelGrade = hotelGrade;
    }
    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }
    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }
}
