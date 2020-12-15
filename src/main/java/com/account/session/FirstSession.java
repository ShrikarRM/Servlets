package com.account.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class FirstSession extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		String name = req.getParameter("nm");
		// getting ref of http session
		HttpSession hs = req.getSession();
		// setting the age of session
		hs.setMaxInactiveInterval(20000);
		// add session object into the scope
		hs.setAttribute("name", name);

		PrintWriter writer = resp.getWriter();
		writer.print("<form action='ss'>");
		writer.print("<input type='submit' value='NextServlet'>");
		writer.print("</form");
		writer.close();
	}
}
