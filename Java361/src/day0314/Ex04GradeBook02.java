package day0314;



import java.util.Scanner;

import util.ScannerUtil;

public class Ex04GradeBook02 {
    
    static final int STUDENT_NUMBER = 5;
    static final int SUBJECT_NUMBER = 3;
    static final int MIN_SCORE = 0;
    static final int MAX_SCORE = 100;
    
    // 인덱스: 0번호, 1이름, 2국, 3영, 4수
    public static String[][] gradeData = new String[5][5];
    
    static int currentStudentIndex;
    
    public static void main(String[] args) {
        
              
        gradeData[0][0] = "";
          
        Scanner scanner = new Scanner(System.in);
        
        currentStudentIndex = 0;
        
        
        while(true) {
            
            
            System.out.print("성적관리 프로그램(1.입력 2.출력 3.종료) : ");
            int selectMenu = scanner.nextInt();
            
            
            if(selectMenu == 1) {
                for(currentStudentIndex=0; currentStudentIndex < STUDENT_NUMBER; currentStudentIndex++) {
                    System.out.printf("=============%d번째 학생============\n", currentStudentIndex+1);
                    gradeData = inputGrade(currentStudentIndex);
                }
                
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

    public static String[][] inputGrade(int StudentIndex) {
        
        String studentId = inputScore("학생번호");
        gradeData[StudentIndex][0] = studentId;
        
        String studentName = ScannerUtil.nextLine("이름");
        gradeData[StudentIndex][1] = studentName;
                     
        String korean = inputScore("국어");
        gradeData[StudentIndex][2] = korean;
        
        String english = inputScore("영어");
        gradeData[StudentIndex][3] = english;
        
        String math = inputScore("수학");
        gradeData[StudentIndex][4] = math;
        
        System.out.println("성적 입력 완료===================");
         
        return gradeData;
    }
    
    public static String inputScore(String subject) {
        
        int score;
        
        while(true){
            
            score = ScannerUtil.nextInt(subject);
            
            if(score >= 0 && score <= 100) {
                String SScore = String.valueOf(score); 
                return SScore;
            }
            else{
                System.out.println("(숫자입력오류)0~100 사이 숫자로 다시 입력하세!!");
            }
        }
        
    }
    
    public static void readGrade(String gradeData[][]) {
    
        if(gradeData[0][0] == "")
            System.out.println("아직 성적 입력이 안됐습니다~\n");
        else {
            for(currentStudentIndex=0; currentStudentIndex < STUDENT_NUMBER; currentStudentIndex++) {
                
                System.out.printf("=============%d번째 학생============= \n", currentStudentIndex+1);
                System.out.println("===============성적 확인=============");
                System.out.printf("번호: %3s 이름: %3s\n",  gradeData[currentStudentIndex][0],  gradeData[currentStudentIndex][1]);                    
                System.out.printf("국어: %3s점 영어: %3s점 수학: %3s점\n", 
                        gradeData[currentStudentIndex][2], gradeData[currentStudentIndex][3], gradeData[currentStudentIndex][4]);
                System.out.println("======================================");
            }
            
        }
        
    }

}
