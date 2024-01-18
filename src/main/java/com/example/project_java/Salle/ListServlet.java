package com.example.project_java.Salle;

import entity.Factory;
import entity.Salle;
import Services.SalleService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listSalle")
public class ListServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(SalleService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SalleService salleService = Factory.get(SalleService.class);
        List<Salle> salles = salleService.getAllSalle();

        req.setAttribute("salles", salles);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Salle/ListSalle.jsp");
        dispatcher.forward(req, resp);
    }
}
