package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.giftshop.exception.LoginException;
import com.chainsys.giftshop.impl.UserDaoImpl;
import com.chainsys.giftshop.model.UserloginPojo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		UserloginPojo ul = new UserloginPojo(username, pwd);
		UserDaoImpl ui = new UserDaoImpl();
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();

		ResultSet rs = null;
		
			rs = ui.validateuser1(ul);
			rs.next();
			session.setAttribute("logincustomer", rs.getInt(1));
			if (rs.getString(6).equals("admin")) {
				resp.sendRedirect("adminlogin.jsp");
			} else if (rs.getString(6).equals("user")) {

				resp.sendRedirect("homepage.jsp");
			} else {

				throw new LoginException();

			} 
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invlid MailId or Password');");
			out.println("location='login.jsp';");
			out.println("</script>");
		 
		}catch (ClassNotFoundException | SQLException | LoginException | IOException e) {	
			e.printStackTrace();
		}
		

	}
}
