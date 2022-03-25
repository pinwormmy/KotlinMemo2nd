package day0311;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 로또 추첨기 ver 4.0

public class Ex02Lotto04 {

    public static void main(String[] args) {
        
        int[] lottoNumberSet = new int[6];
        int[] realLottoNumberSet = new int[6];
        
        Scanner scanner = new Scanner(System.in);
        
        int index = 0;
        while(index <= 5) {
            
            System.out.printf("로또 번호 수동 입력(%d번칸) : ", index+1);
            int inputNumber = scanner.nextInt();
            
            if(inputNumber <= 45 && inputNumber >= 1) {
                
                lottoNumberSet[index] = inputNumber;
                
                for(int i=0; i <= index-1; i++) {
                    
                    if(inputNumber == lottoNumberSet[i]) {
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
        
        scanner.close();
        
        Arrays.sort(lottoNumberSet);
        
        System.out.println("");
        System.out.println("입력하신 로또번호는 "); 
        System.out.println(Arrays.toString(lottoNumberSet) + "입니다.");  
        
        
        Random random = new Random();
        
        index = 0;
        while(index <= 5) {
            
            realLottoNumberSet[index] = random.nextInt(1, 45 + 1);
            
            for(int i=0; i < index; i++) {
                
                if(realLottoNumberSet[i] == realLottoNumberSet[index]) {
                    index--;
                    break;
                }
            }
            
            index++;

        }
        
        System.out.println("");
        
        Arrays.sort(realLottoNumberSet);
        System.out.println("====오늘의 당첨번호====");
        System.out.println(Arrays.toString(realLottoNumberSet));  
        System.out.println("=======================");
        
        int correctCount = 0;
        
        for(int i=0; i< realLottoNumberSet.length; i++) {
            for(int j=0; j<realLottoNumberSet.length; j++) {
                if(lottoNumberSet[i] == realLottoNumberSet[j])
                    correctCount++;
            }
        }
        
        System.out.printf("당첨된 번호 갯수는 %d입니다.\n", correctCount);
        
        // 보너스 번호 없어서 2등은 없다;
        
        if(correctCount == 6)
            System.out.println("대박. 1등입니다. 진짜 로또 긁으러 가보세요;;");
        else if(correctCount == 5)
            System.out.println("오우 3등입니다. 3등도 대박인데 ㄷㄷ");
        else if(correctCount == 4)
            System.out.println("올ㅋ 4등입니다. 오만원~");
        else if(correctCount == 3)
            System.out.println("5등입니다. 5천원 당첨~~");
        else
            System.out.println("꽝~~다음 기회에~~~");
    }
}
