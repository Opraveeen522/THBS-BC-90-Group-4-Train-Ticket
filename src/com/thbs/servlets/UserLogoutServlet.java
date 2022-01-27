package com.thbs.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.thbs.bean_classes.UserBean;
@SuppressWarnings("serial")
public class UserLogoutServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie ck[] = req.getCookies();
		if(ck!=null) {
			
			Cookie ck1 = new Cookie("ckname","");
			ck1.setMaxAge(0);
			res.addCookie(ck1);
			Cookie ck2 = new Cookie("ckpwd","");
			ck2.setMaxAge(0);
			res.addCookie(ck2);
			ServletContext sct = req.getServletContext();
			UserBean ub = (UserBean)sct.getAttribute("ubean");
			ub.setGender("");
			ub.setFname("");
			ub.setAge("");
			ub.setMailid("");
			ub.setPhno(0);
			ub.setPword("");
			ub.setUname("");
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
			pw.println("<div class='tab'><p1 class='menu'>You have been successfully logged out !</p1></div>");
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
			
			pw.println("<div class='tab'><p1 class='menu'>You are Already Logged Out !</p1></div>");
		}
	}
}
