package com.thbs.servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.thbs.jdbc_connections.DBConnection;
public class Passenger_Details extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into passenger values(?,?,?,?)");
			ps.setString(1, req.getParameter("pname"));
			ps.setString(2, req.getParameter("age"));
			ps.setString(3, req.getParameter("gender"));
			ps.setString(4, req.getParameter("traveldate"));
			int k = ps.executeUpdate();
			if(k==1) {
				RequestDispatcher rd = req.getRequestDispatcher("Passenger.html");
				rd.include(req, res);
				pw.println("<div class='tab'><p1 class='menu'>Details Entered Successfully !</p1></div>");
			}
			
		}
		catch(Exception e) {}
	}

}