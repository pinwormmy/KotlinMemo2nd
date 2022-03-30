package a210824;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ScoreWriter {
	public ScoreWriter(RspInfo info) {
		String path = "d:/test/RspScore/" + info.getName().trim() + "/UserInfo.sav";
		
		File dir = new File("d:/test/RspScore");
		
		if(!dir.exists())
			dir.mkdir();
		
		File dir2 = new File(dir, info.getName().trim());
		if(!dir2.exists())
			dir2.mkdir(); // 유저 입력 아디로 폴더 생성
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(info);
			if(oos != null)
				oos.close();
			
			System.out.println("(전적이 저장됩니다.)");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("(전적 저장을 실패했습니다...)");
		}
	}
}
