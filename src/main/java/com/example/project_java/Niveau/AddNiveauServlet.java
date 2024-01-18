package com.example.project_java.Niveau;

import Services.NiveauService;
import entity.Factory;
import entity.Niveau;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/addNiveau")
public class AddNiveauServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(NiveauService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Niveau/AddNiveau.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomNiveau = req.getParameter("nomNiveau");
        // Parse the date string to LocalDateTime
        LocalDateTime dateCreation = LocalDateTime.now(); // Assuming you want to use the current date and time

        if (nomNiveau != null) {
            NiveauService niveauService = Factory.get(NiveauService.class);
            niveauService.createNiveau(nomNiveau, dateCreation);
            resp.sendRedirect(req.getContextPath() + "/listEtudiant"); // Redirige vers la page AddEtudiant.jsp
        } else {
            // Handle the case where the parameters are not valid
            resp.sendRedirect(req.getContextPath() + "/addNiveau");
        }
    }
}
