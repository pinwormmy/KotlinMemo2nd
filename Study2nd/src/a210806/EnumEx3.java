package a210806;

public class EnumEx3 {
	public enum Item{
		Add(5), Del(11), Search(2), Cancel(22);
		private final int var;
		
		Item(int v){
			var = v;
		}
		
		public int getVar() {
			return var;
		}
	}
	
	public static void main(String[] args) {
		for(Item n : Item.values()) {
			System.out.println(n + " : " + n.getVar());
		}
	}

}
