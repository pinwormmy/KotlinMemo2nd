package a210731;

import java.util.Scanner;

class SwitchEx1 {
	public static void main(String[] args) {
		System.out.print("월수를 입력하시오(1~12월) : ");
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		String res;
		switch(month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			res = "31";
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			res = "30";
			break;
		case 2:
			res = "29";
			break;
			default:
				res = "입력 이상";
		}
		
		System.out.println(month + "월은 " + res + "일까지 입니다.");
	}

}
