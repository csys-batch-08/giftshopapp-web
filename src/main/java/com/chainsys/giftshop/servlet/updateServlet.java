package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.impl.ProductsDaoImpl;
import com.chainsys.giftshop.model.ProductPojo;

@WebServlet("/update")
public class updateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productid = Integer.parseInt(req.getParameter("productid"));
		double price = Double.parseDouble(req.getParameter("price"));
		int qunatity = Integer.parseInt(req.getParameter("quantity"));
		ProductPojo pr = new ProductPojo(productid, price, qunatity);
		ProductsDaoImpl product = new ProductsDaoImpl();
		try {
			product.update(pr);
			resp.sendRedirect("adminlogin.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
