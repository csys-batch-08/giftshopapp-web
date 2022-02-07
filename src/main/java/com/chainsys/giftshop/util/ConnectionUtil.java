package com.chainsys.giftshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.giftshop.logger.Logger;

public class ConnectionUtil {
	
	private ConnectionUtil() {
	}
public static Connection gbconnection() throws ClassNotFoundException, SQLException {
	Connection con = null;
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}

	return con;
}
public static void close(ResultSet rs,PreparedStatement pstmt,Connection con) {
	try {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}

	} catch (SQLException e) {
		Logger.printstackrace(e);
		Logger.runTimeException(e.getMessage());
	}
}

}
