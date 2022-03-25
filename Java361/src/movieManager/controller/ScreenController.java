package movieManager.controller;

import movieManager.model.MovieModel;
import movieManager.model.ScreenDTO;
import movieManager.model.TheaterDTO;
import movieManager.model.Util;
import movieManager.view.MovieView;

public class ScreenController {
    
    
    public static void deleteScreen(TheaterDTO theater) {
        
        ScreenDTO screen = new ScreenDTO();
        
        while(true) {
            
            while(true) {
                int screenNum = Util.scanInt("삭제할 상영작 번호 입력하세요");
                
                if(MovieModel.searchScreenTheater(screenNum, theater) == true) {                
                    screen = MovieModel.searchScreenTheater(screenNum);
                    break;
                }else {
                    System.out.println("잘못된 입력입니다. 상영작 번호 잘 확인해보세요;;");
                }
            }
                        
            String question = Util.scanString("정말 해당 영화관 정보를 삭제하겠습니까?(y/n)");
            
            if(question.equalsIgnoreCase("y")) {
                MovieController.screenList.remove(screen);
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println("삭제를 취소합니다.");
                break;
            }else
                System.out.println("입력 오류. y나 n 중 입력해주세요...");
        }         
    }
    
    public static void modifyScreen(TheaterDTO theater) {
        
        ScreenDTO screen = new ScreenDTO();
        
        System.out.println("상영 정보 수정======");
       
        
        while(true) {
            
            int screenNum = Util.scanInt("수정할 상영작 번호 입력하세요");
            
            if(MovieModel.searchScreenTheater(screenNum, theater) == true) {                
                screen = MovieModel.searchScreenTheater(screenNum);
                break;
            }else {
                System.out.println("잘못된 입력입니다. 상영작 번호 잘 확인해보세요;;");
            }
        } 
        
        while(true) {
            MovieView.showMovieList(MovieController.movieList);
            int movieNumber = Util.scanInt("영화번호(" + screen.getMovieNumber() + ")");
            
            if(MovieModel.searchMovieNumber(movieNumber) == true) {
                screen.setMovieNumber(movieNumber); 
                break;
            }
            else
                System.out.println("잘못된 번호입니다. 확인바랍니다.");
        }
        
        
        screen.setScreenTime(Util.scanString("상영시간(" + screen.getScreenTime() + ")"));               
        
        System.out.println("영화 정보가 수정되었습니다.==========");
    }

    public static void addScreen(TheaterDTO theater) {
        
        ScreenDTO screen = new ScreenDTO();        
        
        System.out.println("상영 정보 신규 등록======");
        
        screen.setTheaterNumber(theater.getTheaterNumber());
        screen.setScreenNumber(MovieController.screenNumberSet++);
        
        while(true){
            MovieView.showMovieList(MovieController.movieList);
            
            int movieNumber = Util.scanInt("상영할 영화, 번호로 입력하세요");
                        
            if(MovieModel.searchMovieNumber(movieNumber) == true) {
                screen.setMovieNumber(movieNumber); // 입력 제대로 된거 확인반복문
                break;
            }
            else
                System.out.println("잘못된 번호입니다. 확인바랍니다.");
        }
        
        screen.setScreenTime(Util.scanString("상영 시간 입력(1/23 13:45 ~ 14:55 형식으로)"));
        
        
        MovieController.screenList.add(screen);
        
        System.out.println("새로운 상영 정보가 등록되었습니다.==========");
        
    }

}
