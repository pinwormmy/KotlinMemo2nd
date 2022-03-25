package day0314;

import util.ScannerUtil;

// 간편화시킨 스캐너 클래스 활용

public class Ex01ScannerUtil {

    public static void main(String[] args) {
                
        ScannerUtil scan = new ScannerUtil();
        int temp = scan.nextInt("임시값 입력하쇼");
        
                
        System.out.print("쩝 이러면 하나마나 아닌가 ㅋ : " + temp);
    }
}
