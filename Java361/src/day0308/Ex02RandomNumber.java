package day0308;

import java.util.Random;
import java.util.Scanner;

// 랜덤 게임

public class Ex02RandomNumber {

    public static void main(String[] args) {
    
        Random random = new Random();
   
        int bestRecord = -1;
        
        
        System.out.println("미도리가~좋아하는~랜덤~게임~!!");
      
        Scanner scanner = new Scanner(System.in);
                
        while(true) {
            
            System.out.print("1.게임시작 2.최고기록 출력 3.종료 : ");
            int selectMenu = scanner.nextInt();
            
            if(selectMenu == 1) {
                
                System.out.println("게임을 시작합니다~~~~~~~~~~~~~~~!");
                
                int targetNumber = random.nextInt(1, 101);
                int chance = 0;
       
                while(true) {
                    
                    chance++;
                    System.out.printf(" (%d번째 기회!!) \n", chance);
                    System.out.print("1~100 사이 숫자 입력 : ");
                    int inputNumber = scanner.nextInt();
                    
                    if(inputNumber < 1 || inputNumber > 100)
                        System.out.println("숫자 똑바로 입력해라");
                    else if(targetNumber < inputNumber)
                        System.out.println("======Down!======");
                    else if(targetNumber > inputNumber)
                        System.out.println("======Up!======");
                    else {
                        System.out.println("정답~!!");
     
                        if((bestRecord == -1) || (chance < bestRecord)) {
                            System.out.println("@@@@@ 최고기록 갱신!!! @@@@@");
                            bestRecord = chance;
                        }
                        
                        break;
                    }
                }   
                
            }
            else if(selectMenu == 2){
                if(bestRecord == -1)
                    System.out.println("아직 게임기록이 없습니다;...");
                else
                    System.out.printf("현재 최고기록은 [%d회]입니다.\n", bestRecord);
            }
            else {
                System.out.println("프로그램을 종료합니다. 감사합니다.");
                scanner.close();
                break;
            }
        }
        
    }
}
