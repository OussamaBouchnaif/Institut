package com.example.project_java.Formateur;
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
import java.util.List;

@WebServlet("/listFormateur")
public class listServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(FormateurService.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormateurService fs = Factory.get(FormateurService.class);
        List<Formateur> formateur = fs.getAllFormateur();

        req.setAttribute("formateurs", formateur);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Formateur/listFormateur.jsp");
        dispatcher.forward(req, resp);

    }
}
