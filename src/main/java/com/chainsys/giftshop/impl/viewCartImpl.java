package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.giftshop.model.OrdersPojo;
import com.chainsys.giftshop.model.ProductPojo;
import com.chainsys.giftshop.model.viewcartPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class viewCartImpl {

	public void insertview(viewcartPojo vcar) throws ClassNotFoundException, SQLException {

		String insertQuery = "insert into gcart(image,product_name,p_type,standard_cost,p_size,quantity,user_id,product_id)values(?,?,?,?,?,?,?,?)";

		Connection con = ConnectionUtil.gbconnection();
		PreparedStatement pstmt = con.prepareStatement(insertQuery);
		pstmt.setString(1, vcar.getImage());
		pstmt.setString(2, vcar.getProductname());
		pstmt.setString(3, vcar.getType());
		pstmt.setDouble(4, vcar.getStandardcost());
		pstmt.setString(5, vcar.getSize());
		pstmt.setInt(6, vcar.getQuantity());
		pstmt.setInt(7, vcar.getUserid());
		pstmt.setInt(8, vcar.getProductid());
		int i = pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}

	public List<viewcartPojo> insertcart1(viewcartPojo vcar) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.gbconnection();
		List<viewcartPojo> cart = new ArrayList<viewcartPojo>();
		String insertQuery = "insert into gcart(image,product_name,p_type,standard_cost,p_size,quantity,user_id,product_id)values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insertQuery);
		pstmt.setString(1, vcar.getImage());
		pstmt.setString(2, vcar.getProductname());
		pstmt.setString(3, vcar.getType());
		pstmt.setDouble(4, vcar.getStandardcost());
		pstmt.setString(5, vcar.getSize());
		pstmt.setInt(6, vcar.getQuantity());
		pstmt.setInt(7, vcar.getUserid());
		pstmt.setInt(8, vcar.getProductid());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			vcar.setImage(rs.getString(1));
			vcar.setProductname(rs.getString(2));
			vcar.setType(rs.getString(3));
			vcar.setStandardcost(rs.getDouble(4));
			vcar.setSize(rs.getString(5));
			vcar.setQuantity(rs.getInt(6));
			vcar.setUserid(rs.getInt(7));
			vcar.setProductid(rs.getInt(8));
		}
		int i = pstmt.executeUpdate();
		pstmt.close();
		con.close();

		return cart;
	}

	public List<viewcartPojo> showcart(viewcartPojo vcar1) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.gbconnection();
		List<viewcartPojo> cart = new ArrayList<viewcartPojo>();
		String query = "select image,product_name,p_type,standard_cost,p_size,quantity,product_id from gcart where user_id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, vcar1.getUserid());
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			vcar1 = new viewcartPojo();
			vcar1.setImage(rs.getString(1));
			vcar1.setProductname(rs.getString(2));
			vcar1.setType(rs.getString(3));
			vcar1.setStandardcost(rs.getDouble(4));
			vcar1.setSize(rs.getString(5));
			vcar1.setQuantity(rs.getInt(6));
			vcar1.setProductid(rs.getInt(7));
			cart.add(vcar1);
		}
		return cart;
	}

	public List<viewcartPojo> showcart() {
		List<viewcartPojo> view = new ArrayList<viewcartPojo>();
		String show = "select image,product_name,p_type,standard_cost,p_size,quantity,user_id,product_id from gcart";
		Connection con;
		viewcartPojo show1 = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(show);
			while (rs.next()) {
				show1 = new viewcartPojo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7));
				view.add(show1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return view;
	}

	public List<viewcartPojo> showcart1(viewcartPojo vcar1) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.gbconnection();
		List<viewcartPojo> cart = new ArrayList<viewcartPojo>();
		String query = "select image,product_name,p_type,standard_cost,p_size,quantity,product_id from gcart where user_id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, vcar1.getUserid());
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			vcar1 = new viewcartPojo();
			vcar1.setImage(rs.getString(1));
			vcar1.setProductname(rs.getString(2));
			vcar1.setType(rs.getString(3));
			vcar1.setStandardcost(rs.getDouble(4));
			vcar1.setSize(rs.getString(5));
			vcar1.setQuantity(rs.getInt(6));
			vcar1.setProductid(rs.getInt(7));
			cart.add(vcar1);
		}
		return cart;
	}

	public boolean emptycart(viewcartPojo vcar2) throws SQLException, ClassNotFoundException {
		Connection con = ConnectionUtil.gbconnection();
		String delcart = "DELETE FROM gcart WHERE user_id=?";
		PreparedStatement pstmt = con.prepareStatement(delcart);
		pstmt.setInt(1, vcar2.getUserid());
		int i = pstmt.executeUpdate();
		if (i != 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<viewcartPojo> mycart(viewcartPojo vcart) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.gbconnection();
		List<viewcartPojo> view = new ArrayList<viewcartPojo>();
		String showcart = "SELECT image,user_id,product_id,product_name,p_type,p_size,quantity,standard_cost,standard_cost*quantity AS total_price FROM gcart where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(showcart);
		pstmt.setInt(1, vcart.getUserid());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			vcart.setImage(rs.getString(1));
			vcart.setUserid(rs.getInt(2));
			vcart.setProductid(rs.getInt(3));
			vcart.setProductname(rs.getString(4));
			vcart.setType(rs.getString(5));
			vcart.setSize(rs.getString(6));
			vcart.setQuantity(rs.getInt(7));
			vcart.setStandardcost(rs.getDouble(8));
			vcart.setTotalprice(rs.getDouble(9));
			view.add(vcart);
		}

		return view;

	}

	public int duplicatecart(viewcartPojo vcart1) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.gbconnection();
        int qtyn =0;
		String showcart = "select quantity from gcart where user_id=? and product_id=? and p_size=?";
		PreparedStatement pstmt = con.prepareStatement(showcart);
		pstmt.setInt(1, vcart1.getUserid());
		pstmt.setInt(2, vcart1.getProductid());
		pstmt.setString(3, vcart1.getSize());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			qtyn=rs.getInt("quantity");
	
		}

		return qtyn;
	}

	public viewcartPojo removefromcart(viewcartPojo vcar) throws ClassNotFoundException, SQLException {
		String insertQuery = "delete from gcart where product_id=? and user_id=? and p_size=?";
		Connection con = ConnectionUtil.gbconnection();
		PreparedStatement pstmt = con.prepareStatement(insertQuery);
		pstmt.setInt(2, vcar.getUserid());
		pstmt.setInt(1, vcar.getProductid());
		pstmt.setString(3, vcar.getSize());
		int i = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return vcar;
	}
	public void updatecart(viewcartPojo vcar) throws ClassNotFoundException, SQLException {

		String insertQuery = "UPDATE gcart SET image = ?, product_name = ?,p_type = ?,standard_cost = ?,p_size = ?,quantity = ?,user_id = ?,product_id = ? WHERE user_id=? and product_id=? and p_size=?";

		Connection con = ConnectionUtil.gbconnection();
		PreparedStatement pstmt = con.prepareStatement(insertQuery);
		pstmt.setString(1, vcar.getImage());
		pstmt.setString(2, vcar.getProductname());
		pstmt.setString(3, vcar.getType());
		pstmt.setDouble(4, vcar.getStandardcost());
		pstmt.setString(5, vcar.getSize());
		pstmt.setInt(6, vcar.getQuantity());
		pstmt.setInt(7, vcar.getUserid());
		pstmt.setInt(8, vcar.getProductid());
		pstmt.setInt(9, vcar.getUserid());
		pstmt.setInt(10, vcar.getProductid());
		pstmt.setString(11, vcar.getSize());
		int i = pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}

}