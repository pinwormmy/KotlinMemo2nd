package a210826;

import java.io.*;

public class RandomAccessFileEx {
	public static void main(String[] args) {
		RandomAccessFile ra = null;
		try {
			ra = new RandomAccessFile("d:\\test\\random.txt", "rw");
			
			String receive = ">.<";
			ra.seek(ra.length());
			ra.write(receive.getBytes());
			
			byte[] buf = new byte[(int)ra.length()];
			ra.seek(0);
			ra.read(buf);
			System.out.print("ó�� ���� ���� : ");
			System.out.println(new String(buf));
			
			
			ra.seek(0);
			ra.read(buf);
			
			
			System.out.print("�ٽ� ���� ���� : ");
			System.out.println(new String(buf));
			
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(ra != null)ra.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
