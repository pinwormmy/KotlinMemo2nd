package travelAgency;

import travelAgency.controller.MainController;

// 여행사 프로그램

public class TravelHelper {
    
    public static void main(String[] args) {
        
        
        System.out.println("========== Travel Helper =============");
        System.out.println("===================여행예약 프로그램==");
        
        MainController mainController = new MainController();
        
        mainController.run();
        
    }

}
