<%@ page import="entity.Etudiant" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.util.List" %>
<%@ page import="Services.EtudiantService" %>
<%@ page import="Services.FormateurService" %>
<%@ page import="entity.Formateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Etudiant</title>
</head>
<body>
<div class="container">
    <h1>Gestion des Formateurs</h1>
    <%
        FormateurService fs = FormateurService.getFormateur();
        List<Formateur> formateurs = (List<Formateur>) fs.getAllFormateur();
        if (formateurs != null) {

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
            <%for (Formateur f : formateurs) {
                    %>
        <tr>
            <td><%= f.getId() %></td>
            <td><%= f.getNom() %></td>
            <td><%= f.getPrenom() %></td>
            <td><%= f.getAdresse() %></td>
            <td><%= f.getNumeroTelephone() %></td>
            <td><%= f.getEmail() %></td>

            <td class="text-center"><a href="${pageContext.request.contextPath}/deleteFormateur?id=<%= f.getId() %>"><i class="fa-solid fa-trash text-danger"></i></a></td>
            <td  class="text-center"><a href="${pageContext.request.contextPath}/updateFormateur?id=<%= f.getId() %>"><i  class="fa-solid fa-pen-to-square text-warning"></i></a></td>

        </tr>
            <%

                    }
                %>
        <tbody>
    </table>
    <%
    } else {
    %>
    <p>Aucun Formateur pour le moment.</p>
    <%
        }
    %>
    <a href="${pageContext.request.contextPath}/addFormateur">Ajouter un Formateur</a>
</div>
</body>
</html>
