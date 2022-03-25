package day0308;

// for 반복문

public class Ex05For {
    
    public static void main(String[] args) {
        
        for(int i=0; i<3; i++) {
            System.out.printf("뭐하니~~지짜.. %d\n", i);
        }
        
        int start = 3;
        int end = 7;
        
        for(int i = start; i<end; i++) {
            System.out.println("반복되니");
        }
        
        for(int i=1; i<6000; i *= 8) {
            System.out.printf("그래서 몇번 중벅이냐 %d\n", i);
        }
        
        int i = 11;
        for(; ; ) { // 이렇게 조건문 따로 뺄 수 있는데, 이럴거면 그냥 while문쓰지.
            System.out.println(i);
            if(i >= 13)
                break;
            i++;
        }
        
    }
    
}
