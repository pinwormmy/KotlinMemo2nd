package day0310;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// 로또 번호 추첨기

public class Ex02Lotto {
    
    public static void main(String[] args) {
        
        final int min_number = 1;
        final int max_number = 45;
        
        int[] lottoNumber = new int[6];
        
        Random random = new Random();
               
        int i=0;
        while(i<6) {
            
            int selectedNumber = random.nextInt(min_number, max_number+1);
            
            if(IntStream.of(lottoNumber).anyMatch(x -> x == selectedNumber) == false) {
                lottoNumber[i] = selectedNumber;
                i++;
            }
        }
        
        Arrays.sort(lottoNumber);
        System.out.println("===로또 번호 추첨기===");
        System.out.println(Arrays.toString(lottoNumber));  
        
        // 배열에서 정수검색함수랑, 정렬 함수는 내맘대로 갖다 쓴거
    }

}
