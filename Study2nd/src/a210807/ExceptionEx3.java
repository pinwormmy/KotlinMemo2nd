package a210807;

import static java.lang.System.out;

import java.util.*;

public class ExceptionEx3 {
	public static void main(String[] args) {
		int var = 50;
		try {
			System.out.print("���� �Է� : ");
			int data = new Scanner(System.in).nextInt();
			
			out.println(var/data);
		}catch(InputMismatchException ie) {
			out.println("����5�� �ƴմϴ�.0..");
		}catch(ArithmeticException ae) {
			out.println("0���� ���� �� �����ϴ�....");
		}
		out.println("���α׷� ����!");
	}

}
