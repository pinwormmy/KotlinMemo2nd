package day0311;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 로또 5.0
// 자동 수동 선택

// 지정한 횟수의 게임하게 제작
// 결과창에서 옆에 맞은 갯수 표기

public class Ex04Lotto05 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
   
        while(true){
            
            System.out.print("몇 게임하시겠습니까? : ");
            int gameTime = scanner.nextInt();
            
            if(gameTime <= -1)
                System.out.println("입력이 잘못되었습니다. 1이상 입력하세요");
            else if(gameTime > 10)
                System.out.println("중독방지법에 의거, 한번에 10게임 넘게 할 수 없습니다.");
            else if(gameTime == 0)
                
            {
                System.out.println("프로그램 종료");
                break;
            }
            else {
                int inputNumber;
                int [][] inputLottoSet = new int[gameTime][6];
                int [][] correctLottoSet = new int[gameTime][6];
                
                Random random = new Random();
                
                
                int recentTime = 0;
                while(recentTime < gameTime) {
                    
                    System.out.printf("%d번째 게임---------\n", recentTime+1);
                    System.out.print("게임방식을 선택하세요(1:자동 2:수동): ");
                    int gameType = scanner.nextInt();
                    
                        if(gameType == 1) {
                            
                            int index = 0;
                            while(index <= 5) {
                                
                                inputLottoSet[recentTime][index] = random.nextInt(1, 45 + 1);
                                
                                for(int i=0; i < index; i++) {
                                    
                                    if(inputLottoSet[recentTime][i] == inputLottoSet[recentTime][index]) {
                                        index--;
                                        break;
                                    }
                                }
                                
                                index++;
            
                            }
                           
                            Arrays.sort(inputLottoSet[recentTime]);                    
                            
                            for(int j=0; j < 6; j++) {
                                System.out.printf("%d ", inputLottoSet[recentTime][j]);
                            }
                            System.out.println("");
                            
                            recentTime++;
                        }
                        
                    else if(gameType ==2) {
                        
                        int index = 0;
                        while(index <= 5) {
                            
                            System.out.printf("로또 번호 수동 입력(%d번칸) : ", index+1);
                            inputNumber = scanner.nextInt();
                            
                            if(inputNumber <= 45 && inputNumber >= 1) {
                                
                                inputLottoSet[recentTime][index] = inputNumber;
                                
                                for(int i=0; i <= index-1; i++) {
                                    
                                    if(inputNumber == inputLottoSet[recentTime][i]) {
                                        System.out.println("이미 입력한 숫자입니다. 다시 적으세요...");
                                        index--;
                                        break;
                                    }
                                }
                                index++;
                            }
                            else
                                System.out.println("1~45 숫자를 입력하세요!!!");
                        }
                        
                        Arrays.sort(inputLottoSet[recentTime]);
                        
                        for(int j=0; j < 6; j++) {
                            System.out.printf("%d ", inputLottoSet[recentTime][j]);
                        }
                        System.out.println("");
                        
                        recentTime++;
                        
                    }
                    else
                        System.out.println("게임방식 입력오류: 1과 2중에 입력하세요!");
                }
                
                recentTime = 0;
                while(recentTime < gameTime){
                    
                    int index = 0;
                    while(index <= 5) {
                        
                        correctLottoSet[recentTime][index] = random.nextInt(1, 45 + 1);
                        
                        for(int i=0; i < index; i++) {
                            
                            if(correctLottoSet[recentTime][i] == correctLottoSet[recentTime][index]) {
                                index--;
                                break;
                            }
                        }
                        
                        index++;

                    }
                    
                    recentTime++;
                }
                
                recentTime = 0;
                int[] correctCount = new int[gameTime];
                while(recentTime < gameTime) {
                    
                    correctCount[recentTime] = 0;
                    for(int i=0; i< correctLottoSet[recentTime].length; i++) {
                        for(int j=0; j<correctLottoSet[recentTime].length; j++) {
                            if(inputLottoSet[recentTime][i] == correctLottoSet[recentTime][j])
                                correctCount[recentTime]++;
                        }
                    }
                    Arrays.sort(correctLottoSet[recentTime]);
                    recentTime++;
                }
                
                System.out.println("결과))");
                        
                System.out.println("당첨번호 :");
                for(recentTime=0; recentTime < gameTime; recentTime++) {
                    System.out.printf("%2d번째 게임 :", recentTime+1);
                    for(int j=0; j < 6; j++) {
                        System.out.printf("%2d ", correctLottoSet[recentTime][j]);
                    }
                    System.out.printf(" : 맞은숫자 %2d개 \n", correctCount[recentTime]);
                }
                System.out.println("프로그램 종료 GG~");
                break;
            }
        }
        scanner.close();
    }
        
}
