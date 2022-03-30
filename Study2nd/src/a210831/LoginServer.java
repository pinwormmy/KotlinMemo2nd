package a210831;

// 9.1 작성분

import java.net.*;
import java.io.*;

public class LoginServer {
	public static void main(String[] args) throws IOException, 
	ClassNotFoundException, InterruptedException {
		ServerSocket sSocket = new ServerSocket(3000);
		System.out.println("클라이언트 접속 대기중...");
		Socket socket = sSocket.accept();
		System.out.println("클라이언트 접속");
		
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		
		Protocol protocol = new Protocol(Protocol.PT_REQ_LOGIN);
		// 로그인 정보 요청 패킷을 전송
		os.write(protocol.getPacket());
		while(true) {
			protocol = new Protocol();
			// 기본적으로 1000개의 byte가 잡혀있음
			byte[] buf = protocol.getPacket();
			is.read(buf);
			// 패킷 타입을 얻음
			int packetType = buf[0];
			protocol.setPacket(packetType, buf);
			if(packetType == Protocol.PT_EXIT) {
				protocol = new Protocol(Protocol.PT_EXIT);
				os.write(protocol.getPacket());
				System.out.println("서버종료");
				break;
			}
			switch(packetType) {
			// 클라이언트가 로그인 정보 응답 패킷인 경우
			case Protocol.PT_RES_LOGIN:
				System.out.println("클라이언트가" + "로그인 정보를 보냈습니다.");
				String id = protocol.getId();
				String password = protocol.getPassword();
				System.out.println(id + password);
				if(id.equals("pinwormmy")) {
					if(password.equals("1111")) {
						//로그인 성공
						protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
						protocol.setLoginResult("1");
						System.out.println("로그인 성공");
					}else {
						// 암호 틀림
						protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
						protocol.setLoginResult("2");
						System.out.println("암호 틀림");
					}
				}else {
					// 아이디 존재 안함
					protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
					protocol.setLoginResult("3");
					System.out.println("아이디가 존재하지 않습니다.");
				}
				System.out.println("로그인 처리 결과 전송");
				os.write(protocol.getPacket());
				break;
			} // end switch
		} // end while
		is.close();
		os.close();
		socket.close();
	}
}
