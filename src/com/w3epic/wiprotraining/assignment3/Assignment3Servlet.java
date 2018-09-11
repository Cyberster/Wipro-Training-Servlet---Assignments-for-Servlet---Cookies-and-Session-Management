/*
Create a Servlet that uses session tracking to keep per-client access counts. 
Also show other generic- info about the session.
 */

package com.w3epic.wiprotraining.assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Assignment3Servlet extends HttpServlet {	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
		
		if (session.isNew())
			session.setAttribute("visitCount", 1);
		else {
			int count = (int) session.getAttribute("visitCount");
			session.setAttribute("visitCount", count + 1);
		}
		
		out.println("<h1>Session information</h1>");
		out.println("<table border='1'>");
		
			out.println("<tr>");
				out.println("<td>" + "Session ID" + "</td>");
				out.println("<td>" + session.getId() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
				String creationTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(session.getCreationTime());
				out.println("<td>" + "Creation Time" + "</td>");
				out.println("<td>" + creationTime + "</td>");
			out.println("</tr>");

			out.println("<tr>");
				String lastAccessTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(session.getLastAccessedTime());
				out.println("<td>" + "Time of Last Access" + "</td>");
				out.println("<td>" + lastAccessTime + "</td>");
			out.println("</tr>");

			out.println("<tr>");
				out.println("<td>" + "Visit Count" + "</td>");
				out.println("<td>" + session.getAttribute("visitCount") + "</td>");
			out.println("</tr>");
			
		out.println("</table>");
		
		out.close();
	}
}
