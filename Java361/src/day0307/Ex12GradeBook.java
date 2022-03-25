package day0307;

import java.util.Scanner;

// 메뉴 조건부 무한반복 프로그램
// 활용해서 성적 관리 프로그램 만들기
//결과)
//번호: 0##번 이름: ###
//국어: 0##점 영어: 0##점 수학: 0##점
//총점: 0##점 평균: 0##.##점

// 입력 없이 출력 띄우면 아직 정보없다고 하기

public class Ex12GradeBook {
    public static void main(String[] args) {
        
        // 과목의 갯수를 저장한 상수
        final int SUBJECT_SIZE = 3;
        int id = -1;
        String name = "";
        int korean = -1;
        int english = -1;
        int math = -1;
        
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("1.입력 2.출력 3.종료 : ");
            int userChoice = scanner.nextInt();
            
            if(userChoice == 1) {
                
                while(true) {
                    
                    System.out.printf("사용자 번호 입력 : ");
                    id = scanner.nextInt();
                    System.out.printf("사용자 이름 입력 : ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.printf("국어 점수 입력 : ");
                    korean = scanner.nextInt();
                    System.out.printf("영어 점수 입력 : ");
                    english = scanner.nextInt();
                    System.out.printf("수학 점수 입력 : ");
                    math = scanner.nextInt();
                    
                    if((id>= 0) && (name != "") && (korean >= 0 || korean <=100) && (english >= 0 || english <=100) && (math >= 0 || math <=100))
                    {
                        System.out.println("이상없이 입력 완료되었습니다^^");
                        break;
                    }
                    else
                        System.out.println("입력오류. 다시 똑바로 하세욧!");
                }
                
            }else if(userChoice == 2){
                
                if(id == -1) {
                    System.out.println("아직 입력된 정보가 없습니다.");
                }else{
                 // 1. 번호: 0##번 이름: ### 을 담당하는 printf()
                    System.out.printf("번호: %03d번 이름: %s\n", id, name);

                    // 2. 국어: 0##점 영어: 0##점 수학: 0##점 을 담당하는 printf()
                    System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);

                    // 3. 총점: 0##점 평균: 0##.##점 을 담당하는 printf()
                    // 3-1. 총점을 담당할 변수를 선언하고 총점을 계산하여 저장한다.
                    int sum = korean + english + math;

                    // 3-2. 평균을 담당할 변수를 선언하고 평균을 계산하여 저장한다.
                    double average = sum / (double) SUBJECT_SIZE;

                    System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
                    
                }

            }else {
                System.out.println("장비를 정지합니다.--------------------------");
                break;
            }
            
        }
        
        scanner.close();
    }
}
