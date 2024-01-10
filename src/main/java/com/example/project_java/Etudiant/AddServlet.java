package com.example.project_java.Etudiant;

import Services.EtudiantService;
import entity.Etudiant;
import entity.Groupe;
import entity.Niveau;
import entity.Paiement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addEtudiant")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Etudiant/addEtudiant.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String groupeId = req.getParameter("groupeId");
        String niveauId = req.getParameter("niveauId");

        if(!nom.isEmpty() && !prenom.isEmpty() && !groupeId.isEmpty() && !niveauId.isEmpty() )
        {
            long gId = Long.parseLong(groupeId);
            long nId = Long.parseLong(niveauId);
            EtudiantService e = new EtudiantService();
            e.ajouterEtudiant(nom,prenom,nId,gId);
            resp.sendRedirect("Etudiant/listEtudiant.jsp");
        }
        else{
            resp.sendRedirect("Etudiant/addEtudiant.jsp");
        }

    }
}
