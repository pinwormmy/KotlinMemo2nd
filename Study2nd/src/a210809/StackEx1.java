package a210809;

import java.util.Stack;
import static java.lang.System.out;

public class StackEx1 {
	public static void main(String[] args) {
		String[] groupA = {"ȫ�浿", "��浿", "�ڱ浿", "�̱浿", "�ֱ浿"};
		
		Stack<String> stack = new Stack<String>();
		for(String n : groupA)
			stack.push(n);
		
		while(!stack.isEmpty())
			out.println(stack.pop());
	}
}
