
<%@ page import="entity.Niveau" %>
<%@ page import="java.util.List" %>
<%@ page import="Services.NiveauService" %>
<%@ page import="Services.GroupeService" %>
<%@ page import="entity.Groupe" %><%--
  Created by IntelliJ IDEA.
  User: oussa
  Date: 10/01/2024
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Add Etudiant</title>
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
        NiveauService niveaus = NiveauService.GetNiveauService();
        List<Niveau> niveauxList = niveaus.getAllNiveaux();

        GroupeService groupes = GroupeService.GetGroupeService();
        List<Groupe> groupList = groupes.getAllGroupe();

    %>

    <div class="container login">
        <div class="roww">
            <div class="user-actions">
                <form action="${pageContext.request.contextPath}/addEtudiant" method="post">
                    <div class="form_group">
                        <label>First Name<span>*</span></label>
                        <input type="text" class="form-control" name="nom" /><br>
                    </div>
                    <div class="form_group">
                        <label>Last Name  <span>*</span></label>
                        <input type="text" class="form-control" name="prenom" /><br>
                    </div>
                    <select name="niveauId" class="form-select">
                        <option value="">Sélectionnez un niveau</option>


                        <% for (Niveau niveau : niveauxList) { %>
                        <option value="<%= niveau.getId() %>"><%= niveau.getNomNiveau() %></option>
                        <% } %>
                    </select><br>
                    <select name="groupeId" class="form-select">
                        <option value="">Sélectionnez un Groupe</option>


                        <% for (Groupe groupe : groupList) { %>
                        <option value="<%= groupe.getId() %>"><%= groupe.getNomGroupe() %></option>
                        <% } %>
                    </select><br>
                    <div class="form_group group_3 ">
                        <button class="btn btn-primary" type="submit">Ajouter Etudiant</button>
                    </div>


                </form>

            </div>
        </div>
    </div>

</body>
</html>
