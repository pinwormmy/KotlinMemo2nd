package a210809;

import java.util.Vector;
import static java.lang.System.out;

public class VectorEx1 {
	
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2,5);
		out.println("::::::::::::Vector ������::::::::::::::");
		out.println("capacity : " + v.capacity());
		out.println("size : " + v.size());
		
		v.add("������");
		v.add("���ֿ�");
		v.addElement("����ö?");
		
		out.println("::::::::::::��� �߰���:::::::::::::");
		out.println("capacity : " + v.capacity());
		out.println("size : " + v.size());
		
	}

}
