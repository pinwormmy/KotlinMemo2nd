package a210907;

import java.sql.*;

public class JdbcEx {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String arg[]) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle.thin:@localhost:1521:xe",
					"System", "0215");
			Statement stmt = con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("create table test1(id varchar(10),");
			sb.append("age number");
			int updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("createCount : " + updateCount);
			
			sb.setLength(0);
			sb.append("insert into test1 values ('pinwormmy'");
			sb.append(",10)");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("insertCount : " + updateCount);
			
			sb.setLength(0);
			sb.append("select * from test1");
			ResultSet rs = stmt.executeQuery(sb.toString());
			while(rs.next()) {
				System.out.print("id : " + rs.getString(1) + " , ");
				System.out.println("age : " + rs.getString("age"));
			}
			
			sb.setLength(0);
			sb.append("update test1 set id = 'pinwormmy2',");
			sb.append("age = 20 where id = 'pinwormmy'");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("updateCount : " + updateCount);
			
			sb.setLength(0);
			sb.append("select * from test1");
			rs = stmt.executeQuery(sb.toString());
			while(rs.next()) {
				System.out.print("id : " + rs.getString(1) + " , ") ;
				System.out.println("age : " + rs.getString("age"));
			}
			
			sb.setLength(0);
			sb.append("delete from test1");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("deleteCount : " + updateCount);
			
			sb.setLength(0);
			sb.append("drop table test1");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("dropCount : " + updateCount);
			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException ee) {
			System.out.println("Connnection Error");
			ee.printStackTrace();
		}
	}

}
