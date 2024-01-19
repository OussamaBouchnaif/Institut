//package com.example.project_java.Groupe;
//
//import Services.SalleService;
//import entity.Factory;
//import entity.Salle;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet("/updateSalle")
//public class UpdateServlet extends HttpServlet {
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        Factory.add(SalleService.class);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String idParam = req.getParameter("id");
//        long id = Long.parseLong(idParam);
//
//        SalleService salleService = Factory.get(SalleService.class);
//        Salle salle = salleService.getsalletById(id);
//
//        req.setAttribute("salle", salle);
//        req.setAttribute("id", id);
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("Salle/updateUser.jsp");
//        dispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        long idS = Long.parseLong(id);
//        String nomSalle = req.getParameter("nomSalle");
//        int capacite = Integer.parseInt(req.getParameter("capacite"));
//
//        if (idS > 0 && nomSalle != null && capacite > 0) {
//            SalleService salleService = Factory.get(SalleService.class);
//            salleService.updateSalle(idS, nomSalle, capacite);
//            resp.sendRedirect(req.getContextPath() + "/listSalle");
//        } else {
//            // Handle the case where the parameters are not valid
//            resp.sendRedirect(req.getContextPath() + "/updateSalle?id=" + idS);
//        }
//    }
//}
