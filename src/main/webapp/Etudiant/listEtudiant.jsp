<%@ page import="entity.Etudiant" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.util.List" %>
<%@ page import="Services.EtudiantService" %><%--
  Created by IntelliJ IDEA.
  User: oussa
  Date: 10/01/2024
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Etudiant</title>
</head>
<body>
<div class="container">
    <h1>Gestion des Etudiants</h1>
    <%
        EtudiantService ed = EtudiantService.getEtudiantService();
        List<Etudiant> etudiants = (List<Etudiant>) ed.getAllEtudiants();
        if (etudiants != null) {
            int index = 0;
    %>

    <table id="todoTable" class="table table-hover mt-5" >
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Groupe</th>
            <th scope="col">Niveau</th>
            <th scope="col" class="text-center" colspan="2"> Actions </th>
        </tr>
        </thead>
        <tbody>
            <%for (Etudiant e : etudiants) {
                    %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getFirstName() %></td>
            <td><%= e.getLastName() %></td>
            <td><%= e.getGroupe() %></td>
            <td><%= e.getNiveau() %></td>
            <td class="text-center"><a href="${pageContext.request.contextPath}/paiementEtudiant?id=<%= e.getId() %>"><i class="fa-solid fa-money-bill text-warning"></i></a></td>
            <td class="text-center"><a href="${pageContext.request.contextPath}/deleteEtudiant?id=<%= e.getId() %>"><i class="fa-solid fa-trash text-danger"></i></a></td>
            <td  class="text-center"><a href="${pageContext.request.contextPath}/updateEtudiant?id=<%= e.getId() %>"><i  class="fa-solid fa-pen-to-square text-warning"></i></a></td>

        </tr>
            <%
                index++;
                    }
                %>
        <tbody>
    </table>
    <%
    } else {
    %>
    <p>Aucun Etudiant pour le moment.</p>
    <%
        }
    %>

    <a href="${pageContext.request.contextPath}/addEtudiant">Ajouter un Etudiant</a>
</div>
</body>
</html>
