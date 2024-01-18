package com.example.project_java.Etudiant;

import Services.EtudiantService;
import Services.GroupeService;
import Services.NiveauService;
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


@WebServlet("/addEtudiant")
public class AddServlet extends HttpServlet {

    @Override
    public void init() throws jakarta.servlet.ServletException {
        super.init();
        Factory.add(EtudiantService.class);
        Factory.add(NiveauService.class);
        Factory.add(GroupeService.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        NiveauService niveaus = Factory.get(NiveauService.class);
        List<Niveau> niveauxList = niveaus.getAllNiveaux();

        GroupeService groupes = Factory.get(GroupeService.class);
        List<Groupe> groupList = groupes.getAllGroupes();
        req.setAttribute("groupe", groupList);
        req.setAttribute("niveau", niveauxList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Etudiant/addEtudiant.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String groupeId = req.getParameter("groupeId");
        String niveauId = req.getParameter("niveauId");
        String adress = req.getParameter("adress");
        String numtele = req.getParameter("tele");

        if(!nom.isEmpty() && !prenom.isEmpty() && !groupeId.isEmpty() && !niveauId.isEmpty() )
        {
            long gId = Long.parseLong(groupeId);
            long nId = Long.parseLong(niveauId);
            EtudiantService esc = Factory.get(EtudiantService.class);
            esc.createEtudiant(nom,prenom,nId,gId,adress,numtele);
            resp.sendRedirect(req.getContextPath() + "/listEtudiant");


        }
        else{
            resp.sendRedirect(req.getContextPath() + "/addEtudiant");
        }


    }

}
