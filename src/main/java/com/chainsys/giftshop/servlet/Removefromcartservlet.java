package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.ViewCartDaoImpl;
import com.chainsys.giftshop.model.viewcartPojo;

@WebServlet("/removecart")
public class Removefromcartservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("logincustomer");
		int productid = Integer.parseInt(req.getParameter("pid"));
		String size = req.getParameter("size");
		viewcartPojo vcar = new viewcartPojo();
		vcar.setProductid(productid);
		vcar.setUserid(uid);
		vcar.setSize(size);
		ViewCartDaoImpl pi = new ViewCartDaoImpl();
		try {
			viewcartPojo vcp = pi.removefromcart(vcar);
			vcp.setProductid(productid);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("cart");
		rd.forward(req, resp);
	}
}
