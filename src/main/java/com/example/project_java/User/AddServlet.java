package com.example.project_java.User;

import Services.UserService;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addUser")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/addUser.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String prenom = request.getParameter("prenom");
        String password = request.getParameter("password");
        String adress = request.getParameter("adress");
        String tele = request.getParameter("tele");

        UserService userService = new UserService();
        User newUser = new User(name, prenom,adress ,tele, email, password);
        userService.createUser(newUser);


        response.sendRedirect("User/listServlet.jsp");
    }
}
