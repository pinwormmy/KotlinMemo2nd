package a210802;

class StringEx5 {
	
	public static void main(String[] args) {
		String s1 = "Kim Han Eol";
		
		int index = s1.indexOf('n');
		System.out.println("맨 처음 문자 n의 위치 : " + index);
		
		index = s1.indexOf("Han");
		System.out.println("문자 Han의 위치 : " + index);
		
		index = s1.lastIndexOf('n');
		System.out.println("마지막 문자 n의 위치 : " + index);
		
		char c = s1.charAt(index);
		System.out.println("추출한 문자 : " + c);
		
		index = s1.indexOf('a');
		String str = s1.substring(index);
		System.out.println("소문자 a로부터 끝까지 편집 : " + str);
		
		str = s1.substring(index, index+3);
		System.out.println("소문자 a부터 3글자 편집 : " + str);
		
		int length = s1.length();
		System.out.println("s1의 길이 : " + length);
		
		System.out.println("-----------문자열 분할하기-------");
		String[] arr = s1.split(" ");
		for(int i=0; i<arr.length; i++)
			System.out.println("arr[" + i + "] : " + arr[i]);
	}
}
