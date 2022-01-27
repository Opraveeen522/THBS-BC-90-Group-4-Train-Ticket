package com.thbs.servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.thbs.jdbc_connections.DBConnection;
@SuppressWarnings("serial")
public class AdminTrainUpdate extends HttpServlet{
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
						long trNo = Long.parseLong(req.getParameter("trainnumber"));
						PreparedStatement ps = con.prepareStatement("select * from trains where tr_no=?");
						ps.setLong(1, trNo);
						ResultSet rs = ps.executeQuery();
						if(rs.next()) {
						RequestDispatcher rd = req.getRequestDispatcher("AdminHome.html");
						rd.include(req, res);
						pw.println("<div  style='text-align:center; margin-top:3%; font-size:20px; font-weight:700;color:#00008B;'class='tab'>Train Schedule Update</div>");
						pw.println("<div  style='text-align:center; margin-top:1%; font-size:15px; font-weight:700;color:#00008B;class='tab'>"
								+ "<table  border=2 align=center cellpadding=1><form action='updatetrainschedule' method='post'>"
								+ "<tr style='color:orange;'><td>Train No :</td><td><input type='text' name='trainno' value='"+rs.getLong("tr_no")+"'></td></tr>"
								+ "<tr style='color:orange;'><td>Train Name :</td><td><input type='text' name='trainname' value='"+rs.getString("tr_name")+"'></td></tr>"
								+ "<tr style='color:orange;'><td>From Station :</td><td><input type='text' name='fromstation' value='"+rs.getString("from_stn")+"'></td></tr>"
								+ "<tr style='color:orange;'><td>To Station :</td><td><input type='text' name='tostation' value='"+rs.getString("to_stn")+"'></td></tr>"
								+ "<tr style='color:orange;'><td>Available seats:</td><td><input type='text' name='available' value='"+rs.getLong("available")+"'></td></tr>"
								+ "<tr style='color:orange;'><td>Fare (INR) :</td><td><input type='text' name='fare' value='"+rs.getLong("fare")+"'></td></tr>"
								+ "<tr style='color:blue;'><td></td><td><input type='submit' name='submit' value='Update Train Schedule'></td></tr>"
								+ "</form></table>"
								+ "</div>");
						}
						else {
							RequestDispatcher rd = req.getRequestDispatcher("AdminUpdateTrain.html");
							rd.include(req, res);
							pw.println("<div style='text-align:center; margin-top:3%; font-size:15px; font-weight:700;color:#00008B;'  class='tab'>Train Not Available</div>");
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
