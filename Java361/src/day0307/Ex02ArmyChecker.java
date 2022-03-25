package day0307;

import java.util.Scanner;

// 현역, 공익, 면제 판별 프로그램

public class Ex02ArmyChecker {

    public static void main(String[] args) {
        
        int gender;
        int age;
        int bodyGrade;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("성별을 입력하시오(남자:1 여자:2) : ");
        gender = scanner.nextInt();
                
        if(gender == 1) {
            
            System.out.print("나이을 입력하시오 : ");
            age = scanner.nextInt();
            
            if(age < 0) {
                System.out.println("나이 입력 오류");
            }
            else if(age > 18) {
                
                System.out.print("신체등급을 입력하시오(1~7) : ");
                bodyGrade = scanner.nextInt();
                
                if(bodyGrade > 7 || bodyGrade < 1)
                    System.out.println("신체등급 입력오류");
                else if(bodyGrade < 4)
                    System.out.println("현역");
                else if(bodyGrade == 4)
                    System.out.println("공익");
                else
                    System.out.println("면제");
            }
            else {
                System.out.println("아직 미성년자.");
            }
        }else if(gender == 2) 
            System.out.println("여성에게 병역 의무 없다 쩝");
        else
           System.out.println("성별 입력 오류");
        
        scanner.close();
    }
}
