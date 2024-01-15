package com.example.project_java.Seance;

import Services.EtudiantService;
import Services.SeanceService;
import entity.Factory;
import entity.Seance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deleteSeance")
public class deleteServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Factory.add(SeanceService.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long idS = Long.parseLong(id);

        SeanceService seanceService = Factory.get(SeanceService.class);
        if(seanceService != null)
        {
            seanceService.delete(idS);
            resp.sendRedirect(req.getContextPath() + "/listSeance");
        }
    }
}
