package com.multi.el.controller;

import com.multi.el.model.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/test2")
public class TestTwoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = new MemberDTO("홍길동", 20, "010-1234-5678", "hong@uni.com");
		
		request.setAttribute("member", member);
		
		RequestDispatcher view = request.getRequestDispatcher("views/el/testEl2.jsp");
		view.forward(request, response);
		
	}

}
