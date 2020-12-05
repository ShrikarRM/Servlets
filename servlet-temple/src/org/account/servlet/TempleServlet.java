package org.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TempleServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String name = config.getInitParameter("Name");
		String age = config.getInitParameter("Age");

		PrintWriter writer = resp.getWriter();
		writer.print(name + " " + age);
	}

	@Override
	public void init() throws ServletException {
		//super.init(config);
		System.out.println("Initializing the resources");

	}

}
