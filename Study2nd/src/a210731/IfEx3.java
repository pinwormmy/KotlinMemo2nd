package a210731;

class IfEx3 {
	public static void main(String[] args) {
		int su1 = 34;
		String res;
		
		if(su1 >= 41)
			res = "���";
		else if(su1 >= 11)
			res = "�߱�";
		else if(su1 >= 0)
			res = "�ʱ�";
		else
			res = "���ڿ���";
		
		System.out.println(res + "�Դϴ�.");
		
	}

}
