package com.chainsys.giftshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.chainsys.giftshop.model.UserPojo;
import com.chainsys.giftshop.model.userloginPojo;

public interface UserDao {

	public boolean insert(UserPojo user) throws ClassNotFoundException, SQLException;

	public UserPojo validateUserNum(UserPojo user) throws ClassNotFoundException, SQLException;

	public UserPojo validateUsermail(UserPojo user) throws ClassNotFoundException, SQLException;

	public ResultSet validateuser1(userloginPojo ul) throws ClassNotFoundException, SQLException;

	public List<UserPojo> showusers();

	public ResultSet validateuser(String Email, String password) throws ClassNotFoundException, SQLException;
}
