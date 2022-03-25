package day0303;

// 논리연산자

// boolean(참,거짓)에 대한 연산

public class Ex10Operator04 {
    
    public static void main(String[] args) {
        
        System.out.println("1. and");
        System.out.println("true && true : " + (true && true));
        System.out.println("true && false : " + (true && false));
        System.out.println("false && true : " + (false && true));
        System.out.println("false && false : " + (false && false));
        
        System.out.println("2. or");
        System.out.println("true || true : " + (true || true));
        System.out.println("true || false : " + (true || false));
        System.out.println("false || true : " + (false || true));
        System.out.println("false || false : " + (false || false));
        
        System.out.println("3. not");
        System.out.println("!true : " + !true);
        System.out.println("!false : " + !false);
        
        int x = 5;
        // System.out.println(0<= x <=10); 수학공식처럼 주절주절 쓰는게 아니다. 
        // 여기선 0<=x 에 대한 답이 0이나 1로 나와버려서 두번째 비교는 엉뚱한 값이랑 하는 문제가 생김
        System.out.println("0<= x <=10 : " + (0<= x && x <=10)); // and연산자 활용해서 문법에 맞게 수정
                
    }

}
