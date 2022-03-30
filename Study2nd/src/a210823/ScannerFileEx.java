package a210823;

import java.io.*;
import java.util.*;

public class ScannerFileEx {
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("d:\\test\\scan.txt"));
			while(scan.hasNextDouble()) {
				System.out.printf("��ĵ double : %,.2f %n", scan.nextDouble());
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			if(scan != null)scan.close();
		}
	}
}
