package com.chainsys.giftshop.model;

import java.io.Serializable;

public class UserloginPojo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userid;
	private String username;
	private String password;
	private String email;
	private Long mobilenumber;
	private String address;
	private String role;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
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
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "userlogin [username=" + username + ", password=" + password + "]";
	}

	public UserloginPojo(int userid, String username, String password, String email, Long mobilenumber, String address,
			String role) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.address = address;
		this.role = role;
	}

	public UserloginPojo(String email,String password) {
		super();
		this.email = email;
		this.password = password;
		
	}

	public UserloginPojo() {
		super();
	
	}

	
}
