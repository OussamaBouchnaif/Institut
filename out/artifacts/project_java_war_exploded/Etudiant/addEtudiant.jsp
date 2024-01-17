
<%@ page import="entity.Niveau" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Groupe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Add Etudiant</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>

    <%

        List<Niveau> niveauxList = (List<Niveau>) request.getAttribute("niveau");
        List<Groupe> groupList = (List<Groupe>) request.getAttribute("groupe");

    %>
<jsp:include page="../head.jsp" />
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
                    <div class="form_group">
                        <label>Adress  <span>*</span></label>
                        <input type="text" class="form-control" name="adress" /><br>
                    </div>
                    <div class="form_group">
                        <label>Num Tele  <span>*</span></label>
                        <input type="text" class="form-control" name="tele" /><br>
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
