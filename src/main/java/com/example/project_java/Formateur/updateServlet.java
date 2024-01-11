package com.example.project_java.Formateur;

import Services.EtudiantService;
import Services.FormateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/updateFormateur")
public class updateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        long id = Long.parseLong(idParam);
        resp.sendRedirect("Formateur/updateFormateur.jsp?id="+id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long idE = Long.parseLong(id);
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String adress = req.getParameter("adress");
        String tele = req.getParameter("tele");

        if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !adress.isEmpty() && !tele.isEmpty() )
        {

            FormateurService fs = FormateurService.getFormateur();
            fs.updateFormateur(idE,nom,prenom,adress,tele,email);
            resp.sendRedirect("Formateur/listFormateur.jsp");
        }
        else{
            resp.sendRedirect("Formateur/updateFormateur.jsp");
        }
    }
}
