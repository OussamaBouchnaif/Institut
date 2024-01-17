package com.example.project_java.Seance;

import Services.*;
import entity.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
@WebServlet("/addSeance")
public class AddSevlet extends HttpServlet {

    @Override
    public void init() throws jakarta.servlet.ServletException {
        super.init();
        Factory.add(SeanceService.class);
        Factory.add(GroupeService.class);
        Factory.add(FormateurService.class);
        Factory.add(SalleService.class);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormateurService formateur = Factory.get(FormateurService.class);
        List<Formateur> formateurList = formateur.getAllFormateur();

        GroupeService groupes = Factory.get(GroupeService.class);
        List<Groupe> groupList = groupes.getAllGroupes();

        SalleService salle = Factory.get(SalleService.class);
        List<Salle> salleList = salle.getAllSalle();

        req.setAttribute("groupe", groupList);
        req.setAttribute("formateur",formateurList );
        req.setAttribute("salle",salleList );
        RequestDispatcher dispatcher = req.getRequestDispatcher("Seance/addSalle.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime dateDebut = LocalDateTime.parse(req.getParameter("datedebut"));
        LocalDateTime datefin = LocalDateTime.parse(req.getParameter("datefin"));
        Long groupeId = Long.valueOf(req.getParameter("groupeId"));
        Long formateurid = Long.valueOf(req.getParameter("formateurid"));
        Long salleid = Long.valueOf(req.getParameter("salleid"));
        if (dateDebut != null && groupeId != null && formateurid != null && salleid != null && datefin.isAfter(dateDebut)) {

            SeanceService ss = Factory.get(SeanceService.class);
            ss.createSeance(groupeId,salleid,formateurid,dateDebut,datefin);
            resp.sendRedirect(req.getContextPath() + "/listSeance");
        }
        else{
            resp.sendRedirect(req.getContextPath() + "/addSeance");
        }

    }
}
