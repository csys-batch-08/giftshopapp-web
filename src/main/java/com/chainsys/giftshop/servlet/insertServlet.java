package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.impl.ProductsDaoImpl;
import com.chainsys.giftshop.model.ProductPojo;

@WebServlet("/insert")
public class insertServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int productid = Integer.parseInt(req.getParameter("productid"));
		HttpSession session = req.getSession();
		session.setAttribute("productsid", productid);
		String productname = req.getParameter("productname");
		String description = req.getParameter("productdescription");
		double cost = Double.parseDouble(req.getParameter("productprice"));
		String category = req.getParameter("productcategory");
		int qunatity = Integer.parseInt(req.getParameter("productquantity"));
		String image = req.getParameter("image");
		String type = req.getParameter("type");
		ProductPojo pr = new ProductPojo(productid, productname, description, cost, category, qunatity, image, type);
		ProductsDaoImpl product = new ProductsDaoImpl();
		try {
			product.insert(pr);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('product inserted successfully');");
			out.println("location='adminlogin.jsp';");
			out.println("</script>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
