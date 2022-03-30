package a210816;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class JEditorPaneEx extends JFrame{
	
	public JEditorPaneEx() throws IOException{
		super("JEditorPane Test");
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setPage("https://www.hanbit.co.kr/");
		JScrollPane sp = new JScrollPane(editorPane);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(800,600));
		add(sp);
		pack();
		setLocation(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws IOException{
		new JEditorPaneEx();
	}

}
