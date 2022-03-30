package a210806;

public class Terran extends Unit{
	boolean fly;
	public Terran(String n, boolean b) {
		name = n;
		hp = 40;
		fly = b;
	}
	
	public void AtkDamage() {
		hp -= 5;
	}
}
