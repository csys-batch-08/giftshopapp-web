package com.chainsys.giftshop.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.ViewCartDaoImpl;
import com.chainsys.giftshop.model.ViewCartPojo;

@WebServlet("/editservlet")
public class Editcartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			
		HttpSession session = req.getSession();
		int userid = Integer.parseInt(session.getAttribute("logincustomer").toString());
		int productid = Integer.parseInt(req.getParameter("pid"));
		ViewCartPojo vcp = new ViewCartPojo();
		ViewCartPojo  vcpojo= new ViewCartPojo();
		vcp.setProductid(productid);
		vcp.setUserid(userid);
		ViewCartDaoImpl vci = new ViewCartDaoImpl();
			vcpojo = vci.editcart(vcp);
		session.setAttribute("cartitems", vcpojo);
		if (vcpojo.getSize().equals("ra")) {
			RequestDispatcher rd = req.getRequestDispatcher("addcartone.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("addcart.jsp");
			rd.forward(req, resp);
		}
		}catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}
}