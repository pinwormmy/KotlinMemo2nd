package a210823;

import java.io.*;

public class FileOutputStreamEx {
	public static void main(String arg[]) throws FileNotFoundException, IOException {
		FileOutputStream fos = null;
		try {
			File f = new File("d:\\test");
			if(!f.exists())
				f.mkdirs();
			fos = new FileOutputStream("d:\\test\\fileout.txt");
			//fos = new FileOutputStream("d:\\test\\fileout.txt", true); // true 항목은 이어쓰기
			String message = "Halo FileOutputStream!!";
			fos.write(message.getBytes());
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			try {
				if(fos != null)
					fos.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
