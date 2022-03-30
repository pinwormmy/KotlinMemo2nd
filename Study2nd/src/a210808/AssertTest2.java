package a210808;

import static java.lang.System.out;

public class AssertTest2 {
	public void gugu(int dan) {
		assert dan > 1 && dan < 10 : "2~9단중 하나를 입력하시오";
		out.println(dan + "단");
		out.println("-------------");
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<9; i++) {
			sb.delete(0, sb.length());
			sb.append(dan);
			sb.append("*");
			sb.append(i+1);
			sb.append("=");
			sb.append(dan*(i+1));
			out.println(sb.toString());
		}
	}
	public static void main(String[] args) {
		AssertTest2 at = new AssertTest2();
		try {
			at.gugu(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
