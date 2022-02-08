package com.chainsys.giftshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.ViewCartDaoImpl;
import com.chainsys.giftshop.model.ViewCartPojo;

@WebServlet("/viewcart")
public class Viewcartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int flag = 0;
			HttpSession session = req.getSession();
			ViewCartPojo vcart = (ViewCartPojo) session.getAttribute("cartitems");
			ViewCartDaoImpl dao = new ViewCartDaoImpl();
			int productid = vcart.getProductid();
			String image = vcart.getImage();
			String productname = vcart.getProductname();
			String type = vcart.getType();
			Double standardcost = vcart.getStandardcost();
			String size = req.getParameter("size");
			if (size == null) {
				size = "ra";
			}
			int qty = Integer.parseInt(req.getParameter("qty"));
			ViewCartPojo vcart1 = new ViewCartPojo();
			int userid = (int) session.getAttribute("logincustomer");

			vcart1.setUserid(userid);
			vcart1.setProductid(productid);
			vcart1.setSize(size);
			flag = dao.duplicatecart(vcart1);
			if (flag > 0) {
				ViewCartPojo vcar = new ViewCartPojo(image, productname, type, standardcost, size, qty, userid,
						productid);
				dao.updatecart(vcar);
				resp.sendRedirect("cart");
			} else {
				ViewCartPojo vcar = new ViewCartPojo(image, productname, type, standardcost, size, qty, userid,
						productid);
				dao.insertview(vcar);
				resp.sendRedirect("cart");
			}
		} catch (NumberFormatException | IOException e) {
			e.getMessage();
		}
	}
}
