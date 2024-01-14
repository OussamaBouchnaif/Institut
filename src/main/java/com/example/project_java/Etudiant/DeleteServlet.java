package com.example.project_java.Etudiant;

import Services.EtudiantService;
import entity.Factory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deleteEtudiant")
public class DeleteServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(EtudiantService.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long idE = Long.parseLong(id);

        EtudiantService esc = Factory.get(EtudiantService.class);
        if(esc != null)
        {
            esc.deleteEtudiant(idE);
            resp.sendRedirect(req.getContextPath() + "/listEtudiant");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
