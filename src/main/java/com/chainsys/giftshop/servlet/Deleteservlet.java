package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.impl.ProductsDaoImpl;
import com.chainsys.giftshop.model.ProductPojo;

@WebServlet("/delproduct")
public class Deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			PrintWriter out = resp.getWriter();
			int productid = Integer.parseInt(req.getParameter("pid"));
			ProductPojo pr = new ProductPojo(productid);
			ProductsDaoImpl product = new ProductsDaoImpl();
			product.delete(pr);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Product deleted successfully');");
			out.println("location='adminlogin.jsp';");
			out.println("</script>");
		} catch (NumberFormatException | IOException e) {
			e.getMessage();
		}

	}
}