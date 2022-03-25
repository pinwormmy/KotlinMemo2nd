package day0303;

// 할당 연산자

public class Ex08Operator02 {
    
    public static void main(String[] args) {
        
        int number;
        
        number = 30;
        
        System.out.println("현재값 : " + number);
        
        number += 2;
        
        System.out.println("현재값 : " + number);
        
        number *= 4;
        
        System.out.println("현재값 : " + number);
        
        number -= 64;
        
        System.out.println("현재값 : " + number);
        
        // 5. /=
        // 앞의 공간의 현재 값에 뒤의 값을 나눈 몫을
        // 다시 앞의 공간에 할당해라
        
        // number의 현재 값에 10을 나눈 몫을
        // number에 다시 할당해라      
        
        number /= 10;
        
        // number의 현재 값을 화면에 출력해라
        System.out.println("number의 현재값 : " + number);
        
        // 6. %=
        // 앞의 공간의 현재 값에 뒤에 나눈 나머지를
        // 다시 앞의 공간에 할당해라
        
        // number의 현재 값에 4를 나눈 나머지를
        // number에 할당해라
        number %= 4;
        
        // number의 현재 값을 화면에 출력해라
        System.out.println("number의 현재값 : " + number);
        
        // ++, --
        // ++ 혹은 -- 는 증감연산자라고도 하며 
        // 특이하게도 해당 공간에 값을 1증가시키거나 1 감소시킨다.
        // 단, 변수의 앞에 붙냐, 뒤에 붙냐에 따라서
        // 실행 우선순위가 달라진다.
        
        // 전위 증감연산자
        // 만약 ++ 혹은 --가 변수의 앞에 붙어있으면
        // 전위 증감연산자라 부르며
        // 해당 라인에서 가장 우선순위가 높다.
        // 즉 가장 빨리 실행되는 그룹에 속한다.
        
        // number의 현재 값 출력
        System.out.println("number의 현재 값 : " + number);
        // ++number의 결과값을 화면에 출력해보자
        System.out.println("++number : " + ++number);
        // 위의 87번 라인은 한줄로 작성되어있지만 실제로는 다음과 같은 단계를 거친다.
        // 1. ++number가 실행되서 number의 현재 값이 2에서 1증가한 3이 된다.
        // 2. "++number"라는 String 값으로 변환되서 이어지고
        // "++number: 3"이라는 String값이 결과값이 된다.
        // 3. 2단계의 결과값인 "++number: 3"이라는 결과값이 화면에 출력된다.
        
        // number의 현재 값 출력
        System.out.println("number의 현재값 : " + number);
        
        // 후위 증감 연산자
        System.out.println("number++ : " + number++);
        // number의 현재 값을 화면에 출력해라
        System.out.println("number의 현재값 : " + number);
        
        // 번외
        String name = "김";       
        
        // name의 현재 값을 화면에 출력
        System.out.println("name의 현재값 : " + name);
        
        name += "한얼";
        
     // name의 현재 값을 화면에 출력
        System.out.println("name의 현재값 : " + name);
        
    }
    
}
