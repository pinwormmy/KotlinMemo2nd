package travelAgency.controller;

import java.util.List;
import travelAgency.model.RentCarDTO;
import travelAgency.model.RentCarReportDTO;
import travelAgency.model.TravelModel;
import travelAgency.model.Util;
import travelAgency.view.TravelView;

public class RentCarController extends TravelView{
    
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
                    if(rentCar.getCarNumber() == selectRentCarNumber && TravelModel.checkReserve(rentCar) == false){
                        
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
            System.out.printf("관리번호 : %d\n", rentCar.getCarNumber());
            System.out.printf("차번호판 : %s\n", rentCar.getCarRegNumber());
            System.out.printf("차종 : %s\n", rentCar.getCarType());
            System.out.printf("색상 : %s\n", rentCar.getCarColor());
                  
            
            if(TravelModel.checkReserve(rentCar) == true) {
                
                System.out.println("대여 처리된 렌트카입니다.");
                
                RentCarReportDTO carReport = TravelModel.checkReserve(rentCar, MainController.rentCarReportList);
                
                System.out.printf("대여번호 : %d 임차인: %s 시작일: %s 종료일: %s \n", carReport.getCarRentalNumber(), 
                        TravelModel.translateMemberNumToNickname(carReport.getMemberNumber()), carReport.getStartRentDate(), carReport.getEndRentDate());
                
                int selectMenu = Util.scanInt("1.반납(및 대여취소) 0.뒤로가기");                
                if(selectMenu == 1) {
                    cancleCarReport(carReport);
                }else if(selectMenu == 0){
                    break;
                }else {
                    System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
                }
                
            }else {
                int selectMenu = Util.scanInt("1.렌트카 수정 2.렌트카 삭제 3.고객 대여 0.뒤로가기");
                
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
        
        rentCar.setCarNumber(MainController.rentCarNumberSet++);
        rentCar.setCarRegNumber(Util.scanString("차번호판"));
        rentCar.setCarType(Util.scanString("차종"));
        rentCar.setCarColor(Util.scanString("색상"));        
        
        MainController.rentCarList.add(rentCar);
        
        System.out.println("새로운 렌트카 정보가 등록되었습니다.==========");
    }
    
    public static void modifyRentCar(RentCarDTO rentCar) {        
        
        System.out.println("렌트카 정보 수정======"); 
        rentCar.setCarRegNumber(Util.scanString("차번호판 (" + rentCar.getCarRegNumber() + ")"));
        rentCar.setCarType(Util.scanString("차종 (" + rentCar.getCarType() + ")"));
        rentCar.setCarColor(Util.scanString("색상 (" + rentCar.getCarColor() + ")"));
        System.out.println("렌트카 정보가 수정되었습니다.==========");
    }        
    
    public static void deleteRentCar(RentCarDTO rentCar) {
        
        while(true) {
            String question = Util.scanString("정말 해당 렌트카 정보를 삭제하겠습니까?(y/n)");
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
    
    public static void manageCarReport() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====[관리자 모드] 렌트카 대여 관리====");
            
            showCarReportList(MainController.rentCarReportList);
            
            int selectMenu = Util.scanInt("1.대여 조회 9.뒤로가기");
            
            switch(selectMenu) {
            case 1:
                selectCarReportInfo(MainController.rentCarReportList);
                break;
            case 9:
                System.out.println("이전 화면으로 이동합니다.");
                break;
            default:
                System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
            }
            if(selectMenu == 9)
                break;
        }
    }
        
    
    private static void selectCarReportInfo(List<RentCarReportDTO> carReportList) {
        
        while(true) {
            
            int selectCarReportNumber = Util.scanInt("조회할 렌트카 대여번호 입력(0.뒤로가기)");
            
            if(selectCarReportNumber == 0)
                break;
            
            if(MainController.rentCarReportNumberSet == 1) {
                System.out.println("등록된 렌트카 대여내용이 없습니다.");
                break;
            }else {
                
                for(RentCarReportDTO carReport : carReportList) {
                    if(carReport.getCarRentalNumber() == selectCarReportNumber){
                        
                        if(MainController.memberDTO.getUserLevel() == 2 || MainController.memberDTO.getUserLevel() == 1){
                            showRentCarInfo(TravelModel.translateReportNumToRentCar(carReport.getCarRentalNumber()));
                            break;
                        }else if(MainController.memberDTO.getUserLevel() == 0) {
                            showRentCarInfoForTourist(TravelModel.translateReportNumToRentCar(carReport.getCarRentalNumber()));
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
        
        System.out.println("[관리자 모드]렌트카 고객대여하기======");        
        while(true) {
            int memberNumber = Util.scanInt("대여할 회원번호 입력하시오(0.뒤로가기)");
            
            if(memberNumber == 0){
                break;
            }else if(memberNumber != 0 && TravelModel.checkMember(memberNumber) == true) {
                carReport.setMemberNumber(memberNumber);
                carReport.setCarRentalNumber(MainController.rentCarReportNumberSet++);
                carReport.setCarNumber(rentCar.getCarNumber());
                carReport.setStartRentDate(Util.scanString("대여 시작일을 적어주세요"));        
                carReport.setEndRentDate(Util.scanString("대여 종료일을 적어주세요"));        
                
                MainController.rentCarReportList.add(carReport);
                
                System.out.println("렌트카 고객대여 완료==========");
                break;
            }else {
                System.out.println("없는 번호입니다. 입력 다시 확인해주세요.");
            }
        }
    }
    
    public static void cancleCarReport(RentCarReportDTO carReport) {
        
        while(true) {
            String question = Util.scanString("렌트카를 반납(혹은 대여취소)하시겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.rentCarReportList.remove(carReport);
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println("반납 처리를 취소합니다.");
                break;
            }else
                System.out.println("입력 오류. y나 n 중 입력해주세요...");
        }
        
    }
    
    //////////////////////////////////////////////////
    
    public static void manageRentCarForTourist() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====관광객 렌트카 대여 관리====");
            
            showRentCarList(MainController.rentCarList);
            showCarReportListForTourist(MainController.rentCarReportList);
            
            int selectMenu = Util.scanInt("1.렌트카 조회 2.대여기록 조회 9.뒤로가기");
            
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
            System.out.printf("관리번호 : %d\n", rentCar.getCarNumber());
            System.out.printf("차번호판 : %s\n", rentCar.getCarRegNumber());
            System.out.printf("차종 : %s\n", rentCar.getCarType());
            System.out.printf("색상 : %s\n", rentCar.getCarColor());
            
            
            if(TravelModel.checkReserve(rentCar) == false) {
                System.out.println("해당 렌트카 대여 가능합니다.");
                System.out.print("1.대여하기 ");
            }                
            else {
                System.out.println("대여 중인 렌트카입니다.");
                System.out.print("2.반납 및 취소하기 ");
            }        
            
            int selectMenu = Util.scanInt("0.뒤로가기");
            
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
        
        System.out.println("========대여된 렌트카 목록 =========");
        System.out.println("대여번호| 차번호 | 임차인 | 시작일 | 종료일 |");
        
        int index = 0;
        for(RentCarReportDTO carReport : carReportList) {    
                if(carReport.getMemberNumber() == MainController.memberDTO.getUserNumber()) {
                    System.out.printf("%3d |    %s |    %s |   %s |   %s \n", carReport.getCarRentalNumber(), carReport.getCarNumber(), 
                            TravelModel.translateMemberNumToNickname(carReport.getMemberNumber()), carReport.getStartRentDate(), carReport.getEndRentDate()); 
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
        
        carReport.setCarRentalNumber(MainController.rentCarReportNumberSet++);
        carReport.setCarNumber(rentCar.getCarNumber());
        carReport.setMemberNumber(MainController.memberDTO.getUserNumber());
        carReport.setStartRentDate(Util.scanString("대여 시작일을 적어주세요"));        
        carReport.setEndRentDate(Util.scanString("대여 종료일을 적어주세요"));        
        
        MainController.rentCarReportList.add(carReport);
        
        System.out.println("렌트카 대여 완료==========");
    }
    

}
