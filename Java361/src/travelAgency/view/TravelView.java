package travelAgency.view;

import java.util.List;

import travelAgency.controller.MainController;
import travelAgency.controller.RoomController;
import travelAgency.model.AirTicketDTO;
import travelAgency.model.AirTicketReserveDTO;
import travelAgency.model.HotelDTO;
import travelAgency.model.RentCarDTO;
import travelAgency.model.RentCarReportDTO;
import travelAgency.model.RoomDTO;
import travelAgency.model.RoomReserveDTO;
import travelAgency.model.TravelModel;
import travelAgency.model.Util;

public class TravelView {

    public static String dbar =      "======================================";
    
    
    public static String mainTitle = "========== Travel Helper =============";
    public static String subTitle =  "=================여행 관리 프로그램===";
    
    public static String user = "%s님\n";
    public static String adminLogin = "관리자 로그인: 1.항공권 2.렌터카 3.호텔 7.여행사 8.로그아웃 9.종료";
    public static String agencyLogin = "여행사 로그인: 1.항공권 관리 2.렌터카 관리 3.호텔 관리 8.로그아웃 9.종료";
    public static String touristLogin = "관광객 로그인: 1.항공권 2.렌터카 3.호텔 7.여행사 신청 8.로그아웃 9.종료";
    public static String guestLogin = "0.로그인 1.회원가입 9.프로그램 종료";
    
    public static String exit = "프로그램을 종료합니다. 이용해주셔서 감사합니다~~~";    
    public static String checkInputNotice = "입력 오류. 해당 메뉴에 맞게 입력해주세요~";
    
    public static String memberTitle = "===============회원가입===============";
    public static String pressId = "ID를 입력하세요";
    public static String alreadyId = "이미 있는 ID입니다. 다른 걸로 하세요";
    public static String availableId = "사용 가능한 ID입니다. ㄱㄱㄱ";
    public static String checkPw = "비밀번호 입력하시오";
    public static String checkPw2 = "확인차 같은 비밀번호 다시 입력하시오";
    public static String errorPw = "비밀번호 입력 오류!!!";
    public static String pressNick = "닉네임 입력하시오";
    
    public static String agencyNotice = "여행객 계정으로 등록됩니다~~~";
    
    public static String welcome = "========가입 완료. 환영합니다~========";
    public static String loginOk = "========로그인 성공. 환영합니다=======";
    
    public static String checkNoId = "존재하지 않는 ID입니다. 확인 바랍니다.";
    public static String noticeUpgradeId = "해당 계정을 여행사 계정으로 변경 요청합니다.(요청시, 해당 계정으로 신청한 예약이 모두 취소됩니다.)";
    public static String yesOrNo = "진행하겠습니까?(y/n)";
    public static String cancle = "진행을 취소합니다.";
    public static String errorYN = "입력 오류. y나 n 중 입력해주세요...";
    
    public static String agencyRequestList = "여행사 계정 신청 목록";
    public static String agencyRequestToolBar = "|회원번호|   ID   |   닉네임   |";
    
    public static String noList = "목록이 없습니다.";
    
    public static String pressUpMember = "여행사 계정 승인할 회원번호 입력(0.뒤로가기)";
    public static String noticeUpMember = "%s 님은 여행사 계정으로 변경되었습니다.\n";    
    
    public static void showAirTicketList(List<AirTicketDTO> airTicketList) {
        
        System.out.println("========항공권 목록 =========");
        System.out.println("번호| 좌석 | 출발지 | 도착지 | 출발시간 | 도착시간 |");
             
        int index = 0;
        for(AirTicketDTO airTicket : airTicketList) {
            if(TravelModel.checkReserve(airTicket) == false) {
                System.out.printf("%3d | %s | %s | %s | %s | %s |\n", airTicket.getAirTicketNumber(), airTicket.getSeat(), 
                        airTicket.getStartPoint(), airTicket.getDestination(), airTicket.getStartTime(), airTicket.getArrivalTime());
                index++;
            }                
        }
        if(index == 0)
            System.out.println("예약가능한 항공권이 없습니다.");    
        
        System.out.println("================================");        
    }
    
    protected static void showAirReserveList(List<AirTicketReserveDTO> airReserveList) {
        
        System.out.println("========예약된 항공권 목록 =========");
        System.out.println("번호| 항공권번호 | 예약자 | 예약일 |");
        
        int index = 0;
        for(AirTicketReserveDTO airReserve : airReserveList) {            
                System.out.printf("%3d |    %d | %s | %s |\n", airReserve.getAirReserveNum(), airReserve.getAirTicketNumber(), 
                        TravelModel.translateMemberNumToNickname(airReserve.getMemberNumber()), airReserve.getRevserDate()); 
                index++;
        }
        if(index == 0)
            System.out.println("예약한 항공권이 없습니다.");   
        System.out.println("=================================");
    }
    
