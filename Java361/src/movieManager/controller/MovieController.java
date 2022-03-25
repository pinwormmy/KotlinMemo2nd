package movieManager.controller;

import java.util.ArrayList;
import java.util.List;
import movieManager.model.GradeDTO;
import movieManager.model.MemberDTO;
import movieManager.model.MovieDTO;
import movieManager.model.MovieModel;
import movieManager.model.ScreenDTO;
import movieManager.model.TheaterDTO;
import movieManager.model.Util;
import movieManager.view.MovieView;

public class MovieController {
    
    public static List<MemberDTO> memberList = new ArrayList<>(); // DB역할
    public static List<MovieDTO> movieList = new ArrayList<>(); 
    public static List<TheaterDTO> theaterList = new ArrayList<>(); 
    public static List<ScreenDTO> screenList = new ArrayList<>(); 
    public static List<GradeDTO> gradeList = new ArrayList<>(); 
    public static MemberDTO memberDTO;
    public static MovieDTO movieDTO;
    public static TheaterDTO theaterDTO;
    public static ScreenDTO screenDTO;
    public static GradeDTO gradeDTO;
    
    public static int userNumberSet = 0;
    public static int movieNumberSet = 1;
    public static int theaterNumberSet = 1;
    public static int screenNumberSet = 1;
    public static int gradeNumberSet = 1;
    
    public void run() {
        
        MovieModel.setAdministrator(); // 관리자 계정 자동생성. ID : administrator PW: 1111
        
        System.out.println("========영화 관리 프로그램========");
        
        while(true) {          
                        
            if(memberDTO == null) {
                MenuForGuest();
            }
            else if(memberDTO.getUserLevel() == 1){
                MenuForLoginCritic();
            }
            else if(memberDTO.getUserLevel() == 0){
                MenuForLoginAudience();
            }
            else {
                MenuForAdmin();
            }
        }
    }
    
    public static void MenuForAdmin() {
        
        System.out.println();
        int selectMenu = Util.scanInt("관리자 로그인: 1.영화 관리 2.영화관 관리 8.로그아웃 9.프로그램 종료");
        
        switch(selectMenu) {
        case 1:
            manageMovie();
            break;    
        case 2:
            TheaterController.manageTheater();
            break;
        case 8:
            MovieController.memberDTO = null;
            break;
        case 9:
            System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다~~~");
            System.exit(0);
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하시오");
        }        
    }
    
    public static void MenuForLoginCritic() {
        
        System.out.println();
        System.out.printf("%s님\n", MovieController.memberDTO.getUserNickname());        
        int selectMenu = Util.scanInt("평론가 로그인: 1.영화 목록 2.영화관 목록 8.로그아웃 9.프로그램 종료");
        
        switch(selectMenu) {
        case 1:
            MovieView.showMovieList(MovieController.movieList);
            selectMovieInfo(MovieController.movieList);
            break;
        case 2:
            MovieView.showTheaterList(MovieController.theaterList);
            TheaterController.selectTheaterInfoForCustomer(MovieController.theaterList);
            break;        
        case 8:
            MovieController.memberDTO = null;
            break;
        case 9:
            System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다~~~");
            System.exit(0);
        default:
            System.out.println("숫자 입력 오류. 메뉴에 해당하는 숫자를 입력하쇼");
        }
    }
    
    public static void MenuForLoginAudience() {
        
        System.out.println();
        System.out.printf("%s님\n", MovieController.memberDTO.getUserNickname());
        int selectMenu = Util.scanInt("관람객 로그인: 1.영화 목록 2.영화관 목록 8.로그아웃 9.프로그램 종료");
        
        switch(selectMenu) {
        case 1:
            MovieView.showMovieList(MovieController.movieList);
            selectMovieInfo(MovieController.movieList);
            break;
        case 2:
            MovieView.showTheaterList(MovieController.theaterList);
            TheaterController.selectTheaterInfoForCustomer(MovieController.theaterList);
            break;        
        case 8:
            MovieController.memberDTO = null;
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
            MovieController.memberDTO = MemberController.login();
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
    
    private static void manageMovie() {
        
        while(true) {
            
            System.out.println("");
            System.out.println("====[관리자 모드] 영화 정보 관리====");
            
            MovieView.showMovieList(MovieController.movieList);
            
            int selectMenu = Util.scanInt("1.영화 조회 2.영화 등록 9.메인으로");
            
            switch(selectMenu) {
            case 1:
                selectMovieInfo(MovieController.movieList);
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
    
    private static void addMovie() {
        
        MovieDTO movieDTO = new MovieDTO();        
        
        System.out.println("영화 정보 신규 등록======");
        
        movieDTO.setMovieTitle(Util.scanString("영화 제목"));
        movieDTO.setMovieNumber(MovieController.movieNumberSet++);
        
        while(true) {
            int movieRating = Util.scanInt("영화 심의 등급은?(0.전체이용가 12.세 이용가 15.세 이용가 19.청소년 이용불가)");
            
            if(movieRating == 0 || movieRating == 12 || movieRating == 15 || movieRating == 19) {
                movieDTO.setMovieRating(movieRating);
                break;
            }
            else
                System.out.println("숫자 입력 오류. 나이 기준으로 잘 입력해주소~~~");            
        }
        movieDTO.setStoryLine(Util.scanString("영화 줄거리 작성하시오(최대한 간단하게 쓰라잉)"));
        MovieController.movieList.add(movieDTO);
        
        System.out.println("새로운 영화 정보가 등록되었습니다.==========");
    }
    
    public static void deleteMovie(MovieDTO movie) {
        
        while(true) {
            String question = Util.scanString("정말 해당 영화를 삭제하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MovieController.movieList.remove(movie);
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
                
        System.out.println("영화 정보 수정======");
        
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
                
        System.out.println("영화 정보가 수정되었습니다.==========");
    }
    
    
    
    private static void selectMovieInfo(List<MovieDTO> movieList) {
            
            while(true) {
                
                int selectMovieNumber = Util.scanInt("조회할 영화 번호 입력(0.뒤로가기)");
                
                if(selectMovieNumber == 0)
                    break;
                
                if(MovieController.movieNumberSet == 1) {
                    System.out.println("등록된 영화가 없습니다. 영화를 등록해주세요~");
                    break;
                }else {
                    
                    for(MovieDTO movie : movieList) {
                        if(movie.getMovieNumber() == selectMovieNumber){
                            
                            if(MovieController.memberDTO.getUserLevel() == 2){
                                MovieView.showMovieInfo(movie);
                                break;
                            }else if(MovieController.memberDTO.getUserLevel() == 1 | MovieController.memberDTO.getUserLevel() == 0) {
                                MovieView.showMovieInfoForCustomer(movie);
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
