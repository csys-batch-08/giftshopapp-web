package com.chainsys.giftshop.model;

import java.io.Serializable;

public class ViewCartPojo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String image;
	private String productname;
	private String type;
	private double standardcost;
	private String size;
	private int quantity;
	private int userid;
	private int productid;
	private double totalprice;

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double d) {
		this.totalprice = d;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getStandardcost() {
		return standardcost;
	}

	public void setStandardcost(double standardcost) {
		this.standardcost = standardcost;
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
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public ViewCartPojo(String image, String productname, String type, double standardcost, String size, int quantity,
			int userid) {
		super();
		this.image = image;
		this.productname = productname;
		this.type = type;
		this.standardcost = standardcost;
		this.size = size;
		this.quantity = quantity;
		this.userid = userid;
	}

	public ViewCartPojo() {
		super();
	}

	@Override
	public String toString() {
		return "viewcartPojo [image=" + image + ", productname=" + productname + ", type=" + type + ", standardcost="
				+ standardcost + ", size=" + size + ", quantity=" + quantity + ", userid=" + userid + ", productid="
				+ productid + ", totalprice=" + totalprice + "]";
	}

	public ViewCartPojo(String image, String productname, String type, double standardcost, String size, int quantity,
			int userid, int productid) {
		super();
		this.image = image;
		this.productname = productname;
		this.type = type;
		this.standardcost = standardcost;
		this.size = size;
		this.quantity = quantity;
		this.userid = userid;
		this.productid = productid;
	}

	public ViewCartPojo(String image, String productname, String type, double standardcost, String size, int quantity,
			int userid, int productid, double totalprice) {
		super();
		this.image = image;
		this.productname = productname;
		this.type = type;
		this.standardcost = standardcost;
		this.size = size;
		this.quantity = quantity;
		this.userid = userid;
		this.productid = productid;
		this.totalprice = totalprice;
	}

	public ViewCartPojo(String image2, String productname2, String type2, Double standardcost2, int qty, int userid2,
			int productid2) {

	}

}
