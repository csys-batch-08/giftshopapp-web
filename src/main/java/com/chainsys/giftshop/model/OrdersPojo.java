package com.chainsys.giftshop.model;

import java.io.Serializable;
import java.util.Date;

public class OrdersPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrdersPojo() {
		super();
	}

	private int productid;
	private String productname;
	private String producttype;
	private int orderid;
	private int userid;
	private Date orderdate;
	private String produtsize;
	private double totalprice;
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
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getProdutsize() {
		return produtsize;
	}

	public void setProdutsize(String produtsize) {
		this.produtsize = produtsize;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
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
		this.productname = productname;
		this.producttype = producttype;
		this.orderid = orderid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.produtsize = produtsize;
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
		this.productid = productid;
		this.orderid = orderid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.status = status;
	}

	public OrdersPojo(int userid, String productname, String producttype, int orderid, Date orderdate,
			String produtsize, double totalprice, int quantiy, String status) {
		super();

		this.productname = productname;
		this.producttype = producttype;
		this.orderid = orderid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.produtsize = produtsize;
		this.totalprice = totalprice;
		this.quantiy = quantiy;
		this.status = status;
	}

}
