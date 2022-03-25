package day0307;

//사용자로부터 점수를 입력받아서

//90점이상: A
//80점대: B
//70점대: C
//60점대: D
//그외: F
//가 출력되는 프로그램을 작성해보세요.

//추가옵션. 잘못된 옵션 입력하면 제대로 입력할 때까지 반복문
// -1 입력시 프로그램 종료하기

import java.util.Scanner;

public class Ex11GradeChecker2 {
 public static void main(String[] args) {
     
     Scanner scanner = new Scanner(System.in);

     int score = -11; // 반복문 진입 위한 임의의 값
     
     while(score < 0 || score > 100) {
      // 1. 점수를 입력받는다.
         System.out.println("점수를 입력해주세요.(-1 입력시 종료)");
         System.out.print("> ");
         score = scanner.nextInt();
      
         
         if(score == -1) {
             System.out.println("프로그램 쓰지도 않았는데 뭐가 감사한진 모르겠지만...이용해주셔서 감사합니다~");
             break;
         }
         
         
         // 2. 점수에 따라서 결과를 출력한다.
            if (score >= 90) {
                // 2-1. 입력한 점수가 90 이상이므로 A를 출력한다.
                System.out.println("A");
            } else if (score >= 80) {
                // 2-2. 입력한 점수가 80대이므로 B를 출력한다.
                System.out.println("B");
            } else if (score >= 70) {
                // 2-3. 입력한 점수가 70대이므로 C를 출력한다.
                System.out.println("C");
            } else if (score >= 60) {
                // 2-4. 입력한 점수가 60대이므로 D를 출력한다.
                System.out.println("D");
            } else {
                // 2-5. 그외는 F를 출력한다.
                System.out.println("F");
            }
     }
           
     
     
     scanner.close();
 } 
}