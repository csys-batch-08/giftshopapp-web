package com.chainsys.giftshop.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.giftshop.dao.UserDao;
import com.chainsys.giftshop.logger.Logger;
import com.chainsys.giftshop.model.UserPojo;
import com.chainsys.giftshop.model.UserloginPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	private static final String ADDRESS = "address";
	private static final String MOBILE_NUMBER = "mobile_number";
	private static final String EMAIL = "email";
	private static final String USER_NAME = "user_name";
	private static final String USER_ID = "user_id";



	@Override
	public boolean insert(UserPojo user) {
		PreparedStatement pstmt = null;
		Connection con = null;
		boolean flag=false;
		int i=0;
		String query = "insert into user_gift(user_name,email,mobile_number,user_Password,address) values(?,?,?,?,?)";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setLong(3, user.getMobilenumber());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			i=pstmt.executeUpdate();
			if(i>0) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(null, pstmt, con);
		}	
		return flag;
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
				logUser = new UserPojo(rs.getInt(USER_ID), rs.getString(USER_NAME), rs.getString(EMAIL), rs.getLong(MOBILE_NUMBER), rs.getString("role"));
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(rs, pstmt, con);
		}	
		return logUser;
	}

	@Override
	public UserPojo validateUsermail(UserPojo user){
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
				logUser = new UserPojo(rs.getInt(USER_ID), rs.getString(USER_NAME), rs.getString(EMAIL), rs.getLong(MOBILE_NUMBER), rs.getString("role"));

			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(rs, pstmt, con);
		}	
		return logUser;
	}

	@Override
	public UserloginPojo validateuser(UserloginPojo ulp)  {
		UserloginPojo userlogin=null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String query = "select user_id,role from user_gift where email = ? and user_password = ?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ulp.getEmail());
			pstmt.setString(2, ulp.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userlogin=new UserloginPojo(rs.getInt(USER_ID),rs.getString("role"));
			}
		}catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(rs, pstmt, con);
		}	
		return userlogin;
	}

	@Override
	public List<UserPojo> showusers() {
		List<UserPojo> products = new ArrayList<>();
		String query = "select user_id,user_name,email,mobile_number,address from user_gift";
		PreparedStatement pstmt = null;
		Connection con=null;
		UserPojo users = null;
		ResultSet rs=null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				users = new UserPojo(rs.getInt(USER_ID), rs.getString(USER_NAME), rs.getString(EMAIL), rs.getLong(MOBILE_NUMBER), rs.getString(ADDRESS));

				products.add(users);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(rs, pstmt, con);
		}	
		return products;
	}



	public List<UserPojo> serachusers(String users) {
		List<UserPojo> searchproducts = new ArrayList<>();
		PreparedStatement pstmt = null;
		Connection con=null;
		String query = "select user_id,user_name,email,mobile_number,address from user_gift where lower(user_name ) like ? ";
		ResultSet rs = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, users + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserPojo search = new UserPojo(rs.getInt(USER_ID), rs.getString(USER_NAME), rs.getString(EMAIL),
						rs.getLong(MOBILE_NUMBER), rs.getString(ADDRESS));
				searchproducts.add(search);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(rs, pstmt, con);
		}	
		return searchproducts;
	}


}
