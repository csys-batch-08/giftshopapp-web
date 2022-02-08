package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.giftshop.logger.Logger;
import com.chainsys.giftshop.model.ViewCartPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class ViewCartDaoImpl {

	private static final String USER_ID = "user_id";
	private static final String PRODUCT_ID = "product_id";
	private static final String QUANTITY = "quantity";
	private static final String P_SIZE = "p_size";
	private static final String P_TYPE = "p_type";
	private static final String STANDARD_COST = "standard_cost";
	private static final String PRODUCT_NAME = "product_name";
	private static final String IMAGE = "image";

	public void insertview(ViewCartPojo vcar) {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			String query = "insert into gcart(image,product_name,p_type,standard_cost,p_size,quantity,user_id,product_id)values(?,?,?,?,?,?,?,?)";
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vcar.getImage());
			pstmt.setString(2, vcar.getProductname());
			pstmt.setString(3, vcar.getType());
			pstmt.setDouble(4, vcar.getStandardcost());
			pstmt.setString(5, vcar.getSize());
			pstmt.setInt(6, vcar.getQuantity());
			pstmt.setInt(7, vcar.getUserid());
			pstmt.setInt(8, vcar.getProductid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}
	}

	public List<ViewCartPojo> insertcart1(ViewCartPojo vcar) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<ViewCartPojo> cart = new ArrayList<>();
		try {
			con = ConnectionUtil.gbconnection();
			String insertQuery = "insert into gcart(image,product_name,p_type,standard_cost,p_size,quantity,user_id,product_id)values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, vcar.getImage());
			pstmt.setString(2, vcar.getProductname());
			pstmt.setString(3, vcar.getType());
			pstmt.setDouble(4, vcar.getStandardcost());
			pstmt.setString(5, vcar.getSize());
			pstmt.setInt(6, vcar.getQuantity());
			pstmt.setInt(7, vcar.getUserid());
			pstmt.setInt(8, vcar.getProductid());
			rs = pstmt.executeQuery();
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
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return cart;
	}

	public List<ViewCartPojo> showcartpage(ViewCartPojo vcar1) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<ViewCartPojo> cart = new ArrayList<>();
		try {
			con = ConnectionUtil.gbconnection();
			String query = "select image,product_name,p_type,standard_cost,p_size,quantity,product_id from gcart where user_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vcar1.getUserid());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vcar1 = new ViewCartPojo();
				vcar1.setImage(rs.getString(IMAGE));
				vcar1.setProductname(rs.getString(PRODUCT_NAME));
				vcar1.setType(rs.getString(P_TYPE));
				vcar1.setStandardcost(rs.getDouble(STANDARD_COST));
				vcar1.setSize(rs.getString(P_SIZE));
				vcar1.setQuantity(rs.getInt(QUANTITY));
				vcar1.setProductid(rs.getInt(PRODUCT_ID));
				cart.add(vcar1);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return cart;
	}

	public List<ViewCartPojo> showcart() {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ViewCartPojo vcp = null;
		List<ViewCartPojo> view = new ArrayList<>();
		String query = "select image,product_name,p_type,standard_cost,p_size,quantity,user_id,product_id from gcart";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vcp = new ViewCartPojo(rs.getString(IMAGE), rs.getString(PRODUCT_NAME), rs.getString(P_TYPE),
						rs.getDouble(STANDARD_COST), rs.getString(P_SIZE), rs.getInt(QUANTITY), rs.getInt(USER_ID));
				view.add(vcp);
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return view;
	}

	public boolean emptycart(ViewCartPojo vcar2) {
		PreparedStatement pstmt = null;
		Connection con = null;
		boolean flag = false;
		String query = "DELETE FROM gcart WHERE user_id=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vcar2.getUserid());
			int i = pstmt.executeUpdate();
			if (i != 0) {
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

	public List<ViewCartPojo> mycart(ViewCartPojo vcart) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String showcart = "SELECT image,user_id,product_id,product_name,p_type,p_size,quantity,standard_cost,standard_cost*quantity AS total_price FROM gcart where user_id=?";
		List<ViewCartPojo> view = new ArrayList<>();
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(showcart);
			pstmt.setInt(1, vcart.getUserid());
			rs = pstmt.executeQuery();
			while (rs.next()) {

				vcart.setImage(rs.getString(IMAGE));
				vcart.setUserid(rs.getInt(USER_ID));
				vcart.setProductid(rs.getInt(PRODUCT_ID));
				vcart.setProductname(rs.getString(PRODUCT_NAME));
				vcart.setType(rs.getString(P_TYPE));
				vcart.setSize(rs.getString(P_SIZE));
				vcart.setQuantity(rs.getInt(QUANTITY));
				vcart.setStandardcost(rs.getDouble(STANDARD_COST));
				vcart.setTotalprice(rs.getDouble(STANDARD_COST));
				view.add(vcart);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return view;

	}

	public int duplicatecart(ViewCartPojo vcart1) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		int qtyn = 0;
		String query = "select quantity from gcart where user_id=? and product_id=? and p_size=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vcart1.getUserid());
			pstmt.setInt(2, vcart1.getProductid());
			pstmt.setString(3, vcart1.getSize());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qtyn = rs.getInt(QUANTITY);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return qtyn;

	}

	public ViewCartPojo removefromcart(ViewCartPojo vcar) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String query = "delete from gcart where product_id=? and user_id=? and p_size=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(2, vcar.getUserid());
			pstmt.setInt(1, vcar.getProductid());
			pstmt.setString(3, vcar.getSize());
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}
		return vcar;
	}

	public void updatecart(ViewCartPojo vcar) {
		String query = "UPDATE gcart SET image = ?, product_name = ?,p_type = ?,standard_cost = ?,p_size = ?,quantity = ?,user_id = ?,product_id = ? WHERE user_id=? and product_id=? and p_size=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
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
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}
	}

	public void updatecartitems(ViewCartPojo vcar) {
		String query = "UPDATE gcart SET quantity = ? WHERE  product_id=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vcar.getQuantity());
			pstmt.setInt(2, vcar.getProductid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
		}

	}

	public ViewCartPojo editcart(ViewCartPojo vcp) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.gbconnection();
			String query = "select image,product_name,p_type,standard_cost,p_size,quantity,user_id,product_id from gcart where user_id=? and product_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vcp.getUserid());
			pstmt.setInt(2, vcp.getProductid());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vcp.setImage(rs.getString(IMAGE));
				vcp.setProductname(rs.getString(PRODUCT_NAME));
				vcp.setType(rs.getString(P_TYPE));
				vcp.setStandardcost(rs.getDouble(STANDARD_COST));
				vcp.setSize(rs.getString(P_SIZE));
				vcp.setQuantity(rs.getInt(QUANTITY));
				vcp.setUserid(rs.getInt(USER_ID));
				vcp.setProductid(rs.getInt(PRODUCT_ID));
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return vcp;

	}
}