package com.rs.jsr94.jeasy.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        if (isSuspicious(request)) {
            out.print("Access denied");
        } else {
            out.print("Welcome!");
        }
    }
    
    private boolean isSuspicious(HttpServletRequest request) {
        return request.getAttribute(SuspiciousRequestRule.SUSPICIOUS) != null;
    }
}