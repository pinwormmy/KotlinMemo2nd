package day0308;

import java.util.Scanner;

public class Ex09StarPrint02 {
    
    public static void main(String[] args) {
            
        System.out.println("============= 별 찍기 2 ===============");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("별갯수 입력 : ");
        int starNumber = scanner.nextInt();
        
        for(int i=starNumber; i>=1; i--) {
            for(int j=i; j>=1; j--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        
        scanner.close();
    }
}
