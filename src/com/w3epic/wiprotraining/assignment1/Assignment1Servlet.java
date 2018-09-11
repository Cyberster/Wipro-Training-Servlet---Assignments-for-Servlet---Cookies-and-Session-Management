/*
Create a Servlet that recognizes first time visitor to web application 
and responds by saying "Welcome to new user" otherwise “welcome back”
 */

package com.w3epic.wiprotraining.assignment1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Assignment1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("testCookie")) {
					out.println("Welcome back");
					break;
				}		
			}
			//out.println("Welcome back");
		} else {
			Cookie testCookie = new Cookie("testCookie", "cookieValue");
			resp.addCookie(testCookie);
			out.println("Welcome to new user");
		}
		
		out.close();
	}
}
