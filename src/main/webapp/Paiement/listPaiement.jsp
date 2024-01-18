<%@ page import="entity.Paiement" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: oussa
  Date: 18/01/2024
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Paiement</title>
</head>
<body>
    <jsp:include page="../sidbar.jsp" />

    <%
        List<Paiement> paiments = (List<Paiement>) request.getAttribute("paiement");
        if (paiments != null) {
    %>
    <section class="home-section">
        <jsp:include page="../head.jsp" />
        <div class="content">
            <div class="container">



                <table class="table table-hover mt-5">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom </th>
                        <th>Prenom</th>
                        <th>Groupe</th>
                        <th>Niveau</th>
                        <th>Date </th>
                        <th>Total</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (Paiement p : paiments) { %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getEtudiant().getNom() %></td>
                        <td><%= p.getEtudiant().getPrenom() %></td>
                        <td><%= p.getEtudiant().getGroupe().toString() %></td>
                        <td><%= p.getEtudiant().getNiveau().toString() %></td>
                        <td><%= p.getDatePaiement() %></td>
                        <td><%= p.getMontant() %>$</td>
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/deletePaiement?id=<%= p.getId() %>">
                                <i class="fa-solid fa-trash text-danger"></i>
                            </a>
                        </td>
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/updatePaiement?id=<%= p.getId() %>">
                                <i class="fa-solid fa-pen-to-square text-warning"></i>
                            </a>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
            <%
                }
            %>

        </div>


    </section>
</body>
</html>
