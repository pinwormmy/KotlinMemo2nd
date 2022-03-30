package a210824;

import java.io.Serializable;

public class RspInfo implements Serializable{
	private int win, lose, draw;
	private String name; // À¯Àú ID
	
	public void setWin(int win) {this.win = win;}
	public void setLose(int lose) {this.lose = lose;}
	public void setDraw(int draw) {this.draw = draw;}
	public void setName(String name) {this.name = name;}
	
	public int getWin() {return win;}
	public int getLose() {return lose;}
	public int getDraw() {return draw;}
	public String getName() {return name;}
}
