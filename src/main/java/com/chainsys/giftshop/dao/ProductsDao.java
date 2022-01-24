package com.chainsys.giftshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.giftshop.model.ProductPojo;

public interface ProductsDao {
	public void insert(ProductPojo product) throws ClassNotFoundException, SQLException;
	
	public void update(ProductPojo product2) throws SQLException, ClassNotFoundException;
	
	public  List<ProductPojo> adminShowProduct();
	
	public void showProduct();
	
	public List<ProductPojo> mens(); 
	
	public List<ProductPojo> womens();
	
	public List<ProductPojo> kids();
	
	public int productid(String prodname) throws Exception;
	
	public ProductPojo validateProduct(String proName);
	
	
	
}
