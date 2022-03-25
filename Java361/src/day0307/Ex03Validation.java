package day0307;

// 검증(Validation)

import java.util.Scanner;

public class Ex03Validation {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // 1. 점수를 입력받는다.
        System.out.println("점수를 입력해주세요.");
        System.out.print("> ");
        int score = scanner.nextInt();
        
        // 2. 점수에 따라서 결과를 출력한다.
        
        // 그니까 전체 검증 코드를 제일 윗쪽 옵션에 추가하면 되지..
        
        if(score < 0 || score > 100) { // 검증 조건문. 점수 범위(0~100) 이외 숫자는 오류라 출력하기
            System.out.println("입력값 오류");
        }else if (score >= 90) {
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
        }else{
            // 2-5. 그외는 F를 출력한다.
            System.out.println("F");
        }

        scanner.close();
    }
}
