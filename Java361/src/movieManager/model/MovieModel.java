package movieManager.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import movieManager.controller.MovieController;


public class MovieModel {
    
    public static void setAdministrator(){
        
        MemberDTO administrator = new MemberDTO();
        
        administrator.setUserNumber(MovieController.userNumberSet++);
        administrator.setUserId("administrator");
        administrator.setUserPassword("1111");
        administrator.setUserNickname("관리자");
        administrator.setUserLevel(2); 
        
        MovieController.memberList.add(administrator);
    }
        
    public static boolean CheckDuplicatedId(String userId, List<MemberDTO> list) {
     
        for (MemberDTO memberDTO : list) {
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
    
    public static String showMovieRating(int movieRaatingNum) {
        
        String movieRating = "";
        switch(movieRaatingNum){
        case 0:
            movieRating = "전체 이용가";
            break;
        case 12:
            movieRating = "12세 이용가";
            break;
        case 15:
            movieRating = "15세 이용가";
            break;
        case 19:
            movieRating = "청소년 이용불가";
            break;
        default:
            System.out.println("영화 등급 데이터 오류. 확인 요망");
            break;        
        }
        
        return movieRating;
    }
 
    public static String translateMovieName(int movieNum) {
        
        String movieName="";
        
        for(MovieDTO movie : MovieController.movieList) {
            if(movie.getMovieNumber() == movieNum)
                movieName = movie.getMovieTitle();
        }
        
        return movieName;
    }
    
    public static String translateMemberNumToNickname(int memberNum) {
        
        String nickName="";
        
        for(MemberDTO member : MovieController.memberList) {
            if(member.getUserNumber() == memberNum)
                nickName = member.getUserNickname();
        }
        
        return nickName;
    }
    
    public static boolean searchScreenTheater(TheaterDTO theater) {
        
        for(ScreenDTO screen : MovieController.screenList) {
            if(screen.getTheaterNumber() == theater.getTheaterNumber())
                return true;
        }
        return false;
        
    }
    
    public static boolean searchScreenTheater(int screenNum ,TheaterDTO theater) {
        
        for(ScreenDTO screen : MovieController.screenList) {
            if(screen.getTheaterNumber() == theater.getTheaterNumber() && screen.getScreenNumber() == screenNum)
                return true;
        }
        return false;
    }
    
    public static ScreenDTO searchScreenTheater(int screenNum) {
        
        for(ScreenDTO screen : MovieController.screenList) {
            if(screen.getScreenNumber() == screenNum)
                return screen;
        }
        return null;
    }
    
    public static boolean searchMovieNumber(int movieNum) {
        
        for(MovieDTO movie : MovieController.movieList) {
            if(movie.getMovieNumber() == movieNum)
                return true;
        }
        
        return false;
    }
    
    public static boolean searchAddedGrade(int movieNum) { // 로그인한 사용자가 이전에 이 영화에 평점 달았는지 확인
        
        for(GradeDTO grade : MovieController.gradeList) {
            if(grade.getMovieNumber() == movieNum && grade.getMemberNumber() == MovieController.memberDTO.getUserNumber())
                return true;
        }
        
        return false;
    }
    
    
    
    public static GradeDTO searchAddedGrade(int movieNum, MemberDTO writer) { // 로그인한 사용자가 이전에 달았던 평점 내용을 반환
        
        for(GradeDTO grade : MovieController.gradeList) {
            if(grade.getMovieNumber() == movieNum && grade.getMemberNumber() == MovieController.memberDTO.getUserNumber())
                return grade;
        }
        
        return null;
    }
    
    public static boolean searchAddedGrade(int movieNum, int userLevel) { // 해당영화에 평점이 있는가 userLevel 나눠서 검색. 0:관람객 1:평론가
        
        for(GradeDTO grade : MovieController.gradeList) {
            if(grade.getMovieNumber() == movieNum) {
                for(MemberDTO member : MovieController.memberList) {
                    if(grade.getMemberNumber() == member.getUserNumber() && member.getUserLevel() == userLevel)
                        return true;
                }
            } 
        }        
        return false;
    }   
    
    public static boolean checkGradeInfo(GradeDTO grade, int movieNum, int userLevel) {
        
        if(grade.getMovieNumber() == movieNum) {
            for(MemberDTO member : MovieController.memberList) {
                if(grade.getMemberNumber() == member.getUserNumber() && member.getUserLevel() == userLevel)
                    return true;         
            }
        }
        
        return false;
    }
    
    public static double movieGradeAverage(int movieNum) {
        
        double gradeAverage = 0;
        int index = 0;
        for(GradeDTO grade : MovieController.gradeList) {
            
            if(grade.getMovieNumber() == movieNum)
            {
                gradeAverage += grade.getGradeScore();
                index++;
            }
        }         
        gradeAverage = (double)gradeAverage / index;        
        
        return gradeAverage;
    }
    
    
    
    
}


