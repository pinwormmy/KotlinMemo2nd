package a210807;

import static java.lang.System.out;

public class ExceptionEx2 {
	public static void main(String[] args) {
		int[] var = {10, 200, 300};
		for(int i=0; i<=3; i++) {
			try {
				out.println("var[" + i + "] : " + var[i]);
			}catch(ArrayIndexOutOfBoundsException ae) {
				out.println("�迭�� �Ѿ����ϴ�.");
			}
		}
		
		out.println("���α׷� ��!");
	}

}