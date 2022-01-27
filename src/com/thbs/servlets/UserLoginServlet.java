package com.thbs.servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.thbs.bean_classes.UserBean;
import com.thbs.jdbc_connections.DBConnection;
@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		try {
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("select * from register where uname=? and pword=?");
			
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				UserBean ub = new UserBean();
				ub.setUname(rs.getString("uname"));
				ub.setPword(rs.getString("pword"));
				ub.setFname(rs.getString("fname"));
				ub.setAge(rs.getString("age"));
				ub.setGender(rs.getString("gender"));
				ub.setPhno(Long.parseLong(rs.getString("phno")));
				ub.setMailid(rs.getString("mailid"));
			
				Cookie ck1 = new Cookie("ckname",uName);
				res.addCookie(ck1);
				Cookie ck2 = new Cookie("ckpwd",pWord);
				res.addCookie(ck2);
				ServletContext sct = req.getServletContext();
				sct.setAttribute("ubean", ub);
					RequestDispatcher rd = req.getRequestDispatcher("UserHome.html");				
					rd.include(req, res);
					pw.println("<div style=text-align:center;color:white; class='main'><p1 class='menu'>Hello "+uName+" ! Welcome to Torry's World</p1></div>");
					
					PreparedStatement ps2 = preparedStatement("select * from userphoto where uname=?");
					ps2.setString(1, uName);
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next())
					{
						
					}   
			    
				}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
				rd.include(req, res);
				
				pw.println("<div class='tab'><p1 class='menu'>Invalid Uname Or Pa$$ !</p1></div>");

			}
	    
		}
		catch(Exception e) {}
	}

	private PreparedStatement preparedStatement(String string) {
		return null;
	}
}
