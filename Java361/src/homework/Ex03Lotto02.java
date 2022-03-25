package homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import util.ArrayUtil;

// ArrayUtil 활용해서 동적 할당이 적용된 로또 추첨기 만들기
// 심화 ) 다양한 메소드 만들어서 사용자가 여러 게임 할 수 있게 제작

// 다차원 배열도 ArrayUtil 써먹을 수 있는데, 안되는줄 알고 더 어렵게 삽질.

public class Ex03Lotto02 {
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
                int [] inputLottoSet = new int[1];
                
                int [] correctLottoSet = new int[1];
                
                int recentTime = 0;
                
                int [][] inputLottoPool = new int[recentTime][];
                int [][] correctLottoPool = new int[recentTime][];
                
                inputLottoSet[0] = recentTime;
                correctLottoSet[0] = recentTime;
                
                while(recentTime < gameTime) {
                    
                    System.out.printf("%d번째 게임---------\n", recentTime+1);
                    System.out.print("게임방식을 선택하세요(1:자동 2:수동): ");
                    int gameType = scanner.nextInt();
                    
                        if(gameType == 1) {
                                                        
                            autoLotto(inputLottoPool[recentTime], recentTime);
                           
                            for(int j=(recentTime+1)*6-5; j < inputLottoSet.length; j++) 
                                System.out.printf("%d ", inputLottoSet[j]);
                            
                            System.out.println("");
                           
                            recentTime++;
                        }
                        
                    else if(gameType ==2) {
                        
                        int index = 0;
                        while(index <= 5) {
                            
                            System.out.printf("로또 번호 수동 입력(%d번칸) : ", index+1);
                            inputNumber = scanner.nextInt();
                            
                            if(inputNumber <= 45 && inputNumber >= 1) {
                                
                                inputLottoSet[index] = inputNumber;
                                
                                for(int i=0; i <= index-1; i++) {
                                    
                                    if(inputNumber == inputLottoSet[i]) {
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
                        
                        Arrays.sort(inputLottoSet, (recentTime+1)*6-5, (recentTime+1)*6);
                        
                        for(int j=0; j < 6; j++) {
                            System.out.printf("%d ", inputLottoSet[j]);
                        }
                        System.out.println("");
                        
                        recentTime++;
                        
                    }
                    else
                        System.out.println("게임방식 입력오류: 1과 2중에 입력하세요!");
                }
                
                recentTime = 0;
                while(recentTime < gameTime){
                    
                    autoLotto(correctLottoSet, recentTime);
                    
                    recentTime++;
                }
                
                recentTime = 0;
                int[] correctCount = new int[gameTime];
                while(recentTime < gameTime) {
                    
                    autoLotto(correctLottoSet, recentTime);
                    
                    for(int j=1; j < correctLottoSet.length; j++) 
                        System.out.printf("%d ", inputLottoSet[j]);
                    
                    //Arrays.sort(correctLottoSet, (recentTime+1)*6-5, (recentTime+1)*6);
                    System.out.println("");
                    recentTime++;
                }
                
                System.out.println("결과))");
                        
                System.out.println("당첨번호 :");
                for(recentTime=0; recentTime < gameTime; recentTime++) {
                    System.out.printf("%2d번째 게임 :", recentTime+1);
                    
                    for(int j=1; j < correctLottoSet.length; j++) {
                        System.out.printf("%2d ", correctLottoSet[j]);
                    }
                    
                    System.out.printf(" : 맞은숫자 %2d개 \n", correctCount[recentTime]);
                    System.out.println("");
                }
                System.out.println("");
                System.out.println("프로그램 종료 GG~");
                break;
            }
        }
        scanner.close();
    }
    
    public static void autoLotto(int lottoSet[], int round) {
        
        Random random = new Random();
        
        for(int i=0; i<=5; i++) {
            
            int lottoNum = random.nextInt(1, 45 + 1);
            
            if(ArrayUtil.contains(lottoSet, lottoNum)) // 앞 회차까지 중복검색 적용되서 오류 발생 ㅋ
                i--;
            else
                lottoSet = ArrayUtil.add(lottoSet, lottoNum);
            
        }
        
        System.out.println("총 몇칸 확인 : " + lottoSet.length);
        
        Arrays.sort(lottoSet, (round+1)*6-5, lottoSet.length);
        
        for(int j=(round+1)*6-5; j < lottoSet.length; j++) 
            System.out.printf("%d ", lottoSet[j]);
        System.out.println("");
                
    }
}
