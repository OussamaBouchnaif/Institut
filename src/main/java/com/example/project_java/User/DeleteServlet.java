package com.example.project_java.User;

import Services.UserService;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));

        UserService userService = new UserService();
        User user = userService.getUserById(userId);

        if (user != null) {
            // Delete the user
            userService.deleteUser(userId);

            // Redirect to list users page or another appropriate action
            response.sendRedirect("User/ListServlet");
        } else {
            // User not found, handle accordingly
            response.sendRedirect("listUser.jsp");
        }
    }
}
