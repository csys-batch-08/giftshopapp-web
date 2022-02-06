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
import com.chainsys.giftshop.model.showordersPojo;

@WebServlet("/orderdetails")
public class Orderdetailsservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int orderid = Integer.parseInt(req.getParameter("ordid"));
		session.setAttribute("order", orderid);
		showordersPojo orddetails = new showordersPojo();
		orddetails.setOrderid(orderid);
		ShowordersDaoImpl soi = new ShowordersDaoImpl();
		List<showordersPojo> sop = new ArrayList<>();
		sop = soi.orderdetails(orddetails);
		req.setAttribute("orderdetails", sop);
		RequestDispatcher rd = req.getRequestDispatcher("orderdetails.jsp");
		rd.forward(req, resp);

	}
}
