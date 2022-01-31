package com.chainsys.giftshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.giftshop.model.viewcartPojo;

public interface CartDao {

	public void insertview(viewcartPojo vcar) throws ClassNotFoundException, SQLException;

	public List<viewcartPojo> insertcart1(viewcartPojo vcar) throws ClassNotFoundException, SQLException;

	public List<viewcartPojo> showcart(viewcartPojo vcar1) throws ClassNotFoundException, SQLException;

	public List<viewcartPojo> showcart();

	public List<viewcartPojo> showcart1(viewcartPojo vcar1) throws ClassNotFoundException, SQLException;

	public boolean emptycart(viewcartPojo vcar2) throws SQLException, ClassNotFoundException;

	public List<viewcartPojo> mycart(viewcartPojo vcart) throws ClassNotFoundException, SQLException;

	public boolean duplicatecart(viewcartPojo vcart) throws ClassNotFoundException, SQLException;

	public viewcartPojo removefromcart(viewcartPojo vcar) throws ClassNotFoundException, SQLException;
}
