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
		
		HttpSession session=req.getSession();
		viewcartPojo vcart = (viewcartPojo) session.getAttribute("cartitmes");
		  int productid = vcart.getProductid();
		  String image = vcart.getImage(); 
		  String productname = vcart.getProductname();
		  String type =vcart.getType(); 
		  Double standardcost =vcart.getStandardcost();
		 String size=req.getParameter("sss");
		 System.out.println(size);
		 int qty=Integer.parseInt(req.getParameter("qqq"));
		 System.out.println(qty);
		 
	      viewcartPojo vcar1=new viewcartPojo();
	    		  int userid = (int) session.getAttribute("logincustomer");
	       vcar1.setUserid(userid);
	      vcar1.setSize(size);
	      vcar1.setQuantity(qty);
	      viewcartPojo vcar=new viewcartPojo(image,productname,type,standardcost,size,qty,userid,productid);
	      viewCartImpl dao=new viewCartImpl();
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
			/* RequestDispatcher rd=req.getRequestDispatcher("cart"); */
			/* rd.forward(req,resp); */
			
		}
}
