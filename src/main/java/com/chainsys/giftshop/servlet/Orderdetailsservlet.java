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

import com.chainsys.giftshop.impl.ShowordersDaoImpl;
import com.chainsys.giftshop.model.ShowOrdersPojo;

@WebServlet("/orderdetails")
public class Orderdetailsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		String status=null;
		try {
		
		HttpSession session = req.getSession();
		int orderid = Integer.parseInt(req.getParameter("ordid"));
		session.setAttribute("order", orderid);
		ShowOrdersPojo orddetails = new ShowOrdersPojo();
		orddetails.setOrderid(orderid);
		ShowordersDaoImpl soi = new ShowordersDaoImpl();
		List<ShowOrdersPojo> sop = new ArrayList<>();
	        status=soi.checkstatus(orddetails);
		sop = soi.orderdetails(orddetails);
		req.setAttribute("orderdetails", sop);
		req.setAttribute("status", status);
		RequestDispatcher rd = req.getRequestDispatcher("orderdetails.jsp");
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}
}
