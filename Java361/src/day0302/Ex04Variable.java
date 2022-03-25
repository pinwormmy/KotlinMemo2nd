package day0302;

// 변수(variable) 변경할 수 있는 값. 그것의 저장공간
// 선언 과 초기화를 거쳐야 사용가능

public class Ex04Variable {
    
    public static void main(String[] args) {
        
        int number;
        
        number = 20;
        
        System.out.println(number);
        
        number = 30;
        
        System.out.println(number);
        
        
        // 변수의 선언과 초기화는 한줄로 가능
        int number2 = 45;
        System.out.println(number2);
        
        // 같은 이름의 변수를 여러개 선언할 수 없음
        // int number2;
        
        number = 80;
        
        // (당연하지만) 선언하지 않은 변수에 값을 저장하거나 호출할 수 없음
        
        // 값을 할당할 때는 왼쪽에 무조건 공간을, 오른쪽에 값으로 작성
        // 100 = number;
        
        System.out.println(number);
        
        number = number2;
        
        System.out.println(number);
    }

}
