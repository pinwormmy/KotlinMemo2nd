package a210809;

import java.util.LinkedList;
import java.util.Vector;
import static java.lang.System.out;

public class QueueEx1 {
	
	public static void main(String[] args) {
		String[] item = {"�ҳ�Ÿ", "������", "��Ծ�"};
		LinkedList<String> q = new LinkedList<String>();
		
		for(String n : item)
			q.offer(n);
		
		String data = "";
		while((data = q.poll()) != null)
			out.println(data + "����!!");
			out.println("q�� ũ�� : " + q.size());
		}

}
