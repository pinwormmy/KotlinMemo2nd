package a210831;

// 9.1 �ۼ���

import java.net.*;
import java.io.*;

public class LoginServer {
	public static void main(String[] args) throws IOException, 
	ClassNotFoundException, InterruptedException {
		ServerSocket sSocket = new ServerSocket(3000);
		System.out.println("Ŭ���̾�Ʈ ���� �����...");
		Socket socket = sSocket.accept();
		System.out.println("Ŭ���̾�Ʈ ����");
		
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		
		Protocol protocol = new Protocol(Protocol.PT_REQ_LOGIN);
		// �α��� ���� ��û ��Ŷ�� ����
		os.write(protocol.getPacket());
		while(true) {
			protocol = new Protocol();
			// �⺻������ 1000���� byte�� ��������
			byte[] buf = protocol.getPacket();
			is.read(buf);
			// ��Ŷ Ÿ���� ����
			int packetType = buf[0];
			protocol.setPacket(packetType, buf);
			if(packetType == Protocol.PT_EXIT) {
				protocol = new Protocol(Protocol.PT_EXIT);
				os.write(protocol.getPacket());
				System.out.println("��������");
				break;
			}
			switch(packetType) {
			// Ŭ���̾�Ʈ�� �α��� ���� ���� ��Ŷ�� ���
			case Protocol.PT_RES_LOGIN:
				System.out.println("Ŭ���̾�Ʈ��" + "�α��� ������ ���½��ϴ�.");
				String id = protocol.getId();
				String password = protocol.getPassword();
				System.out.println(id + password);
				if(id.equals("pinwormmy")) {
					if(password.equals("1111")) {
						//�α��� ����
						protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
						protocol.setLoginResult("1");
						System.out.println("�α��� ����");
					}else {
						// ��ȣ Ʋ��
						protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
						protocol.setLoginResult("2");
						System.out.println("��ȣ Ʋ��");
					}
				}else {
					// ���̵� ���� ����
					protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
					protocol.setLoginResult("3");
					System.out.println("���̵� �������� �ʽ��ϴ�.");
				}
				System.out.println("�α��� ó�� ��� ����");
				os.write(protocol.getPacket());
				break;
			} // end switch
		} // end while
		is.close();
		os.close();
		socket.close();
	}
}
