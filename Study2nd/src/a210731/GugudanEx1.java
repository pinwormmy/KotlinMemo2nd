package a210731;

import java.util.Scanner;

class GugudanEx1 {
	public static void main(String[] args) {
		System.out.print("�μ��Է� : ");
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		for(int i=1; i<=9; i++)
			System.out.println(dan + "*" + i + "=" + (dan*i));
	}

}
