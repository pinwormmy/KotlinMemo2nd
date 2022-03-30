package a210803;

public class StringBufEx3 {
	
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("Han-Eol");
		StringBuffer sb2 = sb1.append(" & LISA");
		
		sb2.insert(7, " & Jenny");
		String msg = sb1.toString();
		System.out.println("sb1 : " + msg);
			
	}

}
