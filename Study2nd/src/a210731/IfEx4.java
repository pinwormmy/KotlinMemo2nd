package a210731;

import java.util.Scanner;

class IfEx4 {

	public static void main(String[] args) {
		System.out.println("���ĸ� : ");
		Scanner scan = new Scanner(System.in);
		String food = scan.next();
		String res;
		
		if(food.equals("cake"))
			res = "�޴�.";
		else if(food.equals("kimchi"))
			res = "�ʴ�.";
		else
			res = "�߸� �Է��ѵ�?";
		
		System.out.println(res);
	}
}
