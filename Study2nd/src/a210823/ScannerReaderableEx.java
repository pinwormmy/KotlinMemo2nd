package a210823;

import java.io.*;
import java.util.*;

public class ScannerReaderableEx {
	public static void main(String[] args) {
		Scanner scan = null;
		FileReader fr = null;
		try {
			fr = new FileReader("d:\\test\\scan.txt");
			scan = new Scanner(fr);
			while(scan.hasNextDouble()) {
				System.out.printf("½ºÄµ double : %,.2f %n", scan.nextDouble());
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fr != null)fr.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			if(scan != null)scan.close();
		}
	}
}
