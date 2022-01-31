package com.chainsys.giftshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.giftshop.model.showordersPojo;

public interface ShowordersDao {

	public List<showordersPojo> myorders(showordersPojo showord) throws ClassNotFoundException, SQLException;

	public List<showordersPojo> orderdetails(showordersPojo orddetails) throws ClassNotFoundException, SQLException;
}
