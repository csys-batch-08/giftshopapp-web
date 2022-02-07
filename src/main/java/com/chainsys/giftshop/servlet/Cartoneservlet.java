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

import com.chainsys.giftshop.impl.ViewCartDaoImpl;
import com.chainsys.giftshop.model.ViewCartPojo;

@WebServlet("/cart1")
public class Cartoneservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){

		HttpSession session = req.getSession();
		int userid = Integer.parseInt(session.getAttribute("logincustomer").toString());
		ViewCartPojo vcar1 = new ViewCartPojo();
		vcar1.setUserid(userid);
		ViewCartDaoImpl vci = new ViewCartDaoImpl();
		List<ViewCartPojo> vcp = new ArrayList<>();
		vcp = vci.showcartpage(vcar1);
		req.setAttribute("car", vcp);
		RequestDispatcher rd = req.getRequestDispatcher("cartmobile.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException  e) {
			e.printStackTrace();
		}
	}
}
