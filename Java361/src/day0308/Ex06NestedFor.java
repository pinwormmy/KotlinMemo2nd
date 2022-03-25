package day0308;

// 중첩 for문

public class Ex06NestedFor {

    public static void main(String[] args) {
        
        for(int i=1; i<=3; i++) {
            
            System.out.println("-------------------------------");
            
            for(int j=1; j<=3; j++) {
                System.out.printf("i의 \n의 현재값 %d  j의 현재값 %d \n", i, j);
            }
            
            System.out.println("-------------------------------");
        }
    }
}
