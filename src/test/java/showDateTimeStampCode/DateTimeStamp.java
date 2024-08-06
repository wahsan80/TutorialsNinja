package showDateTimeStampCode;

import java.util.Date;

public class DateTimeStamp {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		
		System.out.println(date);
		System.out.println(date.toString());
		
		String replaceDate = date.toString().replace(" ", "_"); // Replace " " in date format with "_"
		
		System.out.println(replaceDate);
		
		String finalReplaceDate = replaceDate.replace(":", "_"); // Replace " " in date format with ":"
		
		System.out.println(finalReplaceDate);
		
	}
}
