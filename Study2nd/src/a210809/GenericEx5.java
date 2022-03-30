package a210809;

import static java.lang.System.out;

import a210808.GenEx1;
import a210808.GenEx2;
import a210808.GenEx3;

public class GenericEx5 <T>{
	
	T v;
	public GenericEx5(T n) {
		v = n;
	}
	public void set(T n) {
		v = n;
	}
	public T get() {
		return v;
	}
	public static void main(String[] args) {
		GenEx3 g3 = new GenEx3();
		GenericEx5<? extends GenEx2> g5 = new GenericEx5<GenEx3>(g3);
		GenEx2 test = g5.get();
		//GenEx2 test2 = g5.get();
		out.println("g5ÀÇ °á°ú : " + test.msg + ", " + test.getMsg());
	}

}
