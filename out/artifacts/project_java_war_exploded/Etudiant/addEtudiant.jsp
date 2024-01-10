<%@ page import="Services.NiveauDAO" %>
<%@ page import="entity.Niveau" %>
<%@ page import="java.util.List" %>
<%@ page import="Services.NiveauService" %><%--
  Created by IntelliJ IDEA.
  User: oussa
  Date: 10/01/2024
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>oussama</h1>
    <%
        NiveauService niveaus = new NiveauService();
        List<Niveau> niveauxList = niveaus.getAllNiveaux();
    %>
    <form  action="../addEtudiant" method="post">
        <label>First Name</label>
        <input type="text" name="nom" /><br>
        <label>Last Name</label>
        <input type="text" name="prenom" /><br>

        <select name="niveauId">
            <option value="">Sélectionnez un niveau</option>


            <% for (Niveau niveau : niveauxList) { %>
            <option value="<%= niveau.getId() %>"><%= niveau.getNomNiveau() %></option>
            <% } %>
        </select>

        <input type="submit" value="Ajouter" />
    </form>
</body>
</html>
