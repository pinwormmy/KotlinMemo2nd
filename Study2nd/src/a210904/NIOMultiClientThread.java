package a210904;

import java.io.IOException;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.util.*;

public class NIOMultiClientThread extends Thread {
	private NIOMultiClient mc;
	private Charset charset;
	private CharsetDecoder decoder;
	public NIOMultiClientThread(NIOMultiClient mc) {
		this.mc = mc;
		charset = Charset.forName("KSC5601");
		decoder = charset.newDecoder();
	}
	public void run() {
		String message = null;
		String[] receivedMsg = null;
		Selector selector = mc.getSelector();
		boolean isStop = false;
		while(!isStop) {
			try {
				selector.select();
				Iterator iterator = selector.selectedKeys().iterator();
				while(iterator.hasNext()) {
					SelectionKey key = (SelectionKey)iterator.next();
					if(key.isReadable()) {
						message = read(key);
					}
					iterator.remove();
				} // end while
				receivedMsg = message.split("#");
			}catch(Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			System.out.println(receivedMsg[0] + ", " + receivedMsg[1]);
			if(receivedMsg[1].equals("exit")) {
				if(receivedMsg[0].equals(mc.getId())) {
					mc.exit();
				}else {
					mc.getJta().append(receivedMsg[0] + "¥‘¿Ã ¡æ∑·«œºÃΩ¿¥œ¥Ÿ." 
				+ System.getProperty("line.separator"));
					mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
				}
			}else {
				mc.getJta().append(receivedMsg[0] + " : " + receivedMsg[1] + System.getProperty("line.separator"));
				mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
			}
		}
	}
	
	public String read(SelectionKey key) {
		SocketChannel sc = (SocketChannel)key.channel();
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		try {
			sc.read(buffer);
		}catch(IOException e) {
			e.printStackTrace();
			try {
				sc.close();
			}catch(IOException ioe) {
			}
		}
		System.out.println(buffer);
		buffer.flip();
		String message = null;
		try {
			message = decoder.decode(buffer).toString();
		}catch(CharacterCodingException e) {
			e.printStackTrace();
		}
		System.out.println("message : " + message);
		return message;
	}

}
