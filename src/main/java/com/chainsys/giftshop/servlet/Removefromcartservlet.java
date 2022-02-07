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
import com.chainsys.giftshop.model.ViewCartPojo;

@WebServlet("/removecart")
public class Removefromcartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("logincustomer");
		int productid = Integer.parseInt(req.getParameter("pid"));
		String size = req.getParameter("size");
		ViewCartPojo vcar = new ViewCartPojo();
		vcar.setProductid(productid);
		vcar.setUserid(uid);
		vcar.setSize(size);
		ViewCartDaoImpl pi = new ViewCartDaoImpl();
		ViewCartPojo vcp = null;
	    vcp = pi.removefromcart(vcar);
		vcp.setProductid(productid);
		RequestDispatcher rd = req.getRequestDispatcher("cart");
		rd.forward(req, resp);
		}catch (ClassNotFoundException | SQLException | IOException e) {	
			e.printStackTrace();
		}
	}
}
