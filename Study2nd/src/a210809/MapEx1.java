package a210809;

import java.util.*;
import static java.lang.System.out;

public class MapEx1 {
	
	public static void main(String[] args) {
		String[] msg = {"베를린", "도르트문트", "프랑크프루트", "젤센지슘?", "함부르크"};
		
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		
		for(int i=0; i<msg.length; i++)
			map.put(i, msg[i]);
		
		Set<Integer>keys = map.keySet();
		for(Integer n : keys)
			out.println(map.get(n));
	}

}
