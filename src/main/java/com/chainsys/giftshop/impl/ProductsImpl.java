package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.giftshop.dao.ProductsDao;
import com.chainsys.giftshop.model.OrdersPojo;
import com.chainsys.giftshop.model.ProductPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class ProductsImpl implements ProductsDao {

//	private static final ProductsImpl ProductDao1 = null;

	public void insert(ProductPojo product1) throws ClassNotFoundException, SQLException {

		String insertQuery = "insert into gproducts (product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type)values(?,?,?,?,?,?,?,?)";
		Connection con = ConnectionUtil.gbconnection();
		PreparedStatement pstmt = con.prepareStatement(insertQuery);
		pstmt.setInt(1, product1.getProductId());
		pstmt.setString(2, product1.getProductName());
		pstmt.setString(3, product1.getDescription());
		pstmt.setDouble(4, product1.getStandardCost());
		pstmt.setString(5, product1.getCategory());
		pstmt.setInt(6, product1.getQuantityonhand());
		pstmt.setString(7, product1.getImage());
		pstmt.setString(8, product1.getType());
		int i = pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}

	public void update(ProductPojo product2) throws SQLException, ClassNotFoundException {
		String UpdateQuery = "update gproducts set standard_cost=?,quantity_onhand=? where product_id=?";
		Connection con = ConnectionUtil.gbconnection();
		PreparedStatement pstmt = con.prepareStatement(UpdateQuery);
		pstmt.setDouble(1, product2.getStandardCost());
		pstmt.setInt(2, product2.getQuantityonhand());
		pstmt.setInt(3, product2.getProductId());
		int i = pstmt.executeUpdate();
		con.close();
		pstmt.close();
	}

	public List<ProductPojo> adminShowProduct() {
		List<ProductPojo> products = new ArrayList<ProductPojo>();
		String prod = "select product_name,description,category,image from gproducts";
		Connection con;
		ProductPojo product = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(prod);
			while (rs.next()) {
				product = new ProductPojo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				products.add(product);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public void showProduct() {
		String prod = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts";
		Connection con;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(prod);
			while (rs.next()) {
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ProductPojo> mens() {
		List<ProductPojo> products = new ArrayList<ProductPojo>();
		String products1 = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where category='mens'";
		Connection con;
		ProductPojo product = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(products1);
			while (rs.next()) {
				product = new ProductPojo(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(7));
				products.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public List<ProductPojo> womens() {
		List<ProductPojo> products = new ArrayList<ProductPojo>();
		String products1 = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where category='womens'";
		Connection con;
		ProductPojo product = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(products1);
			while (rs.next()) {
				product = new ProductPojo(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(7));
				products.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public List<ProductPojo> kids() {
		List<ProductPojo> products = new ArrayList<ProductPojo>();
		String products1 = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where category='kids'";
		Connection con;
		ProductPojo product = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(products1);
			while (rs.next()) {
				product = new ProductPojo(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(7));
				products.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public List<ProductPojo> occasions() {
		List<ProductPojo> products = new ArrayList<ProductPojo>();
		String products1 = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where category='occasions'";
		Connection con;
		ProductPojo product = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(products1);
			while (rs.next()) {
				product = new ProductPojo(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(7));
				products.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public void delete(ProductPojo product3) throws SQLException, ClassNotFoundException {
		System.out.println("row deleted successfully");
		String Deletequery = "delete from gproducts where product_id=?";
		Connection con = ConnectionUtil.gbconnection();
		PreparedStatement pstmt = con.prepareStatement(Deletequery);
		pstmt.setInt(1, product3.getProductId());
		int i = pstmt.executeUpdate();
	}

	public int productid(String prodname) throws Exception {
		String UpdateQuery = "select product_id from gproducts where product_name in ?";
		Connection con = ConnectionUtil.gbconnection();
		PreparedStatement pstmt = con.prepareStatement(UpdateQuery);
		pstmt.setString(1, prodname);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	public ProductPojo validateProduct(String productname) {

		String validdateQuery = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where product_name=?";
		ProductPojo product1 = null;

		try {
			Connection con = ConnectionUtil.gbconnection();
			PreparedStatement pstmt = con.prepareStatement(validdateQuery);
			pstmt.setString(1, productname);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				product1 = new ProductPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getInt(6));
				return product1;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product1;

	}

	public List<ProductPojo> viewmenstshirt() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();
		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='Mens tshirt'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setProductId(rs.getInt(5));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> adminviewtshirt() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getview = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where product_name='Mens tshirt'and category='menstee'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getview);
			while (rs.next()) {

				prod = new ProductPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> adminviewmobilecase() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getview = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where product_name='mobile case'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getview);
			while (rs.next()) {

				prod = new ProductPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> adminviewcaricature() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getview = "select product_id,product_name,description,standard_cost,category,quantity_onhand,image,p_type from gproducts where product_name='womens caricature'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getview);
			while (rs.next()) {

				prod = new ProductPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> mobilecase() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='mobile case'and category='menscase'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setProductId(rs.getInt(5));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> offertshirt() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_id in(11,12)";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));
				prod.setProductId(rs.getInt(5));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> offersgift() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_id in(13,14)";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));
				prod.setProductId(rs.getInt(5));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> offerskids() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_id in(15,16)";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));
				prod.setProductId(rs.getInt(5));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> viewwomenscaricature() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='womens caricature' and category='womens caricature'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setProductId(rs.getInt(5));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> viewwomenswatch() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='womens watch' and category='womens watch'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setProductId(rs.getInt(5));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> viewkidsmugs() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='kids mugs'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setProductId(rs.getInt(5));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> viewkidstshirts() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where product_name='kids tshirts'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setProductId(rs.getInt(5));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}

	public List<ProductPojo> viewvalentines() {
		List<ProductPojo> products2 = new ArrayList<ProductPojo>();

		String getprice = "select product_name,standard_cost,image,p_type,product_id from gproducts where category='valentines'";
		Connection con;
		ProductPojo prod = null;
		try {
			con = ConnectionUtil.gbconnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getprice);
			while (rs.next()) {

				prod = new ProductPojo();
				prod.setImage(rs.getString(3));
				prod.setProductName(rs.getString(1));
				prod.setProductId(rs.getInt(5));
				prod.setStandardCost(rs.getDouble(2));
				prod.setType(rs.getString(4));

				products2.add(prod);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products2;
	}
}
