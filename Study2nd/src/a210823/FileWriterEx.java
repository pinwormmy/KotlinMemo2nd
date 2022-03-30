package a210823;

import java.io.*;

public class FileWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:\\test\\fileWriter.txt");
			//fw = new FileWriter("d:\\test\\fileWriter.txt", true);
			String message = "안녕하세요 FileWriter Test 요요";
			fw.write(message);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fw != null)fw.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
