package a210808;

public class GenericEx1Main {
	public static void main(String[] args) {
		GenericEx1<String> t = new GenericEx1<String>();
		
		String[] ss = {"��", "��", "��"};
		//Integer[] ss = {1,2,3};
		t.set(ss);
		t.print();
		
		/* ���� ����� �ƴϷ� 
		GenericEx1 t1 = new GenericEx1();
		Integer[] s = {1,2,3};
		t1.set(s);
		t1.print();
		*/
	}

}
