package a210823;

import java.io.*;

public class PrintWriterFirstEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("d:\\test\\printWriterFirst.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);
			pw.println("안녕하세요우");
			pw.println("반가워요우");
			pw.println(100);
			pw.println(new Integer("1000"));
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fw != null)fw.close();
				if(bw != null)bw.close();
				if(pw != null)pw.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
