package a210806;

public class CellPhoneTest {
	
	public static void main(String[] args) {
		CameraPhone camera = new CameraPhone("IN-760", "010-1234-5678", 60, "1200¸¸");
		MP3Phone mp = new MP3Phone("KN-600", "010-1212-1234", 60, 256);
		
		System.out.println(camera.getModel() + ", " + camera.pixel + ", " + camera.getNumber());
	}

}
