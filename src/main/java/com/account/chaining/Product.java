package com.account.chaining;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/prod")
public class Product extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productName = req.getParameter("pn");
		String quantity = req.getParameter("pq");
		String id=req.getParameter("id");
		
		//adding the data into request scope
		req.setAttribute("prodName",productName);
		req.setAttribute("prodQuant",quantity );
		req.setAttribute("prId", id);
		//servlet chaining
		RequestDispatcher dispatcher=req.getRequestDispatcher("cart");
		dispatcher.forward(req, resp);
		
		}
}
