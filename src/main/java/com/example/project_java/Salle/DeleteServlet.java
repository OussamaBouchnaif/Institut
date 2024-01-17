package com.example.project_java.Salle;

import entity.Factory;
import Services.SalleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deleteSalle")
public class DeleteServlet extends HttpServlet {

    private SalleService salleService;

    @Override
    public void init() throws ServletException {
        super.init();
        salleService = Factory.get(SalleService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long salleId = Long.valueOf(req.getParameter("id"));

        if (salleId != null) {
            salleService.deleteSalle(salleId);
            resp.sendRedirect(req.getContextPath() + "/listSalle");
        } else {
            // Handle the case where the parameter is not valid
            resp.sendRedirect(req.getContextPath() + "/listSalle?errorMessage=Invalid parameters");
        }
    }
}
