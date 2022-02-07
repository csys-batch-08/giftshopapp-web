package com.chainsys.giftshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.giftshop.model.ViewCartPojo;

public interface CartDao {

	public void insertview(ViewCartPojo vcar);

	public List<ViewCartPojo> insertcart1(ViewCartPojo vcar);

	public List<ViewCartPojo> showcart(ViewCartPojo vcar1) throws ClassNotFoundException, SQLException;

	public List<ViewCartPojo> showcart();

	public List<ViewCartPojo> showcart1(ViewCartPojo vcar1);

	public boolean emptycart(ViewCartPojo vcar2) throws SQLException, ClassNotFoundException;

	public List<ViewCartPojo> mycart(ViewCartPojo vcart);

	public int duplicatecart(ViewCartPojo vcart);

	public ViewCartPojo removefromcart(ViewCartPojo vcar);
}
