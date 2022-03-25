package day0303;

// 변수 선언 및 호출 예제

public class Ex05PrimitiveTypes {
    
    public static void main(String[] args) {
        
        System.out.println("1. 정수형 데이터 타입");
        
        byte a = 10;
        // byte b = 128; 에러 발생
        
        System.out.println(a);
        
        System.out.println("=========================");
        
        System.out.println("2. 실수형 데이터 타입 ");
        
        float c = 1.2345f;
        System.out.println(c);
        
        double d = 0.43413;
        System.out.println(d);
        
        System.out.println("=========================");
        
        System.out.println("3. 문자형 데이터 타입 ");
        
        char f = 'Z';
        System.out.println(f);
        char g = 103;
        System.out.println(g);
        
        System.out.println("=========================");
        
        System.out.println("4. 논리형 데이터 타입 ");
        
        boolean h = false;
        System.out.println(h);
    }

}
