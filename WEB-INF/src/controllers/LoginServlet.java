package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import models.*;


 public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	HttpSession session = request.getSession();
	String nextPage="";
	String logType=request.getParameter("logType");
	
	if(logType.equals("owner")){
		//String oname = request.getParameter("oname");
		System.out.println(logType);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email+password);
		RegisterOwner owner=new RegisterOwner(email,password);
		if(owner.checkLogin()){
			nextPage="my_rest_home.jsp";
			System.out.println(nextPage);
		}
		else{
		nextPage="login.jsp";
		request.setAttribute("message","Invalid email or password");
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
		String ownerName=owner.getOwnerName();
		session.setAttribute("ownername",ownerName);
		System.out.println(ownerName+"inside ols");
		request.getRequestDispatcher(nextPage).forward(request,response);

	}
	else{
		//String oname = request.getParameter("oname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user=new User(email,password);
		if(user.checkLogin()){
			nextPage="index.jsp";
		}
		else{
		nextPage="login.jsp";
		request.setAttribute("message","Invalid email or password");
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
		String userName=user.getUserName();
		session.setAttribute("userName",userName);
		System.out.println(userName+"inside ols");
		request.getRequestDispatcher(nextPage).forward(request,response);
		
	}
	
	}
}