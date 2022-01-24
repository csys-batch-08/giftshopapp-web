package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.giftshop.dao.UserDao;
import com.chainsys.giftshop.model.ProductPojo;
import com.chainsys.giftshop.model.UserPojo;
import com.chainsys.giftshop.model.userloginPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class UserImpl implements UserDao {
public void insert (UserPojo user) throws ClassNotFoundException, SQLException {
	
		String insertQuery="insert into user_gift(user_name,email,mobile_number,user_Password,address) values(?,?,?,?,?)";
		Connection con=ConnectionUtil.gbconnection();
		PreparedStatement pstmt=con.prepareStatement(insertQuery);
		pstmt.setString(1,user.getUsername());
		pstmt.setString(2,user.getEmail());
		pstmt.setLong(3,user.getMobilenumber());
		pstmt.setString(4,user.getPassword());	
		pstmt.setString(5,user.getAddress());
	int i = pstmt.executeUpdate();	
    pstmt.close();
	con.close();
	}




public ResultSet validateuser1(userloginPojo ul) throws ClassNotFoundException, SQLException {
	ResultSet rs=null;
	String  validate="select * from user_gift where email = ? and user_password = ?";
	Connection con=ConnectionUtil.gbconnection();
	PreparedStatement Pstmt1 = con.prepareStatement(validate);
    Pstmt1.setString(1, ul.getUsername());
    Pstmt1.setString(2, ul.getPassword());
    rs=Pstmt1.executeQuery();
	return rs;
}


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
			users = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4),
					rs.getString(5));
			
			products.add(users);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return products;
}
@Override
public ResultSet validateuser(String Email, String password) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return null;
}

}
