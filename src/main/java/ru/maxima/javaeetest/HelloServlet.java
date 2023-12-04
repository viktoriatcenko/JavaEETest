package ru.maxima.javaeetest;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World from Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String surName = request.getParameter("surname");
        if (name == null) {
            name = "User";
        }

        if (surName == null) {
            surName = "User";
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Hello, " + name + " " + surName + "</h1>");
        out.println("</body></html>");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


//        response.sendRedirect("https://ru.wikipedia.org/wiki/JavaServer_Pages");
    }

    public void destroy() {
    }
}