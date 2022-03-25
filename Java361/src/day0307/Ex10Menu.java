package day0307;

import java.util.Scanner;

// 메뉴 조건부 무한반복 프로그램

public class Ex10Menu {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("1.입력 2.출력 3.종료 : ");
            int userChoice = scanner.nextInt();
            
            if(userChoice == 1) {
                System.out.println("어차피 입력이야 계속하는데?");
                
            }else if(userChoice == 2){
                
                System.out.println("뭐 출력할 만한게 있나?");
                
            }else {
                System.out.println("장비를 정지합니다.");
                break;
            }
            
        }
        
        scanner.close();
    }
}
