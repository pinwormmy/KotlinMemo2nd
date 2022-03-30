package a210810;

import java.awt.*;

public class MenuEx extends Frame {
	public MenuEx() {
		super("Menu Test");
		
		MenuBar mb = new MenuBar();
		
		Menu mnufile = new Menu("파일");
		Menu mnucolor = new Menu("색상");
		Menu mnuhelp = new Menu("도움말");
		
		MenuItem mnunew = new MenuItem("새파일");
		MenuItem mnusave = new MenuItem("저장");
		MenuItem mnuopen = new MenuItem("열기");
		MenuItem mnuexit = new MenuItem("종료");
		
		mnufile.add(mnunew);
		mnufile.add(mnusave);
		mnufile.add(mnuopen);
		mnufile.addSeparator();
		mnufile.add(mnuexit);
		
		Menu mnuforecolor = new Menu("글자색");
		mnucolor.add(mnuforecolor);
		
		CheckboxMenuItem mnublack = new CheckboxMenuItem("검정색", true);
		CheckboxMenuItem mnured = new CheckboxMenuItem("빨간색");
		CheckboxMenuItem mnublue = new CheckboxMenuItem("파란색");
		
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
