package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.exception.LoginException;
import com.chainsys.giftshop.impl.ProductsImpl;
import com.chainsys.giftshop.model.ProductPojo;

@WebServlet("/insert")
public class insertServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		int productid = Integer.parseInt(req.getParameter("productid"));
		String productname = req.getParameter("productname");
		String description = req.getParameter("productdescription");
		double cost = Double.parseDouble(req.getParameter("productprice"));
		String category = req.getParameter("productcategory");
		int qunatity = Integer.parseInt(req.getParameter("productquantity"));
		String image = req.getParameter("image");
		String type = req.getParameter("type");
		ProductPojo pr = new ProductPojo(productid, productname, description, cost, category, qunatity, image, type);
		ProductsImpl product = new ProductsImpl();
		try {
			product.insert(pr);
			resp.sendRedirect("adminlogin.jsp");
		} catch (ClassNotFoundException | SQLException e) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invlid MailId or Password');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}

	}

}
