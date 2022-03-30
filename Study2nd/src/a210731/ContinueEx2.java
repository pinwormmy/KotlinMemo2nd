package a210731;

class ContinueEx2 {
	public static void main(String[] args) {
		label:
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++)
					if(j==3)continue label;
			}
	}

}
