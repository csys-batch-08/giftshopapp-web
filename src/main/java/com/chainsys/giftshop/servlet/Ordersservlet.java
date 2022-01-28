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

import com.chainsys.giftshop.impl.OrdersImpl;
import com.chainsys.giftshop.model.OrdersPojo;
@WebServlet("/orders")
public class Ordersservlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	HttpSession session=req.getSession();
	  int userid = Integer.parseInt( session.getAttribute("logincustomer").toString());
	OrdersImpl oi=new OrdersImpl();
	OrdersPojo showord=new OrdersPojo();
showord.setUserid(userid);
	List<OrdersPojo> op=new ArrayList<OrdersPojo>();
	try {
		op = oi.userOrderDetails(showord);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("showorders", op);
	RequestDispatcher rd=req.getRequestDispatcher("gorders.jsp");
	rd.forward(req, resp);

}
	
}
