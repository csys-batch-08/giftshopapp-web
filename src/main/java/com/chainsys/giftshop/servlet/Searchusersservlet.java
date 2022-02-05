package com.chainsys.giftshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.giftshop.impl.UserDaoImpl;
import com.chainsys.giftshop.model.UserPojo;

@WebServlet("/searchuser")
public class Searchusersservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchusers = req.getParameter("users");
		UserDaoImpl ui = new UserDaoImpl();
		List<UserPojo> up = ui.serachusers(searchusers);
		req.setAttribute("users", up);
		RequestDispatcher rd = req.getRequestDispatcher("showusers.jsp");
		rd.forward(req, resp);
	}
}