<%@ page import="DAO.NiveauDAO" %>
<%@ page import="entity.Niveau" %>
<%@ page import="java.util.List" %><%--
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
        NiveauDAO niveauDAO = new NiveauDAO();
        List<Niveau> niveauxList = niveauDAO.getAllNiveaux();
    %>
    <form  action="../addEtudiant" method="post">
        <label>First Name</label>
        <input type="text" name="nom" /><br>
        <label>Last Name</label>
        <input type="text" name="prenom" /><br>

        <select name="niveauId"> <!-- Assurez-vous d'ajouter un nom à la balise select pour pouvoir récupérer la valeur sélectionnée -->
            <option value="">Sélectionnez un niveau</option>

            <!-- Boucle pour afficher les options en fonction des niveaux récupérés depuis la base de données -->
            <% for (Niveau niveau : niveauxList) { %>
            <option value="<%= niveau.getId() %>"><%= niveau.getNomNiveau() %></option>
            <% } %>
        </select>

        <input type="submit" value="Ajouter" />
    </form>
</body>
</html>
