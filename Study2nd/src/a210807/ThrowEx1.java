package a210807;

import static java.lang.System.out;

public class ThrowEx1 {
	
	public void methodA(String[] n) throws Exception{
		if(n.length > 0) {
			for(String s : n)
				out.println(s);
		}else
			throw new Exception("배열에 요소가 없습니다..");
	}
	
	public static void main(String[] args) {
		ThrowEx1 te = new ThrowEx1();
		String[] arg1 = {"1,2,3"};
		String[] arg2 = {};
		try {
			te.methodA(arg2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
