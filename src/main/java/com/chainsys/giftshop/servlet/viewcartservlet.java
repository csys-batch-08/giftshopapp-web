package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.viewCartImpl;
import com.chainsys.giftshop.model.viewcartPojo;

@WebServlet("/viewcart")
public class viewcartservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        int flag=0;
		HttpSession session = req.getSession();
		viewcartPojo vcart = (viewcartPojo) session.getAttribute("cartitems");
		viewCartImpl dao = new viewCartImpl();
		int productid = vcart.getProductid();
		String image = vcart.getImage();
		String productname = vcart.getProductname();
		String type = vcart.getType();
		Double standardcost = vcart.getStandardcost();
		String size = req.getParameter("sss");
          if(size==null) {
			size="ra";
		  }
		int qty = Integer.parseInt(req.getParameter("qqq"));
		viewcartPojo vcart1 = new viewcartPojo();
		int userid = (int) session.getAttribute("logincustomer");
		
		vcart1.setUserid(userid);
		vcart1.setProductid(productid);
		vcart1.setSize(size);
		try {
		     flag=dao.duplicatecart(vcart1);
			System.out.println(flag);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}if(flag>0){
			int sum= flag+qty;
			viewcartPojo vcar = new viewcartPojo(image, productname, type, standardcost, size, sum, userid, productid);
			try {
				dao.updatecart(vcar);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("cart");	
		}
		else {
		viewcartPojo vcar = new viewcartPojo(image, productname, type, standardcost, size, qty, userid, productid);
		try {
			dao.insertview(vcar);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("cart");
	}}
}
