package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.impl.ProductsDaoImpl;
import com.chainsys.giftshop.model.ProductPojo;

@WebServlet("/search")
public class Searchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		String productName = req.getParameter("proname");
		ProductsDaoImpl pr = new ProductsDaoImpl();
		List<ProductPojo> pp = pr.serachProduct(productName);
		req.setAttribute("usershow", pp);
		RequestDispatcher rd = req.getRequestDispatcher("userallproducts.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.getMessage();
		}
	}
}
