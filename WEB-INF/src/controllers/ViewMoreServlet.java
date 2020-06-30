package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import models.*;

public class ViewMoreServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("rest_id"));
		/*Integer restId=request.getParameter("rest_id");
		System.out.println(restId);
		RestRegister rr = new RestRegister();
		RestRegister records=rr.collectRest3(restId);
		session.setAttribute("records",records);
		
		request.getRequestDispatcher("add_menu.jsp").forward(request,response);*/
	}
}