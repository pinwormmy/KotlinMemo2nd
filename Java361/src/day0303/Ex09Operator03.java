package day0303;

// 비교연산자

public class Ex09Operator03 {
    
    public static void main(String[] args) {
        
        int a = 5;
        int b = 8;
        
        System.out.println("1. <, > 연산자");
        System.out.println("b < 100 : " + (b < 100));
        System.out.println("b < a : " + (b < a));
        System.out.println("a < 5 : " + (a < 5));
        System.out.println("b < 100 : " + (b < 100));
        System.out.println("b < a : " + (b < a));
        System.out.println("a < 5 : " + (a < 5));
        
        System.out.println("2. <=, >=연산자 ");
        System.out.println("b <= 100 : " + (b <= 100));
        System.out.println("b >= a : " + (b >= a));
        System.out.println("a <= 5 : " + (a <= 5));
        
        System.out.println("3. == 연산자 ");
        System.out.println("b == 100 : " + (b == 100));
        System.out.println("b == 8 : " + (b ==8));
        System.out.println("a == 5 : " + (a == 5));
        
        System.out.println("4. != 연산자 ");
        System.out.println("b != 100 : " + (b != 100));
        System.out.println("b != 8 : " + (b !=8));
        System.out.println("a != 5 : " + (a != 5));
        
        String string1 = "abc";
        String string2 = new String("abc");
        String string3 = string1;
        
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        
        // string2는 new 연산자를 통해서 다른 주소에 문자열을 저장해서 그렇다.
        // 정리하면 string type에 ==로 비교하면 문자열 내용을 비교하는 게 아니라, 참조된 주소값을 비교한다.
        System.out.println("string1 == string2 : " + (string1 == string2));
        System.out.println("string1 == string3 : " + (string1 == string3));
        System.out.println("string2 == string1 : " + (string2 == string1));
        
        // 문자열 내용으로 비교하려면 equals메소드 사용하면 됨
        
        System.out.println("string1 과 string2의 문자열 비교 : " + string1.equals(string2));
        System.out.println("string1 과 string3의 문자열 비교 : " + string1.equals(string3));
        System.out.println("string2 과 string1의 문자열 비교 : " + string2.equals(string1));
    }
}
