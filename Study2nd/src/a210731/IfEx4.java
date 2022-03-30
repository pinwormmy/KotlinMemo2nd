package a210731;

import java.util.Scanner;

class IfEx4 {

	public static void main(String[] args) {
		System.out.println("음식명 : ");
		Scanner scan = new Scanner(System.in);
		String food = scan.next();
		String res;
		
		if(food.equals("cake"))
			res = "달다.";
		else if(food.equals("kimchi"))
			res = "맵다.";
		else
			res = "잘못 입력한듯?";
		
		System.out.println(res);
	}
}
