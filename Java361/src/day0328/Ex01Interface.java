package day0328;

// 인터페이스

public class Ex01Interface {
    
    public static void main(String[] args) {
        
        StudentInterface eStudent = new ElementaryStudent();
        StudentInterface mStudent = new MiddleschoolStudent();
        
        eStudent.printInfo();
        System.out.println("===========================================");
        mStudent.printInfo();
    }
    
    

}
