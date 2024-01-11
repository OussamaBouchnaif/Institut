package com.example.project_java.Formateur;

import Services.EtudiantService;
import Services.FormateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deleteFormateur")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long idE = Long.parseLong(id);

        FormateurService fs = FormateurService.getFormateur();
        fs.deleteFormateur(idE);
        resp.sendRedirect("Formateur/listFormateur.jsp");
    }
}
