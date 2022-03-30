package a210822;

import java.io.IOException;

public class InputStreamEx {
	public static void main(String[] args) throws IOException{
		System.out.print("입력하세요 : ");
		int _byte;
		while((_byte = System.in.read()) != 1) {
			if(_byte == '\r' || _byte == '\n')
				continue;
			if(_byte == 'q' || _byte == 'Q') {
				System.out.println("큐 치면 종료됨");
				break;
			}
			char c = (char)_byte;
			System.out.printf("%s(%d)", c, _byte);
		}
	}
}
