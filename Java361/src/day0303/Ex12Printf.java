package day0303;

public class Ex12Printf {
    
    public static void main(String[] args) {
        
        int number = 47;
        
        // 정수 그대로 출력
        System.out.printf("%d \n", number);
        System.out.printf("%4d \n", number);
        System.out.printf("%4d \n", 12345); // 출력할 값이 정렬위치보다 클 때는 정렬옵션 무시
        
    }

}
