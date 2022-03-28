package day0328;

// 컬랙션 클래스에 인터페이스로 구현됨

import java.util.HashMap;

public class Ex02HashMap {
    
    public static void main(String[] args) {
        
        HashMap<String, ElementaryStudent> map = new HashMap<>();
        
        ElementaryStudent e1 = new ElementaryStudent();    
        
        e1.id = 1;
        e1.name = "김철수";
        e1.korean = 64;
        e1.english = 76;
        e1.math = 54;
        
        ElementaryStudent e2 = new ElementaryStudent();
        e2.id = 2;
        e2.name = "김봉만";
        e2.korean = 68;
        e2.english = 12;
        e2.math = 55;
        
        ElementaryStudent e3 = new ElementaryStudent();
        e3.id = 3;
        e3.name = "김혁";
        e3.korean = 88;
        e3.english = 98;
        e3.math = 90;
        
        ElementaryStudent e4 = new ElementaryStudent();
        e4.id = 4;
        e4.name = "박갑수";
        e4.korean = 55;
        e4.english = 26;
        e4.math = 77;
        
        ElementaryStudent e5 = new ElementaryStudent();
        e5.id = 5;
        e5.name = "이정민";
        e5.korean = 76;
        e5.english = 56;
        e5.math = 47;
        
        
        map.put("학생1", e1);
        map.put("학생1", e2);
        map.put("학생1", e3);
        map.put("학생1", e4);
        map.put("학생1", e5);
    }
    
    
    
    
}
