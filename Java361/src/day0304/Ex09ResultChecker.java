package day0304;

import java.util.Scanner;

// 학원에서 강의 들음

public class Ex09ResultChecker {
    
    public static void main(String[] args) {
        
        // 상수 적용
        final int AVERAGE_MINIMUM = 70;
        final int SCORE_MINIMUM = 60;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("국어 점수 입력 : ");
        int korean =scanner.nextInt();
        System.out.print("영어 점수 입력 : ");
        int english =scanner.nextInt();
        System.out.print("수학 점수 입력 : ");
        int math =scanner.nextInt();
        
        double average = (double)(korean + english + math) / 3;
        
        if(korean < 0 || korean > 100 || english < 0 || english > 100 || math < 0 || math > 100) // 각 과목 점수가 0~100점 범위 밖 숫자면 입력 오류로 간주
            System.out.println("점수 입력이 잘못되었습니다.");
        else if(korean < SCORE_MINIMUM || english < SCORE_MINIMUM || english < SCORE_MINIMUM)
            System.out.printf("%d점 미만 과목 있어서 탈락!~ \n", SCORE_MINIMUM);
        else if(average < AVERAGE_MINIMUM)
            System.out.printf("평균이 %d점이 안되서 탈락~! \n", AVERAGE_MINIMUM);
        else
            System.out.println("오 합격~~");
    
        scanner.close();
    }
        
}
