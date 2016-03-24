package com.ferraborghini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ferraborghini.servlet.base.BaseServlet;

@WebServlet(urlPatterns = "/note/test.jsp")
public class TestServlet extends BaseServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");		
		response.getWriter().println("¹§Ï²Äú£¬¾º¼Û³É¹¦!");

	}
}
