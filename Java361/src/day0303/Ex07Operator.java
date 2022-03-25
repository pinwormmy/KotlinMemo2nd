package day0303;

// 연산자
// 논리, 산술, 할당, 비교, 비트 연산자 5가지 존재

public class Ex07Operator {
    
    public static void main(String[] args) {
        
        System.out.println("1. 정수끼리 산술 연산");
        
        int a = 3;
        int b = 5;
        
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b); // 소수점 버림
        System.out.println(a % b);
        
        System.out.println("------------------");
        
        System.out.println("2. 실수끼리 산술 연산");
        
        double c = 3;
        double d = 5;
        
        System.out.println(c + d);
        System.out.println(c - d);
        System.out.println(c * d);
        System.out.println(c / d); // 소수점까지 표기
        System.out.println(c % d);
        
        System.out.println("------------------");
        
        System.out.println("3. 정수와 실수 산술 연산");
        
        System.out.println(a + d);
        System.out.println(a - d);
        System.out.println(a * d);
        System.out.println(a / d); // 소수점까지 표기
        System.out.println(a % d);
        
        System.out.println("------------------");
        
        // (번외)String값의 덧셈
        System.out.println("super" + "sonic");
        System.out.println("super" + 123); // 정수값이 String값으로 형변환되어 적용
        System.out.println("123" + 456); // 정수값이 String값으로 형변환되어 적용
        
    }

}
