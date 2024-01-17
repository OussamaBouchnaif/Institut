package com.example.project_java.Salle;
import Services.*;
import entity.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/addSalle")
public class AddServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(SalleService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Salle/addSalle.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomSalle = req.getParameter("nomSalle");
        int capacite = Integer.parseInt(req.getParameter("capacite"));

        if (nomSalle != null && capacite > 0) {
            SalleService salleService = Factory.get(SalleService.class);
            salleService.cerateSalle(capacite, nomSalle);
            resp.sendRedirect(req.getContextPath() + "/listSalle");
        } else {
            resp.sendRedirect(req.getContextPath() + "/addSalle");
        }
    }
}
