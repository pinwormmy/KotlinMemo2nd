package a210731;

import java.util.Scanner;

class SwitchEx1 {
	public static void main(String[] args) {
		System.out.print("������ �Է��Ͻÿ�(1~12��) : ");
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
				res = "�Է� �̻�";
		}
		
		System.out.println(month + "���� " + res + "�ϱ��� �Դϴ�.");
	}

}
