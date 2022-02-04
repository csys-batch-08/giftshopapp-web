package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.OrdersDaoImpl;
import com.chainsys.giftshop.model.OrdersPojo;

@WebServlet("/orders")
public class Ordersservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int userid = Integer.parseInt(session.getAttribute("logincustomer").toString());
		OrdersDaoImpl oi = new OrdersDaoImpl();
		OrdersPojo showord = new OrdersPojo();
		showord.setUserid(userid);
		List<OrdersPojo> op = new ArrayList<OrdersPojo>();
		op = oi.userOrderDetails(showord);
		req.setAttribute("showorders", op);
		RequestDispatcher rd = req.getRequestDispatcher("gorders.jsp");
		rd.forward(req, resp);

	}

}