package a210813;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx extends Frame implements ActionListener{
	
	Point first_point, last_point, old_point;
	MenuItem menu_tool_pen, menu_tool_line, menu_tool_circle, menu_tool_rect;
	String str = "��";
	
	public GraphicsEx() {
		super("Graphics Test");
		
		MenuBar mb = new MenuBar();
		
		Menu menu_tool = new Menu("����");
		
		menu_tool_pen = new MenuItem("��");
		menu_tool_line = new MenuItem("��");
		menu_tool_circle = new MenuItem("��");
		menu_tool_rect = new MenuItem("�簢��");
		
		menu_tool.add(menu_tool_pen);
		menu_tool.add(menu_tool_line);
		menu_tool.add(menu_tool_circle);
		menu_tool.add(menu_tool_rect);
		
		mb.add(menu_tool);
		setMenuBar(mb);
		
		add(new GrimPanCanvas(), BorderLayout.CENTER);
		
		setBounds(200,200,400,400);
		setVisible(true);
		
		menu_tool_pen.addActionListener(this);
		menu_tool_line.addActionListener(this);
		menu_tool_circle.addActionListener(this);
		menu_tool_rect.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		MenuItem selected_menu = (MenuItem)ae.getSource();
		
		if(selected_menu.equals(menu_tool_pen)) {
			str = menu_tool_pen.getLabel();
		}else if(selected_menu.equals(menu_tool_line)) {
			str = menu_tool_line.getLabel();
		}else if(selected_menu.equals(menu_tool_circle)) {
			str = menu_tool_circle.getLabel();
		}else if(selected_menu.equals(menu_tool_rect)) {
			str = menu_tool_rect.getLabel();
		}
	}
	
	public static void main(String[] args) {
		new GraphicsEx();
	}
	
	class GrimPanCanvas extends Canvas implements MouseMotionListener, MouseListener{
		
		public GrimPanCanvas() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		public void mouseClicked(MouseEvent me) {}
		public void mouseEntered(MouseEvent me) {}
		public void mouseExited(MouseEvent me) {}
		
		public void mousePressed(MouseEvent me) {
			first_point = me.getPoint();
			old_point = me.getPoint();
		}
		
		public void mouseReleased(MouseEvent me) {
			last_point = me.getPoint();
			repaint();
		}
		
		public void mouseDragged(MouseEvent me) {
			last_point = me.getPoint();
			repaint();
		}		
		
		public void mouseMoved(MouseEvent me) {}
		
		public void update(Graphics g) {
			paint(g);
		}
		
		public void paint(Graphics g) {
			if(first_point != null && last_point != null) {
				if(str.equals("��")) {
					g.drawLine(first_point.x, first_point.y, last_point.x, last_point.y);
					first_point = last_point;
					
					return;
				}
				if(str.equals("��")) {
					g.setColor(Color.WHITE);
					g.drawLine(first_point.x, first_point.y, old_point.x, old_point.y);
					
					g.setColor(Color.BLACK);
					g.drawLine(first_point.x, first_point.y, last_point.x, last_point.y);
				}else if(str.equals("��")) {
					g.setColor(new Color(255,255,255));
					g.fillOval(first_point.x, first_point.y, 
							old_point.x-first_point.x, old_point.y-first_point.y);
					
					g.setColor(new Color(0,0,255));
					g.fillOval(first_point.x, first_point.y, 
							last_point.x-first_point.x, last_point.y-first_point.y);
				}else if(str.equals("�簢��")) {
					g.setColor(new Color(255,255,255));
					g.fillRect(first_point.x, first_point.y, 
							old_point.x-first_point.x, old_point.y-first_point.y);
					
					g.setColor(new Color(255,0,0));
					g.fillRect(first_point.x, first_point.y, 
							last_point.x-first_point.x, last_point.y-first_point.y);
				}
				old_point = last_point;
				
			}
		}
	}

}
