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

@WebServlet("/editservlet")
public class Editcartservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		int userid = Integer.parseInt(session.getAttribute("logincustomer").toString());
		int productid = Integer.parseInt(req.getParameter("pid"));
		viewcartPojo vcp = new viewcartPojo();
		viewcartPojo vcpojo = new viewcartPojo();
		vcp.setProductid(productid);
		vcp.setUserid(userid);
		ViewCartDaoImpl vci = new ViewCartDaoImpl();
		try {
			vcpojo = vci.editcart(vcp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("cartitems", vcpojo);
		System.out.println(vcpojo.getSize());
		if (vcpojo.getSize().equals("ra")) {
			RequestDispatcher rd = req.getRequestDispatcher("addcartone.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("addcart.jsp");
			rd.forward(req, resp);
		}
	}
}