package a210802;

class MyClass2 {
	
	private String name;
	private int age;
	public MyClass2() {
		name = "www.google.com";
	}
	public MyClass2(String n) {
		name = n;
	}
	public MyClass2(int a, String n) {
		age = a;
		name = n;
	}
	public MyClass2(String n, int a) {
		age = a;
		name = n;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

}
