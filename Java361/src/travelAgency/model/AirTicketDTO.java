package travelAgency.model;

public class AirTicketDTO {
    
    private int airTicketNumber;
    private String startPoint;
    private String startTime;
    private String destination;
    private String arrivalTime;
    private String seat;
    
    
    public int getAirTicketNumber() {
        return airTicketNumber;
    }
    public void setAirTicketNumber(int airTicketNumber) {
        this.airTicketNumber = airTicketNumber;
    }
    public String getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }  
    
}
