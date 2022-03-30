package a210806;

abstract class Unit {
	protected String name;
	protected int hp;
	abstract public void AtkDamage();
	public int getDamage() {
		return hp;
	}

}
