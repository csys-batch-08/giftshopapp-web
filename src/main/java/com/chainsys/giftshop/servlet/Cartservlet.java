package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.viewCartImpl;
import com.chainsys.giftshop.model.viewcartPojo;

@WebServlet("/cart")
public class Cartservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		int userid = Integer.parseInt(session.getAttribute("logincustomer").toString());

		viewcartPojo vcar1 = new viewcartPojo();
		vcar1.setUserid(userid);
		viewCartImpl vci = new viewCartImpl();
		List<viewcartPojo> vcp = new ArrayList<viewcartPojo>();
		try {
			vcp = vci.showcart(vcar1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("car", vcp);
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);
	}
}
