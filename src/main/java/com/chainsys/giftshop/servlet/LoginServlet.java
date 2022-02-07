package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
		UserloginPojo userlogin=null;
		UserloginPojo ulp = new UserloginPojo(username, pwd);
		UserDaoImpl ui = new UserDaoImpl();
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		userlogin = ui.validateuser(ulp);
			session.setAttribute("logincustomer", userlogin.getUserid());
			if (userlogin.getRole().equals("admin")) {
				resp.sendRedirect("adminlogin.jsp");
			} else if (userlogin.getRole().equals("user")) {

				resp.sendRedirect("homepage.jsp");
			} else {

				throw new LoginException();

			}
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invlid MailId or Password');");
			out.println("location='login.jsp';");
			out.println("</script>");
		 
		}catch (LoginException | IOException e) {	
			e.printStackTrace();
			
		}
		

	}
}
