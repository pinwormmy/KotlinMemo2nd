package a210731;

class WhileEx1 {
	public static void main(String[] args) {
		int sum, su;
		sum = su = 0;
		
		while(su <= 100) {
			sum += su;
			su++; // 수정
		}
		System.out.println("1 ~ 100까지 합 : " + sum);
	}

}
