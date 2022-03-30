package a210823;

import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("d:\\test\\fileReader.txt");
			int readChar;
			while((readChar = fr.read()) != -1) {
				System.out.print((char)readChar);
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fr != null)
					fr.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
