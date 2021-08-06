package com.younes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res ) throws ServletException, IOException{
		
		Students s=new Students(1,"younes");
		  
		req.setAttribute("students", s);
		RequestDispatcher rd=req.getRequestDispatcher("Display.jsp");
		rd.forward(req, res);
	}

}
