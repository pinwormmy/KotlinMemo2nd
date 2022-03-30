package a210731;

public class SwitchEx2 {
	public static void main(String[] args) {
		
		String str = "미";
		String result;
		
		switch(str) {
		case "수":
			result = "90 ~ 100점";
			break;
		case "우":
			result = "80 ~ 89점";
			break;
		case "미":
			result = "70 ~ 79점";
			break;
		case "양":
			result = "60 ~ 69점";
			break;
		case "가":
			result = "50 ~ 59점";
			break;
		default :
			result = "입력 오류";
			break;
		}
		System.out.println(result);
	}

}
