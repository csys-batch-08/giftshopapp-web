package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.giftshop.dao.UserDao;
import com.chainsys.giftshop.model.UserPojo;
import com.chainsys.giftshop.model.userloginPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public boolean insert(UserPojo user) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String Query = "insert into user_gift(user_name,email,mobile_number,user_Password,address) values(?,?,?,?,?)";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(Query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setLong(3, user.getMobilenumber());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}  finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public UserPojo validateUserNum(UserPojo user) {
		UserPojo logUser = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String query = "select user_id,user_name,email,mobile_number,role from user_gift where mobile_number=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, user.getMobilenumber());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				logUser = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
			}

		} catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return logUser;
	}

	@Override
	public UserPojo validateUsermail(UserPojo user) throws ClassNotFoundException, SQLException {
		UserPojo logUser = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String query = "select user_id,user_name,email,mobile_number,role from user_gift where email=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				logUser = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));

			}

		} catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return logUser;
	}

	@Override
	public ResultSet validateuser1(userloginPojo ul) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		String validate = "select user_id,user_name,user_password,email,mobile_number,role,address from user_gift where email = ? and user_password = ?";
		Connection con = ConnectionUtil.gbconnection();
		PreparedStatement Pstmt1 = con.prepareStatement(validate);
		Pstmt1.setString(1, ul.getUsername());
		Pstmt1.setString(2, ul.getPassword());
		rs = Pstmt1.executeQuery();
		return rs;
	}

	@Override
	public List<UserPojo> showusers() {
		List<UserPojo> products = new ArrayList<UserPojo>();
		String products1 = "select user_id,user_name,email,mobile_number,address from user_gift";
		Connection con;
		UserPojo users = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(products1);
			while (rs.next()) {
				users = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));

				products.add(users);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ResultSet validateuser(String Email, String password) throws ClassNotFoundException, SQLException {
		return null;
	}

	public List<UserPojo> serachusers(String users) {
		List<UserPojo> searchproducts = new ArrayList<>();
		String searchquery = "select user_id,user_name,email,mobile_number,address from user_gift where lower(user_name ) like ? ";
		ResultSet rs = null;
		try {
			Connection con = ConnectionUtil.gbconnection();
			PreparedStatement pre = con.prepareStatement(searchquery);
			pre.setString(1, users + "%");
			rs = pre.executeQuery();
			while (rs.next()) {
				UserPojo search = new UserPojo(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("email"),
						rs.getLong("mobile_number"), rs.getString("address"));

				searchproducts.add(search);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return searchproducts;
	}
}
