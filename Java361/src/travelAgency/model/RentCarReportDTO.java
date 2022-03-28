package travelAgency.model;

public class RentCarReportDTO {
    
    
    private int carRentalNumber;
    private int memberNumber;
    private int carNumber;
    private String startRentDate;
    private String endRentDate;
    
    
    public int getCarRentalNumber() {
        return carRentalNumber;
    }
    public void setCarRentalNumber(int carRentalNumber) {
        this.carRentalNumber = carRentalNumber;
    }
    public int getMemberNumber() {
        return memberNumber;
    }
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }
    public int getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }
    public String getStartRentDate() {
        return startRentDate;
    }
    public void setStartRentDate(String startRentDate) {
        this.startRentDate = startRentDate;
    }
    public String getEndRentDate() {
        return endRentDate;
    }
    public void setEndRentDate(String endRentDate) {
        this.endRentDate = endRentDate;
    }
}
