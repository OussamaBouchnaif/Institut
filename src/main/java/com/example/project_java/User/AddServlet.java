package com.example.project_java.User;

import Services.*;
import entity.Factory;
import entity.Formateur;
import entity.Groupe;
import entity.Salle;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
@WebServlet("/addUser")
public class AddServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Populate any necessary data for the user creation form
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/addUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve user input from the form
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String numeroTelephone = req.getParameter("numeroTelephone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Validate and create the user
        if (nom != null && prenom != null && adresse != null && numeroTelephone != null && email != null && password != null) {
            UserService userService = Factory.get(UserService.class);
            userService.createUser(nom, prenom, adresse, numeroTelephone, email, password);
            resp.sendRedirect(req.getContextPath() + "/listUsers");
        } else {
            resp.sendRedirect(req.getContextPath() + "/addUser");
        }
    }
}

