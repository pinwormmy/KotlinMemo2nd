package a210823;

import java.io.*;

public class PrintWriterSecondEx {
	public static void main(String[] args) {
		PrintWriter pw = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("d:\\test\\printWriterSecond.txt");
			bos = new BufferedOutputStream(fos);
			pw = new PrintWriter(bos, true);
			pw.println("æ»≥Á«œºÓ!!");
			pw.println("∂« ∫∏ø¿");
			pw.println(100.0);
			pw.println(new Boolean(true));
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fos != null)fos.close();
				if(bos != null)bos.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
