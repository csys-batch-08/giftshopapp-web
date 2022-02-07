package com.chainsys.giftshop.dao;

import java.util.List;

import com.chainsys.giftshop.model.ShowOrdersPojo;

public interface ShowordersDao {

	public List<ShowOrdersPojo> myorders(ShowOrdersPojo showord);

	public List<ShowOrdersPojo> orderdetails(ShowOrdersPojo orddetails);
}
