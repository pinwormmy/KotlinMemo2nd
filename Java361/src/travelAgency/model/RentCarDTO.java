package travelAgency.model;

public class RentCarDTO {
    
    private int carNumber;
    private int carRegNumber;
    private String carType;
    private String carColor;
    
    
    public int getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }
    public int getCarRegNumber() {
        return carRegNumber;
    }
    public void setCarRegNumber(int carRegNumber) {
        this.carRegNumber = carRegNumber;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
   
}
