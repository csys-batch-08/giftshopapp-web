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

import com.chainsys.giftshop.impl.ViewCartDaoImpl;
import com.chainsys.giftshop.model.viewcartPojo;

@WebServlet("/cart1")
public class Cartoneservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		int userid = Integer.parseInt(session.getAttribute("logincustomer").toString());
		viewcartPojo vcar1 = new viewcartPojo();
		vcar1.setUserid(userid);
		ViewCartDaoImpl vci = new ViewCartDaoImpl();
		List<viewcartPojo> vcp = new ArrayList<viewcartPojo>();
		try {
			vcp = vci.showcart(vcar1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("car", vcp);
		RequestDispatcher rd = req.getRequestDispatcher("cartmobile.jsp");
		rd.forward(req, resp);
	}
}
