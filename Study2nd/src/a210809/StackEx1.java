package a210809;

import java.util.Stack;
import static java.lang.System.out;

public class StackEx1 {
	public static void main(String[] args) {
		String[] groupA = {"홍길동", "김길동", "박길동", "이길동", "최길동"};
		
		Stack<String> stack = new Stack<String>();
		for(String n : groupA)
			stack.push(n);
		
		while(!stack.isEmpty())
			out.println(stack.pop());
	}
}
