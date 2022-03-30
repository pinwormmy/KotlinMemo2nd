package a210824;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ScoreLoader {
	private RspInfo info;
	
	public RspInfo getInfo() {
		return info;
	}
	
	public ScoreLoader(RspInfo info) {
		this.info = info;
		
		String path = "d:/test/RspScore/" + info.getName().trim() + "/UserInfo.sav";
		File f1 = new File(path);
		
		if(f1.exists()) {
			try {
				ObjectInputStream ois = 
						new ObjectInputStream(new FileInputStream(path));
				this.info = (RspInfo)ois.readObject();
				
				if(ois != null)
					ois.close();
				
				System.out.println("로드성공");
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("로드실패");
			}
		}else {
			System.out.println("새로운 ID 생성");
		}
	}
}

