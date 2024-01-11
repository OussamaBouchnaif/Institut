package com.example.project_java.Etudiant;

import Services.EtudiantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deleteEtudiant")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long idE = Long.parseLong(id);

        EtudiantService etudiantService = EtudiantService.getEtudiantService();
        etudiantService.deleteEtudiant(idE);
        resp.sendRedirect("Etudiant/listEtudiant.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
