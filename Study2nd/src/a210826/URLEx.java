package a210826;

import java.net.*;
import java.io.*;

public class URLEx {
	public static void main(String[] args) throws MalformedURLException, IOException {
		URL url = new URL("https", "www.google.com", 8800, "index.jsp?name=pinwormmy#content");
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		int defaultPort = url.getDefaultPort();
		
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		String _url = url.toExternalForm();
		String mixUrl = null;
		if(port == -1) {
			mixUrl = protocol + "//" + host + path + "?" + query + "#" + ref;
		}else {
			mixUrl = protocol + "//" + host + ":" + port + path + "?" + query + "#" + ref;
		}
		if(port == -1) port = url.getDefaultPort();
		System.out.printf("�������� : %s %n", protocol);
		System.out.printf("ȣ��Ʈ : %s %n", host);
		System.out.printf("��Ʈ : %s %n", port);
		System.out.printf("�н� : %s %n", path);
		System.out.printf("���� : %s %n", query);
		System.out.printf("ref : %s %n", ref);
		System.out.printf("mixURL : %s %n", mixUrl);
		System.out.printf("URL : %s %n", _url);
		
		url = new URL("https://www.google.com/");
		InputStream input = url.openStream();
		int readByte;
		System.out.println("=== ���� ���� ===");
		while(((readByte = input.read()) != -1)) {
			System.out.print((char)readByte);
		}
		input.close();
	}
}
