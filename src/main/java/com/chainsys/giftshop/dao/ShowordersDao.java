package com.chainsys.giftshop.dao;

import java.util.List;

import com.chainsys.giftshop.model.showordersPojo;

public interface ShowordersDao {

	public List<showordersPojo> myorders(showordersPojo showord);

	public List<showordersPojo> orderdetails(showordersPojo orddetails);
}
