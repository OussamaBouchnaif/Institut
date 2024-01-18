package com.example.project_java.Groupe;

import Services.GroupeService;
import entity.Factory;
import entity.Groupe;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/addgroupe")
public class AddServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(GroupeService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Groupe/AddGroupe.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomGroupe = req.getParameter("nomGroupe");
        // Parse the date string to LocalDateTime
        LocalDateTime dateCreation = LocalDateTime.now(); // Assuming you want to use the current date and time

        if (nomGroupe != null) {
            GroupeService groupeService = Factory.get(GroupeService.class);
            groupeService.createGroupe(nomGroupe, dateCreation);
            resp.sendRedirect(req.getContextPath() + "/listEtudiant");
        } else {
            // Handle the case where the parameters are not valid
            resp.sendRedirect(req.getContextPath() + "/addgroupe");
        }
    }
}
