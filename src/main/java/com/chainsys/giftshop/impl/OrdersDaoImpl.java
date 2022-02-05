package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.giftshop.dao.OrdersDao;
import com.chainsys.giftshop.model.OrdersPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public void orderinsert(int userid, String productname, int quantity, double price) {
		String Query = "insert into gorders(user_id,product_name,quantity,price) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, userid);
			pstmt.setString(2, productname);
			pstmt.setInt(3, quantity);
			pstmt.setDouble(4, price);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public OrdersPojo showorders(int userid) {
		String Query = "select user_id,product_name,p_type,order_id,order_date,p_size,total_price,quantity,status from gorders where user_id in ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrdersPojo op = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				op = new OrdersPojo(rs.getInt("user_id"), rs.getString("product_name"), rs.getNString("p_type"),
						rs.getInt("order_id"), rs.getDate("order_date"), rs.getString("p_size"),
						rs.getDouble("total_price"), rs.getInt("quantity"), rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return op;

	}

	@Override
	public void insert(OrdersPojo product) {
		String Query = "insert into gorders(user_id,product_name,p_type,order_id,order_date,p_size,total_price,qunatity,status) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(Query);
			pstmt.setString(1, product.getProductname());
			pstmt.setString(2, product.getProducttype());
			pstmt.setString(3, product.getProdutsize());
			pstmt.setDouble(4, product.getTotalprice());
			pstmt.setInt(5, product.getQuantiy());
			pstmt.setString(6, product.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createorder(OrdersPojo order) {
		String Query = "insert into gorders(user_id) values(?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, order.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int getorder(OrdersPojo order) {
		int orderid = 0;
		PreparedStatement pstmt = null;
		Connection con = null;
		String Query = "SELECT order_id FROM gorders where user_id = ?  order by order_date desc fetch first rows only";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, order.getUserid());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				orderid = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderid;
	}

	@Override
	public void insertorder(OrdersPojo order1) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String Query = "insert into gorder_items1(order_id,quantity_ordered,total_price,user_id,product_id,p_size)values(?,?,?,?,?,?)";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, order1.getOrderid());
			pstmt.setInt(2, order1.getQuantiy());
			pstmt.setDouble(3, order1.getTotalprice());
			pstmt.setInt(4, order1.getUserid());
			pstmt.setInt(5, order1.getProductid());
			pstmt.setString(6, order1.getProdutsize());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<OrdersPojo> userOrderDetails(OrdersPojo showord) {
		PreparedStatement pstmt = null;
		Connection con = null;
		List<OrdersPojo> orderlist = new ArrayList<>();
		String query = "select order_id,trunc(order_date),status from gorders where user_id=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, showord.getUserid());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrdersPojo op = new OrdersPojo();

				op.setOrderid(rs.getInt(1));
				op.setOrderdate(rs.getDate(2));
				op.setStatus(rs.getString(3));
				orderlist.add(op);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderlist;
	}

	@Override
	public boolean cancelorder(OrdersPojo vcar2) {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			String Query = "update gorders set status='order cancelled' where order_id=?";
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, vcar2.getOrderid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public OrdersPojo reorder(OrdersPojo order) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String Query = "select order_id,quantity_ordered,total_price,user_id,product_id,p_size from gorder_items1 where product_id=?";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, order.getProductid());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				order.setOrderid(rs.getInt("order_id"));
				order.setQuantiy(rs.getInt("quantity_ordered"));
				order.setTotalprice(rs.getDouble("total_price"));
				order.setUserid(rs.getInt("user_id"));
				order.setProductid(rs.getInt("product_id"));
				order.setProdutsize(rs.getString("p_size"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return order;
	}

}
