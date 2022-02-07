package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.OrdersDaoImpl;
import com.chainsys.giftshop.impl.ViewCartDaoImpl;
import com.chainsys.giftshop.model.OrdersPojo;
import com.chainsys.giftshop.model.ViewCartPojo;

@WebServlet("/buynow")
public class Buynowservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		try {
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("logincustomer");
		int ordip = 0;
		boolean flag = false;
		OrdersPojo order = new OrdersPojo();
		order.setUserid(uid);
		OrdersDaoImpl obj = new OrdersDaoImpl();
		obj.createorder(order);

		ordip = obj.getorder(order);
		ViewCartPojo vcar1 = new ViewCartPojo();
		vcar1.setUserid(uid);
		ViewCartDaoImpl obj1 = new ViewCartDaoImpl();
		List<ViewCartPojo> cartlist = null;
		
			cartlist = obj1.showcart1(vcar1);
		for (int i = 0; cartlist.size() > i; i++) {
			OrdersPojo orders = new OrdersPojo();
			orders.setUserid(uid);
			orders.setOrderid(ordip);
			orders.setProductid(cartlist.get(i).getProductid());
			orders.setQuantiy(cartlist.get(i).getQuantity());
			orders.setProdutsize(cartlist.get(i).getSize());
			orders.setProducttype(cartlist.get(i).getType());
			orders.setTotalprice(cartlist.get(i).getStandardcost());
			OrdersDaoImpl ord = new OrdersDaoImpl();
			ord.insertorder(orders);
		}
		ViewCartPojo vcar2 = new ViewCartPojo();
		vcar2.setUserid(uid);
		ViewCartDaoImpl obj2 = new ViewCartDaoImpl();
	
			flag = obj2.emptycart(vcar2);
		 		if (flag) {
			
				resp.sendRedirect("exit.jsp");
			
		}
	}catch (ClassNotFoundException | SQLException | IOException e) {
		e.printStackTrace();
	} 

	}

}
