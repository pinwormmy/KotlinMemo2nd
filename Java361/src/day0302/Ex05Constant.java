package day0302;

// 상수는 딱 한 번 값 저장. 이후 변경 불가능. 변수의 반댓말

public class Ex05Constant {
    
    public static void main(String[] args) {
        
        final int NUMBER;
        NUMBER = 20;
        System.out.println(NUMBER);
        
        // NUMBER = 30; 상수라서 값 변경 불가능
    }
}
