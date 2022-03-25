package day0308;

import java.util.Random;

// 난수(Random Number)

public class Ex01Random {
    
    public static void main(String[] args) {
        
        Random random = new Random();
        
        System.out.println(random.nextDouble());
        
        System.out.println(random.nextInt());
        
        System.out.println("창돼지 금주 로또 번호는 !?!?!?");
        System.out.println(random.nextInt(1,46));
        System.out.println(random.nextInt(1,46));
        System.out.println(random.nextInt(1,46));
        System.out.println(random.nextInt(1,46));
        System.out.println(random.nextInt(1,46));
        System.out.println(random.nextInt(1,46));
        
        
        System.out.println(random.nextInt(2));
       
        
    }

}
