package day0314;

import java.util.Scanner;

import util.ScannerUtil;

// 전역변수

public class Ex03GlobalVar {
    
    static int[] gradeData = new int[3];
    final static int MIN_SCORE = 0;
    final static int MAX_SCORE = 100;
    
    public static void main(String[] args) {
        
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
        ScannerUtil scan = new ScannerUtil();
                
        while(true){
            
            score = scan.nextInt(subject);
            
            if(score >= MIN_SCORE  && score <= MAX_SCORE) {
                return score;
            }
            else{
                System.out.println("(점수입력오류)0~100 사이 숫자로 다시 입력하세!!");
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
