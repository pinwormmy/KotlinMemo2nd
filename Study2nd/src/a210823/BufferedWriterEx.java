package a210823;

import java.io.*;

public class BufferedWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("d:\\test\\bufferWriter.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter Test �Գ״ٸ�");
			bw.newLine();
			bw.write("�ȳ��ϼ���" + System.getProperty("line.separator"));
			bw.write("���� �� �־�� ������ ����");
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
