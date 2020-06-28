package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ShowAddMenuServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Integer ownerId=(Integer)session.getAttribute("ownerId");
		System.out.println(ownerId+"insam11111111111111");
		//System.out.println(request.getQueryString());
		request.getRequestDispatcher("add_menu.jsp").forward(request,response);
	}
}