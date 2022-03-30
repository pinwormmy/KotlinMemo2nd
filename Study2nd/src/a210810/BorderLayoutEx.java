package a210810;

import java.awt.*;

public class BorderLayoutEx {
	
	public static void main(String[] args) {
		Frame f = new Frame("BorderLayout Test");
		
		Button east = new Button("EAST");
		Button west = new Button("WEST");
		Button center = new Button("CENTER");
		Button south = new Button("SOUTH");
		Button north = new Button("NORTH");
		
		f.add(east, BorderLayout.EAST);
		f.add(west, BorderLayout.WEST);
		f.add(center, BorderLayout.CENTER);
		f.add(south, BorderLayout.SOUTH);
		f.add(north, BorderLayout.NORTH);
		
		f.setLocation(300,300);
		f.setSize(300,200);
		f.setVisible(true);
	}
}
