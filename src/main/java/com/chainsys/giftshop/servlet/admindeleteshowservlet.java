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

@WebServlet("/delete")
public class admindeleteshowservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductsDaoImpl pi = new ProductsDaoImpl();
		List<ProductPojo> pp = pi.adminShowdelete();
		req.setAttribute("deleteproduct", pp);
		RequestDispatcher rd = req.getRequestDispatcher("admindeleteproduct.jsp");
		rd.forward(req, resp);
	}
}