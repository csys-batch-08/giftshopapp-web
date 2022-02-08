package com.chainsys.giftshop.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.OrdersDaoImpl;
import com.chainsys.giftshop.model.OrdersPojo;

@WebServlet("/cancel")
public class Orderdeleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		int orderid = (int) session.getAttribute("orderdetailsid");
		OrdersPojo vcar1 = new OrdersPojo();
		vcar1.setOrderid(orderid);
		OrdersDaoImpl obj2 = new OrdersDaoImpl();
		boolean flag = obj2.cancelorder(vcar1);
		if (flag) {
			try {
				resp.sendRedirect("orderdelete.jsp");
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}
}
