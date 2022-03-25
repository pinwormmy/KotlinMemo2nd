package homework;

import util.ArrayUtil;

// String[] 기준으로 한 동적할당 메소드(A~K) 구현
// 단, remove의 경우 이름 통일시켜줌
// 그거 써서 유틸에 추가하고 잘 되는 지 확인해보기

public class Ex04ArrayUtil {
 
    
    public static void main(String[] args) {
        
        String[] arr = new String[3];
        arr[0] = "abcdsfjlaks";
        arr[1] = "midori";
        arr[2] = "김한얼";
        
        System.out.println("lastIndexOf : ");
        System.out.println("abcdsfjlaks : " + ArrayUtil.lastIndexOf(arr, "얼"));
        
        System.out.println("삭제전 : " + arr[0]);
        ArrayUtil.remove(arr, 0);
        System.out.println("삭제후 : " + arr[0]);
    }
    
}
