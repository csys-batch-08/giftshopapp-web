package com.chainsys.giftshop.dao;

import java.util.List;

import com.chainsys.giftshop.model.ProductPojo;

public interface ProductsDao {

	public void insert(ProductPojo product);

	public void update(ProductPojo product2);

	public List<ProductPojo> adminShowProduct();

	public void showProduct();

	public List<ProductPojo> mens();

	public List<ProductPojo> womens();

	public List<ProductPojo> kids();

	public List<ProductPojo> occasions();

	public void delete(ProductPojo product3);

	public int productid(String prodname);

	public ProductPojo validateProduct(String proName);

	public List<ProductPojo> viewmenstshirt();

	public List<ProductPojo> adminviewtshirt();

	public List<ProductPojo> adminviewmobilecase();

	public List<ProductPojo> adminviewcaricature();

	public List<ProductPojo> mobilecase();

	public List<ProductPojo> offertshirt();

	public List<ProductPojo> offersgift();

	public List<ProductPojo> offerskids();

	public List<ProductPojo> viewwomenscaricature();

	public List<ProductPojo> viewwomenswatch();

	public List<ProductPojo> viewkidsmugs();

	public List<ProductPojo> viewkidstshirts();

	public List<ProductPojo> viewvalentines();

}
