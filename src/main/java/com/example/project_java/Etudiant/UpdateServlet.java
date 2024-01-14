package com.example.project_java.Etudiant;

import Services.EtudiantService;
import Services.GroupeService;
import Services.NiveauService;
import entity.Etudiant;
import entity.Factory;
import entity.Groupe;
import entity.Niveau;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/updateEtudiant")
public class UpdateServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(EtudiantService.class);
        Factory.add(NiveauService.class);
        Factory.add(GroupeService.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        long id = Long.parseLong(idParam);
        EtudiantService etudiants = Factory.get(EtudiantService.class);
        Etudiant etudiant = etudiants.getEtudiantById(id);

        NiveauService niveaus = Factory.get(NiveauService.class);
        List<Niveau> niveauxList = niveaus.getAllNiveaux();

        GroupeService groupes = Factory.get(GroupeService.class);
        List<Groupe> groupList = groupes.getAllGroupe();
        req.setAttribute("groupe", groupList);
        req.setAttribute("niveau", niveauxList);
        req.setAttribute("etudiant", etudiant);
        req.setAttribute("id", id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("Etudiant/updateEtudiant.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long idE = Long.parseLong(id);
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String groupeId = req.getParameter("groupeId");
        String niveauId = req.getParameter("niveauId");

        if(!nom.isEmpty() && !prenom.isEmpty() && !groupeId.isEmpty() && !niveauId.isEmpty() )
        {
            long gId = Long.parseLong(groupeId);
            long nId = Long.parseLong(niveauId);
            EtudiantService esc = Factory.get(EtudiantService.class);
            esc.updateEtudiant(idE,nom,prenom,nId,gId);
            resp.sendRedirect(req.getContextPath() + "/listEtudiant");
        }
        else{
            resp.sendRedirect(req.getContextPath() + "/addEtdudiant");
        }
    }
}
