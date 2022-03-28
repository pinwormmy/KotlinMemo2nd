package travelAgency.model;

public class RoomReserveDTO {
    
    private int roomReserveNumber;
    private int roomNumber;
    private String startReserveDate;
    private String endReserveDate;
    
    
    public int getRoomReserveNumber() {
        return roomReserveNumber;
    }
    public void setRoomReserveNumber(int roomReserveNumber) {
        this.roomReserveNumber = roomReserveNumber;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getStartReserveDate() {
        return startReserveDate;
    }
    public void setStartReserveDate(String startReserveDate) {
        this.startReserveDate = startReserveDate;
    }
    public String getEndReserveDate() {
        return endReserveDate;
    }
    public void setEndReserveDate(String endReserveDate) {
        this.endReserveDate = endReserveDate;
    }
}
