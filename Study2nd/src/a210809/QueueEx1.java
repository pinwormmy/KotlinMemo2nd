package a210809;

import java.util.LinkedList;
import java.util.Vector;
import static java.lang.System.out;

public class QueueEx1 {
	
	public static void main(String[] args) {
		String[] item = {"소나타", "렉스톤", "재규어"};
		LinkedList<String> q = new LinkedList<String>();
		
		for(String n : item)
			q.offer(n);
		
		String data = "";
		while((data = q.poll()) != null)
			out.println(data + "삭제!!");
			out.println("q의 크기 : " + q.size());
		}

}
