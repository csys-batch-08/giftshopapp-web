package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.impl.ProductsDaoImpl;
import com.chainsys.giftshop.model.ProductPojo;

@WebServlet("/delproduct")
public class Deleteservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int productid = Integer.parseInt(req.getParameter("pid"));
		ProductPojo pr = new ProductPojo(productid);
		ProductsDaoImpl product = new ProductsDaoImpl();
		try {
			product.delete(pr);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Product deleted successfully');");
			out.println("location='adminlogin.jsp';");
			out.println("</script>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}