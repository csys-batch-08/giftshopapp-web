package com.chainsys.giftshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.model.ViewCartPojo;

@WebServlet("/addtocart")
public class Addtocartservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			HttpSession session = req.getSession();
			int productid = Integer.parseInt(req.getParameter("pid"));
			String image = req.getParameter("image");
			String pname = req.getParameter("productName");
			String type = req.getParameter("type");
			Double price = Double.parseDouble(req.getParameter("cost"));
			int userid = Integer.parseInt(session.getAttribute("logincustomer").toString());
			ViewCartPojo vcart = new ViewCartPojo();
			vcart.setImage(image);
			vcart.setProductid(productid);
			session.setAttribute("pidd", productid);
			vcart.setProductname(pname);
			vcart.setType(type);
			vcart.setUserid(userid);
			vcart.setStandardcost(price);
			session.setAttribute("cartitems", vcart);
			RequestDispatcher rd = req.getRequestDispatcher("addcart.jsp");
			rd.forward(req, resp);
		} catch (NumberFormatException | ServletException | IOException e) {
			e.getMessage();
		}
	}
}
