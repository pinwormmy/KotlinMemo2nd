package a210810;

import java.awt.Frame;

public class FrameEx2 extends Frame{
	
	public FrameEx2() {
		super("frame test");
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FrameEx2 fe = new FrameEx2();
	}

}
