package util;

import java.util.Scanner;

// Scanner 메소드 편하게 쓰기 위한 클래스

public class ScannerUtil {
    
    
    public static void printMessage(String message) {
        System.out.println("=====================================");
        System.out.println(message);
        System.out.println("입력해주세요=========================");
    }
    
    
    public static int nextInt(String message) {
        
        Scanner scanner = new Scanner(System.in);
                
        printMessage(message);
        int temp = scanner.nextInt();
        
        return temp;
    }
    
public static String nextLine(String message) {
        
        Scanner scanner = new Scanner(System.in);
                
        printMessage(message);
        String temp = scanner.nextLine();
        
        return temp;
    }
}
