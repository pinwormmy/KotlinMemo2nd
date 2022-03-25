package day0310;

import java.util.Random;

// 로또 번호 추첨기 ver 2.0
// 짜다가 수업종료.

public class Ex03Lotto02 {

    public static void main(String[] args) {
        
        Random random = new Random();
   
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;
        final int MAX_DIGIT = 6;
        
        int[] lottoNumberSet = new int[MAX_DIGIT];
        
        for(int i=0; i< MAX_DIGIT;) {
            boolean non_duplication; // 추첨 번호가 중복이 '아니면' true
            
            for(int j=0; j<MAX_DIGIT; j++) {
            
                
            }
            
            int lotteryNumber = random.nextInt(MIN_NUMBER, MAX_NUMBER+1);
        }
        
        
    }
}
