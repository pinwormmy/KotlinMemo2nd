package day0307;

// 중첩 if문

public class Ex01NestedIf {

    public static void main(String[] args) {
        
        int number = 100;
        
        if(number >= 0) {
            
            System.out.println("자연수입니다.");
            if(number == 0) 
                System.out.println("0입니다.");
            else if(number < 10)
                System.out.println("한자리 수입니다.");
            else
                System.out.println("두자리 이상의 수입니다.");
        }
        else
            System.out.println("음수입니다.");
    }
    
}
