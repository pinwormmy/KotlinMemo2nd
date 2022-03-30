package a210903;

import java.nio.*;

public class ByteBufferEx {
	public static void main(String[] args) {
		ByteBuffer byteBuf1 = ByteBuffer.allocate(12);
		System.out.println(byteBuf1);
		byteBuf1.putInt(100);
		System.out.println(byteBuf1);
		byteBuf1.putDouble(12.10);
		System.out.println(byteBuf1);
		byteBuf1.flip();
		System.out.println(byteBuf1.getInt());
		System.out.println(byteBuf1.getDouble());
		
		ByteBuffer byteBuf2 = ByteBuffer.allocate(6);
		System.out.println(byteBuf2);
		byteBuf2.putChar('ªr');
		System.out.println(byteBuf2);
		byteBuf2.putFloat(23.45f);
		System.out.println(byteBuf2);
		byteBuf2.flip();
		System.out.println(byteBuf2.getChar());
		System.out.println(byteBuf2.getFloat());
	}

}
