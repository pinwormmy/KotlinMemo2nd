package a210809;

import java.util.Calendar;
import static java.lang.System.out;

public class CalendarEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("연중 ");
		Calendar now = Calendar.getInstance();
		
		int week_yy = now.get(now.WEEK_OF_YEAR);
		int yy = now.get(now.YEAR);
		int mm = now.get(now.MONTH)+1; // 1월이 0을 기억.
		int dd = now.get(now.DAY_OF_MONTH);
		
		sb.append(week_yy);
		sb.append("주째인 ");
		sb.append(yy);
		sb.append("년 ");
		sb.append(mm);
		sb.append("월 ");
		sb.append(dd);
		sb.append("일입니다.");
		
		out.println(sb.toString());
	}

}
