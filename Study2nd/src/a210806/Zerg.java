package a210806;

public class Zerg extends Unit{
	boolean fly;
	public Zerg(String n, boolean b) {
		name = n;
		hp = 80;
		fly = b;
	}
	
	public void AtkDamage() {
		hp -= 6;
	}
}