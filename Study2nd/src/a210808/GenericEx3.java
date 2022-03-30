package a210808;

import static java.lang.System.out;

public class GenericEx3 <T>{
	
	T v;
	public GenericEx3() {}
	public GenericEx3(T n) {
		v = n;
	}
	public void set(T n) {
		v = n;
	}
	public T get() {
		return v;
	}
	public static void main(String[] args) {
		GenericEx3<?> g3 = new GenericEx3<String>("String zemzem");
		//g3.set("String °´Ã¼");
		String s = (String)g3.get();
		out.println("g3ÀÇ °á°ú : " + s);
	}

}
