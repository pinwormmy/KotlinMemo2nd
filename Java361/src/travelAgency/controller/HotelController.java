package travelAgency.controller;

import java.util.List;
import travelAgency.model.HotelDTO;
import travelAgency.model.Util;

public class HotelController {
    
    public static void manageHotel() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====[관리자 모드] 호텔 관리====");
            
            showHotelList(MainController.hotelList);
            RoomController.showRoomReserveList(MainController.roomReserveList);
            
            int selectMenu = Util.scanInt("1.호텔 조회 2.호텔 등록 3.예약 조회 9.메인으로");
            
            switch(selectMenu) {
            case 1:
                selectHotelInfo(MainController.hotelList);
                break;
            case 2:
                addHotel();
                break;  
            case 3:
                RoomController.selectRoomReserveInfo(MainController.roomReserveList);
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
    
    public static void showHotelList(List<HotelDTO> hotelList) {
        
        System.out.println("========호텔 목록 =========");
        System.out.println("|번호|     이름     |         주소         | 등급 |    연락처     |");
             
        for(HotelDTO hotel : hotelList) {
            System.out.printf(" %3d |     %s |      %s      | %d성급 |    %s   \n", hotel.getHotelNumber(), hotel.getHotelName(), 
                    hotel.getHotelLocation(), hotel.getHotelGrade(), hotel.getHotelPhoneNumber());
        }
        System.out.println("================================");        
    }
    
    static void selectHotelInfo(List<HotelDTO> hotelList) {
        
        while(true) {
            
            int selectHotelNumber = Util.scanInt("조회할 호텔 번호 입력(0.뒤로가기)");
            
            if(selectHotelNumber == 0)
                break;
            
            if(MainController.hotelNumberSet == 1) {
                System.out.println("등록된 호텔이 없습니다. 등록해주세요~");
                break;
            }else {
                
                for(HotelDTO hotel : hotelList) {
                    if(hotel.getHotelNumber() == selectHotelNumber){
                        
                        if(MainController.memberDTO.getUserLevel() == 2 || MainController.memberDTO.getUserLevel() == 1){
                            showHotelInfo(hotel);
                            break;
                        }else if(MainController.memberDTO.getUserLevel() == 0) {
                            showHotelInfoForTourist(hotel);
                            break;
                        }
                    }                    
                    System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                }
            }
        }
    }
    
    public static void showHotelInfo(HotelDTO hotel) {
        
        while(true) {
            
            System.out.println("========호텔 정보 조회======");
            System.out.printf("번호 : %d\n", hotel.getHotelNumber());
            System.out.printf("호텔명 : %s\n", hotel.getHotelName());
            System.out.printf("주소 : %s\n", hotel.getHotelLocation());
            System.out.printf("등급 : %d\n", hotel.getHotelGrade());
            System.out.printf("연락처 : %s\n", hotel.getHotelPhoneNumber());
                              
            int selectMenu = Util.scanInt("1.호텔 수정 2.호텔 삭제 3.객실 조회 0.뒤로가기");
            
            if(selectMenu == 1) {
                modifyHotel(hotel);                
            }else if(selectMenu == 2){
                deleteHotel(hotel);
                break;
            }else if(selectMenu == 3){
                RoomController.showRoomList(hotel);
                break;
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
    }    
    
    private static void addHotel() {
        
        HotelDTO hotel = new HotelDTO();        
        
        System.out.println("호텔 신규 등록======");
        
        hotel.setHotelNumber(MainController.hotelNumberSet++);
        hotel.setHotelName(Util.scanString("호텔명"));
        hotel.setHotelLocation(Util.scanString("주소"));
        hotel.setHotelGrade(Util.scanInt("등급"));        
        hotel.setHotelPhoneNumber(Util.scanString("연락처"));        
        
        MainController.hotelList.add(hotel);
        
        System.out.println("새로운 호텔 정보가 등록되었습니다.==========");
    }
    
    public static void modifyHotel(HotelDTO hotel) {        
        
        System.out.println("호텔 정보 수정======"); 
        hotel.setHotelName(Util.scanString("호텔명 (" + hotel.getHotelName() + ")"));
        hotel.setHotelLocation(Util.scanString("주소 (" + hotel.getHotelLocation() + ")"));
        hotel.setHotelGrade(Util.scanInt("등급 (" + hotel.getHotelGrade() + "성급)"));
        hotel.setHotelPhoneNumber(Util.scanString("연락처 (" + hotel.getHotelPhoneNumber() + ")"));
        System.out.println("호텔 정보가 수정되었습니다.==========");
    }        
    
    public static void deleteHotel(HotelDTO hotel) {
        
        while(true) {
            String question = Util.scanString("정말 해당 호텔 정보를 삭제하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.hotelList.remove(hotel);
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
    
    public static void manageHotelForTourist() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====관광객 호텔 관리====");
            
            showHotelList(MainController.hotelList);
            RoomController.showRoomReserveListForTourist(MainController.roomReserveList);
            
            int selectMenu = Util.scanInt("1.호텔 조회 2.예약 조회 9.뒤로가기");
            
            switch(selectMenu) {
            case 1:
                selectHotelInfo(MainController.hotelList);
                break;
            case 2:                
                RoomController.selectRoomReserveInfo(MainController.roomReserveList);
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
    
    public static void showHotelInfoForTourist(HotelDTO hotel) {
        
        while(true) {
            
            System.out.println("========호텔 정보 조회======");
            System.out.printf("번호 : %d\n", hotel.getHotelNumber());
            System.out.printf("호텔명 : %s\n", hotel.getHotelName());
            System.out.printf("주소 : %s\n", hotel.getHotelLocation());
            System.out.printf("등급 : %d\n", hotel.getHotelGrade());
            System.out.printf("연락처 : %s\n", hotel.getHotelPhoneNumber());
            
            int selectMenu = Util.scanInt("1.객실 조회 0.뒤로가기"); 
            
            if(selectMenu == 1) {
                RoomController.showRoomListForTourist(hotel);     
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }        
    }
            
    
}
