package com.example.project_java.Etudiant;

import Services.EtudiantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/updateEtudiant")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        long id = Long.parseLong(idParam);
        resp.sendRedirect("Etudiant/updateEtudiant.jsp?id="+id);
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
            EtudiantService e = EtudiantService.getEtudiantService();
            e.updateEtudiant(idE,nom,prenom,nId,gId);
            resp.sendRedirect("Etudiant/listEtudiant.jsp");
        }
        else{
            resp.sendRedirect("Etudiant/updateEtudiant.jsp");
        }
    }
}
