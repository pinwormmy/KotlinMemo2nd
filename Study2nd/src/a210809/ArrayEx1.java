package a210809;

import java.util.Arrays;
import static java.lang.System.out;

public class ArrayEx1 {
	
	public static void main(String[] args) {
		String[] ar = {"fill()", "in", "the","Arrays"};
		
		for(String n : ar)
			out.print(n + ", ");
		out.println("\n-----------------------");
		
		Arrays.fill(ar, "Lisa");
		for(String n : ar)
			out.print(n + ", ");
				
		out.println("\n-----------------------");
		Arrays.fill(ar,  1, 3, "¢½");
		for(String n : ar)
			out.print(n + ", ");
	}

}
