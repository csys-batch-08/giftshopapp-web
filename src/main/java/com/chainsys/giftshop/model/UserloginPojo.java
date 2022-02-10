package com.chainsys.giftshop.model;

import java.io.Serializable;

public class UserloginPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String password;
	private String email;
	private Long mobileNumber;
	private String address;
	private String role;

	public int getUserid() {
		return userId;
	}

	public void setUserid(int userid) {
		this.userId = userid;
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

	public void setMobilenumber(Long mobilenumber) {
		this.mobileNumber = mobilenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "userlogin [username=" + userName + ", password=" + password + "]";
	}

	public UserloginPojo(int userid, String username, String password, String email, Long mobilenumber, String address,
			String role) {
		super();
		this.userId = userid;
		this.userName = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobilenumber;
		this.address = address;
		this.role = role;
	}

	public UserloginPojo(String email, String password) {
		super();
		this.email = email;
		this.password = password;

	}

	public UserloginPojo() {
		super();

	}

	public UserloginPojo(int userid, String role) {
		super();
		this.userId = userid;
		this.role = role;
	}

}
