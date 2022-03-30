package a210823;

import java.io.*;

public class BufferedWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("d:\\test\\bufferWriter.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter Test 입네다리");
			bw.newLine();
			bw.write("안녕하세요" + System.getProperty("line.separator"));
			bw.write("한줄 더 있어야 구분이 되지");
			bw.flush();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fw != null)fw.close();
				if(bw != null)bw.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
