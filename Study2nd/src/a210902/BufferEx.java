package a210902;

import java.nio.*;

public class BufferEx {
	public static void main(String[] args) {
		IntBuffer intBuf = IntBuffer.allocate(5);
		intBuf.put(1000);
		intBuf.put(2000);
		intBuf.put(3000);
		intBuf.put(4000);
		
		intBuf.flip();
		while(intBuf.hasRemaining()) {
			System.out.println("첫번째 : " + intBuf.get());
		}
		System.out.println();
		intBuf.clear();
		intBuf.put(4,5000);
		intBuf.rewind();
		while(intBuf.hasRemaining()) {
			System.out.println("두번째 : " + intBuf.get());
		}
	}

}
