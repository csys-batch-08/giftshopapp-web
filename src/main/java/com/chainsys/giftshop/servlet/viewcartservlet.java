package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.ViewCartDaoImpl;
import com.chainsys.giftshop.model.viewcartPojo;

@WebServlet("/viewcart")
public class viewcartservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int flag = 0;
		HttpSession session = req.getSession();
		viewcartPojo vcart = (viewcartPojo) session.getAttribute("cartitems");
		ViewCartDaoImpl dao = new ViewCartDaoImpl();
		int productid = vcart.getProductid();
		String image = vcart.getImage();
		String productname = vcart.getProductname();
		String type = vcart.getType();
		Double standardcost = vcart.getStandardcost();
		String size = req.getParameter("sss");
		if (size == null) {
			size = "ra";
		}
		int qty = Integer.parseInt(req.getParameter("qty"));
		viewcartPojo vcart1 = new viewcartPojo();
		int userid = (int) session.getAttribute("logincustomer");

		vcart1.setUserid(userid);
		vcart1.setProductid(productid);
		vcart1.setSize(size);
		try {
			flag = dao.duplicatecart(vcart1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (flag > 0) {
			viewcartPojo vcar = new viewcartPojo(image, productname, type, standardcost, size, qty, userid, productid);
			try {
				dao.updatecart(vcar);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("cart");
		} else {
			viewcartPojo vcar = new viewcartPojo(image, productname, type, standardcost, size, qty, userid, productid);
			try {
				dao.insertview(vcar);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("cart");
		}
	}
}
