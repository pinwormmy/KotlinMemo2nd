
package day0311;

// 메소드. C언어의 함수 개념인데, 자바에선 클래스 내부 함수에 국한해서 사용하는 표현

public class Ex05Method {

    public static void main(String[] args) {
        
        printMyName();
        printMyName();
        printMyName();
        printMyName();
        printMyName();
        
        plusInt(3, 5);
        
        double result;
        result = calculateAverage(10, 17, 8);
        System.out.println(result);
    }
    
    public static void printMyName() {
       
        System.out.println("");
        System.out.println("===================================");
        System.out.println("-----------------------------------");
        System.out.println("\t김\t한\t얼");
        System.out.println("-----------------------------------");
        System.out.println("===================================");
        System.out.println("");
    }
    
    public static void plusInt(int num1, int num2) {
        
        System.out.println("");
        System.out.println("===================================");
        System.out.println("-----------------------------------");
        System.out.printf("%d + %d = %d \n", num1, num2, num1+num2);
        System.out.println("-----------------------------------");
        System.out.println("===================================");
        System.out.println("");
        
    }
    
    public static double calculateAverage(int a, int b, int c) {
        
        double average = (double)(a + b + c) / 3;
        
        return average;
    }
}
