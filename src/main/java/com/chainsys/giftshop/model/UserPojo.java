package com.chainsys.giftshop.model;

import java.io.Serializable;

public class UserPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String password;
	private String email;
	private Long mobileNumber;
	private String address;

	public int getUserid() {
		return userId;
	}

	public void setUserid(int userid) {
		this.userId = userid;
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
		return mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobileNumber = mobilenumber;
	}

	public UserPojo(String username, String password, String email, Long mobilenumber) {

		this.userName = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobilenumber;
	}

	public UserPojo() {
		super();
	}

	public UserPojo(String username, String password, String email, Long mobilenumber, String address) {
		super();
		userName = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobilenumber;
		this.address = address;
	}

	public UserPojo(int userid, String username, String email, Long mobilenumber, String address) {
		super();
		this.userId = userid;
		userName = username;
		this.email = email;
		this.mobileNumber = mobilenumber;
		this.address = address;
	}

}