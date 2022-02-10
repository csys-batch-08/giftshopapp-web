package com.chainsys.giftshop.model;

import java.io.Serializable;

public class ViewCartPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String image;
	private String productName;
	private String type;
	private double standardCost;
	private String size;
	private int quantity;
	private int userId;
	private int productId;
	private double totalPrice;

	public double getTotalprice() {
		return totalPrice;
	}

	public void setTotalprice(double d) {
		this.totalPrice = d;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductname() {
		return productName;
	}

	public void setProductname(String productname) {
		this.productName = productname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getStandardcost() {
		return standardCost;
	}

	public void setStandardcost(double standardcost) {
		this.standardCost = standardcost;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserid() {
		return userId;
	}

	public void setUserid(int userid) {
		this.userId = userid;
	}

	public int getProductid() {
		return productId;
	}

	public void setProductid(int productid) {
		this.productId = productid;
	}

	public ViewCartPojo(String image, String productname, String type, double standardcost, String size, int quantity,
			int userid) {
		super();
		this.image = image;
		this.productName = productname;
		this.type = type;
		this.standardCost = standardcost;
		this.size = size;
		this.quantity = quantity;
		this.userId = userid;
	}

	public ViewCartPojo() {
		super();
	}

	@Override
	public String toString() {
		return "viewcartPojo [image=" + image + ", productname=" + productName + ", type=" + type + ", standardcost="
				+ standardCost + ", size=" + size + ", quantity=" + quantity + ", userid=" + userId + ", productid="
				+ productId + ", totalprice=" + totalPrice + "]";
	}

	public ViewCartPojo(String image, String productname, String type, double standardcost, String size, int quantity,
			int userid, int productid) {
		super();
		this.image = image;
		this.productName = productname;
		this.type = type;
		this.standardCost = standardcost;
		this.size = size;
		this.quantity = quantity;
		this.userId = userid;
		this.productId = productid;
	}

	public ViewCartPojo(String image, String productname, String type, double standardcost, String size, int quantity,
			int userid, int productid, double totalprice) {
		super();
		this.image = image;
		this.productName = productname;
		this.type = type;
		this.standardCost = standardcost;
		this.size = size;
		this.quantity = quantity;
		this.userId = userid;
		this.productId = productid;
		this.totalPrice = totalprice;
	}

	public ViewCartPojo(String image2, String productname2, String type2, Double standardcost2, int qty, int userid2,
			int productid2) {

	}

}
