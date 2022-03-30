package a210810;

import java.awt.*;

public class CanvasEx {
	
	public static void main(String[] args) {
		Frame f = new Frame("Canvas Tset");
		
		MyCanvas canvas = new MyCanvas();
		
		canvas.setBackground(Color.yellow);
		
		f.add(canvas);
		
		f.setLocation(300,300);
		f.setSize(200, 200);
		f.setVisible(true);
	}
}

class MyCanvas extends Canvas{
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(50, 50, 100, 100);
	}
}
