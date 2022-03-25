package day0321;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 시간 표시

// 요즘엔 Calender 주로 씀

public class Ex01Time {
    public static void main(String[] args) {
        
        Date date = new Date();
        
        System.out.println(date);
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.printf(simpleDate.format(calendar.getTime()));
    }
}
