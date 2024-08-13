package com.qa.ninjatutorials.utilities;

import java.time.Duration;
import java.util.Date;

public class Utilities {
	
	public static String generateDateTimeStamp() {
		
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + timeStamp + "@gmail.com";
	}
	
	public static final int IMPLICIT_WAIT_TIME = 20;
	public static final int PAGELOAD_TIME = 20;
}
