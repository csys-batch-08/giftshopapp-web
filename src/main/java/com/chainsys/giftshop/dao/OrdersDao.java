package com.chainsys.giftshop.dao;

import java.util.List;

import com.chainsys.giftshop.model.OrdersPojo;

public interface OrdersDao {

	public void orderinsert(int userid, String prodname, int quant, double price);

	public OrdersPojo showorders(int userid);

	public void insert(OrdersPojo product1);

	public void createorder(OrdersPojo order);

	public int getorder(OrdersPojo order);

	public void insertorder(OrdersPojo order1);

	public List<OrdersPojo> userOrderDetails(OrdersPojo showord);

	public boolean cancelorder(OrdersPojo vcar2);

}
