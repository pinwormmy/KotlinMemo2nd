package a210826;

import java.net.*;

public class InetAddressEx {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress iaddr = InetAddress.getLocalHost();
		System.out.printf("ȣ��Ʈ �̸� : %s %n", iaddr.getHostName());
		System.out.printf("ȣ��Ʈ IP�ּ� : %s %n", iaddr.getHostAddress());
		iaddr = InetAddress.getByName("www.naver.com");
		System.out.printf("ȣ��Ʈ �̸� : %s %n", iaddr.getHostName());
		System.out.printf("ȣ��Ʈ IP�ּ� : %s %n", iaddr.getHostAddress());
		InetAddress sw[] = InetAddress.getAllByName("www.daum.net");
		for(InetAddress temp_sw : sw) {
			System.out.printf("ȣ��Ʈ �̸� : %s , ", temp_sw.getHostName());
			System.out.printf("ȣ��Ʈ IP�ּ� : %s %n", temp_sw.getHostAddress());
		}
		
		
	}

}
