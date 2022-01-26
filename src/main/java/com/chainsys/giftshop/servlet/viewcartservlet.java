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
@WebServlet("/addcart")
public class viewcartservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String size=req.getParameter("sss");
		 System.out.println(size);
		 int qty=Integer.parseInt(req.getParameter("qqq"));
		 System.out.println(qty);
		 HttpSession session=req.getSession();
	      viewcartPojo vcar1=new viewcartPojo();
	    		  session.getAttribute("cart");
	    		  int userid = (int) session.getAttribute("logincustomer");
	       vcar1.setUserid(userid);
	      vcar1.setSize(size);
	      vcar1.setQuantity(qty);
	      System.out.println(userid);
	      viewCartImpl dao=new viewCartImpl();
	      viewcartPojo vcar=new viewcartPojo();
	      try {
				dao.insertcart1(vcar);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("cart.jsp");	
			
		}
	      
			/*
			 * viewCartImpl vci=new viewCartImpl(); try { viewcartPojo
			 * vcp=vci.insertview(vcar1); req.setAttribute("viewcart", vcp);
			 * RequestDispatcher rd=req.getRequestDispatcher("cart.jsp"); rd.forward(req,
			 * resp); } catch (ClassNotFoundException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); }
			 */
}
