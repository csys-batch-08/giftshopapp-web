package com.chainsys.giftshop.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.ProductsDaoImpl;
import com.chainsys.giftshop.model.ProductPojo;

public class ShowProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int productid = Integer.parseInt(req.getParameter("productid"));
			String productname = req.getParameter("productname");
			String description = req.getParameter("productdescription");
			double cost = Double.parseDouble(req.getParameter("productprice"));
			String category = req.getParameter("productcategory");
			int quantity = Integer.parseInt(req.getParameter("productquantity"));
			String image = req.getParameter("image");
			ProductPojo product = new ProductPojo(productid, productname, description, cost, category, quantity, image);
			ProductsDaoImpl pr = new ProductsDaoImpl();
			pr.adminShowProduct();
			resp.sendRedirect("adminlogin.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("productname", product);
		}catch (NumberFormatException  | IOException e) {	
			e.printStackTrace();
		}
		
	}
}
