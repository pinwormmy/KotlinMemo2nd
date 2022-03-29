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
        
        System.out.println("========여행 관리 프로그램========");
        
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
        System.out.printf("%s님\n", MainController.memberDTO.getUserNickname());   
        int selectMenu = Util.scanInt("관리자 로그인: 1.항공권 2.렌터카 3.호텔 7.여행사 8.로그아웃 9.종료");
        
        switch(selectMenu) {
        case 1:
            AirlineController.manageAirTicket();
            break;    
        case 2:
            // RentCarController.manageRentCar();
            break;
        case 3:
            // RentCarController.manageHotel();
            break; 
        case 7:
            // RentCarController.manageHotel();
            break;      
        case 8:
            MainController.memberDTO = null;
            break;
        case 9:
            System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다~~~");
            System.exit(0);
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하시오");
        }        
    }
    
    public static void MenuForAgency() {
        
        System.out.println();
        System.out.printf("%s님\n", MainController.memberDTO.getUserNickname());        
        int selectMenu = Util.scanInt("여행사 로그인: 1.항공권 관리 2.렌터카 관리 3.호텔 관리 8.로그아웃 9.종료");
        
        switch(selectMenu) {
        case 1:
            AirlineController.manageAirTicket();
            break;    
        case 2:
            // RentCarController.manageRentCar();
            break;
        case 3:
            // RentCarController.manageHotel();
            break;          
        case 8:
            MainController.memberDTO = null;
            break;
        case 9:
            System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다~~~");
            System.exit(0);
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하시오");
        }        
    }
    
    public static void MenuForLoginTourist() {
        
        System.out.println();
        System.out.printf("%s님\n", MainController.memberDTO.getUserNickname());
        int selectMenu = Util.scanInt("관광객 로그인: 1.항공권 2.렌터카 3.호텔 7.여행사 신청 8.로그아웃 9.종료");
        
        switch(selectMenu) {        
        case 1:
            AirlineController.manageAirTicketForTourist();
            break;    
        case 2:
            // RentCarController.manageRentCar();
            break;
        case 3:
            // RentCarController.manageHotel();
            break;  
        case 7:
            // RentCarController.manageHotel();
            break;          
        case 8:
            MainController.memberDTO = null;
            break;
        case 9:
            System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다~~~");
            System.exit(0);
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하시오");
        }        
    }
        

    public static void MenuForGuest() {
        
        System.out.println("");
        int selectMenu = Util.scanInt("0.로그인 1.회원가입 9.프로그램 종료");
        
        System.out.println();
        switch(selectMenu) {
        case 0:
            MainController.memberDTO = MemberController.login();
            break;
        case 1:
            MemberController.signUp();
            break;
        case 9:
            System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다~~~");
            System.exit(0);
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
        }
    }
    
    
    

}
