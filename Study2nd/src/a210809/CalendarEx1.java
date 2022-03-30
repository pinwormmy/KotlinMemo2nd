package a210809;

import java.util.Calendar;
import static java.lang.System.out;

public class CalendarEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("���� ");
		Calendar now = Calendar.getInstance();
		
		int week_yy = now.get(now.WEEK_OF_YEAR);
		int yy = now.get(now.YEAR);
		int mm = now.get(now.MONTH)+1; // 1���� 0�� ���.
		int dd = now.get(now.DAY_OF_MONTH);
		
		sb.append(week_yy);
		sb.append("��°�� ");
		sb.append(yy);
		sb.append("�� ");
		sb.append(mm);
		sb.append("�� ");
		sb.append(dd);
		sb.append("���Դϴ�.");
		
		out.println(sb.toString());
	}

}
