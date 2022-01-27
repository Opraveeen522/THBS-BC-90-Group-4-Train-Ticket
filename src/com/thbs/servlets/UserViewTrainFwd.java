package com.thbs.servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.thbs.jdbc_connections.DBConnection;
@SuppressWarnings("serial")
public class UserViewTrainFwd extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie ck[] = req.getCookies();
		if(ck!=null) {
			String uName = ck[0].getValue();
			if(!uName.equals("")||uName!=null) {
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from trains");
					ResultSet rs = ps.executeQuery();
					if(rs.next()) 
					{
						RequestDispatcher rd = req.getRequestDispatcher("UserViewTrains.html");
						rd.include(req, res);
						pw.println("<div style=text-align:center;color:white; class='tab'>" + 
								"		<p1 class='menu'>" + 
								"	Hello User Book Your Favorite Journey" + 
								"		</p1>" + 
								"	</div>");
						pw.println("<div style=text-align:center;color:orange; class='main'><p1 class='menu'>!!! Currently Running Trains !!!</p1></div>");
						pw.println("<div class='tab'><table><tr><th>Train Name</th><th>Train Number</th>"
								+ "<th>From Station</th><th>To Station</th><th>Seats</th><th>Fare (INR)</th><th>Booking</th></tr>");
						
						long trainNo;
						String fromStn;
						String toStn;
						long fare;
						long available;
						do {
							 trainNo = rs.getLong("tr_no");
							 fromStn = rs.getString("from_stn");
							 toStn = rs.getString("to_stn");
							 available = rs.getLong("available");
							 fare = rs.getLong("fare");
							 
								pw.println(""
										+ "<table style=color:yellow;text-align:center; class='center'>"
										+ "<tr> "
										+ "<td><a href='view?trainNo="+trainNo+"&fromStn="+fromStn+"&toStn="+toStn+"'>"+rs.getString("tr_name")+"</a></td>"
										+ "<td>"+trainNo+"</td>"
										+ "<td>"+fromStn+"</td>"
										+ "<td>"+toStn+"</td>"
									    + "<td>"+rs.getLong("available")+"</td>"
										+ "<td>"+rs.getLong("fare")+" RS</td>"
										+ "<td><a href='booktrainbyref?trainNo="+trainNo+"&fromStn="+fromStn+"&toStn="+toStn+"&available="+available+"&fare="+fare+"'><div class='red'>Book Now</div></a></td></tr>"
							);
						}while(rs.next());
						pw.println("</table></div>");
					}
					else {
						RequestDispatcher rd = req.getRequestDispatcher("UserViewTrains.html");
						rd.include(req, res);
						pw.println("<div style=color:white; class='main'><p1 class='menu red'> No Running Trains</p1></div>");
					}
				}
				catch(Exception e) {}
			}
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
			pw.println("<div class='tab'><p1 class='menu'>Please Login first !</p1></div>");
		}
	}

}
