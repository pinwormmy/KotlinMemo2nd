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
			{"zero","LISA", 1234, "�����±���"},
			{"one", "����", 1212, "���λ��ڳ�"},
			{"two", "��", 1234, "�Ϳ�����"},
			{"three", "������", 1231, "����ٴ�"}
	}; // ������ ����� �ȵ�..
	
	String[] name = {"���̵�","�̸�","��й�ȣ","Ư¡"};
	
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
