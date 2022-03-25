package day0303;

// 자바 콘솔 화면에 출력하는 3가지 방법

public class Ex11Print {

    public static void main(String[] args) {
        
        String s1 = "abcd";
        String s2 = "efgh";
        
        // 기본 출력문
        System.out.print(s1);
        System.out.print(s2);
        
        // 줄바꿈
        System.out.println(s1);
        System.out.println(s2);
        
        System.out.printf("%s", s1);
        System.out.printf("%s", s2);
        
        // 이스케이프 문자 : 프로그래밍 코드랑 겹치면 문제가 되는 문자들은 별도 표기법으로 사용
        
        // newline
        System.out.print(s1 + '\n');
        System.out.print(s2 + "\n\n" + s1);
        // tab
        System.out.println(s1 + '\t' + s2);
        // '(따옴표) 프로그래밍 코드가 아니라 문자열에 쓸 때 사용
        System.out.println('\'');
        // "(쌍따옴표)
        System.out.println("\"");
        System.out.println("\"내 사전이 어디갔지\"");
        // 역 슬래쉬 : 따로 쓰면 이스케이프 문 등이 발동되버려서 오류 발생
        System.out.println("c:\\user\\gg"); 
    }
    
}
