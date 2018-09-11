/*
Create a table of the cookies associated with the suitable home page. 
If there are no active cookies display as stating “No Cookies” 
otherwise display cookie name and value in a tabular format
 */

package com.w3epic.wiprotraining.assignment2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Assignment2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			out.println("<h1>List of cookies</h1>");
			out.println("<table border='1'>");
			for (int i = 0; i < cookies.length; i++) {
				out.println("<tr>");
				out.println("<td>" + cookies[i].getName() + "</td>");
				out.println("<td>" + cookies[i].getValue() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} else {
			out.println("No Cookies");
		}
		
		out.close();
	}
}
