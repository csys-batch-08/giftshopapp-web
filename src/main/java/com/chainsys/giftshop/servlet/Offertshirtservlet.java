package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.impl.ProductsImpl;
import com.chainsys.giftshop.model.ProductPojo;
@WebServlet("/offertshirt")
public class Offertshirtservlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	ProductsImpl pi=new ProductsImpl();
	List<ProductPojo>pp=pi.offertshirt();
	req.setAttribute("offertshirt", pp);
	RequestDispatcher rd=req.getRequestDispatcher("offertshirt.jsp");
	rd.forward(req, resp);
}
}
