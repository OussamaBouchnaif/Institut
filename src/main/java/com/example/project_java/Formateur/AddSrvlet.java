package com.example.project_java.Formateur;

import Services.EtudiantService;
import Services.FormateurService;
import com.example.project_java.HelloServlet;
import entity.Factory;
import entity.Formateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/addFormateur")
public class AddSrvlet extends HelloServlet {

    @Override
    public void init()
    {
        super.init();
        Factory.add(FormateurService.class);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException{

        RequestDispatcher dispatcher = request.getRequestDispatcher("Formateur/addFormateur.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String adress = req.getParameter("adress");
        String tele = req.getParameter("tele");
        String ville = "";


        if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !adress.isEmpty() && !tele.isEmpty() )
        {

            FormateurService fs = Factory.get(FormateurService.class);
            fs.cerateFormateur(nom,prenom,adress,tele,email,ville);
            resp.sendRedirect(req.getContextPath() + "/listFormateur");
        }
        else{
            resp.sendRedirect(req.getContextPath() + "/addFormateur");
        }
    }
}
