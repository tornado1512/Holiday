package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import models.*;
import java.util.ArrayList;

public class GetRestServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	HttpSession session = request.getSession();
	String nextPage="allRest.jsp";
	
	/*Integer city_id=request.getParameter("ct_id");
	ArrayList<RestRegister> rests=RestRegister.collectRest(city_id);
	
	request.setAttribute("rests",rests);*/
	request.getRequestDispatcher(nextPage).forward(request,response);	
	}
	
}