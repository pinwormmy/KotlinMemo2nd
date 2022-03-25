package day0308;

// Switch 조건문

public class Ex03Switch {
    public static void main(String[] args) {
        int number = 156215;
        
        switch(number % 7) {
        case 1:
            System.out.println("1입니다.");
            break;
        case 2:
            System.out.println("2입니다.");
            break;
        case 3:
            System.out.println("3입니다.");
            break;
        case 4:
            System.out.println("4입니다.");
            break;
        default :
            System.out.println("기타입니다.");
            break;
        }
    }
}
