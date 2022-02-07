package com.chainsys.giftshop.model;

import java.io.Serializable;

public class UserPojo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userid;
	private String userName;
	private String password;
	private String email;
	private Long mobilenumber;
	private String address;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public UserPojo(String username, String password, String email, Long mobilenumber) {

		this.userName = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
	}

	public UserPojo() {
		super();
	}

	public UserPojo(String username, String password, String email, Long mobilenumber, String address) {
		super();
		userName = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.address = address;
	}

	public UserPojo(int userid, String username, String email, Long mobilenumber, String address) {
		super();
		this.userid = userid;
		userName = username;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.address = address;
	}

}