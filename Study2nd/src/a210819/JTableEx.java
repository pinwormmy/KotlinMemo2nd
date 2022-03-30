package a210819;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class JTableEx extends JFrame{
	
	JTable table;
	JTableModel model;
	
	public JTableEx() {
		
		model = new JTableModel();
		table = new JTable(model);
		add(new JScrollPane(table));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(200,200,300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableEx();
	}
}

///////////////////////////////////////////////////////////

class JTableModel extends AbstractTableModel{
	Object[][] data = {
			{"zero","LISA", 1234, "블핑태국애"},
			{"one", "제니", 1212, "블핑샤넬녀"},
			{"two", "츄", 1234, "귀염둥이"},
			{"three", "아이유", 1231, "다재다능"}
	}; // 적용이 제대로 안됨..
	
	String[] name = {"아이디","이름","비밀번호","특징"};
	
	public int getColumnCount() {
		return name.length;
	}
	
	public int getRowCount() {
		return data.length;
	}
	
	public Object getVauleAt(int r, int c) {
		return data[r][c];
	}
	
	public boolean isCellEditable(int r, int c) {
		return (c != 0) ? true : false ;
	}
	
	public String getColumnName(int c) {
		return name[c];
	}
	
	public void setValueAt(Object obj, int r, int c) {
		data[r][c] = obj;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
