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

@WebServlet("/adminviewmobilecase")
public class adminviewmobilecaseservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductsDaoImpl pi = new ProductsDaoImpl();
		List<ProductPojo> pp = pi.adminviewmobilecase();
		req.setAttribute("adminviewmobilecase", pp);
		RequestDispatcher rd = req.getRequestDispatcher("adminviewmobilecase.jsp");
		rd.forward(req, resp);
	}
}
