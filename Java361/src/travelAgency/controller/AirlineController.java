package travelAgency.controller;

import java.util.List;

import travelAgency.model.Util;
import travelAgency.model.AirTicketDTO;
import travelAgency.model.AirTicketReserveDTO;
import travelAgency.model.TravelModel;

public class AirlineController {
        
    public static void manageAirTicket() {
        
        while(true) { 
            
            System.out.println("");
            System.out.println("====[관리자 모드] 항공권 관리====");
            
            showAirTicketList(MainController.airTicketList);
            
            int selectMenu = Util.scanInt("1.항공권 조회 2.항공권 등록 3.예약자 조회 9.메인으로");
            
            switch(selectMenu) {
            case 1:
                selectAirTicketInfo(MainController.airTicketList);
                break;
            case 2:
                addAirTicket();
                break;   
            case 3:
                manageAirReserve();
                break; 
            case 9:
                System.out.println("메인 화면으로 이동합니다.");
                break;
            default:
                System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
            }
            if(selectMenu == 9)
                break;
        }
    }
    
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
    
    static void selectAirTicketInfo(List<AirTicketDTO> airTicketList) {
        
        while(true) {
            
            int selectAirTicketNumber = Util.scanInt("조회할 항공권 티켓 번호 입력(0.뒤로가기)");
            
            if(selectAirTicketNumber == 0)
                break;
            
            if(MainController.airTicketNumberSet == 1) {
                System.out.println("등록된 항공권이 없습니다. 티켓을 등록해주세요~");
                break;
            }else {
                
                for(AirTicketDTO airTicket : airTicketList) {
                    if(airTicket.getAirTicketNumber() == selectAirTicketNumber && TravelModel.checkReserve(airTicket) == false){
                        
                        if(MainController.memberDTO.getUserLevel() == 2 || MainController.memberDTO.getUserLevel() == 1){
                            showAirTicketInfo(airTicket);
                            break;
                        }else if(MainController.memberDTO.getUserLevel() == 0) {
                            showAirTicketInfoForTourist(airTicket);
                            break;
                        }
                    }                    
                    System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                }
            }
        }
    }
    
    public static void showAirTicketInfo(AirTicketDTO airTicket) {
        
        while(true) {
            
            System.out.println("========항공권 정보 조회======");
            System.out.printf("번호 : %d\n", airTicket.getAirTicketNumber());
            System.out.printf("좌석 : %s\n", airTicket.getSeat());
            System.out.printf("출발지 : %s\n", airTicket.getStartPoint());
            System.out.printf("도착지 : %s\n", airTicket.getDestination());
            System.out.printf("출발시간 : %s\n", airTicket.getStartTime());
            System.out.printf("도착시간 : %s\n", airTicket.getArrivalTime());            
            
            if(TravelModel.checkReserve(airTicket) == true) {
                
                System.out.println("예약 처리된 항공권입니다.");
                
                AirTicketReserveDTO airReserve = TravelModel.checkReserve(airTicket, MainController.airReserveList);
                
                System.out.printf("예약번호 : %d 예약자: %s 예약일: %s \n", airReserve.getAirReserveNum(), 
                        TravelModel.translateMemberNumToNickname(airReserve.getMemberNumber()), airReserve.getRevserDate());
                
                int selectMenu = Util.scanInt("1.예약 취소 0.뒤로가기");                
                if(selectMenu == 1) {
                    cancleAirReserve(airReserve);
                }else if(selectMenu == 0){
                    break;
                }else {
                    System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
                }
                
            }else {
                int selectMenu = Util.scanInt("1.항공권 수정 2.항공권 삭제 3.고객 예약 0.뒤로가기");
                
                if(selectMenu == 1) {
                    AirlineController.modifyAirTicket(airTicket);                
                }else if(selectMenu == 2){
                    AirlineController.deleteAirTicket(airTicket);
                    break;
                }else if(selectMenu == 3){
                    reserveAir(airTicket);
                    break;
                }else if(selectMenu == 0){
                    break;
                }else {
                    System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
                }
            }
        }
    }    
    
    
    private static void addAirTicket() {
        
        AirTicketDTO airTicket = new AirTicketDTO();        
        
        System.out.println("항공권 신규 등록======");
        
        airTicket.setAirTicketNumber(MainController.airTicketNumberSet++);
        airTicket.setSeat(Util.scanString("좌석 번호"));
        airTicket.setStartPoint(Util.scanString("출발지"));
        airTicket.setDestination(Util.scanString("도착지"));
        airTicket.setStartTime(Util.scanString("출발 시간(입력형식: 1/23 12:34)"));
        airTicket.setArrivalTime(Util.scanString("도착 시간(입력형식: 1/23 12:34)"));   
        
        MainController.airTicketList.add(airTicket);
        
        System.out.println("새로운 항공권 티켓 정보가 등록되었습니다.==========");
    }
    
