package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.OrdersImpl;
import com.chainsys.giftshop.model.OrdersPojo;

@WebServlet("/cancel")
public class orderdeleteservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		int orderid = Integer.parseInt(session.getAttribute("orderid").toString());
		boolean flag = false;
		OrdersPojo vcar1 = new OrdersPojo();
		vcar1.setOrderid(orderid);
		OrdersImpl obj2 = new OrdersImpl();
		try {
			flag = obj2.cancelorder(vcar1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			resp.sendRedirect("orderdelete.jsp");
		}
	}
}
