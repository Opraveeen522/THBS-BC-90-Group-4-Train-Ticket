package com.thbs.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.thbs.jdbc_connections.DBConnection;

import java.sql.*;
@SuppressWarnings("serial")
public class AdminCancleTrain extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie ck[] = req.getCookies();
		if(ck!=null) {
			String uName = ck[0].getValue();
			String pWord = ck[1].getValue();
			if(!uName.equals("")||uName!=null) {
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("delete from trains where tr_no=?");
					ps.setLong(1,Long.parseLong(req.getParameter("trainno")));
					int k = ps.executeUpdate();
					if(k==1) {
						RequestDispatcher rd = req.getRequestDispatcher("CancleTrain.html");
						rd.include(req, res);
						pw.println("<div style='text-align:center; margin-top:3%; font-size:15px; font-weight:700;color:#00008B;' class='main'><p1 class='menu'>Train number "+req.getParameter("trainno")+" has been Cancelled Successfully.</p1></div>");
					}
					else {
						RequestDispatcher rd = req.getRequestDispatcher("CancleTrain.html");
						rd.include(req, res);
						pw.println("<div style='text-align:center; margin-top:3%; font-size:15px; font-weight:700;color:#00008B;' class='tab'><p1 class='menu'>Train No."+req.getParameter("trainno")+" is Not Available !</p1></div>");
					}
				}
				catch(Exception e) {}
				
			}
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
			rd.include(req, res);
			pw.println("<div style='text-align:center; margin-top:3%; font-size:15px; font-weight:700;color:#00008B;' class='tab'><p1 class='menu'>Please Login first !</p1></div>");
		}
	}

}
