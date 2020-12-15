package com.account.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ss")
public class SecondSession extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		String name = (String) hs.getAttribute("nam");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("Second servlet session obj " + name + " " + hs.getId());
		printWriter.close();
	}
}
