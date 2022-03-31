package travelAgency;

import travelAgency.controller.MainController;

// 여행 관리 프로그램 Travel Helper!!

// 관리자 계정
// ID : administrator
// PW : 1111

public class TravelHelper {
    
    public static void main(String[] args) {    
        
        MainController mainController = new MainController();
        
        mainController.run();
        
    }

}
