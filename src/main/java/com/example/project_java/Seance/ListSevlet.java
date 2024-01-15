package com.example.project_java.Seance;

import Services.EtudiantService;
import Services.SeanceService;
import entity.Etudiant;
import entity.Factory;
import entity.Seance;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listSeance")
public class ListSevlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(SeanceService.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SeanceService sf = Factory.get(SeanceService.class);
        List<Seance> seances = sf.getAllSeance();

        req.setAttribute("seances", seances);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Seance/ListSeance.jsp");
        dispatcher.forward(req, resp);
    }


}

