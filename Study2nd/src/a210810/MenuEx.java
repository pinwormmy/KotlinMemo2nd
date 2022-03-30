package a210810;

import java.awt.*;

public class MenuEx extends Frame {
	public MenuEx() {
		super("Menu Test");
		
		MenuBar mb = new MenuBar();
		
		Menu mnufile = new Menu("����");
		Menu mnucolor = new Menu("����");
		Menu mnuhelp = new Menu("����");
		
		MenuItem mnunew = new MenuItem("������");
		MenuItem mnusave = new MenuItem("����");
		MenuItem mnuopen = new MenuItem("����");
		MenuItem mnuexit = new MenuItem("����");
		
		mnufile.add(mnunew);
		mnufile.add(mnusave);
		mnufile.add(mnuopen);
		mnufile.addSeparator();
		mnufile.add(mnuexit);
		
		Menu mnuforecolor = new Menu("���ڻ�");
		mnucolor.add(mnuforecolor);
		
		CheckboxMenuItem mnublack = new CheckboxMenuItem("������", true);
		CheckboxMenuItem mnured = new CheckboxMenuItem("������");
		CheckboxMenuItem mnublue = new CheckboxMenuItem("�Ķ���");
		
		mnuforecolor.add(mnublack);
		mnuforecolor.add(mnured);
		mnuforecolor.add(mnublue);
		
		mb.add(mnufile);
		mb.add(mnucolor);
		mb.add(mnuhelp);
		
		setMenuBar(mb);
		
		setSize(300,300);
		setVisible(true);		
	}
	public static void main(String[] args) {
		new MenuEx();
	}

}
