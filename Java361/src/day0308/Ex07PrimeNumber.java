package day0308;

// for문 사용해서 1~100 사이 소수 구하기

public class Ex07PrimeNumber {

    public static void main(String[] args) {
        
        
        for(int primeNumber = 1; primeNumber <= 100; primeNumber++) {
            
            for(int count = 2; count <= primeNumber; count++) {
                
                
                if((primeNumber % count == 0) && (primeNumber != count))
                {
                    //System.out.printf("소수 아님(재끼끼) %d\n", primeNumber);
                    break;
                    
                }
                else if(primeNumber % count != 0) {
                    //System.out.printf("소수 아님(다음숫자봐야함) %d\n", primeNumber);   
                }            
                else
                    System.out.printf("%d ", primeNumber);
                
            }
            
        }
    }
}
