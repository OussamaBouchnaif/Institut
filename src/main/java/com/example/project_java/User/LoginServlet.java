package com.example.project_java.User;

import Services.UserService;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        User user = userService.authenticateUser(email, password);

        if (user != null) {

            response.sendRedirect("index.jsp");
        } else {

            response.sendRedirect("Login.jsp?error=1");
        }
    }
}
