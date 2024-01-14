package com.example.project_java.Etudiant;


import Services.EtudiantService;
import Services.FormateurService;
import Services.NiveauService;
import entity.Etudiant;
import entity.Factory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="listEtudiant",value="/listEtudiant")
public class ListServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(EtudiantService.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EtudiantService esc = Factory.get(EtudiantService.class);
        List<Etudiant> etudiants = esc.getAllEtudiants();

        req.setAttribute("etudiants", etudiants);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Etudiant/listEtudiant.jsp");
        dispatcher.forward(req, resp);



    }
}
