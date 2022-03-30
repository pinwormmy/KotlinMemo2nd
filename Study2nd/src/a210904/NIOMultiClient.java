package a210904;

// 9.5 �ۼ���..

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.Scanner;

public class NIOMultiClient implements ActionListener{
	private JFrame jframe;
	private JTextField jtf;
	private JTextArea jta;
	private JLabel jlb1, jlb2;
	private JPanel jp1, jp2;
	private String ip;
	private String id;
	private JButton jbtn;
	private Selector selector;
	private SocketChannel sc;
	private ByteBuffer buffer;
	public NIOMultiClient(String argIp, String argId) {
		ip = argIp;
		id = argId;
		jframe = new JFrame("NIO Multi Chatting");
		jtf = new JTextField(30);
		jta = new JTextArea("", 10, 50);
		jlb1 = new JLabel("Usage ID : [[ " + id + "]]");
		jlb2 = new JLabel("IP : " + ip);
		jbtn = new JButton("����");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jlb1.setBackground(Color.yellow);
		jlb2.setBackground(Color.green);
		jta.setBackground(Color.pink);
		jp1.setLayout(new BorderLayout());
		jp2.setLayout(new BorderLayout());
		
		jp1.add(jbtn, BorderLayout.EAST);
		jp1.add(jtf, BorderLayout.CENTER);
		jp2.add(jlb1, BorderLayout.CENTER);
		jp2.add(jlb2, BorderLayout.EAST);
		
		jframe.add(jp1, BorderLayout.SOUTH);
		jframe.add(jp2, BorderLayout.NORTH);
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jframe.add(jsp, BorderLayout.CENTER);
		
		jtf.addActionListener(this);
		jbtn.addActionListener(this);
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					buffer.clear();
					String msg = id + "#exit";
					buffer.put(msg.getBytes());
					buffer.flip();
					sc.write(buffer);
				}catch(IOException ee) {
					ee.printStackTrace();
				}
				System.exit(0);
			}
			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});
		jta.setEditable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		jframe.pack();
		jframe.setLocation((screenHeight-jframe.getWidth())/2, (screenWidth-jframe.getHeight())/2);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf.getText();
		if(obj == jtf) {
			if(msg == null || msg.length() == 0) {
				JOptionPane.showMessageDialog(jframe, "���� ������", "���", 
						JOptionPane.WARNING_MESSAGE);
			}else {
				try {
					msg = id + "#" + msg;
					buffer.clear();
					buffer.put(msg.getBytes());
					buffer.flip();
					sc.write(buffer);
				}catch(IOException ee) {
					ee.printStackTrace();
				}
				jtf.setText(" ");
			}
		}else if(obj == jbtn) {
			try {
				buffer.clear();
				msg = id + "#exit";
				buffer.put(msg.getBytes());
				buffer.flip();
				sc.write(buffer);
			}catch(IOException ee) {
				ee.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	public void exit() {
		System.exit(0);
	}
	public void init() throws IOException{
		buffer = ByteBuffer.allocateDirect(1024);
		selector = Selector.open();
		sc = SocketChannel.open(new InetSocketAddress(ip, 3000));
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
		NIOMultiClientThread ct = new NIOMultiClientThread(this);
		Thread t = new Thread(ct);
		t.start();
	}
	
	public static void main(String args[]) throws IOException{
		JFrame.setDefaultLookAndFeelDecorated(true);
		Scanner sc = new Scanner(System.in);
		System.out.print("ip : ");
		String ip = sc.next();
		System.out.print("id : ");
		String id = sc.next();
		NIOMultiClient cc = new NIOMultiClient(ip, id);
		cc.init();
		sc.close();
	}
	public JTextArea getJta() {
		return jta;
	}
	public String getId() {
		return id;
	}
	public Selector getSelector() {
		return selector;
	}
}


