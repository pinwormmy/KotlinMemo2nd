package day0311;

import java.util.Scanner;

// 로또 번호 추출기 ver 3.0

public class Ex01Lotto03 {

    public static void main(String[] args) {
        
        int[] lottoNumberSet = new int[6];
        
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
        
        // selection sort
        for(int i=0; i<lottoNumberSet.length -1; i++) {
            
            int leastNumberIndex=i;
            
            for(int j=i+1; j< lottoNumberSet.length; j++) {
                
                if(lottoNumberSet[leastNumberIndex] > lottoNumberSet[j]) {
                    leastNumberIndex = j;
                }
            }
            
            int temp = lottoNumberSet[i];
            lottoNumberSet[i] = lottoNumberSet[leastNumberIndex];
            lottoNumberSet[leastNumberIndex] = temp;
        }
        
        for(int i=0; i< lottoNumberSet.length; i++)
            System.out.print(lottoNumberSet[i] + " ");
        
    }
    
}
