package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.giftshop.dao.OrdersDao;
import com.chainsys.giftshop.logger.Logger;
import com.chainsys.giftshop.model.OrdersPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public void orderinsert(int userid, String productname, int quantity, double price) {
		String query = "insert into gorders(user_id,product_name,quantity,price) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userid);
			pstmt.setString(2, productname);
			pstmt.setInt(3, quantity);
			pstmt.setDouble(4, price);
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}
	}

	@Override
	public OrdersPojo showorders(int userid) {
		String query = "select user_id,product_name,p_type,order_id,order_date,p_size,total_price,quantity,status from gorders where user_id in ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrdersPojo op = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				op = new OrdersPojo(rs.getInt("user_id"), rs.getString("product_name"), rs.getNString("p_type"),
						rs.getInt("order_id"), rs.getDate("order_date"), rs.getString("p_size"),
						rs.getDouble("total_price"), rs.getInt("quantity"), rs.getString("status"));
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}

		return op;

	}

	@Override
	public void insert(OrdersPojo product) {
		String query = "insert into gorders(user_id,product_name,p_type,order_id,order_date,p_size,total_price,qunatity,status) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, product.getProductname());
			pstmt.setString(2, product.getProducttype());
			pstmt.setString(3, product.getProdutsize());
			pstmt.setDouble(4, product.getTotalprice());
			pstmt.setInt(5, product.getQuantiy());
			pstmt.setString(6, product.getStatus());
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}
	}

	@Override
	public void createorder(OrdersPojo order) {
		String query = "insert into gorders(user_id) values(?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getUserid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}
	}

	@Override
	public int getorder(OrdersPojo order) {
		int orderid = 0;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String query = "SELECT order_id FROM gorders where user_id = ?  order by order_date desc fetch first rows only";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getUserid());
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				orderid = rs.getInt(1);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return orderid;
	}

	@Override
	public void insertorder(OrdersPojo order1) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String query = "insert into gorder_items1(order_id,quantity_ordered,total_price,user_id,product_id,p_size)values(?,?,?,?,?,?)";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order1.getOrderid());
			pstmt.setInt(2, order1.getQuantiy());
			pstmt.setDouble(3, order1.getTotalprice());
			pstmt.setInt(4, order1.getUserid());
			pstmt.setInt(5, order1.getProductid());
			pstmt.setString(6, order1.getProdutsize());
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}
	}

	@Override
	public List<OrdersPojo> userOrderDetails(OrdersPojo showord) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<OrdersPojo> orderlist = new ArrayList<>();
		String query = "select order_id,trunc(order_date),status from gorders where user_id=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, showord.getUserid());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrdersPojo op = new OrdersPojo();

				op.setOrderid(rs.getInt(1));
				op.setOrderdate(rs.getDate(2));
				op.setStatus(rs.getString(3));
				orderlist.add(op);
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return orderlist;
	}

	@Override
	public boolean cancelorder(OrdersPojo vcar2) {
		PreparedStatement pstmt = null;
		Connection con = null;
		boolean flag = false;
		int i = 0;
		try {
			con = ConnectionUtil.gbconnection();
			String query = "update gorders set status='order cancelled' where order_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vcar2.getOrderid());
			i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}
		return flag;
	}

	public OrdersPojo reorder(OrdersPojo order) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String query = "select order_id,quantity_ordered,total_price,user_id,product_id,p_size from gorder_items1 where product_id=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getProductid());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				order.setOrderid(rs.getInt("order_id"));
				order.setQuantiy(rs.getInt("quantity_ordered"));
				order.setTotalprice(rs.getDouble("total_price"));
				order.setUserid(rs.getInt("user_id"));
				order.setProductid(rs.getInt("product_id"));
				order.setProdutsize(rs.getString("p_size"));
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return order;
	}

}