    public static void modifyAirTicket(AirTicketDTO airTicket) {        
        
        System.out.println("항공권 정보 수정======");                
        airTicket.setSeat(Util.scanString("좌석 (" + airTicket.getSeat() + ")"));
        airTicket.setStartPoint(Util.scanString("출발지 (" + airTicket.getStartPoint() + ")"));
        airTicket.setDestination(Util.scanString("도착지 (" + airTicket.getDestination() + ")"));
        airTicket.setStartTime(Util.scanString("출발 시간 (" + airTicket.getStartTime() + ")"));
        airTicket.setArrivalTime(Util.scanString("도착 시간 (" + airTicket.getArrivalTime() + ")"));       
        
        System.out.println("항공권 정보가 수정되었습니다.==========");
    }        
    
    public static void deleteAirTicket(AirTicketDTO airTicket) {
        
        while(true) {
            String question = Util.scanString("정말 해당 항공편을 삭제하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.airTicketList.remove(airTicket);
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println("삭제를 취소합니다.");
                break;
            }else
                System.out.println("입력 오류. y나 n 중 입력해주세요...");
        }
    }
    
    public static void manageAirReserve() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====[관리자 모드] 항공권 예약 관리====");
            
            showAirReserveList(MainController.airReserveList);
            
            int selectMenu = Util.scanInt("1.예약 조회 9.뒤로가기");
            
