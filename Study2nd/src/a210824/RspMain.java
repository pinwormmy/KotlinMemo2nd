package a210824;

import java.util.Random;
import java.util.Scanner;

public class RspMain {
	public static void main(String[] args) {
		
		RspInfo rinfo = new RspInfo();
		
		String id;
		int win =0, lose = 0, draw = 0;
		
		System.out.print("ID 입력 : ");
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
		System.out.println(win + "승, " + lose + "패, " + draw + "무");
		
		while(true) {
			int random = new Random().nextInt(3);
			// 0 : 가위 1 : 바위 : 2 : 보
			System.out.print("가위(1) | 바위(2) | 보(3) ? : ");
			String user = scan.next();
			int usercnt = 0;
			
			if(user.equalsIgnoreCase("1")) {
				usercnt = 0;
			}else if(user.equalsIgnoreCase("2")) {
				usercnt = 1;
			}else if(user.equalsIgnoreCase("3")) {
				usercnt = 2;
			}else {
				System.out.println("입력 오류. 다시 똑바로 써");
				continue;
			}
			
			if(usercnt - random == -2 || usercnt - random == 1) {
				System.out.println("이겼습니다!!");
				rinfo.setWin(++win);
			}else if(usercnt -random == 0){
				System.out.println("비겼습니다~");
				rinfo.setDraw(++draw);
			}else{
				System.out.println("졌습니다...");
				rinfo.setDraw(++lose);
			}
			
			System.out.println(rinfo.getWin() + "승 " + rinfo.getLose() + "패 " + rinfo.getDraw() + "무");
			System.out.print("한판더? y|n : ");
			String select = scan.next();
			
			if(!select.equals("y")) {
				break;
			}
		} //while()
		System.out.println("게임 종료");
			
			
		try {
			ScoreWriter sw = new ScoreWriter(rinfo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
