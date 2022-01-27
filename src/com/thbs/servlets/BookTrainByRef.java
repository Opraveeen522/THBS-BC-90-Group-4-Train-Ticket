package com.thbs.servlets;
import java.io.*;
import java.time.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class BookTrainByRef extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		Cookie ck[] =req.getCookies();
		if(ck!=null) {
			String uName = ck[0].getValue();
			//String pWord = ck[1].getValue();
			
			if(!uName.equals("")||uName != null )
			{
				long trainNo =Long.parseLong(req.getParameter("trainNo"));
				int seat = 2;
				String fromStn = req.getParameter("fromStn");
				String toStn = req.getParameter("toStn");
				long fare =Long.parseLong(req.getParameter("fare"));
				long available =Long.parseLong(req.getParameter("available"));
				RequestDispatcher rd = req.getRequestDispatcher("UserViewTrains.html");
				rd.include(req, res);
				pw.println("<div style=text-align:center;color:skyblue; class='main'><p1 class='menu'>Your Ticket Booking Information</p1></div>");
				pw.println("<div class='tab'><form action='ticket.html' method='post'>"
						+ "<table class='center'>"
						+ "<tr><td>PNR: </td><td>"+"PNR_"+(int)Math.floor(Math.random()*10000000)+"_THBS"+"</td>"
						+ "<td>Train NO:</td><td>"+trainNo+"</td></tr>"
						+ "<td>Fare:</td><td>"+fare+"</td>"
						+ "<td>Availability:</td><td>"+available+" seats"+"</td></tr>"
						+ "<tr><td>From Station:</td><td>"+fromStn+"</td>"
						+ "<td>To Station :</td><td>"+toStn+"</tr>"
						+ "<tr><td>Journey Date:</td><td>"
						+ "<input type='hidden' name='trainnumber' value='"+trainNo+"'>"
						+ "<input type='date' name='journeydate' value='"+LocalDate.now()+"'</td>"
						+ "<td>No of Seats:</td><td><input type='number' name='seats' value='"+seat+"'</td></tr>"
						+ "<td>Passenger Details :</td>"
						+ "<td><div style=text-align:center; color:white; class='tab'><p1 class='menu'>Passenger Name: <input type='text' name='pname'</p1></div></td>"
						+ "<td><div style=text-align:center; color:white; class='tab'><p1 class='menu'>Age:    <input type='number' name='age'</p1></div></td>"
						+ "<td><div style=text-align:center; color:white; class='tab'><p1 class='menu'>Gender:     <input type='text' name='gender'</p1></div>"
						+ "</table></div>"
						+ "<div style='text-align:center; margin-top:2%; font-color:yellow;' class='tab'><p1  class='menu'><input type='submit'value='Proceed'></p1></div>"
						+ "</form>");

			}
		}
		else {
			RequestDispatcher rd =req.getRequestDispatcher("UserLogin.html");
			pw.println("<div style='text-align:center; margin-top:3%; font-size:15px; font-weight:700;color:#00008B;'  class='tab'><p1 class='menu'>Please Login First!</p1></div>");
		}
	}
}