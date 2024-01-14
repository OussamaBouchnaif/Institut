package com.example.project_java.Paiement;

import Services.EtudiantService;
import Services.PaiementService;
import entity.Etudiant;
import entity.Factory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/paiementEtudiant")
public class PaiementServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(PaiementService.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        long id = Long.parseLong(idParam);

        EtudiantService etudiants = Factory.get(EtudiantService.class);
        Etudiant etudiant = etudiants.getEtudiantById(id);
        req.setAttribute("etudiant",etudiant);
        req.setAttribute("id",id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Paiement/paiement.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idE");
        long idE = Long.parseLong(id);
        float montant = Float.parseFloat(req.getParameter("montant")) ;
        String methode = req.getParameter("methode");
        if(montant > 0 && methode != "Sélectionnez une methode")
        {
            PaiementService ps = Factory.get(PaiementService.class);
            ps.createPaiement(idE,montant,methode);
            resp.sendRedirect(req.getContextPath() + "/listEtudiant");
        }
        else
        {
            resp.sendRedirect(req.getContextPath() + "/paiementEtudiant");
        }



    }
}
