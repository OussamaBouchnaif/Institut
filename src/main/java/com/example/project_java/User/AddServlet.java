package com.example.project_java.User;

import Services.UserService;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        User newUser = new User(name, "", "", "", email, password);
        userService.createUser(newUser);

        // Redirect to a success page or another appropriate action
        response.sendRedirect("head.jsp");
    }
}
