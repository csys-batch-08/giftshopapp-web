package com.chainsys.giftshop.model;

import java.io.Serializable;
import java.sql.Date;

public class ShowOrdersPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private int orderId;
	private Date orderDate;
	private String status;
	private int quantityOrdered;
	private double totalPrice;
	private String size;
	private String productName;
	private double standardCost;
	private String image;

	public int getUserid() {
		return userId;
	}

	public void setUserid(int userid) {
		this.userId = userid;
	}

	public int getOrderid() {
		return orderId;
	}

	public void setOrderid(int orderid) {
		this.orderId = orderid;
	}

	public Date getOrderdate() {
		return orderDate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderDate = orderdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantityordered() {
		return quantityOrdered;
	}

	public void setQuantityordered(int quantityordered) {
		this.quantityOrdered = quantityordered;
	}

	public double getTotalprice() {
		return totalPrice;
	}

	public void setTotalprice(double totalprice) {
		this.totalPrice = totalprice;
	}

	public ShowOrdersPojo() {
		super();
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getProductname() {
		return productName;
	}

	public void setProductname(String productname) {
		this.productName = productname;
	}

	public double getStandardcost() {
		return standardCost;
	}

	public void setStandardcost(double standardcost) {
		this.standardCost = standardcost;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ShowOrdersPojo(int userid, int orderid, Date orderdate, String status, int quantityordered, int totalprice,
			String size, String productname, double standardcost, String image) {
		super();
		this.userId = userid;
		this.orderId = orderid;
		this.orderDate = orderdate;
		this.status = status;
		this.quantityOrdered = quantityordered;
		this.totalPrice = totalprice;
		this.size = size;
		this.productName = productname;
		this.standardCost = standardcost;
		this.image = image;
	}

}
