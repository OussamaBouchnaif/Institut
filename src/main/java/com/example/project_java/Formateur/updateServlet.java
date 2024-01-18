package com.example.project_java.Formateur;

import Services.EtudiantService;
import Services.FormateurService;
import entity.Factory;
import entity.Formateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/updateFormateur")
public class updateServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(EtudiantService.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        long id = Long.parseLong(idParam);
        FormateurService formateurService = Factory.get(FormateurService.class);
        Formateur formateur = formateurService.getFormateurById(id);
        req.setAttribute("formateur", formateur);
        req.setAttribute("id", id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Formateur/updateFormateur.jsp");
        dispatcher.forward(req, resp);

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
        String ville = req.getParameter("ville");

        if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !adress.isEmpty() && !tele.isEmpty() )
        {

            FormateurService fs = Factory.get(FormateurService.class);
            fs.updateFormateur(idE,nom,prenom,adress,tele,email);
            resp.sendRedirect(req.getContextPath() + "/listFormateur");
        }
        else{
            resp.sendRedirect(req.getContextPath() + "/updateFormateur");
        }
    }
}
