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
import com.chainsys.giftshop.impl.UserDaoImpl;
import com.chainsys.giftshop.model.UserPojo;

@WebServlet("/reg")
public class registerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDaoImpl ui = new UserDaoImpl();
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		Long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String Password = req.getParameter("password");
		UserPojo user1 = new UserPojo(0, null, null, phone, null);
		UserPojo usednum;
		try {
			usednum = ui.validateUserNum(user1);
			if (usednum == null) {
				String email = req.getParameter("email");
				UserPojo user2 = new UserPojo(0, null, email, null, null);
				UserPojo usedmail;
				try {
					usedmail = ui.validateUsermail(user2);
					if (usedmail == null) {
						UserPojo user = new UserPojo(username, Password, email, phone, address);
						boolean flag = ui.insert(user);
						if (flag == true) {
							resp.sendRedirect("login.jsp");
						}
					} else {
						throw new LoginException();

					}
				} catch (ClassNotFoundException | SQLException | LoginException e) {

					out.println("<script type=\"text/javascript\">");
					out.println("alert('mailid already registered');");
					out.println("location='registration.jsp';");
					out.println("</script>");
				}
			} else {
				throw new LoginException();

			}
		} catch (LoginException e) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Mobile number already registered');");
			out.println("location='registration.jsp';");
			out.println("</script>");
		}
	}

}
