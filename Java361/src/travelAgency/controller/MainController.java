package travelAgency.controller;

import java.util.ArrayList;
import java.util.List;
import travelAgency.model.AirTicketDTO;
import travelAgency.model.AirTicketReserveDTO;
import travelAgency.model.HotelDTO;
import travelAgency.model.MemberDTO;
import travelAgency.model.RentCarDTO;
import travelAgency.model.RentCarReportDTO;
import travelAgency.model.RoomDTO;
import travelAgency.model.RoomReserveDTO;
import travelAgency.model.TravelModel;
import travelAgency.model.Util;
import travelAgency.view.TravelView;


public class MainController {
    
    public static List<MemberDTO> memberList = new ArrayList<>(); // DB역할
    public static List<AirTicketDTO> airTicketList = new ArrayList<>(); 
    public static List<AirTicketReserveDTO> airReserveList = new ArrayList<>(); 
    public static List<RentCarDTO> rentCarList = new ArrayList<>(); 
    public static List<RentCarReportDTO> rentCarReportList = new ArrayList<>(); 
    public static List<HotelDTO> hotelList = new ArrayList<>(); 
    public static List<RoomDTO> roomList = new ArrayList<>(); 
    public static List<RoomReserveDTO> roomReserveList = new ArrayList<>(); 
    
    public static MemberDTO memberDTO;
    public static AirTicketDTO airTicketDTO;
    public static AirTicketReserveDTO airTicketReserveDTO;
    public static RentCarDTO rentCarDTO;
    public static RentCarReportDTO rentCarReportDTO;
    public static HotelDTO hotelDTO;
    public static RoomDTO roomDTO;
    public static RoomReserveDTO roomReserveDTO;
    
    public static int userNumberSet = 0;
    public static int airTicketNumberSet = 1;
    public static int airReserveNumberSet = 1;
    public static int rentCarNumberSet = 1;
    public static int rentCarReportNumberSet = 1;
    public static int hotelNumberSet = 1;
    public static int roomNumberSet = 1;
    public static int roomReserveNumberSet = 1;
    
    public void run() {
        
        TravelModel.setAdministrator(); // 관리자 계정 자동생성. ID : administrator PW: 1111
        
        System.out.println(TravelView.mainTitle);        
        System.out.println(TravelView.subTitle);
        
        while(true) {          
                        
            if(memberDTO == null) {
                MenuForGuest();
            }
            else if(memberDTO.getUserLevel() == 1){
                MenuForAgency();
            }
            else if(memberDTO.getUserLevel() == 0){
                MenuForLoginTourist();
            }
            else {
                MenuForAdmin();
            }
        }
    }
    
    public static void MenuForAdmin() {
        
        System.out.println();
        System.out.printf(TravelView.user, MainController.memberDTO.getUserNickname());   
        int selectMenu = Util.scanInt(TravelView.adminLogin);
        
        switch(selectMenu) {
        case 1:
            AirlineController.manageAirTicket();
            break;    
        case 2:
            RentCarController.manageRentCar();
            break;
        case 3:
            HotelController.manageHotel();
            break; 
        case 7:
            MemberController.upgradeToAgency();
            break;      
        case 8:
            MainController.memberDTO = null;
            break;
        case 9:
            System.out.println(TravelView.exit);
            System.exit(0);
        default:
            System.out.println(TravelView.checkInputNotice);
        }        
    }
    
    public static void MenuForAgency() {
        
        System.out.println();
        System.out.printf(TravelView.user, MainController.memberDTO.getUserNickname());        
        int selectMenu = Util.scanInt(TravelView.agencyLogin);
        
        switch(selectMenu) {
        case 1:
            AirlineController.manageAirTicket();
            break;    
        case 2:
            RentCarController.manageRentCar();
            break;
        case 3:
            HotelController.manageHotel();
            break;          
        case 8:
            MainController.memberDTO = null;
            break;
        case 9:
            System.out.println(TravelView.exit);
            System.exit(0);
        default:
            System.out.println(TravelView.checkInputNotice);
        }        
    }
    
    public static void MenuForLoginTourist() {
        
        System.out.println();
        System.out.printf(TravelView.user, MainController.memberDTO.getUserNickname());
        int selectMenu = Util.scanInt(TravelView.touristLogin);
        
        switch(selectMenu) {        
        case 1:
            AirlineController.manageAirTicketForTourist();
            break;    
        case 2:
            RentCarController.manageRentCarForTourist();
            break;
        case 3:
            HotelController.manageHotelForTourist();
            break;  
        case 7:
            MemberController.upgradeRequest();
            break;          
        case 8:
            MainController.memberDTO = null;
            break;
        case 9:
            System.out.println(TravelView.exit);
            System.exit(0);
        default:
            System.out.println(TravelView.checkInputNotice);
        }        
    }
        

    public static void MenuForGuest() {
        
        System.out.println("");
        int selectMenu = Util.scanInt(TravelView.guestLogin);
        
        System.out.println();
        switch(selectMenu) {
        case 0:
            MainController.memberDTO = MemberController.login();
            break;
        case 1:
            MemberController.signUp();
            break;
        case 9:
            System.out.println(TravelView.exit);
            System.exit(0);
        default:
            System.out.println(TravelView.checkInputNotice);
        }
    }
    
    
    

}
