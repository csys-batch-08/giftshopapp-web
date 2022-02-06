package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.giftshop.dao.ProductsDao;
import com.chainsys.giftshop.model.ProductPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class ProductsDaoImpl implements ProductsDao {



	@Override
	public void insert(ProductPojo product1) {
		String query = "insert into gproducts (product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type)values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, product1.getProductId());
			pstmt.setString(2, product1.getProductName());
			pstmt.setString(3, product1.getDescription());
			pstmt.setDouble(4, product1.getStandardCost());
			pstmt.setString(5, product1.getCategory());
			pstmt.setInt(6, product1.getQuantityonhand());
			pstmt.setString(7, product1.getImage());
			pstmt.setString(8, product1.getType());
			pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
	}

	@Override
	public void update(ProductPojo product2) {
		String query = "update gproducts set standard_cost=?,quantity_onhand=? where product_id=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, product2.getStandardCost());
			pstmt.setInt(2, product2.getQuantityonhand());
			pstmt.setInt(3, product2.getProductId());
			pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
	}

	@Override
	public List<ProductPojo> adminShowProduct() {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,description,category,image from gproducts";
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductPojo pp = new ProductPojo();
				pp = new ProductPojo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				products.add(pp);
			}

		} catch (SQLException | ClassNotFoundException e) {
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

		return products;

	}

	@Override
	public void showProduct() {
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
		} catch (SQLException | ClassNotFoundException  e) {
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
	}

	@Override
	public List<ProductPojo> mens() {
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where category='mens'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		List<ProductPojo> products = new ArrayList<>();
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pp = new ProductPojo(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(7));
				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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

		return products;

	}

	@Override
	public List<ProductPojo> womens() {
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where category='womens'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		List<ProductPojo> products = new ArrayList<>();
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery(query);
			while (rs.next()) {
				pp = new ProductPojo(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(7));
				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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

		return products;

	}

	@Override
	public List<ProductPojo> kids() {
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where category='kids'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		List<ProductPojo> products = new ArrayList<>();
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pp = new ProductPojo(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(7));
				products.add(pp);
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return products;

	}

	@Override
	public List<ProductPojo> occasions() {
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where category='occasions'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		List<ProductPojo> products = new ArrayList<>();
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pp = new ProductPojo(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(7));
				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
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

		return products;

	}

	@Override
	public void delete(ProductPojo product3) {
		String query = "delete from gproducts where product_id=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, product3.getProductId());
			pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
	}

	@Override
	public int productid(String prodname) {
		String query = "select product_id from gproducts where product_name in ?";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, prodname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	@Override
	public ProductPojo validateProduct(String productname) {
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where product_name=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pp = new ProductPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6));
				return pp;
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pp;
	}

	@Override
	public List<ProductPojo> viewmenstshirt() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='Mens tshirt'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setProductId(rs.getInt(5));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));
				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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
		return products;
	}

	@Override
	public List<ProductPojo> adminviewtshirt() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where product_name='Mens tshirt'and category='menstee'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8));

				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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
		return products;
	}

	@Override
	public List<ProductPojo> adminviewmobilecase() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where product_name='mobile case'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8));

				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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
		return products;
	}

	@Override
	public List<ProductPojo> adminviewcaricature() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where product_name='womens caricature'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8));

				products.add(pp);
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public List<ProductPojo> mobilecase() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='mobile case'and category='menscase'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setProductId(rs.getInt(5));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));

				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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
		return products;
	}

	@Override
	public List<ProductPojo> offertshirt() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_id in(11,12)";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));
				pp.setProductId(rs.getInt(5));

				products.add(pp);
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public List<ProductPojo> offersgift() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_id in(13,14)";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));
				pp.setProductId(rs.getInt(5));

				products.add(pp);
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public List<ProductPojo> offerskids() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_id in(15,16)";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));
				pp.setProductId(rs.getInt(5));

				products.add(pp);
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public List<ProductPojo> viewwomenscaricature() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='womens caricature' and category='womens caricature'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setProductId(rs.getInt(5));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));

				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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
		return products;
	}

	@Override
	public List<ProductPojo> viewwomenswatch() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='womens watch' and category='womens watch'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setProductId(rs.getInt(5));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));

				products.add(pp);
			}
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
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public List<ProductPojo> viewkidsmugs() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='kids mugs'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setProductId(rs.getInt(5));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));

				products.add(pp);
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public List<ProductPojo> viewkidstshirts() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='kids tshirts'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setProductId(rs.getInt(5));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));

				products.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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
		return products;
	}

	@Override
	public List<ProductPojo> viewvalentines() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_name,standard_cost,image,p_type,product_id from gproducts where category='valentines'";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setProductId(rs.getInt(5));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));

				products.add(pp);
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	public List<ProductPojo> serachProduct(String proName) {
		List<ProductPojo> searchproducts = new ArrayList<>();
		String query = "select product_name,description,category,image from gproducts where lower(product_name ) like ?  ";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, proName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductPojo pp = new ProductPojo(rs.getString("product_name"), rs.getString("description"),
						rs.getString("category"), rs.getString("image"));

				searchproducts.add(pp);
			}

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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return searchproducts;
	}

	public List<ProductPojo> products() {
		List<ProductPojo> products1 = new ArrayList<>();
		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(getprice);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pp = new ProductPojo();
				pp.setImage(rs.getString(3));
				pp.setProductName(rs.getString(1));
				pp.setProductId(rs.getInt(5));
				pp.setStandardCost(rs.getDouble(2));
				pp.setType(rs.getString(4));

				products1.add(pp);
			}
		} catch (SQLException | ClassNotFoundException e) {
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
		return products1;
	}

	public List<ProductPojo> adminShowdelete() {
		List<ProductPojo> products = new ArrayList<>();
		String query = "select product_id,product_name,description,category,image from gproducts";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		ProductPojo pp = null;
		try {
			con = ConnectionUtil.gbconnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pp = new ProductPojo(rs.getInt("product_id"), rs.getString("product_name"), rs.getString("description"),
						rs.getString("category"), rs.getString("image"));

				products.add(pp);
			}

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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}
}
