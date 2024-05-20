package com.multi.servlet.d_redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do GET request handling here
        System.out.println("이 서블릿으로 redirect 성공!");

        System.out.println("getAttribute : "+ request.getAttribute("id"));
        System.out.println("getParameter :"+request.getParameter("id"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do POST request handling here
    }
}