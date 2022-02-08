package com.chainsys.giftshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.OrdersDaoImpl;
import com.chainsys.giftshop.model.OrdersPojo;

@WebServlet("/reorder")
public class Reorderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			HttpSession session = req.getSession();
			int userid = Integer.parseInt(session.getAttribute("logincustomer").toString());
			int productid = Integer.parseInt(req.getParameter("pid"));
			OrdersPojo vcp = new OrdersPojo();
			OrdersPojo vcpojo = new OrdersPojo();
			vcp.setProductid(productid);
			vcp.setUserid(userid);
			OrdersDaoImpl vci = new OrdersDaoImpl();
			vcpojo = vci.reorder(vcpojo);
			session.setAttribute("cartitems", vcpojo);
			RequestDispatcher rd = req.getRequestDispatcher("addcart.jsp");
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.getMessage();
		}

	}
}