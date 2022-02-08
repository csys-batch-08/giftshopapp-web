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

@WebServlet("/womenswatch")
public class Womenswatchservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		ProductsDaoImpl pi = new ProductsDaoImpl();
		List<ProductPojo> pp = pi.viewwomenswatch();
		req.setAttribute("womenswatch", pp);
		RequestDispatcher rd = req.getRequestDispatcher("womenswatch.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.getMessage();
		}
	}
}
