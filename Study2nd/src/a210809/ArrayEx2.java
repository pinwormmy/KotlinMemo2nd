package a210809;

import java.util.Arrays;
import static java.lang.System.out;

public class ArrayEx2 {
	public static void main(String[] args) {
		String[] ar1 = {"fill()", "in", "the", "Arrays"};
		String[] ar2 = {"fill()", "in", ", ", "Arrays"};
		
		if(!Arrays.equals(ar1, ar2))
			out.println("두 배열이 다릅니다.");
		out.println("------------------------");
		
		Arrays.fill(ar2, 2, 3, "the");
		if(!Arrays.equals(ar1, ar2))
			out.println("두 배열이 다릅니다.");
		else
			out.println("두 배열이 같습니다.");
 	}
	
}
