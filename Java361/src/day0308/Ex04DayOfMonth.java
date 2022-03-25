package day0308;

import java.util.Scanner;

public class Ex04DayOfMonth {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("월 입력 : ");
        
        int month = scanner.nextInt();
        
        switch(month) {
        case 2 :
            System.out.println("말일은 28일입니다.");
            break;
        case 4, 6, 9, 11 :
            System.out.println("말일은 30일입니다.");
            break;
        case 1, 3, 5, 7, 8, 10, 12 :
            System.out.println("말일은 31일입니다.");
            break;
        }
        
        scanner.close();
        
    }

}
