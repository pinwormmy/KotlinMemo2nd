package a210802;

class StaticTest3 {
	
	public static void main(String[] args) {
		StaticCount sc1 = new StaticCount();
		System.out.println("sc1�� c : " + sc1.c + ", sc1�� count : " + sc1.count);
		
		StaticCount sc2 = new StaticCount();
		System.out.println("sc2�� c : " + sc2.c + ", sc2�� count : " + sc2.count);
		
		StaticCount sc3 = new StaticCount();
		System.out.println("sc3�� c : " + sc3.c + ", sc3�� count : " + sc3.count);
	}

}
