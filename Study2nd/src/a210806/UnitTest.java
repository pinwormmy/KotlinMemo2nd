package a210806;

public class UnitTest {
	
	public static void main(String[] args) {
		Zerg z1 = new Zerg("Hydralisk", false);
		z1.AtkDamage();
		System.out.println(z1.name + "�� ü�� : "  +z1.getDamage());
		Protoss p1 = new Protoss("Corsair", true);
		p1.AtkDamage();
		System.out.println(p1.name + "�� ü�� : " + p1.getDamage());
		Terran t1 = new Terran("Marine", false);
		t1.AtkDamage();
		System.out.println(t1.name + "�� ü�� : " + t1.getDamage());
	}

}
