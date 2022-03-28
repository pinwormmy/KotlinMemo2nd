package travelAgency.model;

public class RoomDTO {
    
    private int roomNumber;
    private int hotelNumber;
    private String roomLocation;
    private int roomPrice;
    
    
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public int getHotelNumber() {
        return hotelNumber;
    }
    public void setHotelNumber(int hotelNumber) {
        this.hotelNumber = hotelNumber;
    }
    public String getRoomLocation() {
        return roomLocation;
    }
    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }
    public int getRoomPrice() {
        return roomPrice;
    }
    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
}
