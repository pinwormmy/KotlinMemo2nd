package a210831;

import java.io.*;

public class Protocol implements Serializable{
	public static final int PT_UNDEFINED = -1;
	public static final int PT_EXIT = 0;
	public static final int PT_REQ_LOGIN = 1;
	public static final int PT_RES_LOGIN = 2;
	public static final int PT_LOGIN_RESULT = 3;
	public static final int LEN_LOGIN_ID = 20;
	public static final int LEN_LOGIN_PASSWORD = 20;
	public static final int LEN_LOGIN_RESULT = 2;
	public static final int LEN_PROTOCOL_TYPE = 1;
	public static final int LEN_MAX = 1000;
	protected int protocolType;
	private byte[] packet;
	public Protocol() {
		this(PT_UNDEFINED);
	}
	public Protocol(int protocolType) {
		this.protocolType = protocolType;
		getPacket(protocolType);
	}
	public byte[] getPacket(int protocolType) {
		if(packet == null) {
			switch(protocolType) {
			case PT_REQ_LOGIN : 
				packet = new byte[LEN_PROTOCOL_TYPE];
				break;
			case PT_RES_LOGIN : 
				packet = new byte[LEN_PROTOCOL_TYPE + LEN_LOGIN_ID + LEN_LOGIN_PASSWORD];
				break;
			case PT_UNDEFINED : 
				packet = new byte[LEN_MAX];
				break;
			case PT_LOGIN_RESULT : 
				packet = new byte[LEN_PROTOCOL_TYPE + LEN_LOGIN_RESULT];
				break;
			case PT_EXIT : 
				packet = new byte[LEN_PROTOCOL_TYPE];
				break;
			}
		}
		
		packet[0] = (byte)protocolType;
		return packet;
	}
	
	public String getLoginResult() {
		return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_RESULT).trim();
	}
	public void setLoginResult(String ok) {
		System.arraycopy(ok.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, ok.trim().getBytes().length);
		packet[LEN_PROTOCOL_TYPE + ok.trim().getBytes().length] = '\0';
	}
	public void setProtocolType(int protocolType) {
		this.protocolType = protocolType;
	}
	public int getProtocolType() {
		return protocolType;
	}
	public byte[] getPacket() {
		return packet;
	}
	public void setPacket(int pt, byte[] buf) {
		packet = null;
		packet = getPacket(pt);
		protocolType = pt;
		System.arraycopy(buf, 0, packet, 0, packet.length);
	}
	public String getId() {
		return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_ID).trim();
	}
	public void setId(String id) {
		System.arraycopy(id.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, id.trim().getBytes().length);
		packet[LEN_PROTOCOL_TYPE + id.trim().getBytes().length] = '\0';
	}
	public String getPassword() {
		return new String(packet, LEN_PROTOCOL_TYPE + LEN_LOGIN_ID, LEN_LOGIN_PASSWORD).trim();
	}
	public void setPassword(String password) {
		System.arraycopy(password.trim().getBytes(), 0, packet, 
				LEN_PROTOCOL_TYPE + LEN_LOGIN_ID, password.trim().getBytes().length);
		packet[LEN_PROTOCOL_TYPE + LEN_LOGIN_ID + password.trim().getBytes().length] = '\0';
		
	}
}
