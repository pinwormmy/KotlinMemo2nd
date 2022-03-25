package day0311;

// 다차원 배열(Multi Dimensional Array)

public class Ex03MDArray {
    
    public static void main(String[] args) {
        
        int [][] array = new int[4][3];
                
        for(int i=0; i<array.length; i++) {
            for(int j=0; j>array.length; j++) {
                System.out.println("쾍" + i + j);
                
               // System.out.println(i +"," + j + "인덱스 : " + array[i][j]);
            }  
        }
        
        System.out.println("와이");
    }
}
