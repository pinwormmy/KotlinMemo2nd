package movieManager.view;

import java.util.List;

import movieManager.controller.GradeController;
import movieManager.controller.MovieController;
import movieManager.controller.ScreenController;
import movieManager.controller.TheaterController;
import movieManager.model.GradeDTO;
import movieManager.model.MovieDTO;
import movieManager.model.MovieModel;
import movieManager.model.ScreenDTO;
import movieManager.model.TheaterDTO;
import movieManager.model.Util;

public class MovieView { 
    
    public static void showTheaterInfo(TheaterDTO theater) { 
        
        while(true) {
            
            System.out.println("========영화관 정보 조회======");
            System.out.printf("영화관 번호 : %d\n", theater.getTheaterNumber());
            System.out.printf("영화관명 : %s\n", theater.getTheaterName());       
            System.out.printf("주소 : %s\n", theater.getTheatherLocation());       
            System.out.printf("연락처 : %s\n", theater.getTheaterPhone());       
            
            System.out.println("==============================");
            int selectMenu = Util.scanInt("1.영화관 정보 수정 2.영화관 정보 삭제 3.상영작 조회 0.뒤로 가기");
            
            if(selectMenu == 1) {
                TheaterController.modifyTheater(theater);
            }else if(selectMenu == 2){
                TheaterController.deleteTheater(theater);
                break;
            }else if(selectMenu == 3){
                showScreenList(theater);                
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
        
    }
    
    public static void showTheaterInfoForCustomer(TheaterDTO theater) { 
        
        while(true) {
            
            System.out.println("========영화관 정보 조회======");
            System.out.printf("영화관 번호 : %d\n", theater.getTheaterNumber());
            System.out.printf("영화관명 : %s\n", theater.getTheaterName());       
            System.out.printf("주소 : %s\n", theater.getTheatherLocation());       
            System.out.printf("연락처 : %s\n", theater.getTheaterPhone());       
            System.out.println("==============================");
            System.out.println("========상영작 목록 =========");
            System.out.println("번호|           제목             |       상영시간       |");            
            
            if(MovieModel.searchScreenTheater(theater) == false) {
                System.out.println("해당 영화관에 등록된 상영작이 없습니다. 상영작을 등록해주세요~");                
            }
            else {
                for(ScreenDTO screen : MovieController.screenList) {
                    if(screen.getTheaterNumber() == theater.getTheaterNumber())
                        System.out.printf("%3d | %21s  |  %s \n", screen.getScreenNumber(), MovieModel.translateMovieName(screen.getMovieNumber()), screen.getScreenTime());
                }
            }                    
            System.out.println("==============================");
            
            int backKey = Util.scanInt("(0.이전화면)");
            if(backKey == 0)
                break;
            else
                System.out.println("입력 오류. 뒤로 가려면 0 누르세요;");
            
        }
        
    }

    private static void showScreenList(TheaterDTO theater) {        
        
        while(true) {
            
            System.out.println("========상영작 목록 =========");
            System.out.println("번호|           제목             |       상영시간       |");            
            
            if(MovieModel.searchScreenTheater(theater) == false) {
                System.out.println("해당 영화관에 등록된 상영작이 없습니다. 상영작을 등록해주세요~");                
            }
            else {
                for(ScreenDTO screen : MovieController.screenList) {
                    if(screen.getTheaterNumber() == theater.getTheaterNumber())
                        System.out.printf("%3d | %21s  |  %s \n", screen.getScreenNumber(), MovieModel.translateMovieName(screen.getMovieNumber()), screen.getScreenTime());
                }
            }                    
            System.out.println("==============================");
            
            int selectMenu = Util.scanInt("1.상영작 등록 2.상영작 정보 수정 3.상영작 정보 삭제 0.뒤로 가기");
            
            if(selectMenu == 1) {
                ScreenController.addScreen(theater);
            }else if(selectMenu == 2){
                ScreenController.modifyScreen(theater);                
            }else if(selectMenu == 3){
                ScreenController.deleteScreen(theater);  
                break;
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
        
    }  
    
    public static void showTheaterList(List<TheaterDTO> theaterList) {
       
        System.out.println("========등록 영화관 목록 =========");
        System.out.println("번호|           영화관명             |");
                
        if(MovieController.theaterNumberSet == 1) {
            System.out.println("등록된 영화관이 없습니다. 영화관을 등록해주세요~");                
        }
        else {
            for(TheaterDTO theater : theaterList) {
                System.out.printf("%3d | %s\n", theater.getTheaterNumber(), theater.getTheaterName());
            }
        }
        System.out.println("==================================");
        
    }    

    public static void showMovieList(List<MovieDTO> movieList) {
        
        System.out.println("========등록 영화 목록 =========");
        System.out.println("번호|           영화제목             |");
                
        if(MovieController.movieNumberSet == 1) {
            System.out.println("등록된 영화가 없습니다. 영화를 등록해주세요~");                
        }
        else {
            for(MovieDTO movie : movieList) {
                System.out.printf("%3d | %s\n", movie.getMovieNumber(), movie.getMovieTitle());
            }
        }
        System.out.println("================================");
        
    }
    
    

    public static void showMovieInfoForCustomer(MovieDTO movie) {
        
        while(true) {
            
            System.out.println("========영화 정보 조회======");
            System.out.printf("번호 : %d\n", movie.getMovieNumber());
            System.out.printf("제목 : %s\n", movie.getMovieTitle());       
            String mr = MovieModel.showMovieRating(movie.getMovieRating());
            System.out.printf("등급 : %s\n", mr);
            System.out.printf("줄거리 : %s \n", movie.getStoryLine());
            double movieGrade = MovieModel.movieGradeAverage(movie.getMovieNumber());            
            if(Double.isNaN(movieGrade) == false)
                System.out.printf("평점 : %3.1f / 5 \n", movieGrade);
            else
                System.out.println("평점 : 아직 등록된 평점이 없습니다. 영화를 평가해주세요~!");            
            System.out.println("=============================");
            
            int selectMenu = Util.scanInt("1.평점 등록 2.관람객 평점 3.평론가 평점 0.뒤로 가기");
            
            if(selectMenu == 1) {
                GradeController.addGrade(movie);                
            }else if(selectMenu == 2){
                showAudienceGrade(movie);
            }else if(selectMenu == 3) {
                showCriticGrade(movie);
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
        
    }

    private static void showAudienceGrade(MovieDTO movie) {
        
        while(true) {
            System.out.println("========관람객 평점 =========");
            if(MovieModel.searchAddedGrade(movie.getMovieNumber(), 0) == false) {
                System.out.println("등록된 관람객 평점이 없습니다. 영화를 평가해주세요~");                
            }
            else {
                for(GradeDTO grade : MovieController.gradeList) {
                    if(MovieModel.checkGradeInfo(grade, movie.getMovieNumber(), 0) == true) {                        
                        System.out.printf("%s | %d / 5 | %s\n", MovieModel.translateMemberNumToNickname(grade.getMemberNumber()), 
                                grade.getGradeScore(), grade.getComment());                        
                    }  
                }
            }
            System.out.println("================================");
            int back = Util.scanInt("0.뒤로 가기");
            if(back == 0)
                break;
            else
                System.out.println("입력 오류. 뒤로 가려면 0 입력");
                
        }        
    }

    private static void showCriticGrade(MovieDTO movie) {
        
        while(true) {
            System.out.println("========평론가 평점 =========");
            if(MovieModel.searchAddedGrade(movie.getMovieNumber(), 1) == false) {
                System.out.println("등록된 평론가 평점이 없습니다. 영화를 평가해주세요~");                
            }
            else {
                for(GradeDTO grade : MovieController.gradeList) {
                    if(MovieModel.checkGradeInfo(grade, movie.getMovieNumber(), 1) == true) {
                        System.out.println("---------------------------------------------------");
                        System.out.printf("%s | %d / 5 | %s\n", MovieModel.translateMemberNumToNickname(grade.getMemberNumber()), 
                                grade.getGradeScore(), grade.getComment());
                        System.out.println("---------------------------------------------------");
                    }  
                }
            }
            System.out.println("================================");
            int back = Util.scanInt("0.뒤로 가기");
            if(back == 0)
                break;
            else
                System.out.println("입력 오류. 뒤로 가려면 0 입력");
                
        }
        
    }
    

    public static void showMovieInfo(MovieDTO movie) {
        
        while(true) {
            
            System.out.println("========영화 정보 조회======");
            System.out.printf("번호 : %d\n", movie.getMovieNumber());
            System.out.printf("제목 : %s\n", movie.getMovieTitle());       
            String mr = MovieModel.showMovieRating(movie.getMovieRating());
            System.out.printf("등급 : %s\n", mr);
            System.out.printf("줄거리 : %s \n", movie.getStoryLine());
            System.out.println("=============================");
            
            int selectMenu = Util.scanInt("1.영화정보 수정 2.영화정보 삭제 0.뒤로 가기");
            
            if(selectMenu == 1) {
                MovieController.modifyMovie(movie);                
            }else if(selectMenu == 2){
                MovieController.deleteMovie(movie);
                break;
            }else if(selectMenu == 0){
                break;
            }else {
                System.out.println("입력 오류. 메뉴 숫자 확인해주세요~!");
            }
        }
    }

    
    

}
