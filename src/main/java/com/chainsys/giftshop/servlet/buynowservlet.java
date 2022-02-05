package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.OrdersDaoImpl;
import com.chainsys.giftshop.impl.ViewCartDaoImpl;
import com.chainsys.giftshop.model.OrdersPojo;
import com.chainsys.giftshop.model.viewcartPojo;

@WebServlet("/buynow")
public class buynowservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("logincustomer");
		int ordip = 0;
		boolean flag = false;
		OrdersPojo order = new OrdersPojo();
		order.setUserid(uid);
		OrdersDaoImpl obj = new OrdersDaoImpl();
		obj.createorder(order);

		ordip = obj.getorder(order);
		viewcartPojo vcar1 = new viewcartPojo();
		vcar1.setUserid(uid);
		ViewCartDaoImpl obj1 = new ViewCartDaoImpl();
		List<viewcartPojo> cartlist = null;
		try {
			cartlist = obj1.showcart1(vcar1);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		viewcartPojo vcar2 = new viewcartPojo();
		vcar2.setUserid(uid);
		ViewCartDaoImpl obj2 = new ViewCartDaoImpl();
		try {
			flag = obj2.emptycart(vcar2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (flag) {
			resp.sendRedirect("exit.jsp");
		}
	}

}
