package com.chainsys.giftshop.model;

import java.io.Serializable;
import java.util.Date;

public class OrdersPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrdersPojo() {
		super();
	}

	private int productId;
	private String productName;
	private String productType;
	private int orderId;
	private int userId;
	private Date orderDate;
	private String produtSize;
	private double totalPrice;
	private int quantiy;
	private String status;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProductid() {
		return productId;
	}

	public void setProductid(int productid) {
		this.productId = productid;
	}

	public String getProductname() {
		return productName;
	}

	public void setProductname(String productname) {
		this.productName = productname;
	}

	public String getProducttype() {
		return productType;
	}

	public void setProducttype(String producttype) {
		this.productType = producttype;
	}

	public int getOrderid() {
		return orderId;
	}

	public void setOrderid(int orderid) {
		this.orderId = orderid;
	}

	public int getUserid() {
		return userId;
	}

	public void setUserid(int userid) {
		this.userId = userid;
	}

	public Date getOrderdate() {
		return orderDate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderDate = orderdate;
	}

	public String getProdutsize() {
		return produtSize;
	}

	public void setProdutsize(String produtsize) {
		this.produtSize = produtsize;
	}

	public double getTotalprice() {
		return totalPrice;
	}

	public void setTotalprice(double totalprice) {
		this.totalPrice = totalprice;
	}

	public int getQuantiy() {
		return quantiy;
	}

	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}

	public OrdersPojo(String productname, String producttype, int orderid, int userid, Date orderdate,
			String produtsize, int quantiy, String status) {
		super();
		this.productName = productname;
		this.productType = producttype;
		this.orderId = orderid;
		this.userId = userid;
		this.orderDate = orderdate;
		this.produtSize = produtsize;
		this.quantiy = quantiy;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrdersPojo(int productid, int orderid, int userid, Date orderdate, String status) {
		super();
		this.productId = productid;
		this.orderId = orderid;
		this.userId = userid;
		this.orderDate = orderdate;
		this.status = status;
	}

	public OrdersPojo(int userid, String productname, String producttype, int orderid, Date orderdate,
			String produtsize, double totalprice, int quantiy, String status) {
		super();

		this.productName = productname;
		this.productType = producttype;
		this.orderId = orderid;
		this.userId = userid;
		this.orderDate = orderdate;
		this.produtSize = produtsize;
		this.totalPrice = totalprice;
		this.quantiy = quantiy;
		this.status = status;
	}

}
