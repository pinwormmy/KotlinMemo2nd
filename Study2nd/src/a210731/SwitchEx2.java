package a210731;

public class SwitchEx2 {
	public static void main(String[] args) {
		
		String str = "��";
		String result;
		
		switch(str) {
		case "��":
			result = "90 ~ 100��";
			break;
		case "��":
			result = "80 ~ 89��";
			break;
		case "��":
			result = "70 ~ 79��";
			break;
		case "��":
			result = "60 ~ 69��";
			break;
		case "��":
			result = "50 ~ 59��";
			break;
		default :
			result = "�Է� ����";
			break;
		}
		System.out.println(result);
	}

}
