package com.chainsys.giftshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.OrdersDaoImpl;
import com.chainsys.giftshop.model.OrdersPojo;

@WebServlet("/cancel")
public class orderdeleteservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		int orderid = (int) session.getAttribute("orderdetailsid");
		OrdersPojo vcar1 = new OrdersPojo();
		vcar1.setOrderid(orderid);
		OrdersDaoImpl obj2 = new OrdersDaoImpl();
		boolean flag = obj2.cancelorder(vcar1);
		if (flag) {
			resp.sendRedirect("orderdelete.jsp");
		}
	}
}
