package day0307;

import java.util.Scanner;

// 두 자리 양의 정수 입력받는 프로그램

public class Ex06While02 {
    
    public static void main(String[] args) {
        
        int number = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        while(number < 10 || number >= 100) {
            System.out.print("두 자리 양수 입력하시오 : ");
            number = scanner.nextInt();
        }
        
        System.out.printf("입력된 값은 %d입니다.\n", number);
            
            
        
    }

}
