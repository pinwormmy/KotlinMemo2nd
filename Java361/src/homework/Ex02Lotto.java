package homework;
// 숙제 2번.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 메서드를 실행시킬 때 파라미터로 값을 넘겨주는 경우
// call by value(값에 의한 호출)과 call by reference(참조에 의한 호출) 
// 이라는 2가지 방법중 하나가 실행됩니다.
// 각각이 무엇인지 그리고 언제 실행되는지를 조사.
// 로또 프로그램에 값 호출이랑 참조 호출 메소드 하나 이상씩 껴서 만들기

/*
엄밀히 따지면, 자바에 Call by reference 는 없다. 
본예제에서 구현한 것도, 주소값을 복사해와서 원본값을 바꾸는 개념이라 
사실은 Call by Value에 속하는 요소이며
굳이 달리 표현하면 Call by Address라고 할 수 있다.
언제 실행되는지에 대해선 모르겠다
*/

public class Ex02Lotto {
    
    // 일단 최근 제작 로또플그램 복붙하고 시작
    
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
                
                int recentTime = 0;
                while(recentTime < gameTime) {
                    
                    System.out.printf("%d번째 게임---------\n", recentTime+1);
                    System.out.print("게임방식을 선택하세요(1:자동 2:수동): ");
                    int gameType = scanner.nextInt();
                    
                        if(gameType == 1) {
                                                        
                            autoLotto(inputLottoSet, recentTime);
                            
                            Arrays.sort(inputLottoSet[recentTime]);                    
                            
                            for(int j=0; j < 6; j++) 
                                System.out.printf("%d ", inputLottoSet[recentTime][j]);
                            
                            System.out.println("");
                            
                            // System.out.printf("숙제 테스트. 배열은 원본값도 바꼈지만, 이건 아니지 : %d\n", recentTime);
                            
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
                    
                    autoLotto(correctLottoSet, recentTime);
                    
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
    
    public static void autoLotto(int lottoSet[][], int round) {
        
        Random random = new Random();
        
        for(int i=0; i<=5; i++) {
            
            lottoSet[round][i] = random.nextInt(1, 45 + 1);
            
            for(int j=0; j < i; j++) {
                
                if(lottoSet[round][j] == lottoSet[round][i]) {
                    i--;
                    break;
                }
            }
        }
        
        /*
        System.out.println("========CallByReference 증거용. 반환값이 따로 없지만, 원본 배열값도 바꿔버려서 같은 값이 나옴");
        Arrays.sort(lottoSet[round]);
        
        for(int j=0; j < 6; j++) {
            System.out.printf("%d ", lottoSet[round][j]);
        }
        System.out.println("");
        */
        // round += 100;   
        // System.out.printf("=========날로 먹는 CallByValue숙제 (테스트용) : %d\n", round);
        
    }
    
}
