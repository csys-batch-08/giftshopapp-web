package com.chainsys.giftshop.logger;

public class Logger {
	
	private Logger() {
		
	}

	public static void printstackrace(Exception e) {
		
		e.printStackTrace();
	}
	public static void runTimeException(String message) {
		throw new RuntimeException(message);
	}
}

