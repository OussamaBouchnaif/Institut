package com.example.project_java.Formateur;

import Services.EtudiantService;
import Services.FormateurService;
import com.example.project_java.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/addFormateur")
public class AddSrvlet extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("Formateur/addFormateur.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String adress = req.getParameter("adress");
        String tele = req.getParameter("tele");


        if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !adress.isEmpty() && !tele.isEmpty() )
        {

            FormateurService fs = FormateurService.getFormateur();
            fs.cerateFormateur(nom,prenom,adress,tele,email);
            resp.sendRedirect("Formateur/listFormateur.jsp");
        }
        else{
            resp.sendRedirect("Formateur/addFormateur.jsp");
        }
    }
}
