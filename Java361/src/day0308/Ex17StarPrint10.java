package day0308;

import java.util.Scanner;

public class Ex17StarPrint10 {
    
    public static void main(String[] args) {
        
        System.out.println("============= 별 찍기 10 ===============");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("별갯수 입력 : ");
        int starNumber = scanner.nextInt();
        
        for(int i=0; i<=starNumber-1; i++) {
            
            for(int o=0; o<(starNumber-i); o++)
                System.out.print("*");
            
            for(int j=1; j<=(i+i-1); j++) 
                System.out.print(" ");
            
            for(int o=0; o<(starNumber-i); o++) {
                if(i != 0 || o != (starNumber-1)) {
                    System.out.print("*");
                }
            }
                
            
            System.out.print("\n");
        }
        for(int i=starNumber-1; i>=1; i--) {
            
            for(int o=(starNumber-i+1); o>0; o--)
                System.out.print("*");
            
            for(int j=(i*2-3); j>=1; j--) 
                System.out.print(" ");
            
            for(int o=(starNumber-i+1); o>0; o--) {
                if(i != 1 || o != 1) {
                    System.out.print("*");
                }
            }
                 
            System.out.print("\n");
        }
        
        scanner.close();
    }

}
