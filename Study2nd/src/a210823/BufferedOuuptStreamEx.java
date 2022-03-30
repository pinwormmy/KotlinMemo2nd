package a210823;

import java.io.*;

public class BufferedOuuptStreamEx {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("d:\\test\\bufferOut.txt");
			bos = new BufferedOutputStream(fos);
			String str = "BufferedOutputStream Test 입니다요~";
			bos.write(str.getBytes());
			bos.flush();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			try {
				if(fos != null)
					fos.close();
				if(bos != null)
					bos.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
