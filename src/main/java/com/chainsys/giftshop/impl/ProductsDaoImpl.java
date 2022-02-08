package com.chainsys.giftshop.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.giftshop.dao.ProductsDao;
import com.chainsys.giftshop.logger.Logger;
import com.chainsys.giftshop.model.ProductPojo;
import com.chainsys.giftshop.util.ConnectionUtil;

public class ProductsDaoImpl implements ProductsDao {

	private static final String P_TYPE = "p_type";
	private static final String QUANTITY_ONHAND = "quantity_onhand";
	private static final String PRODUCT_ID = "product_id";
	private static final String STANDARD_COST = "standard_cost";
	private static final String IMAGE = "image";
	private static final String CATEGORY = "category";
	private static final String DESCRIPTION = "description";
	private static final String PRODUCT_NAME = "product_name";

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
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
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
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
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
				pp = new ProductPojo(rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION), rs.getString(CATEGORY),
						rs.getString(IMAGE));
				products.add(pp);
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp = new ProductPojo(rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION), rs.getDouble(STANDARD_COST),
						rs.getString(CATEGORY), rs.getString(IMAGE));
				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp = new ProductPojo(rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION), rs.getDouble(STANDARD_COST),
						rs.getString(CATEGORY), rs.getString(IMAGE));
				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp = new ProductPojo(rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION), rs.getDouble(STANDARD_COST),
						rs.getString(CATEGORY), rs.getString(IMAGE));
				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp = new ProductPojo(rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION), rs.getDouble(STANDARD_COST),
						rs.getString(CATEGORY), rs.getString(IMAGE));
				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pstmt, con);
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
				return rs.getInt(PRODUCT_ID);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp = new ProductPojo(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION),
						rs.getDouble(STANDARD_COST), rs.getString(CATEGORY), rs.getInt(QUANTITY_ONHAND));
				return pp;
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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

				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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

				pp = new ProductPojo(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION),
						rs.getDouble(STANDARD_COST), rs.getString(CATEGORY), rs.getInt(QUANTITY_ONHAND),
						rs.getString(IMAGE), rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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

				pp = new ProductPojo(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION),
						rs.getDouble(STANDARD_COST), rs.getString(CATEGORY), rs.getInt(QUANTITY_ONHAND),
						rs.getString(IMAGE), rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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

				pp = new ProductPojo(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION),
						rs.getDouble(STANDARD_COST), rs.getString(CATEGORY), rs.getInt(QUANTITY_ONHAND),
						rs.getString(IMAGE), rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));
				pp.setProductId(rs.getInt(PRODUCT_ID));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));
				pp.setProductId(rs.getInt(PRODUCT_ID));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));

				products.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				ProductPojo pp = new ProductPojo(rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION),
						rs.getString(CATEGORY), rs.getString(IMAGE));

				searchproducts.add(pp);
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp.setImage(rs.getString(IMAGE));
				pp.setProductName(rs.getString(PRODUCT_NAME));
				pp.setProductId(rs.getInt(PRODUCT_ID));
				pp.setStandardCost(rs.getDouble(STANDARD_COST));
				pp.setType(rs.getString(P_TYPE));

				products1.add(pp);
			}
		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
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
				pp = new ProductPojo(rs.getInt(PRODUCT_ID), rs.getString(PRODUCT_NAME), rs.getString(DESCRIPTION),
						rs.getString(CATEGORY), rs.getString(IMAGE));

				products.add(pp);
			}

		} catch (Exception e) {
			Logger.printstackrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pstmt, con);
		}
		return products;
	}
}
