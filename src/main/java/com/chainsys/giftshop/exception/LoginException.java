package com.chainsys.giftshop.exception;

public class LoginException extends Exception {

	public String getUserNameLoginMessage() {
		return "Sorry, username or password incorrect!";
	}

}
