package com.example.project_java.User;

import Services.SeanceService;
import Services.UserService;
import entity.Factory;
import entity.Seance;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listUsers")
public class ListServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve and display the list of users
        UserService userService = Factory.get(UserService.class);
        List<User> users = userService.getAllUsers();

        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/ListUsers.jsp");
        dispatcher.forward(req, resp);
    }
}


