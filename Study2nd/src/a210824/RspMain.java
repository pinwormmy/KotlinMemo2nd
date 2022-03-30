package a210824;

import java.util.Random;
import java.util.Scanner;

public class RspMain {
	public static void main(String[] args) {
		
		RspInfo rinfo = new RspInfo();
		
		String id;
		int win =0, lose = 0, draw = 0;
		
		System.out.print("ID �Է� : ");
		Scanner scan = new  Scanner(System.in);
		id = scan.nextLine();
		rinfo.setName(id.trim());
		
		try {
			ScoreLoader loader = new ScoreLoader(rinfo);
			win = loader.getInfo().getWin();
			lose = loader.getInfo().getLose();
			draw = loader.getInfo().getDraw();
			
			rinfo.setWin(win);
			rinfo.setDraw(draw);
			rinfo.setLose(lose);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(win + "��, " + lose + "��, " + draw + "��");
		
		while(true) {
			int random = new Random().nextInt(3);
			// 0 : ���� 1 : ���� : 2 : ��
			System.out.print("����(1) | ����(2) | ��(3) ? : ");
			String user = scan.next();
			int usercnt = 0;
			
			if(user.equalsIgnoreCase("1")) {
				usercnt = 0;
			}else if(user.equalsIgnoreCase("2")) {
				usercnt = 1;
			}else if(user.equalsIgnoreCase("3")) {
				usercnt = 2;
			}else {
				System.out.println("�Է� ����. �ٽ� �ȹٷ� ��");
				continue;
			}
			
			if(usercnt - random == -2 || usercnt - random == 1) {
				System.out.println("�̰���ϴ�!!");
				rinfo.setWin(++win);
			}else if(usercnt -random == 0){
				System.out.println("�����ϴ�~");
				rinfo.setDraw(++draw);
			}else{
				System.out.println("�����ϴ�...");
				rinfo.setDraw(++lose);
			}
			
			System.out.println(rinfo.getWin() + "�� " + rinfo.getLose() + "�� " + rinfo.getDraw() + "��");
			System.out.print("���Ǵ�? y|n : ");
			String select = scan.next();
			
			if(!select.equals("y")) {
				break;
			}
		} //while()
		System.out.println("���� ����");
			
			
		try {
			ScoreWriter sw = new ScoreWriter(rinfo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
