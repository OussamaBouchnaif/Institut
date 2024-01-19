package com.example.project_java.User;

import Services.UserService;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("userId"));
        String newName = request.getParameter("newName");
        String newEmail = request.getParameter("newEmail");
        String newPassword = request.getParameter("newPassword");

        UserService userService = new UserService();
        User user = userService.getUserById(userId);

        if (user != null) {
            // Update user details
            user.setNom(newName);
            user.setEmail(newEmail);
            user.setPassword(newPassword);

            userService.updateUser(user);

            // Redirect to list users page or another appropriate action
            response.sendRedirect("ListUsersServlet");
        } else {
            // User not found, handle accordingly
            response.sendRedirect("ErrorPage.jsp");
        }
    }
}
