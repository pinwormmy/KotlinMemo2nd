package a210809;

import java.util.Properties;
import java.util.Enumeration;
import static java.lang.System.out;

public class PropertiesEx1 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.put("UserName", "John");
		prop.setProperty("lovely", "Lisa");
		prop.setProperty("dbDRV", "oracle.jdbc.driver.OracleDriver");
		String user = prop.getProperty("UserName");
		String love = prop.getProperty("lovely");
		String db_drv = prop.getProperty("dbDRV");
		out.println(user);
		out.println(love);
		out.println(db_drv);
		
		out.println("------------- keys -------------");
		// 키 값들만 얻어내기
		Enumeration keys = prop.propertyNames(); // 역순으로 저장함.(선입후출)
		//while(keys.hasMoreElements())
			out.println(keys.nextElement());
		
		prop.list(System.out); // 속성 목록 출력하기

	}

}
