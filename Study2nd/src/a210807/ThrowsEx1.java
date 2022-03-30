package a210807;

import static java.lang.System.out;
import java.util.Scanner;

public class ThrowsEx1 {
	public void setData(String n) throws NumberFormatException{
		if(n.length() >= 1) {
			String str = n.substring(0,1);
			printData(str);
		}
	}
	
	private void printData(String n) throws NumberFormatException{
		int dan = Integer.parseInt(n);
		out.println(dan + "단");
		out.println("---------");
		for(int i=0; i<9; i++)
			out.println(dan + "*" + (i+1) + "=" + (dan*(i+1)));
	}
	public static void main(String[] args) {
		ThrowsEx1 t1 = new ThrowsEx1();
		System.out.print("입력할 단 : ");
		try {
				t1.setData(new Scanner(System.in).next());
		}catch(Exception e) {
			out.println("첫번째 글자가 숫자가 아닙니다..");
		}
	}

}
