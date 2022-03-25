package day0303;

// 형 변환

// 암시적 형 변환, 명시적 형 변환 두 가지 존재
// 암시적 형 변환(Implicit Type Casting) : 코드 입력 안 해도 내부적으로 알아서 바꿈

// 명시적 형 변환(Explicit Type Casting) : (값 손실분이 있거나 해서 암시적 형 변환 적용 안되는 경우)직접 코드 입력해서 사용

// 오버플로우(Overflow)와 언더플로우(Underflow) : 데이터값이 표현범위를 초과할 때 값이 음수나 양수로 역전되어 생기는 오차
// ex) 게임 문명의 전쟁왕 간디(문명개발자는 오버플로우 문제 아니라 밝힘)

public class Ex06TypeCasting {
    
    public static void main(String[] args) {
        byte a = 50;
        
        // 더 큰 데이터타입으로 변환(암시적)
        int b = a;
        System.out.println(b);
        
        double c = b;
        System.out.println(c);
        
        // 더 작은 데이터 타입으로 변환(명시적으로 해야만 함)
        
        c = 3.14;
        System.out.println("(변환전)" + c);
        
        // b = c; 손실값이 있어서 오류뜸. 그래서 명시적으로 강제해서 실행해야한다
        b = (int)c;
        
        System.out.println("(변환후)" + b);
        
        // 오버플로우
        byte e;
        b = 128;
        e = (byte)b;
        System.out.println(e); // 뜬금 마이너스가 됨
        
    }

}