            switch(selectMenu) {
            case 1:
                selectAirReserveInfo(MainController.airReserveList);
                break;
            case 9:
                System.out.println("메인 화면으로 이동합니다.");
                break;
            default:
                System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
            }
            if(selectMenu == 9)
                break;
        }
    }
    
    private static void showAirReserveList(List<AirTicketReserveDTO> airReserveList) {
        
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
    
    private static void selectAirReserveInfo(List<AirTicketReserveDTO> airReserveList) {
        
        while(true) {
            
            int selectAirReserveNumber = Util.scanInt("조회할 항공권 예약 번호 입력(0.뒤로가기)");
            
            if(selectAirReserveNumber == 0)
                break;
            
            if(MainController.airReserveNumberSet == 1) {
                System.out.println("등록된 항공권 예약이 없습니다.");
                break;
            }else {
                
                for(AirTicketReserveDTO airReserve : airReserveList) {
                    if(airReserve.getAirTicketNumber() == selectAirReserveNumber){
                        
                        if(MainController.memberDTO.getUserLevel() == 2 || MainController.memberDTO.getUserLevel() == 1){
                            showAirTicketInfo(TravelModel.translateReserveNumToAirTicket(airReserve.getAirTicketNumber()));
                            break;
                        }else if(MainController.memberDTO.getUserLevel() == 0) {
                            showAirTicketInfoForTourist(TravelModel.translateReserveNumToAirTicket(airReserve.getAirTicketNumber()));
                            break;
                        }
                    }                    
                    System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                }
            }
        }
        
    }
    
    private static void reserveAir(AirTicketDTO airTicket) {
        
        AirTicketReserveDTO airTicketReserve = new AirTicketReserveDTO();        
        
        System.out.println("[관리자 모드]항공권 예약하기======");        
        while(true) {
            int memberNumber = Util.scanInt("예약할 회원번호 입력하시오(0.뒤로가기)");
            
            if(memberNumber == 0){
                break;
            }else if(memberNumber != 0 && TravelModel.checkMember(memberNumber) == true) {
                airTicketReserve.setMemberNumber(memberNumber);
                airTicketReserve.setAirReserveNum(MainController.airReserveNumberSet++);
                airTicketReserve.setAirTicketNumber(airTicket.getAirTicketNumber());
                airTicketReserve.setRevserDate(Util.scanString("오늘 날자를 적어주세요"));        
                
                MainController.airReserveList.add(airTicketReserve);
                
                System.out.println("항공권 예약완료==========");
                break;
            }else {
                System.out.println("없는 번호입니다. 입력 다시 확인해주세요.");
            }
        }
    }
    
    private static void cancleAirReserve(AirTicketReserveDTO airTicketReserve) {
        
        while(true) {
            String question = Util.scanString("정말 해당 항공편 예약을 취소하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.airReserveList.remove(airTicketReserve);
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println("삭제를 취소합니다.");
                break;
            }else
                System.out.println("입력 오류. y나 n 중 입력해주세요...");
        }
        
    }
    
    //////////////////////////////////////////////////
    
    public static void manageAirTicketForTourist() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====관광객 항공권 예약 관리====");
            
            showAirTicketList(MainController.airTicketList);
            showAirReserveListForTourist(MainController.airReserveList);
            
            int selectMenu = Util.scanInt("1.항공권 조회 2.예약 조회 9.뒤로가기");
            
            switch(selectMenu) {
            case 1:
                selectAirTicketInfo(MainController.airTicketList);
                break;
            case 2:                
                selectAirReserveInfo(MainController.airReserveList);
                break; 
            case 9:
                System.out.println("메인 화면으로 이동합니다.");
                break;
            default:
                System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
            }
            if(selectMenu == 9)
                break;
        }
    }
    
    public static void showAirTicketInfoForTourist(AirTicketDTO airTicket) {
        
        while(true) {
            
            System.out.println("========항공권 정보 조회======");
            System.out.printf("번호 : %d\n", airTicket.getAirTicketNumber());
            System.out.printf("좌석 : %s\n", airTicket.getSeat());
            System.out.printf("출발지 : %s\n", airTicket.getStartPoint());
            System.out.printf("도착지 : %s\n", airTicket.getDestination());
            System.out.printf("출발시간 : %s\n", airTicket.getStartTime());
            System.out.printf("도착시간 : %s\n", airTicket.getArrivalTime());            
            
            if(TravelModel.checkReserve(airTicket) == false) {
                System.out.println("해당 항공권 예약 가능합니다.");
                System.out.print("1.예약하기 ");
            }                
            else {
                System.out.println("예약중인 항공권입니다.");
                System.out.print("2.취소하기 ");
            }        
            
            int selectMenu = Util.scanInt("0.뒤로가기");
            
            if(selectMenu == 1 && TravelModel.checkReserve(airTicket) == false) {
                reserveAirForTourist(airTicket);            
            }else if(selectMenu == 2 && TravelModel.checkReserve(airTicket) == true){
                cancleAirReserve(TravelModel.checkReserve(airTicket, MainController.airReserveList));         
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }        
    }
            
    static void showAirReserveListForTourist(List<AirTicketReserveDTO> airReserveList) {
        
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
    
    private static void reserveAirForTourist(AirTicketDTO airTicket) {
        
        AirTicketReserveDTO airTicketReserve = new AirTicketReserveDTO();        
        
        System.out.println("항공권 예약하기======");
        
        airTicketReserve.setAirReserveNum(MainController.airReserveNumberSet++);
        airTicketReserve.setAirTicketNumber(airTicket.getAirTicketNumber());
        airTicketReserve.setMemberNumber(MainController.memberDTO.getUserNumber());
        airTicketReserve.setRevserDate(Util.scanString("오늘 날자를 적어주세요"));        
        
        MainController.airReserveList.add(airTicketReserve);
        
        System.out.println("항공권 예약완료==========");
    }
    
}