    protected static void showAirReserveListForTourist(List<AirTicketReserveDTO> airReserveList) {
        
        System.out.println("========예약된 항공권 목록 =========");
        System.out.println("번호| 항공권번호 | 예약자 | 예약일 |");
        
        int index = 0;
        for(AirTicketReserveDTO airReserve : airReserveList) {    
                if(airReserve.getMemberNumber() == MainController.memberDTO.getUserNumber()) {
                    System.out.printf("%3d |    %d | %s | %s |\n", airReserve.getAirReserveNum(), airReserve.getAirTicketNumber(), 
                            TravelModel.translateMemberNumToNickname(airReserve.getMemberNumber()), airReserve.getRevserDate()); 
                    index++;
                }                
        }
        if(index == 0)
            System.out.println("예약한 항공권이 없습니다.");   
        System.out.println("=================================");
    }
    
    public static void showRentCarList(List<RentCarDTO> rentCarList) {
        
        System.out.println("========렌트카 목록 =========");
        System.out.println("|관리번호|차번호판|     차종     | 색상 |");
             
        int index = 0;
        for(RentCarDTO rentCar : rentCarList) {
            if(TravelModel.checkReserve(rentCar) == false) {
                System.out.printf("    %3d | %s | %s | %s |\n", rentCar.getCarNumber(), rentCar.getCarRegNumber(), 
                        rentCar.getCarType(), rentCar.getCarColor());
                index++;
            }                
        }
        if(index == 0)
            System.out.println("대여 가능한 렌트카가 없습니다.");    
        
        System.out.println("================================");        
    }
    
    protected static void showCarReportList(List<RentCarReportDTO> carReportList) {
        
        System.out.println("========대여된 렌트카 목록 =========");
        System.out.println("대여번호|차번호| 임차인 | 시작일 | 종료일 |");
        
        int index = 0;
        for(RentCarReportDTO carReport : carReportList) {            
                System.out.printf("%3d |    %s |    %s |     %s  |    $s  \n", carReport.getCarRentalNumber(), carReport.getCarNumber(), 
                        TravelModel.translateMemberNumToNickname(carReport.getMemberNumber()), carReport.getStartRentDate(), carReport.getEndRentDate()); 
                index++;
        }
        if(index == 0)
            System.out.println("대여한 렌트카가 없습니다.");   
        System.out.println("=================================");
    }
    
    public static void showHotelList(List<HotelDTO> hotelList) {
        
        System.out.println("========호텔 목록 =========");
        System.out.println("|번호|     이름     |         주소         | 등급 |    연락처     |");
             
        for(HotelDTO hotel : hotelList) {
            System.out.printf(" %3d |     %s |      %s      | %d성급 |    %s   \n", hotel.getHotelNumber(), hotel.getHotelName(), 
                    hotel.getHotelLocation(), hotel.getHotelGrade(), hotel.getHotelPhoneNumber());
        }
        System.out.println("================================");        
    }
    
    protected static void showRoomReserveInfo(RoomDTO room) {
        
        if(TravelModel.checkReserve(room) == true) {
            
            RoomReserveDTO roomReserve = new RoomReserveDTO();
            roomReserve = TravelModel.checkReserve(room, MainController.roomReserveList);
            
            System.out.println("========객실 예약 조회======");
            System.out.printf("예약번호 : %d\n", roomReserve.getRoomReserveNumber());
            System.out.printf("고객명 : %s\n", TravelModel.translateMemberNumToNickname(roomReserve.getMemberNumber()));
            System.out.printf("객실번호 : %s\n", roomReserve.getRoomNumber());
            System.out.printf("체크인 : %s\n", roomReserve.getStartReserveDate());        
            System.out.printf("체크아웃 : %s\n", roomReserve.getEndReserveDate());        
        }else {
            System.out.println("아직 객실 예약이 없습니다.");
        }   
    }
    
    protected static void showRoomInfo(RoomDTO room) {
        
        while(true) {
            
            System.out.println("========객실 정보 조회======");
            System.out.printf("객실번호 : %d\n", room.getRoomNumber());
            System.out.printf("호텔번호 : %s\n", room.getHotelNumber());
            System.out.printf("객실호수 : %s\n", room.getRoomLocation());
            System.out.printf("가격 : %d\n", room.getRoomPrice());
                                          
            int selectMenu = Util.scanInt("1.객실정보 수정 2.객실정보 삭제 3.객실 예약 0.뒤로가기");
            
            if(selectMenu == 1) {
                RoomController.modifyRoom(room);                
            }else if(selectMenu == 2){
                RoomController.deleteRoom(room);
                break;
            }else if(selectMenu == 3){
                RoomController.manageRoomReserve(room);
                break;
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
        
    }
}
