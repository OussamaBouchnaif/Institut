package com.example.project_java.Paiement;

import Services.EtudiantService;
import Services.PaiementService;
import entity.Etudiant;
import entity.Factory;
import entity.Paiement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/listPaiement")
public class listServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(PaiementService.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PaiementService ps = Factory.get(PaiementService.class);
        List<Paiement> paiement = ps.getAllPaiement();

        req.setAttribute("paiement", paiement);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Paiement/listPaiement.jsp");
        dispatcher.forward(req, resp);
    }
}
