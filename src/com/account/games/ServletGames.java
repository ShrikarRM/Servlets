package com.account.games;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.security.Init;

public class ServletGames extends HttpServlet {
	public ServletGames() {
		System.out.println("Default constructor");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		System.out.println("Processing client request");
		String name = req.getParameter("nm");
		String type = req.getParameter("tg");
		String noOfPlayers = req.getParameter("np");

		PrintWriter printWriter = resp.getWriter();
		//resp.setContentType("text/html");
		printWriter.print("Thank you for choosing " +name+ " as game");
		
		String url=("jdbc:mysql://localhost:3306?user=root&password=root");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement
			=connection.prepareStatement("insert into jdbc.gaming values(?,?,?)");
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,type);
			preparedStatement.setInt(3,Integer.parseInt(noOfPlayers));
			preparedStatement.execute();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
	}
	//not mandatory that init() must be before service()
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Initializing the resources");
	}
	
	@Override
	public void destroy() {
		System.out.println("closing resources");
		super.destroy();
	}

}
