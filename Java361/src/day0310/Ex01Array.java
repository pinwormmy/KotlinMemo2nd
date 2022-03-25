package day0310;

// 배열

public class Ex01Array {
    
    public static void main(String[] args) {
        
        int[] intArray = new int[4];
        
        intArray[0] = 30; // 배열 첫째칸에 30으로 초기화
        
        System.out.println(intArray[0]);
        
        intArray = new int[3]; // 기본적으로 0으로 초기화됨
        
        System.out.println("첫번째 : " + intArray[0]);
        System.out.println("2번째 : " + intArray[1]);
        System.out.println("3번째 : " + intArray[2]);
        
        // 참조형 데이터 타입은 선언할 때 null로 초기화
        // null은 주소값도 없이 비어있는 상태
        
        String[] stringArray = new String[4];
        
        for(int i=0; i < stringArray.length; i++)
            System.out.printf("%d번배열 : %s", i, stringArray[i] + "\n");
        
    }
}
