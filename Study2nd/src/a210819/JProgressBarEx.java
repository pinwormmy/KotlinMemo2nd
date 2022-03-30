package a210819;

import java.awt.event.*;
import javax.swing.*;

public class JProgressBarEx extends JFrame implements ActionListener{
	
	private JProgressBar progressBar1;
	private JButton startButton;
	private int currentValue;
	public JProgressBarEx() {
		
		super("JProgressBar Test");
		
		startButton = new JButton("Start");
		progressBar1 = new JProgressBar(0, 1000);
		
		progressBar1.setValue(0);
		progressBar1.setStringPainted(true);
		
		JPanel panel = new JPanel();
		panel.add(startButton);
		panel.add(progressBar1);
		
		add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		startButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		currentValue += 100;
		progressBar1.setValue(currentValue);
		if(currentValue == 1000)
			currentValue = 0;
	}
	
	public static void main(String[] args) {
		new JProgressBarEx();
	}

}
