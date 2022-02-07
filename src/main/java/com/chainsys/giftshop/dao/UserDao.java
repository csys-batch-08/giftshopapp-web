package com.chainsys.giftshop.dao;

import java.util.List;

import com.chainsys.giftshop.model.UserPojo;
import com.chainsys.giftshop.model.UserloginPojo;

public interface UserDao {

	public boolean insert(UserPojo user);

	public UserPojo validateUserNum(UserPojo user);

	public UserPojo validateUsermail(UserPojo user);

	public UserloginPojo validateuser(UserloginPojo ul);

	public List<UserPojo> showusers();
}
