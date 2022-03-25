package day0308;

import java.util.Scanner;

public class Ex13StarPrint06 {
    
    public static void main(String[] args) {
        
        System.out.println("============= 별 찍기 6 ===============");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("별갯수 입력 : ");
        int starNumber = scanner.nextInt();
        
        for(int i=starNumber; i>=1; i--) {
            
            for(int o=(starNumber-i); o>0; o--)
                System.out.print(" ");
            
            for(int j=(i*2-1); j>=1; j--) 
                System.out.print("*");
            
            System.out.print("\n");
        }
        
        scanner.close();
    }

}
