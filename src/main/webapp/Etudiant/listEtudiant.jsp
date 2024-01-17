<%@ page import="entity.Etudiant" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.util.List" %>
<%@ page import="Services.EtudiantService" %>
<%@ page import="entity.Factory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>Etudiant</title>
</head>
<body>
<jsp:include page="../head.jsp" />
<div class="container">
    <h1>Gestion des Etudiants</h1>
    <a href="${pageContext.request.contextPath}/addEtudiant" class="btn btn-primary">Ajouter un Etudiant</a>
<%--    <a href="${pageContext.request.contextPath}/addgroupe" class="btn btn-success" data-toggle="modal" data-target="#modal-body"></a>--%>
    <a href="${pageContext.request.contextPath}/addEtudiant" class="btn btn-info" data-toggle="modal" data-target="#myModal">Ajouter un Niveau</a>
<%--    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>--%>
    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModalCenter">
        Ajouter un Groupe
    </button>
    <%
        List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants");
        if (etudiants != null) {

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
            <td><%= e.getNom() %></td>
            <td><%= e.getPrenom() %></td>
            <td><%= e.getGroupe() %></td>
            <td><%= e.getNiveau() %></td>
            <td class="text-center"><a href="${pageContext.request.contextPath}/paiementEtudiant?id=<%= e.getId() %>"><i class="fa-solid fa-money-bill text-warning"></i></a></td>
            <td class="text-center"><a href="${pageContext.request.contextPath}/deleteEtudiant?id=<%= e.getId() %>"><i class="fa-solid fa-trash text-danger"></i></a></td>
            <td  class="text-center"><a href="${pageContext.request.contextPath}/updateEtudiant?id=<%= e.getId() %>"><i  class="fa-solid fa-pen-to-square text-warning"></i></a></td>

        </tr>
            <%

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

<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <h5>Popover in a modal</h5>
    <!-- Your form -->
    <form action="${pageContext.request.contextPath}/addgroupe" method="post" class="mx-auto" style="width: 50%;">
        <div class="form_group">
            <label>Nom du Groupe<span>*</span></label>
            <input type="text" class="form-control" name="nomGroupe" required />
        </div>
        <div class="form_group group_3">
            <button class="btn btn-primary" type="submit">Ajouter Groupe</button>
        </div>
    </form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-rn5to1aUpu2+KqIACaRcfddAdbGgDpD7QDAfeFQ8A6F5XDjh22qpgC5N2EGnMFz1" crossorigin="anonymous"></script>

</body>
</html>
