package movieManager.model;

import java.util.Scanner;

public class Util {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void MessageInScan(String message) {
        System.out.print(message + " : ");
        
    }
    
    public static int scanInt(String message) {
        
        MessageInScan(message);
        int temp = scanner.nextInt();
        
        return temp;
    }
    
    public static String scanString(String message) {
        
        MessageInScan(message);
        String temp = scanner.nextLine();
        
        if (temp.isEmpty()) // 버그 픽스
            temp = scanner.nextLine();
        
        return temp;
    }

}
