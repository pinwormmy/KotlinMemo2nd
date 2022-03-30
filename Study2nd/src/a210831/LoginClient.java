package a210831;

// 9.1 �ۼ���
// �ù� ���� �ȵǴµ� ���� ��ã��..

import java.net.*;
import java.io.*; 

public class LoginClient {
	public static void main(String[] args) throws IOException, 
	ClassNotFoundException, InterruptedException{
		if(args.length < 2)
			System.out.println("���� : " + "java LoginClient �ּ� ��Ʈ��ȣ");
		
		Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		Protocol protocol = new Protocol();
		byte[] buf = protocol.getPacket();
		while(true) {
			is.read(buf);
			int packetType = buf[0];
			protocol.setPacket(packetType, buf);
			if(packetType == Protocol.PT_EXIT) {
				System.out.println("Ŭ���̾�Ʈ ����");
				break;
			}
			switch(packetType) {
			case Protocol.PT_REQ_LOGIN:
				System.out.println("������ �α��� ���� ��û");
				BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("���̵� : ");
				String id = userIn.readLine();
				System.out.print("�н����� : ");
				String pwd = userIn.readLine();
				// ������ ��Ŷ ����
				protocol = new Protocol(Protocol.PT_RES_LOGIN);
				protocol.setId(id);
				protocol.setPassword(pwd);
				System.out.println("�α��� ���� ����");
				os.write(protocol.getPacket());
				break;
			case Protocol.PT_LOGIN_RESULT:
				System.out.println("������ �α��� ��� ����");
				String result = protocol.getLoginResult();
				if(result.equals("1")) {
					System.out.println("�α��� ����");
				}else if(result.equals("2")) {
					System.out.println("�н����� Ʋ��");
				}else if(result.equals("3")) {
					System.out.println("���̵� �������� �ʽ��ϴ�.");
				}
				protocol = new Protocol(Protocol.PT_EXIT);
				System.out.println("���� ��Ŷ ����");
				os.write(protocol.getPacket());
				break;
			}
		}
		os.close();
		is.close();
		socket.close();
	}

}
