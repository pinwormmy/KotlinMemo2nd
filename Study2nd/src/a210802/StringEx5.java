package a210802;

class StringEx5 {
	
	public static void main(String[] args) {
		String s1 = "Kim Han Eol";
		
		int index = s1.indexOf('n');
		System.out.println("�� ó�� ���� n�� ��ġ : " + index);
		
		index = s1.indexOf("Han");
		System.out.println("���� Han�� ��ġ : " + index);
		
		index = s1.lastIndexOf('n');
		System.out.println("������ ���� n�� ��ġ : " + index);
		
		char c = s1.charAt(index);
		System.out.println("������ ���� : " + c);
		
		index = s1.indexOf('a');
		String str = s1.substring(index);
		System.out.println("�ҹ��� a�κ��� ������ ���� : " + str);
		
		str = s1.substring(index, index+3);
		System.out.println("�ҹ��� a���� 3���� ���� : " + str);
		
		int length = s1.length();
		System.out.println("s1�� ���� : " + length);
		
		System.out.println("-----------���ڿ� �����ϱ�-------");
		String[] arr = s1.split(" ");
		for(int i=0; i<arr.length; i++)
			System.out.println("arr[" + i + "] : " + arr[i]);
	}
}
