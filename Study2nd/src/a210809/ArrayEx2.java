package a210809;

import java.util.Arrays;
import static java.lang.System.out;

public class ArrayEx2 {
	public static void main(String[] args) {
		String[] ar1 = {"fill()", "in", "the", "Arrays"};
		String[] ar2 = {"fill()", "in", ", ", "Arrays"};
		
		if(!Arrays.equals(ar1, ar2))
			out.println("�� �迭�� �ٸ��ϴ�.");
		out.println("------------------------");
		
		Arrays.fill(ar2, 2, 3, "the");
		if(!Arrays.equals(ar1, ar2))
			out.println("�� �迭�� �ٸ��ϴ�.");
		else
			out.println("�� �迭�� �����ϴ�.");
 	}
	
}
