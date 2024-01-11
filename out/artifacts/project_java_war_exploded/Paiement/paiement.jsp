<%@ page import="Services.EtudiantService" %>
<%@ page import="entity.Etudiant" %><%--
  Created by IntelliJ IDEA.
  User: oussa
  Date: 11/01/2024
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Paiement</title>
</head>
<body>
<style>

    .login{
        margin-top: 50px;
    }
    .roww{
        margin-top: 50px;
        width: 50%;
        margin: auto;
        padding: 20px;
        border: solid 1px #6a7964;
    }
    .roww .form_group{
        width: 100%;
    }
</style>


<%
        String id = request.getParameter("id");
        long idE = Long.parseLong(id);
        EtudiantService etudiants = EtudiantService.getEtudiantService();
        Etudiant etudiant = etudiants.getEtudiantById(idE);
%>
<div class="container login">
    <div class="roww">
        <div class="user-actions">
            <form action="${pageContext.request.contextPath}/paiementEtudiant?idE=<%= idE %>" method="post">
                <input type="hidden" name="" value="<%= idE %>" />
                <div class="form_group">
                    <label>First Name<span>*</span></label>
                    <input type="text" class="form-control" value="<%= etudiant.getFirstName() %>" name="nom" /><br>
                </div>
                <div class="form_group">
                    <label>Last Name  <span>*</span></label>
                    <input type="text" class="form-control" value="<%= etudiant.getLastName()%>" name="prenom" /><br>
                </div>
                <div class="form_group">
                    <label>Montant <span>*</span></label>
                    <input type="text" class="form-control"  name="montant" /><br>
                </div>
                <select name="methode" class="form-select">
                    <option value="">Sélectionnez une methode</option>
                    <option value="">Cash</option>
                    <option value="">Pypal</option>
                    <option value="">Cart</option>

                </select><br>
                <div class="form_group group_3 ">
                    <button class="btn btn-primary" type="submit">Ajouter Paiement Etudiant</button>
                </div>


            </form>

        </div>
    </div>
</div>
</body>
</html>
