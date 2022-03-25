package movieManager.controller;

import movieManager.model.GradeDTO;
import movieManager.model.MovieDTO;
import movieManager.model.MovieModel;
import movieManager.model.Util;

public class GradeController {
    
    
public static void addGrade(MovieDTO movie) {
        
        GradeDTO grade = new GradeDTO();
        
        grade.setMovieNumber(movie.getMovieNumber());
        grade.setGradeNumber(MovieController.gradeNumberSet++);
        grade.setMemberNumber(MovieController.memberDTO.getUserNumber());
                
        // 이미 평점을 달았으면 덮어쓰는 형태로 한 영화에 하나만 평가할 수 있게 한다.
        if(MovieModel.searchAddedGrade(movie.getMovieNumber()) == true) {
            System.out.println("이전에 평점 달았던 영화입니다. 다시 갱신해서 등록됩니다.");
            grade = MovieModel.searchAddedGrade(movie.getMovieNumber(), MovieController.memberDTO);
        }
        
        while(true) {
            grade.setGradeScore(Util.scanInt("평점 등록해주세요(1~5)"));
            if(grade.getGradeScore() >= 1 && grade.getGradeScore() <= 5) {
                break;
            }
            else
                System.out.println("입력 오류. 1에서 5사이 숫자 입력하세요~!");
        }
        grade.setComment(Util.scanString("감상평을 작성해주세요"));
        
        if(MovieModel.searchAddedGrade(movie.getMovieNumber()) == true) {}        
        else 
            MovieController.gradeList.add(grade);
        
        
        
        if(MovieController.memberDTO.getUserLevel() == 1) {
            System.out.println("평론가 자격으로 평점이 등록되었습니다.");
        }
        else if(MovieController.memberDTO.getUserLevel() == 0){
            System.out.println("관람객 자격으로 평점이 등록되었습니다.");
        }
        else
            System.out.println("고객 등급 오류 확인 필요");                    
        
    }

}
