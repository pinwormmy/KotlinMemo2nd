package a210807;

import static java.lang.System.out;

import java.util.*;

public class ExceptionEx3 {
	public static void main(String[] args) {
		int var = 50;
		try {
			System.out.print("정수 입력 : ");
			int data = new Scanner(System.in).nextInt();
			
			out.println(var/data);
		}catch(InputMismatchException ie) {
			out.println("정수5가 아닙니다.0..");
		}catch(ArithmeticException ae) {
			out.println("0으로 나눌 순 없습니다....");
		}
		out.println("프로그램 종료!");
	}

}
