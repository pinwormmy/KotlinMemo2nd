package travelAgency.controller;

import java.util.List;

import travelAgency.model.HotelDTO;
import travelAgency.model.RoomDTO;
import travelAgency.model.RoomReserveDTO;
import travelAgency.model.TravelModel;
import travelAgency.model.Util;

public class RoomController extends HotelController { 
    
    public static void showRoomList(HotelDTO hotel) {
        
        System.out.println("========객실 목록 =========");
        System.out.println("|객실번호| 호실번호 |    가격    |");
             
        int index = 0;
        for(RoomDTO room : MainController.roomList) {
            if(TravelModel.checkReserve(room) == false && hotel.getHotelNumber() == room.getHotelNumber()) {
                System.out.printf(" %d | %s | %d원 |\n", room.getRoomNumber(), room.getRoomLocation(), room.getRoomPrice());
                index++;
            }                
        }
        if(index == 0)
            System.out.println("예약 가능한 객실이 없습니다.");    
        
        System.out.println("================================");        
        
        int selectMenu = Util.scanInt("1.객실 조회 2.객실 추가 9.뒤로가기");
        
        switch(selectMenu) {
        case 1:
            selectRoomInfo(hotel);
            break;
        case 2:
            addRoom(hotel); 
            break;
        case 9:
            System.out.println("이전 화면으로 이동합니다.");
            break;
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
        }
    }
    
    static void selectRoomInfo(HotelDTO hotel) {                
        
        while(true) {
            
            int selectRoomNumber = Util.scanInt("조회할 객실번호 입력(0.뒤로가기)");
            
            if(selectRoomNumber == 0)
                break;
            
            for(RoomDTO room : MainController.roomList) {
                if(room.getRoomNumber() == selectRoomNumber && hotel.getHotelNumber() == room.getHotelNumber()){
                    
                    if(MainController.memberDTO.getUserLevel() == 2 || MainController.memberDTO.getUserLevel() == 1){
                        showRoomInfo(room);
                        break;
                    }else if(MainController.memberDTO.getUserLevel() == 0) {
                        showRoomInfoForTourist(room);
                        break;
                    }
                }                    
                System.out.println("번호 잘못 입력했습니다. 확인해주세요");
            }
        }        
    }        
    
