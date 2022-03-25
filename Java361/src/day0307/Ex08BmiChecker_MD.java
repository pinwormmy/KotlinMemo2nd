package day0307;

// 사용자로부터 이름, 나이, 키, 몸무게를 차례대로 입력받아서

// 다음과 같은 형식으로 출력되게 프로그램을 작성하시오

// 결과))))
// 이름: ### 나이: 0##세
// 키: #.##M 몸무게: 0##.##kg
// BMI: ##.## 비만도: ###

// BMI 계산 공식은
// 몸무게(kg 단위) / 키(m 단위) / 키(m 단위) 입니다.

// BMI에 따른 비만도는
// ~18.5 미만: 저체중
// 18.5이상 23미만: 정상체중
// 23이상 25미만: 과체중
// 25이상: 비만
// 입니다.

// 비만도 계산 프로그램에서 입력값 검증 대신 똑띠입력할때까지 반복문

import java.util.Scanner;

public class Ex08BmiChecker_MD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 이름 입력
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        String name = scanner.nextLine();

        int age = -1;
        double height = -1;
        double weight = -1;
        
        while(age < 0) {
            // 나이 입력
            System.out.println("나이를 입력해주세요.");
            System.out.print("> ");
            age = scanner.nextInt();
        }
        while(height <= 0 || height > 2.80) {
            // 키 입력
            System.out.println("키를 입력해주세요.");
            System.out.print("> ");
            height = scanner.nextDouble();
        }
        
        while(weight <= 0 || weight > 635) {
            // 몸무게 입력
               System.out.println("몸무게를 입력해주세요.");
               System.out.print("> ");
               weight = scanner.nextDouble();
        }
        
        // 출력
        // 이름: ### 나이: 0##세 출력
        System.out.printf("이름: %s 나이: %03d세\n", name, age);
        // 키: #.##M 몸무게: 0##.##kg 출력
        System.out.printf("키: %.2fM 몸무게: %06.2fkg\n", height, weight);
        // BMI: ##.## 비만도: 출력
        double bmi = weight / height / height;
        System.out.printf("BMI: %.2f 비만도: ", bmi);

        // 비만도 결과값 출력
        if (bmi < 18.5) {
            System.out.println("저체중");
        } else if (bmi < 23) {
            System.out.println("정상 체중");
        } else if (bmi < 25) {
            System.out.println("과체중");
        } else {
            System.out.println("비만");
        }

        scanner.close();
    }
}
