package travelAgency.model;


import java.util.List;
import travelAgency.controller.MainController;


public class TravelModel {    
    
    public static void setAdministrator(){
        
        MemberDTO administrator = new MemberDTO();
        
        administrator.setUserNumber(MainController.userNumberSet++);
        administrator.setUserId("administrator");
        administrator.setUserPassword("1111");
        administrator.setUserNickname("관리자");
        administrator.setUserLevel(2);         
        MainController.memberList.add(administrator);        
       
    }        
        
    public static boolean CheckDuplicatedId(String userId, List<MemberDTO> memberList) {
     
        for (MemberDTO memberDTO : memberList) {
            if (memberDTO.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean CheckPassword(String userId, String password, List<MemberDTO> list) {
        for (MemberDTO memberDTO : list) {
            if (memberDTO.getUserId().equals(userId) && memberDTO.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public static MemberDTO loginUserData(String userId, List<MemberDTO> list) {
        
        for (MemberDTO memberDTO : list) {
            if (memberDTO.getUserId().equals(userId)) {
                return memberDTO;
            }
        }        
        System.out.println("로그인 오류 확인 요청");
        return null;
    }
    
    public static boolean checkReserve(AirTicketDTO airTicket) {
        
        for(AirTicketReserveDTO airReserve : MainController.airReserveList) {
            if(airReserve.getAirTicketNumber() == airTicket.getAirTicketNumber())
                return true;
        }
        
        return false;
    }
    
    public static AirTicketReserveDTO checkReserve(AirTicketDTO airTicket, List<AirTicketReserveDTO> airReserveList) {
        
        for(AirTicketReserveDTO airReserve : airReserveList) {
            if(airReserve.getAirTicketNumber() == airTicket.getAirTicketNumber())
                return airReserve;
        }
        
        return null;
    }
    
    public static boolean checkReserve(RentCarDTO rentCar) {
        
        for(RentCarReportDTO rentCarReport : MainController.rentCarReportList) {
            if(rentCarReport.getCarNumber() == rentCar.getCarNumber())
                return true;
        }
        
        return false;
    }
    
    public static RentCarReportDTO checkReserve(RentCarDTO rentCar, List<RentCarReportDTO> carReportList) {
        
        for(RentCarReportDTO rentCarReport : carReportList) {
            if(rentCarReport.getCarNumber() == rentCar.getCarNumber())
                return rentCarReport;
        }        
        return null;
    }
    
    public static boolean checkReserve(RoomDTO room) {
        
        for(RoomReserveDTO roomReserve : MainController.roomReserveList) {
            if(roomReserve.getRoomNumber() == room.getRoomNumber())
                return true;
        }
        
        return false;
    }
    
    public static RoomReserveDTO checkReserve(RoomDTO room, List<RoomReserveDTO> roomReserveList) {
        
        for(RoomReserveDTO roomReserve : MainController.roomReserveList) {
            if(roomReserve.getRoomNumber() == room.getRoomNumber())
                return roomReserve;
        }        
        return null;
    }
    
    public static boolean checkRoom(int roomNumber) {
        
        for(RoomDTO room : MainController.roomList) {
            if(room.getRoomNumber() == roomNumber)
                return true;
        }        
        return false;
    }
    
    public static RoomDTO checkRoom(List<RoomDTO> hotel, int roomNumber) {
        
        for(RoomDTO room : MainController.roomList) {
            if(room.getRoomNumber() == roomNumber)
                return room;
        }        
        return null;
    }
    
    public static boolean checkMember(int memberNum) {
        
        for(MemberDTO member : MainController.memberList) {
            if(member.getUserNumber() == memberNum)
                return true;
        }
        
        return false;
    }
    
    public static String translateMemberNumToNickname(int memberNum) {        
        
        for(MemberDTO member : MainController.memberList) {
            if(member.getUserNumber() == memberNum)
                return member.getUserNickname();
        }
            
        return null;        
    }
    
    public static AirTicketDTO translateReserveNumToAirTicket(int reserveNum) {        
        
        for(AirTicketDTO airTicket : MainController.airTicketList) {
            if(airTicket.getAirTicketNumber() == reserveNum)
                return airTicket;
        }            
        return null;        
    }
    
    public static RentCarDTO translateReportNumToRentCar(int reportNum) {        
        
        for(RentCarDTO rentCar : MainController.rentCarList) {
            if(rentCar.getCarNumber() == reportNum)
                return rentCar;
        }            
        return null;        
    }

    public static RoomDTO translateReserveNumToRoom(int reserveNum) {        
    
    for(RoomDTO room : MainController.roomList) {
        if(room.getRoomNumber() == reserveNum)
            return room;
    }            
    return null;        
}
}


