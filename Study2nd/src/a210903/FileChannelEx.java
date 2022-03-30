package a210903;

import java.nio.channels.*;
import java.nio.*;
import java.io.*;

public class FileChannelEx {
	public static void main(String[] args) throws IOException{
		RandomAccessFile raf = new RandomAccessFile("d:\\test\\filechannel.txt", "rw");
		FileChannel fc = raf.getChannel();
		
		String message = "æ»≥Á«œººø‰..";
		ByteBuffer byteBuf1 = ByteBuffer.allocate(12);
		byteBuf1.put(message.getBytes());
		byteBuf1.flip();
		fc.write(byteBuf1);
		
		ByteBuffer byteBuf2 = ByteBuffer.allocate(12);
		fc.position(0);
		fc.read(byteBuf2);
		byteBuf2.flip();
		byte[] b = byteBuf2.array();
		System.out.println(new String(b));
		
	}

}
