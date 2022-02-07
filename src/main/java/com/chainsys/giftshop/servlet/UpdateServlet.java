package com.chainsys.giftshop.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.impl.ProductsDaoImpl;
import com.chainsys.giftshop.model.ProductPojo;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
		try {
			
		
		int productid = Integer.parseInt(req.getParameter("productid"));
		double price = Double.parseDouble(req.getParameter("price"));
		int qunatity = Integer.parseInt(req.getParameter("quantity"));
		ProductPojo pr = new ProductPojo(productid, price, qunatity);
		ProductsDaoImpl product = new ProductsDaoImpl();
		product.update(pr);
		resp.sendRedirect("adminlogin.jsp");
		}catch (NumberFormatException | IOException e) {	
			e.printStackTrace();
		}
	}

}
