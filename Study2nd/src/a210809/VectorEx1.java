package a210809;

import java.util.Vector;
import static java.lang.System.out;

public class VectorEx1 {
	
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2,5);
		out.println("::::::::::::Vector 생성시::::::::::::::");
		out.println("capacity : " + v.capacity());
		out.println("size : " + v.size());
		
		v.add("박지성");
		v.add("박주영");
		v.addElement("유상철?");
		
		out.println("::::::::::::요소 추가후:::::::::::::");
		out.println("capacity : " + v.capacity());
		out.println("size : " + v.size());
		
	}

}
