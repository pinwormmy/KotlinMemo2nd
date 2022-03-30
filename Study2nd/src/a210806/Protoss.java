package a210806;

public class Protoss extends Unit{
	boolean fly;
	public Protoss(String n, boolean b) {
		name = n;
		hp = 160;
		fly = b;
	}
	
	public void AtkDamage() {
		hp -= 5;
	}
}