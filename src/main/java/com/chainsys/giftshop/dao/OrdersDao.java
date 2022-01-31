package com.chainsys.giftshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.chainsys.giftshop.model.OrdersPojo;

public interface OrdersDao {

	public void orderinsert(int userid, String prodname, int quant, double price)
			throws ClassNotFoundException, SQLException;

	public ResultSet showorders(int userid) throws Exception;

	// public static void viewInvoice()throws ClassNotFoundException, SQLException;

	public void insert(OrdersPojo product1) throws ClassNotFoundException, SQLException;

	public void createorder(OrdersPojo order) throws ClassNotFoundException, SQLException;

	public int getorder(OrdersPojo order) throws ClassNotFoundException, SQLException;

	public void insertorder(OrdersPojo order1) throws SQLException, ClassNotFoundException;

	public List<OrdersPojo> userOrderDetails(OrdersPojo showord) throws ClassNotFoundException, SQLException;

	public boolean cancelorder(OrdersPojo vcar2) throws SQLException, ClassNotFoundException;

}
