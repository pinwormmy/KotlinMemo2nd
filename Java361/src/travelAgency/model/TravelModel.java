package travelAgency.model;


import java.util.List;

import travelAgency.controller.AirlineController;
import travelAgency.controller.MainController;
import travelAgency.controller.RentCarController;
import travelAgency.controller.RoomController;


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
    
    public static MemberDTO numberToMember(int memberNum) {
        
        for (MemberDTO memberDTO : MainController.memberList) {
            if (memberDTO.getUserNumber() == memberNum) {
                return memberDTO;
            }
        }        
        
        return null;
    }
    
    public static boolean checkReserve(AirTicketDTO airTicket) {
        
        for(AirTicketReserveDTO airReserve : MainController.airReserveList) {
            if(airReserve.getAirTicketNumber() == airTicket.getAirTicketNumber())
                return true;
        }
        
        return false;
    }
    
    public static boolean checkLoginReserve(MemberDTO member, List<AirTicketReserveDTO> airReserveList) {
        
        for(AirTicketReserveDTO airReserve : airReserveList) {
            if(airReserve.getMemberNumber() == member.getUserNumber())
                return true;
        }
        
        return false;
    }
    
    public static AirTicketReserveDTO checkLoginReserve(List<AirTicketReserveDTO> airReserveList, MemberDTO member) {
        
        for(AirTicketReserveDTO airReserve : airReserveList) {
            if(airReserve.getMemberNumber() == member.getUserNumber())
                return airReserve;
        }
        
        return null;
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
    
    public static boolean checkLoginReport(List<RentCarReportDTO> rentCarReportList, MemberDTO member) {
        
        for(RentCarReportDTO rentCarReport : rentCarReportList) {
            if(rentCarReport.getMemberNumber() == member.getUserNumber())
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
    
    public static RentCarReportDTO checkLoginReport(MemberDTO member, List<RentCarReportDTO> carReportList) {
        
        for(RentCarReportDTO rentCarReport : carReportList) {
            if(rentCarReport.getMemberNumber() == member.getUserNumber())
                return rentCarReport;
        }        
        return null;
    }
    
    public static boolean checkLoginRoomReserve(List<RoomReserveDTO> roomReserveList, MemberDTO member) {
        
        for(RoomReserveDTO roomReserve : roomReserveList) {
            if(roomReserve.getMemberNumber() == member.getUserNumber())
                return true;
        }
        
        return false;
    }
    
    public static RoomReserveDTO checkLoginRoomReserve(MemberDTO member, List<RoomReserveDTO> roomReserveList) {
        
        for(RoomReserveDTO roomReserve : roomReserveList) {
            if(roomReserve.getMemberNumber() == member.getUserNumber())
                return roomReserve;
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
    
    public static void deleteAllReserve(MemberDTO memberDTO) {
        
        while(true) {            
            if(TravelModel.checkLoginReserve(MainController.memberDTO, MainController.airReserveList) == false) {
                System.out.println("항공 예약 전체 삭제 완료");
                break;
            }else {
                AirlineController.cancleAirReserve(TravelModel.checkLoginReserve(MainController.airReserveList, MainController.memberDTO));
            }
        }   
        while(true) {            
            if(TravelModel.checkLoginReport(MainController.rentCarReportList, MainController.memberDTO) == false) {
                System.out.println("렌트카 대여 전체 삭제 완료");
                break;
            }else {
                RentCarController.cancleCarReport(TravelModel.checkLoginReport(MainController.memberDTO, MainController.rentCarReportList));
            }
        }   
        while(true) {            
            if(TravelModel.checkLoginRoomReserve(MainController.roomReserveList, MainController.memberDTO) == false) {
                System.out.println("호텔 예약 전체 삭제 완료");
                break;
            }else {
                RoomController.cancleRoomReserve(TravelModel.checkLoginRoomReserve(MainController.memberDTO, MainController.roomReserveList));
            }
        }           
    }
}


