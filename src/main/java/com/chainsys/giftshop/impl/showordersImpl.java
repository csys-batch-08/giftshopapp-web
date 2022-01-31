package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.giftshop.model.showordersPojo;
import com.chainsys.giftshop.model.viewcartPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class showordersImpl {

	public List<showordersPojo> myorders(showordersPojo showord) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.gbconnection();
		List<showordersPojo> view = new ArrayList<showordersPojo>();
		String showcart = "select g.user_id,g.order_id,g.order_date,g.status,o.quantity_ordered,o.total_price,o.p_size,p.product_name,p.standard_cost,p.image from gorders g join gorder_items1 o on g.order_id=o.order_id join gproducts p on p.product_id = o.product_id where o.user_id=?";

		PreparedStatement pstmt = con.prepareStatement(showcart);
		pstmt.setInt(1, showord.getUserid());

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			showordersPojo showords = new showordersPojo();
			showords.setUserid(rs.getInt(1));
			showords.setOrderid(rs.getInt(2));
			showords.setOrderdate(rs.getDate(3));
			showords.setStatus(rs.getString(4));
			showords.setQuantityordered(rs.getInt(5));
			showords.setTotalprice(rs.getDouble(6));
			showords.setSize(rs.getString(7));
			showords.setProductname(rs.getString(8));
			showords.setStandardcost(rs.getDouble(9));
			showords.setImage(rs.getString(10));

			view.add(showords);
		}

		return view;

	}

	public List<showordersPojo> orderdetails(showordersPojo orddetails) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.gbconnection();
		List<showordersPojo> view = new ArrayList<showordersPojo>();
		String showorderdetails = "select o.order_id,o.quantity_ordered,o.total_price,o.p_size,p.product_name,p.image,(o.quantity_ordered*o.total_price)as toalllll from gorders g join gorder_items1 o on g.order_id=o.order_id join gproducts p on p.product_id = o.product_id  where o.order_id=? group by o.order_id,g.user_id,g.order_id,g.order_date,g.status,o.quantity_ordered,o.total_price,o.p_size,p.product_name,p.image";
		PreparedStatement pstmt = con.prepareStatement(showorderdetails);
		pstmt.setInt(1, orddetails.getOrderid());

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			showordersPojo orderdetails = new showordersPojo();
			orderdetails.setOrderid(rs.getInt(1));
			orderdetails.setQuantityordered(rs.getInt(2));
			orderdetails.setTotalprice(rs.getDouble(3));
			orderdetails.setSize(rs.getString(4));
			orderdetails.setProductname(rs.getString(5));
			orderdetails.setImage(rs.getString(6));
			orderdetails.setStandardcost(rs.getDouble(7));

			view.add(orderdetails);
		}

		return view;

	}

}
