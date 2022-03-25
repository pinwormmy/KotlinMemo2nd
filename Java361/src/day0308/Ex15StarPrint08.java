package day0308;

import java.util.Scanner;

public class Ex15StarPrint08 {
    
    public static void main(String[] args) {
        
        System.out.println("============= 별 찍기 8 ===============");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("별갯수 입력 : ");
        int starNumber = scanner.nextInt();
        
        for(int i=1; i<=starNumber; i++) {
            
            for(int o=0; o<(starNumber-i); o++)
                System.out.print(" ");
            
            for(int j=1; j<=i; j++) 
                System.out.print("*");
            
            System.out.print("\n");
        }
        for(int i=starNumber-1; i>=1; i--) {
            
            for(int o=(starNumber-i); o>0; o--)
                System.out.print(" ");
            
            for(int j=i; j>=1; j--) 
                System.out.print("*");
            
            System.out.print("\n");
        }
        
        scanner.close();
    }

}
