package day0328;

// 인터페이스 상속

public class ElementaryStudent implements StudentInterface {
    
    public int korean;
    public int english;
    public int math;
    public int id;
    public String name;

    @Override
    public int calculateSum() {
        
        return korean + english + math;
    }

    @Override
    public double calculateAverage() {
        
        return calculateSum() / 3.0;
    }

    @Override
    public void printInfo() {
        System.out.printf("번호: %03d번 이름 %s \n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점 \n", korean, english, math);
        System.out.printf("총점: %03d점 평균 %3.2f점 \n", calculateSum(), calculateAverage());
        
        
    }

}
