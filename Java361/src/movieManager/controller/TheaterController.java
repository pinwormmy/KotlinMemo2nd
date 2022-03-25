package movieManager.controller;

import java.util.List;

import movieManager.model.TheaterDTO;
import movieManager.model.Util;
import movieManager.view.MovieView;

public class TheaterController {
    
    static void manageTheater() { 
        
        while(true) {
            
            System.out.println("");
            System.out.println("====[관리자 모드] 영화관 정보 관리====");
            
            MovieView.showTheaterList(MovieController.theaterList);
            
            int selectMenu = Util.scanInt("1.영화관 조회 2.영화관 등록 9.메인으로");
            
            switch(selectMenu) {
            case 1:
                selectTheaterInfo(MovieController.theaterList);
                break;
            case 2:
                addTheater();
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
    
    private static void addTheater() {
        
        TheaterDTO theater = new TheaterDTO();        
        
        System.out.println("영화관 정보 신규 등록======");
        
        theater.setTheaterName(Util.scanString("영화관명"));
        theater.setTheaterNumber(MovieController.theaterNumberSet++);
        theater.setTheatherLocation(Util.scanString("주소"));
        theater.setTheaterPhone(Util.scanString("연락처"));
        
        MovieController.theaterList.add(theater);
        
        System.out.println("새로운 영화관 정보가 등록되었습니다.==========");
        
    }

    private static void selectTheaterInfo(List<TheaterDTO> theaterList) {
        
        while(true) {
            
            int selectTheaterNumber = Util.scanInt("조회할 영화관 번호 입력(0.뒤로가기)");
            
            if(selectTheaterNumber == 0)
                break;
            
            if(MovieController.theaterNumberSet == 1) {
                System.out.println("등록된 영화관이 없습니다. 영화관을 등록해주세요~");
                break;
            }else {
                
                for(TheaterDTO theater : theaterList) {
                    if(theater.getTheaterNumber() == selectTheaterNumber){
                        MovieView.showTheaterInfo(theater);
                    break;
                    }else {
                        System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                    }
                }
            }
        }
        
    }
    
    static void selectTheaterInfoForCustomer(List<TheaterDTO> theaterList) {
        
        while(true) {
            
            int selectTheaterNumber = Util.scanInt("조회할 영화관 번호 입력(0.뒤로가기)");
            
            if(selectTheaterNumber == 0)
                break;
            
            if(MovieController.theaterNumberSet == 1) {
                System.out.println("등록된 영화관이 없습니다. 영화관을 등록해주세요~");
                break;
            }else {
                
                for(TheaterDTO theater : theaterList) {
                    if(theater.getTheaterNumber() == selectTheaterNumber){
                        MovieView.showTheaterInfoForCustomer(theater);
                    break;
                    }else {
                        System.out.println("번호 잘못 입력했습니다. 확인해주세요");
                    }
                }
            }
        }        
    }
    
public static void deleteTheater(TheaterDTO theater) {
        
        while(true) {
            String question = Util.scanString("정말 해당 영화관 정보를 삭제하겠습니까?(y/n)");
            if(question.equalsIgnoreCase("y")) {
                MovieController.theaterList.remove(theater);
                break;
            }
            else if(question.equalsIgnoreCase("n")){
                System.out.println("삭제를 취소합니다.");
                break;
            }else
                System.out.println("입력 오류. y나 n 중 입력해주세요...");
        }
        
    }

    public static void modifyTheater(TheaterDTO theater) {
        
        System.out.println("영화관 정보 수정======");
        
        theater.setTheaterName(Util.scanString("영화관명(" + theater.getTheaterName() + ")"));
        theater.setTheatherLocation(Util.scanString("주소(" + theater.getTheatherLocation() + ")"));
        theater.setTheaterPhone(Util.scanString("연락처(" + theater.getTheaterPhone() + ")"));
                
       
        System.out.println("영화관 정보가 수정되었습니다.==========");
        
    }

}
