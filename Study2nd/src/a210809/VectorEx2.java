package a210809;

import java.util.Vector;
import static java.lang.System.out;

public class VectorEx2 {
	
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>(2,5);
		
		v.add(100.3);
		v.add(3.14);
		v.addElement(1000.);
		for(Double n : v)
			out.println(n);
		
		double search = 1000.0;
		int index = v.indexOf(search);
		if(index != -1)
			out.println("검색요소 " + search + "의 위치 : " + index);
		else
			out.println("검색요소 " + search + "가 없습니다.");
		
		out.println(":::::::::::삭제 전 용량/크기 확인:::::::::::");
		out.println("capacity : " + v.capacity());
		out.println("size : " + v.size());
		
		double del = 3.14;
		if(v.contains(del)) {
			v.remove(del);
			out.println(del + " 삭제 완료!--------------------------");
		}
		
		out.println("::::::::::삭제 후 용량/크기 확인:::::::::::");
		out.println("capacity : " + v.capacity());
		out.println("size : " + v.size());
		
		v.trimToSize();
		out.println("::::::::::::용량 조절 후 용량/크기 확인:::::::::::::::");
		out.println("capacity : " + v.capacity());
		out.println("size : " + v.size());
	}
}
