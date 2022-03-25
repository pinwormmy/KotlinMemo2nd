package homework;

import java.util.Scanner;

// 숙제
// 입력, 출력, 종료 기능을 가지고 있는 학생 성적 출력 프로그램을 만들되,
// 점수를 사용자가 입력하면 올바른 점수를 리턴해주는 메서드를 만들어서
// 국어, 영어, 수학 점수를 입력 받을때 해당 메서드를 사용하시고
// 출력도 별개의 메서드로 분리해서 프로그램을 작성하긔
// 입력 메소드, 출력 메소드 따로. / 종료(메인메뉴) 메소드는 메인 메소드 포함

public class Ex01GradeBook {
    public static void main(String[] args) {
        
        int[] gradeData = new int[3];
        
        gradeData[0] = -1;
          
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            
            
            System.out.print("성적관리 프로그램(1.입력 2.출력 3.종료) : ");
            int selectMenu = scanner.nextInt();
            
            if(selectMenu == 1) {
                gradeData = inputGrade();
            }
            else if(selectMenu == 2) {
                readGrade(gradeData);
            }
            else if(selectMenu == 3) {
                System.out.println("프로그램을 종료합니다.....");
                break;
            }
            else {
                System.out.println("1~3 중에 입력해주세요");
            }
        }
        
        scanner.close();
    }

    public static int[] inputGrade() {
        
        int[] gradeData = new int[3];
             
        int korean = inputScore("국어");
        gradeData[0] = korean;
        
        int english = inputScore("영어");
        gradeData[1] = english;
        
        int math = inputScore("수학");
        gradeData[2] = math;
        
        System.out.println("성적 입력 완료===================");
         
        return gradeData;
    }
    
    public static int inputScore(String subject) {
        
        int score;
        
        System.out.printf("%s 점수 입력하세요 : ", subject);
        
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            score = scanner.nextInt();
            
            if(score >= 0 && score <= 100) {
                return score;
            }
            else{
                System.out.print("(점수입력오류)0~100 사이 숫자로 다시 입력하세요 : ");
            }
        }
        
    }
    
    public static void readGrade(int[] score) {
    
        if(score[0] == -1)
            System.out.println("아직 성적 입력이 안됐습니다~\n");
        else {
            System.out.println("===============성적 확인=============");
            System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", score[0], score[1], score[2]);
            System.out.println("======================================");
        }
        
    }
}
