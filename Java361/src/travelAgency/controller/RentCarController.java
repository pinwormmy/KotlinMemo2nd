package travelAgency.controller;

import java.util.List;
import travelAgency.model.RentCarDTO;
import travelAgency.model.RentCarReportDTO;
import travelAgency.model.TravelModel;
import travelAgency.model.Util;

public class RentCarController {
    
    public static void manageRentCar() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====[관리자 모드] 렌트카 관리====");
            
            showRentCarList(MainController.rentCarList);
            
            int selectMenu = Util.scanInt("1.렌트카 조회 2.렌트카 등록 3.임차인 조회 9.메인으로");
            
            switch(selectMenu) {
            case 1:
                selectRentCarInfo(MainController.rentCarList);
                break;
            case 2:
                addRentCar();
                break;   
            case 3:
                manageCarReport();
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
    
    public static void showRentCarList(List<RentCarDTO> rentCarList) {
        
        System.out.println("========렌트카 목록 =========");
        System.out.println("번호| 좌석 | 출발지 | 도착지 | 출발시간 | 도착시간 |");
             
        int index = 0;
        for(RentCarDTO rentCar : rentCarList) {
            if(TravelModel.checkReserve(rentCar) == false) {
                System.out.printf("%3d | %s | %s | %s | %s | %s |\n", rentCar.getAirTicketNumber(), rentCar.getSeat(), 
                        rentCar.getStartPoint(), rentCar.getDestination(), rentCar.getStartTime(), rentCar.getArrivalTime());
                index++;
            }                
        }
        if(index == 0)
            System.out.println("예약가능한 렌트카가 없습니다.");    
        
        System.out.println("================================");        
    }
    
    static void selectRentCarInfo(List<RentCarDTO> rentCarList) {
        
        while(true) {
            
            int selectRentCarNumber = Util.scanInt("조회할 렌트카 번호 입력(0.뒤로가기)");
            
            if(selectRentCarNumber == 0)
                break;
            
            if(MainController.rentCarNumberSet == 1) {
                System.out.println("등록된 렌트카가 없습니다. 등록해주세요~");
                break;
            }else {
                
                for(RentCarDTO rentCar : rentCarList) {
                    if(rentCar.getRentCartNumber() == selectAirTicketNumber && TravelModel.checkReserve(rentCar) == false){
                        
                        if(MainController.memberDTO.getUserLevel() == 2 || MainController.memberDTO.getUserLevel() == 1){
                            showRentCarInfo(rentCar);
                            break;
                        }else if(MainController.memberDTO.getUserLevel() == 0) {
                            showRentCarInfoForTourist(rentCar);
                            break;
                        }
                    }                    
                    System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                }
            }
        }
    }
    
    public static void showRentCarInfo(RentCarDTO rentCar) {
        
        while(true) {
            
            System.out.println("========렌트카 정보 조회======");
            System.out.printf("번호 : %d\n", rentCar.getAirTicketNumber());
            System.out.printf("좌석 : %s\n", rentCar.getSeat());
            System.out.printf("출발지 : %s\n", rentCar.getStartPoint());
            System.out.printf("도착지 : %s\n", rentCar.getDestination());
            System.out.printf("출발시간 : %s\n", rentCar.getStartTime());
            System.out.printf("도착시간 : %s\n", rentCar.getArrivalTime());            
            
            if(TravelModel.checkReserve(rentCar) == true) {
                
                System.out.println("예약 처리된 렌트카입니다.");
                
                RentCarReportDTO carReport = TravelModel.checkReserve(rentCar, MainController.rentCarReportList);
                
                System.out.printf("예약번호 : %d 예약자: %s 예약일: %s \n", carReport.getAirReserveNum(), 
                        TravelModel.translateMemberNumToNickname(carReport.getMemberNumber()), carReport.getRevserDate());
                
                int selectMenu = Util.scanInt("1.예약 취소 0.뒤로 가기");                
                if(selectMenu == 1) {
                    cancleCarReport(carReport);
                }else if(selectMenu == 0){
                    break;
                }else {
                    System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
                }
                
            }else {
                int selectMenu = Util.scanInt("1.렌트카 수정 2.렌트카 삭제 3.고객 예약 0.뒤로 가기");
                
                if(selectMenu == 1) {
                    RentCarController.modifyRentCar(rentCar);                
                }else if(selectMenu == 2){
                    RentCarController.deleteRentCar(rentCar);
                    break;
                }else if(selectMenu == 3){
                    reportCar(rentCar);
                    break;
                }else if(selectMenu == 0){
                    break;
                }else {
                    System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
                }
            }
        }
    }    
    
    
    private static void addRentCar() {
        
        RentCarDTO rentCar = new RentCarDTO();        
        
        System.out.println("렌트카 신규 등록======");
        
        rentCar.setAirTicketNumber(MainController.rentCarNumberSet++);
        rentCar.setSeat(Util.scanString("좌석 번호"));
        rentCar.setStartPoint(Util.scanString("출발지"));
        rentCar.setDestination(Util.scanString("도착지"));
        rentCar.setStartTime(Util.scanString("출발 시간(입력형식: 1/23 12:34)"));
        rentCar.setArrivalTime(Util.scanString("도착 시간(입력형식: 1/23 12:34)"));   
        
        MainController.rentCarList.add(rentCar);
        
        System.out.println("새로운 항공권 티켓 정보가 등록되었습니다.==========");
    }
    
    public static void modifyRentCar(RentCarDTO rentCar) {        
        
        System.out.println("렌트카 정보 수정======");                
        rentCar.setSeat(Util.scanString("좌석 (" + rentCar.getSeat() + ")"));
        rentCar.setStartPoint(Util.scanString("출발지 (" + rentCar.getStartPoint() + ")"));
        rentCar.setDestination(Util.scanString("도착지 (" + rentCar.getDestination() + ")"));
        rentCar.setStartTime(Util.scanString("출발 시간 (" + rentCar.getStartTime() + ")"));
        rentCar.setArrivalTime(Util.scanString("도착 시간 (" + rentCar.getArrivalTime() + ")"));       
        
        System.out.println("렌트카 정보가 수정되었습니다.==========");
    }        
    
    public static void deleteRentCar(RentCarDTO rentCar) {
        
        while(true) {
            String question = Util.scanString("정말 해당 렌트카를 삭제하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.rentCarList.remove(rentCar);
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
            System.out.println("====[관리자 모드] 렌트카 예약 관리====");
            
            showCarReportList(MainController.rentCarReportList);
            
            int selectMenu = Util.scanInt("1.예약 조회 9.메인으로");
            
            switch(selectMenu) {
            case 1:
                selectCarReportInfo(MainController.rentCarReportList);
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
    
    private static void showCarReportList(List<RentCarReportDTO> carReportList) {
        
        System.out.println("========예약된 렌트카 목록 =========");
        System.out.println("번호| 렌트카번호 | 예약자 | 예약일 |");
        
        int index = 0;
        for(RentCarReportDTO carReport : carReportList) {            
                System.out.printf("%3d |    %d | %s | %s |\n", carReport.getAirReserveNum(), carReport.getAirTicketNumber(), 
                        TravelModel.translateMemberNumToNickname(carReport.getMemberNumber()), carReport.getRevserDate()); 
                index++;
        }
        if(index == 0)
            System.out.println("예약한 렌트카가 없습니다.");   
        System.out.println("=================================");
    }
    
    private static void selectCarReportInfo(List<RentCarReportDTO> carReportList) {
        
        while(true) {
            
            int selectCarReportNumber = Util.scanInt("조회할 렌트카 예약 번호 입력(0.뒤로가기)");
            
            if(selectCarReportNumber == 0)
                break;
            
            if(MainController.rentCarReportNumberSet == 1) {
                System.out.println("등록된 렌트카 예약이 없습니다.");
                break;
            }else {
                
                for(RentCarReportDTO carReport : carReportList) {
                    if(carReport.getAirTicketNumber() == selectCarReportNumber){
                        
                        if(MainController.memberDTO.getUserLevel() == 2 || MainController.memberDTO.getUserLevel() == 1){
                            showRentCarInfo(TravelModel.translateReserveNumToAirTicket(carReport.getAirTicketNumber()));
                            break;
                        }else if(MainController.memberDTO.getUserLevel() == 0) {
                            showRentCarInfoForTourist(TravelModel.translateReserveNumToAirTicket(carReport.getAirTicketNumber()));
                            break;
                        }
                    }                    
                    System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                }
            }
        }
        
    }
    
    private static void reportCar(RentCarDTO rentCar) {
        
        RentCarReportDTO carReport = new RentCarReportDTO();        
        
        System.out.println("[관리자 모드]렌트카 예약하기======");        
        while(true) {
            int memberNumber = Util.scanInt("예약할 회원번호 입력하시오(0.뒤로가기)");
            
            if(memberNumber == 0){
                break;
            }else if(memberNumber != 0 && TravelModel.checkMember(memberNumber) == true) {
                carReport.setMemberNumber(memberNumber);
                carReport.setAirReserveNum(MainController.rentCarReportNumberSet++);
                carReport.setAirTicketNumber(rentCar.getAirTicketNumber());
                carReport.setRevserDate(Util.scanString("오늘 날자를 적어주세요"));        
                
                MainController.rentCarReportList.add(carReport);
                
                System.out.println("렌트카 예약완료==========");
                break;
            }else {
                System.out.println("없는 번호입니다. 입력 다시 확인해주세요.");
            }
        }
    }
    
    private static void cancleCarReport(RentCarReportDTO carReport) {
        
        while(true) {
            String question = Util.scanString("정말 해당 렌트카 예약을 취소하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.rentCarReportList.remove(carReport);
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
    
    public static void manageRentCarForTourist() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====관광객 렌트카 예약 관리====");
            
            showRentCarList(MainController.rentCarList);
            showCarReportListForTourist(MainController.rentCarReportList);
            
            int selectMenu = Util.scanInt("1.렌트카 조회 2.예약 조회 9.메인으로");
            
            switch(selectMenu) {
            case 1:
                selectRentCarInfo(MainController.rentCarList);
                break;
            case 2:                
                selectCarReportInfo(MainController.rentCarReportList);
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
    
    public static void showRentCarInfoForTourist(RentCarDTO rentCar) {
        
        while(true) {
            
            System.out.println("========렌트카 정보 조회======");
            System.out.printf("번호 : %d\n", rentCar.getAirTicketNumber());
            System.out.printf("좌석 : %s\n", rentCar.getSeat());
            System.out.printf("출발지 : %s\n", rentCar.getStartPoint());
            System.out.printf("도착지 : %s\n", rentCar.getDestination());
            System.out.printf("출발시간 : %s\n", rentCar.getStartTime());
            System.out.printf("도착시간 : %s\n", rentCar.getArrivalTime());            
            
            if(TravelModel.checkReserve(rentCar) == false) {
                System.out.println("해당 렌트카 예약 가능합니다.");
                System.out.print("1.예약하기");
            }                
            else {
                System.out.println("예약중인 렌트카입니다.");
                System.out.print("2.취소하기");
            }        
            
            int selectMenu = Util.scanInt("0.뒤로 가기");
            
            if(selectMenu == 1 && TravelModel.checkReserve(rentCar) == false) {
                carReportForTourist(rentCar);            
            }else if(selectMenu == 2 && TravelModel.checkReserve(rentCar) == true){
                cancleCarReport(TravelModel.checkReserve(rentCar, MainController.rentCarReportList));         
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }        
    }
            
    static void showCarReportListForTourist(List<RentCarReportDTO> carReportList) {
        
        System.out.println("========예약된 렌트카 목록 =========");
        System.out.println("번호| 렌트카번호 | 임차인 | 대여일 |");
        
        int index = 0;
        for(RentCarReportDTO rentCar : carReportList) {    
                if(rentCar.getMemberNumber() == MainController.memberDTO.getUserNumber()) {
                    System.out.printf("%3d |    %d | %s | %s |\n", rentCar.getAirReserveNum(), rentCar.getAirTicketNumber(), 
                            TravelModel.translateMemberNumToNickname(rentCar.getMemberNumber()), rentCar.getRevserDate()); 
                    index++;
                }
                
        }
        if(index == 0)
            System.out.println("대여한 렌트카가 없습니다.");   
        System.out.println("=================================");
    }
    
    private static void carReportForTourist(RentCarDTO rentCar) {
        
        RentCarReportDTO carReport = new RentCarReportDTO();        
        
        System.out.println("렌트카 대여하기======");
        
        carReport.setAirReserveNum(MainController.rentCarReportNumberSet++);
        carReport.setAirTicketNumber(rentCar.getAirTicketNumber());
        carReport.setMemberNumber(MainController.memberDTO.getUserNumber());
        carReport.setRevserDate(Util.scanString("오늘 날자를 적어주세요"));        
        
        MainController.rentCarReportList.add(carReport);
        
        System.out.println("렌트카 대여 완료==========");
    }
    

}
