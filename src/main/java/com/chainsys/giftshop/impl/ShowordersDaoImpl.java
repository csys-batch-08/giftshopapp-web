package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.giftshop.dao.ShowordersDao;
import com.chainsys.giftshop.logger.Logger;
import com.chainsys.giftshop.model.ShowOrdersPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class ShowordersDaoImpl implements ShowordersDao {

	@Override
	public List<ShowOrdersPojo> myorders(ShowOrdersPojo showord) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<ShowOrdersPojo> view = new ArrayList<>();
		String showcart = "select g.user_id,g.order_id,g.order_date,g.status,o.quantity_ordered,o.total_price,o.p_size,p.product_name,p.standard_cost,p.image from gorders g join gorder_items1 o on g.order_id=o.order_id join gproducts p on p.product_id = o.product_id where o.user_id=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(showcart);
			pstmt.setInt(1, showord.getUserid());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShowOrdersPojo showords = new ShowOrdersPojo();
				showords.setUserid(rs.getInt("user_id"));
				showords.setOrderid(rs.getInt("order_id"));
				showords.setOrderdate(rs.getDate("order_date"));
				showords.setStatus(rs.getString("status"));
				showords.setQuantityordered(rs.getInt("quantity_ordered"));
				showords.setTotalprice(rs.getDouble("total_price"));
				showords.setSize(rs.getString("p_size"));
				showords.setProductname(rs.getString("product_name"));
				showords.setStandardcost(rs.getDouble("standard_cost"));
				showords.setImage(rs.getString("image"));
				view.add(showords);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return view;
	}

	@Override
	public List<ShowOrdersPojo> orderdetails(ShowOrdersPojo orddetails) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String showorderdetails = "select o.order_id,o.quantity_ordered,o.total_price,o.p_size,p.product_name,p.image,(o.quantity_ordered*o.total_price)as toalllll from gorders g join gorder_items1 o on g.order_id=o.order_id join gproducts p on p.product_id = o.product_id  where o.order_id=? group by o.order_id,g.user_id,g.order_id,g.order_date,g.status,o.quantity_ordered,o.total_price,o.p_size,p.product_name,p.image";
		List<ShowOrdersPojo> view = new ArrayList<>();
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(showorderdetails);
			pstmt.setInt(1, orddetails.getOrderid());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShowOrdersPojo orderdetails = new ShowOrdersPojo();
				orderdetails.setOrderid(rs.getInt("order_id"));
				orderdetails.setQuantityordered(rs.getInt("quantity_ordered"));
				orderdetails.setTotalprice(rs.getDouble("total_price"));
				orderdetails.setSize(rs.getString("p_size"));
				orderdetails.setProductname(rs.getString("product_name"));
				orderdetails.setImage(rs.getString("image"));
				orderdetails.setStandardcost(rs.getDouble("toalllll"));
				view.add(orderdetails);
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return view;

	}

	public String checkstatus(ShowOrdersPojo orddetails) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String status = null;
		String query = "select status from gorders where order_id=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orddetails.getOrderid());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				status = rs.getNString("status");
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return status;
	}
}