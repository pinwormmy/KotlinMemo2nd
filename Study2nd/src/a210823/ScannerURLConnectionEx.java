package a210823;

import java.net.*;
import java.io.*;
import java.util.*;

public class ScannerURLConnectionEx {
	public static void main(String[] args) {
		URLConnection urlCon = null;
		Scanner scan = null;
		try {
			urlCon = new URL("https://www.google.com/").openConnection();
			scan = new Scanner(urlCon.getInputStream());
			scan.useDelimiter("\\Z");
			String text = scan.next();
			System.out.println(text);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(scan != null)scan.close();
		}
	}

}
