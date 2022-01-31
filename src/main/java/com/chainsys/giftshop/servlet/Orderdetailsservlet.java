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

import com.chainsys.giftshop.impl.showordersImpl;
import com.chainsys.giftshop.model.showordersPojo;

@WebServlet("/orderdetails")
public class Orderdetailsservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		int orderid = Integer.parseInt(req.getParameter("ordid"));
		showordersPojo orddetails = new showordersPojo();
		orddetails.setOrderid(orderid);
		showordersImpl soi = new showordersImpl();
		List<showordersPojo> sop = new ArrayList<showordersPojo>();
		try {
			sop = soi.orderdetails(orddetails);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("orderdetails", sop);
		RequestDispatcher rd = req.getRequestDispatcher("orderdetails.jsp");
		rd.forward(req, resp);

	}
}
