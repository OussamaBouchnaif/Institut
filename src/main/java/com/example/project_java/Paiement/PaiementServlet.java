package com.example.project_java.Paiement;

import Services.EtudiantService;
import Services.PaiementService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/paiementEtudiant")
public class PaiementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        long id = Long.parseLong(idParam);
        resp.sendRedirect("Paiement/paiement.jsp?id="+id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idE");
        long idE = Long.parseLong(id);
        float montant = Float.parseFloat(req.getParameter("montant")) ;
        String methode = req.getParameter("methode");
        if(montant > 0 && methode != "Sélectionnez une methode")
        {
            PaiementService ps = PaiementService.getPaimentService();
            ps.createPaiement(idE,montant,methode);
            resp.sendRedirect("Etudiant/listEtudiant.jsp");
        }
        else
        {
            resp.sendRedirect("Paiement/paiement.jsp");
        }



    }
}
