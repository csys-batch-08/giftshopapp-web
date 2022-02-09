package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.exception.LoginException;
import com.chainsys.giftshop.impl.UserDaoImpl;
import com.chainsys.giftshop.model.UserPojo;

@WebServlet("/reg")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		UserDaoImpl ui = new UserDaoImpl();
		PrintWriter out;
		try {
			out = resp.getWriter();
			String username = req.getParameter("username");
			Long phone = Long.parseLong(req.getParameter("phone"));
			String address = req.getParameter("address");
			String password = req.getParameter("password");
			UserPojo user1 = new UserPojo(0, null, null, phone, null);
			UserPojo usednum;
			try {
				usednum = ui.validateUserNum(user1);
				if (usednum != null) {
					throw new LoginException();

				}
				String email = req.getParameter("email");
				UserPojo user2 = new UserPojo(0, null, email, null, null);
				UserPojo usedmail;
				try {
					usedmail = ui.validateUsermail(user2);
					if (usedmail != null) {
						throw new LoginException();

					}
					UserPojo user = new UserPojo(username, password, email, phone, address);
					boolean flag = ui.insert(user);
					if (flag) {
						resp.sendRedirect("login.jsp");
					}
				} catch (LoginException e) {

					out.println("<script type=\"text/javascript\">");
					out.println("alert('mailid already registered');");
					out.println("location='registration.jsp';");
					out.println("</script>");
				}
			} catch (LoginException e) {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Mobile number already registered');");
				out.println("location='registration.jsp';");
				out.println("</script>");
			}
		} catch (IOException | NumberFormatException e1) {
			e1.getMessage();
		}

	}

}
