package com.chainsys.giftshop.dao;

import java.sql.SQLException;

import com.chainsys.giftshop.model.AdminPojo;

public interface AdminDao {
	
	public  AdminPojo validateadmin(String email1, String pass) throws ClassNotFoundException, SQLException ;
}
