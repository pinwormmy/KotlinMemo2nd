package a210809;

public class Able {
	String empno;
	int net, ejb, xml, total;
	public Able(int total) {
		this.total = total;
	}
	public Able(String no, int n, int e, int x) {
		empno = no;
		net = n;
		ejb = e;
		xml = x;
		total = n+e+x;
	}
	public int getTotal() {
		return total;
	}

}