    private static void showRoomInfo(RoomDTO room) {
        
        while(true) {
            
            System.out.println("========객실 정보 조회======");
            System.out.printf("객실번호 : %d\n", room.getRoomNumber());
            System.out.printf("호텔번호 : %s\n", room.getHotelNumber());
            System.out.printf("객실호수 : %s\n", room.getRoomLocation());
            System.out.printf("가격 : %d\n", room.getRoomPrice());
                                          
            int selectMenu = Util.scanInt("1.객실정보 수정 2.객실정보 삭제 3.객실 예약 0.뒤로가기");
            
            if(selectMenu == 1) {
                modifyRoom(room);                
            }else if(selectMenu == 2){
                deleteRoom(room);
                break;
            }else if(selectMenu == 3){
                manageRoomReserve(room);
                break;
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
        
    }
    
    private static void manageRoomReserve(RoomDTO room) {
        while(true) {
            
            System.out.println("");
            System.out.println("====[관리자 모드] 객실 예약 관리====");
            
            showRoomReserveInfo(room);
            
            if(TravelModel.checkReserve(room) == false) {
                System.out.println("해당 객실 예약 가능합니다.");
                System.out.print("1.예약하기 ");
            }                
            else {
                System.out.println("예약 중인 객실입니다.");
                System.out.print("2.예약 취소하기 ");
            }        
            
            int selectMenu = Util.scanInt("0.뒤로가기");
            
            if(selectMenu == 1 && TravelModel.checkReserve(room) == false) {
                reserveRoom(room);           
            }else if(selectMenu == 2 && TravelModel.checkReserve(room) == true){
                cancleRoomReserve(TravelModel.checkReserve(room, MainController.roomReserveList));         
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
    }

    private static void showRoomReserveInfo(RoomDTO room) {
        
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

    private static void addRoom(HotelDTO hotel) {
        
        RoomDTO room = new RoomDTO();      
        
        System.out.println("객실 신규 등록======");
        
        room.setRoomNumber(MainController.roomNumberSet++);
        room.setHotelNumber(hotel.getHotelNumber());        
        room.setRoomLocation(Util.scanString("객실호수"));
        room.setRoomPrice(Util.scanInt("가격")); 
        
        MainController.roomList.add(room);
        
        System.out.println("새로운 객실 정보가 등록되었습니다.==========");
    }
    
    private static void modifyRoom(RoomDTO room) {
        
        System.out.println("객실 정보 수정======");         
        room.setRoomLocation(Util.scanString("객실호수 (" + room.getRoomLocation() + ")"));
        room.setRoomPrice(Util.scanInt("가격 (" + room.getRoomPrice() + ")"));
        System.out.println("객실 정보가 수정되었습니다.==========");        
    }
    
    private static void deleteRoom(RoomDTO room) {
        
        while(true) {
            String question = Util.scanString("정말 해당 객실 정보를 삭제하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.roomList.remove(room);
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println("삭제를 취소합니다.");
                break;
            }else
                System.out.println("입력 오류. y나 n 중 입력해주세요...");
        }
        
    }
    
    private static void reserveRoom(RoomDTO room) {
        
        RoomReserveDTO roomReserve = new RoomReserveDTO();
        
        System.out.println("[관리자 모드]고객 객실 예약하기======");   
        
        while(true) {
            
            int memberNumber = Util.scanInt("예약할 회원번호 입력하시오(0.뒤로가기)");            
            if(memberNumber == 0){
                break;
            }else if(TravelModel.checkMember(memberNumber) == true) {
                roomReserve.setMemberNumber(memberNumber);
                roomReserve.setRoomReserveNumber(MainController.roomReserveNumberSet++);
                roomReserve.setRoomNumber(room.getRoomNumber());;
                roomReserve.setStartReserveDate(Util.scanString("예약 시작일을 적어주세요(1/23)"));        
                roomReserve.setEndReserveDate(Util.scanString("예약 종료일을 적어주세요(1/23)"));        
                
                MainController.roomReserveList.add(roomReserve);
                
                System.out.println("호텔 고객예약 완료==========");
                break;
            }else {
                System.out.println("없는 번호입니다. 입력 다시 확인해주세요.");
            }
        }
    }

    static void showRoomReserveList(List<RoomReserveDTO> roomReserveList) {
        // 호텔 상관없이 전체 고객예약건 조회
        System.out.println("========예약된 객실 목록 =========");
        System.out.println("|예약번호| 고객명 |객실번호|    체크인    |   체크아웃  |");
        
        int index = 0;
        for(RoomReserveDTO roomReserve : roomReserveList) {            
                System.out.printf("%d |    %s |    %s    |     %s  |    $s  \n", roomReserve.getRoomReserveNumber(), 
                        TravelModel.translateMemberNumToNickname(roomReserve.getMemberNumber()), roomReserve.getRoomNumber(), 
                        roomReserve.getStartReserveDate(), roomReserve.getEndReserveDate()); 
                index++;
        }
        if(index == 0)
            System.out.println("예약한 객실이 없습니다.");   
        System.out.println("=================================");
    }    
    
    private static void cancleRoomReserve(RoomReserveDTO roomReserve) {
        
        while(true) {
            String question = Util.scanString("해당 객실을 예약취소하시겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.roomReserveList.remove(roomReserve);
                System.out.println("예약이 취소되었습니다.");
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println("예약 취소를 취소합니다.");
                break;
            }else
                System.out.println("입력 오류. y나 n 중 입력해주세요...");
        }
        
    }
    
    static void selectRoomReserveInfo(List<RoomReserveDTO> roomReserveList) {
        
        while(true) {
            
            int selectRoomReserveNumber = Util.scanInt("조회할 객실 예약번호 입력(0.뒤로가기)");
            
            if(selectRoomReserveNumber == 0)
                break;
            
            if(MainController.roomReserveNumberSet == 1) {
                System.out.println("등록된 객실 예약내용이 없습니다.");
                break;
            }else {
                
                for(RoomReserveDTO roomReserve : roomReserveList) {
                    if(roomReserve.getRoomReserveNumber() == selectRoomReserveNumber){
                        
                        if(MainController.memberDTO.getUserLevel() == 2 || MainController.memberDTO.getUserLevel() == 1){
                            showRoomInfo(TravelModel.translateReserveNumToRoom(roomReserve.getRoomReserveNumber()));
                            break;
                        }else if(MainController.memberDTO.getUserLevel() == 0) {
                            showRoomInfoForTourist(TravelModel.translateReserveNumToRoom(roomReserve.getRoomReserveNumber()));
                            break;
                        }
                    }                    
                    System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                }
            }
        }        
    }        
    
    ////////////////////////////////////////////////////////////////
    
    public static void showRoomListForTourist(HotelDTO hotel) {
        
        System.out.println("========객실 목록 =========");
        System.out.println("|객실번호| 호실번호 |    가격    |");
             
        int index = 0;
        for(RoomDTO room : MainController.roomList) {
            if(TravelModel.checkReserve(room) == false && hotel.getHotelNumber() == room.getHotelNumber()) {
                System.out.printf(" %d | %s | %d원 |\n", room.getRoomNumber(), room.getRoomLocation(), room.getRoomPrice());
                index++;
            }                
        }
        if(index == 0)
            System.out.println("예약 가능한 객실이 없습니다.");    
        
        System.out.println("================================");        
        
        int selectMenu = Util.scanInt("1.객실 조회 9.뒤로가기");
        
        switch(selectMenu) {
        case 1:
            selectRoomInfo(hotel);
            break;          
        case 9:
            System.out.println("이전 화면으로 이동합니다.");
            break;
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
        }
    }
    
    private static void showRoomInfoForTourist(RoomDTO room) {
        
        while(true) {
            
            System.out.println("========객실 정보 조회======");
            System.out.printf("객실번호 : %d\n", room.getRoomNumber());
            System.out.printf("호텔번호 : %s\n", room.getHotelNumber());
            System.out.printf("객실호수 : %s\n", room.getRoomLocation());
            System.out.printf("가격 : %d\n", room.getRoomPrice());
            
            if(TravelModel.checkReserve(room) == false) {
                System.out.println("해당 객실 예약 가능합니다.");
                System.out.print("1.예약하기 ");
            }                
            else {
                System.out.println("예약 중인 객실입니다.");
                System.out.print("2.취소하기 ");
            }        
                                          
            int selectMenu = Util.scanInt("0.뒤로가기");
            
            if(selectMenu == 1 && TravelModel.checkReserve(room) == false) {
                roomReserveForTourist(room);                
            }else if(selectMenu == 2 && TravelModel.checkReserve(room) == true){
                cancleRoomReserve(TravelModel.checkReserve(room, MainController.roomReserveList));
                break;
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
        
    }

    static void showRoomReserveListForTourist(List<RoomReserveDTO> roomReserveList) {
        
        System.out.println("========예약된 호텔 목록 =========");
        System.out.println("예약번호| 고객명 | 객실번호 | 체크인 | 체크아웃 |");
        
        int index = 0;
        for(RoomReserveDTO roomReserve : roomReserveList) {    
                if(roomReserve.getMemberNumber() == MainController.memberDTO.getUserNumber()) {
                    System.out.printf("%d |    %s |    %s |   %s |   %s \n", roomReserve.getRoomReserveNumber(), 
                            TravelModel.translateMemberNumToNickname(roomReserve.getMemberNumber()),
                             roomReserve.getRoomNumber(), roomReserve.getStartReserveDate(), roomReserve.getEndReserveDate()); 
                    index++;
                }                
        }
        if(index == 0)
            System.out.println("예약한 객실이 없습니다.");   
        System.out.println("=================================");
    }
    
    private static void roomReserveForTourist(RoomDTO room) {
        
        RoomReserveDTO roomReserve = new RoomReserveDTO();        
        
        System.out.println("객실 예약하기======");
        
        roomReserve.setRoomReserveNumber(MainController.roomReserveNumberSet++);
        roomReserve.setRoomNumber(room.getRoomNumber());
        roomReserve.setMemberNumber(MainController.memberDTO.getUserNumber());
        roomReserve.setStartReserveDate(Util.scanString("예약 시작일을 적어주세요"));        
        roomReserve.setEndReserveDate(Util.scanString("예약 종료일을 적어주세요"));        
        
        MainController.roomReserveList.add(roomReserve);
        
        System.out.println("객실 예약 완료==========");
    }
}
