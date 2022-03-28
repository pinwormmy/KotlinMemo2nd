package travelAgency.controller;

import java.util.ArrayList;
import java.util.List;

import movieManager.model.MemberDTO;
import movieManager.model.MovieDTO;
import movieManager.model.MovieModel;
import movieManager.model.Util;
import movieManager.view.TravelView;
import travelAgency.model.AirTicketDTO;
import travelAgency.model.AirTicketReserveDTO;
import travelAgency.model.HotelDTO;
import travelAgency.model.RentCarDTO;
import travelAgency.model.RentCarReportDTO;
import travelAgency.model.RoomDTO;
import travelAgency.model.RoomReserveDTO;

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
        
        MovieModel.setAdministrator(); // 관리자 계정 자동생성. ID : administrator PW: 1111
        
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
        int selectMenu = Util.scanInt("관리자 로그인: 1.항공권 관리 2.렌터카 관리 3.호텔 관리 8.로그아웃 9.프로그램 종료");
        
        switch(selectMenu) {
        case 1:
            manageMovie();
            break;    
        case 2:
            AirlineController.manageTheater();
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
        int selectMenu = Util.scanInt("여행사 로그인: 1.항공권 관리 2.렌터카 관리 3.호텔 관리 8.로그아웃 9.프로그램 종료");
        
        switch(selectMenu) {
        case 1:
            TravelView.showMovieList(MainController.airTicketList);
            selectMovieInfo(MainController.airTicketList);
            break;
        case 2:
            TravelView.showTheaterList(MainController.theaterList);
            AirlineController.selectTheaterInfoForCustomer(MainController.theaterList);
            break;        
        case 8:
            MainController.memberDTO = null;
            break;
        case 9:
            System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다~~~");
            System.exit(0);
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
        }
    }
    
    public static void MenuForLoginTourist() {
        
        System.out.println();
        System.out.printf("%s님\n", MainController.memberDTO.getUserNickname());
        int selectMenu = Util.scanInt("관광객 로그인: 1.항공권 관리 2.렌터카 관리 3.호텔 관리 8.로그아웃 9.프로그램 종료");
        
        switch(selectMenu) {
        case 1:
            TravelView.showMovieList(MainController.airTicketList);
            selectMovieInfo(MainController.airTicketList);
            break;
        case 2:
            TravelView.showTheaterList(MainController.theaterList);
            AirlineController.selectTheaterInfoForCustomer(MainController.theaterList);
            break;        
        case 8:
            MainController.memberDTO = null;
            break;
        case 9:
            System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다~~~");
            System.exit(0);
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
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
    
    private static void manageAirTicket() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====[관리자 모드] 항공권 정보 관리====");
            
            TravelView.showMovieList(MainController.airTicketList);
            
            int selectMenu = Util.scanInt("1.영화 조회 2.영화 등록 9.메인으로");
            
            switch(selectMenu) {
            case 1:
                selectMovieInfo(MainController.airTicketList);
                break;
            case 2:
                addMovie();
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
    
    private static void addAirTicket() {
        
        AirTicketDTO airTicket = new AirTicketDTO();        
        
        System.out.println("항공권 신규 등록======");
        
        airTicket.setMovieTitle(Util.scanString("영화 제목"));
        airTicket.setMovieNumber(MainController.movieNumberSet++);
        
        while(true) {
            int movieRating = Util.scanInt("영화 심의 등급은?(0.전체이용가 12.세 이용가 15.세 이용가 19.청소년 이용불가)");
            
            if(movieRating == 0 || movieRating == 12 || movieRating == 15 || movieRating == 19) {
                airTicket.setMovieRating(movieRating);
                break;
            }
            else
                System.out.println("숫자 입력 오류. 나이 기준으로 잘 입력해주소~~~");            
        }
        airTicket.setStoryLine(Util.scanString("영화 줄거리 작성하시오(최대한 간단하게 쓰라잉)"));
        MainController.airTicketList.add(airTicket);
        
        System.out.println("새로운 영화 정보가 등록되었습니다.==========");
    }
    
    public static void deleteMovie(MovieDTO movie) {
        
        while(true) {
            String question = Util.scanString("정말 해당 항공편을 삭제하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MainController.airTicketList.remove(movie);
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println("삭제를 취소합니다.");
                break;
            }else
                System.out.println("입력 오류. y나 n 중 입력해주세요...");
        }
    }
        
    public static void modifyMovie(MovieDTO movie) {
                
        System.out.println("항공권 정보 수정======");
        
        movie.setMovieTitle(Util.scanString("영화 제목(" + movie.getMovieTitle() + ")"));
        
        
        while(true) {
            int movieRating = Util.scanInt("영화 심의 등급은?(0.전체이용가 12.세 이용가 15.세 이용가 19.청소년 이용불가)(" + movie.getMovieRating() + ")");
            
            if(movieRating == 0 || movieRating == 12 || movieRating == 15 || movieRating == 19) {
                movie.setMovieRating(movieRating);
                break;
            }
            else
                System.out.println("숫자 입력 오류. 나이 기준으로 잘 입력해주소~~~");            
        }
        movie.setStoryLine(Util.scanString("영화 줄거리 작성하시오(" + movie.getStoryLine() + ")"));
                
        System.out.println("항공권 정보가 수정되었습니다.==========");
    }
    
    
    
    private static void selectMovieInfo(List<MovieDTO> movieList) {
            
            while(true) {
                
                int selectMovieNumber = Util.scanInt("조회할 영화 번호 입력(0.뒤로가기)");
                
                if(selectMovieNumber == 0)
                    break;
                
                if(MainController.movieNumberSet == 1) {
                    System.out.println("등록된 영화가 없습니다. 영화를 등록해주세요~");
                    break;
                }else {
                    
                    for(MovieDTO movie : movieList) {
                        if(movie.getMovieNumber() == selectMovieNumber){
                            
                            if(MainController.memberDTO.getUserLevel() == 2){
                                TravelView.showMovieInfo(movie);
                                break;
                            }else if(MainController.memberDTO.getUserLevel() == 1 | MainController.memberDTO.getUserLevel() == 0) {
                                TravelView.showMovieInfoForCustomer(movie);
                                break;
                            }else {
                                System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                            }
                        }
                    }
                }
            }
        }
    

}
