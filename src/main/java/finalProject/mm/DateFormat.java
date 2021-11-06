package finalProject.mm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
	public static void main(String[] args) {
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
		
		System.out.println(sdf.format(d));
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(sdf.format(cal.getTime()));
		
	}

}
