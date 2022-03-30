package a210731;

class IfEx3 {
	public static void main(String[] args) {
		int su1 = 34;
		String res;
		
		if(su1 >= 41)
			res = "고급";
		else if(su1 >= 11)
			res = "중급";
		else if(su1 >= 0)
			res = "초급";
		else
			res = "숫자오류";
		
		System.out.println(res + "입니다.");
		
	}

}
