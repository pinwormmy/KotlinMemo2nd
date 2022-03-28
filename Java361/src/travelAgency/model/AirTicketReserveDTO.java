package travelAgency.model;

public class AirTicketReserveDTO {
    
    private int airReserveNum;
    private int airTicketNumber;
    private int memberNumber;
    private String revserDate;
    
    
    public int getAirReserveNum() {
        return airReserveNum;
    }
    public void setAirReserveNum(int airReserveNum) {
        this.airReserveNum = airReserveNum;
    }
    public int getAirTicketNumber() {
        return airTicketNumber;
    }
    public void setAirTicketNumber(int airTicketNumber) {
        this.airTicketNumber = airTicketNumber;
    }
    public int getMemberNumber() {
        return memberNumber;
    }
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }
    public String getRevserDate() {
        return revserDate;
    }
    public void setRevserDate(String revserDate) {
        this.revserDate = revserDate;
    }
       
}
