package com.account.chaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.account.chaining.dao.ProductDAO;
import com.account.chaining.dao.ProductDAOImpl;
import com.account.chaining.dto.ProductDTO;
@WebServlet("/cart")
public class Cart extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//getting data from request scope
	String prName=(String) req.getAttribute("prodName");
	String prQuant=(String) req.getAttribute("prodQuant");
	String prodId=(String) req.getAttribute("prId");
	
	int quantity=Integer.parseInt(prQuant);
	double price=18000.00;
	double totalSum=(quantity*price);
	
	PrintWriter writer=resp.getWriter();
	writer.println("Product details="+prName+" Price="+totalSum);
	writer.close();
	
	ProductDTO dto=new ProductDTO();
	dto.setId(2);
	dto.setName(prName);
	dto.setQuantity(quantity);
	dto.setTotalSum(totalSum);

	ProductDAO dao=new ProductDAOImpl();
	dao.saveProductDetails(dto);
	}
}
