
<%@ page import="entity.Niveau" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Groupe" %>
<%@ page import="entity.Salle" %>
<%@ page import="entity.Formateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Add Seance</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>

<%

    List<Salle> sallList = (List<Salle>) request.getAttribute("salle");
    List<Groupe> groupList = (List<Groupe>) request.getAttribute("groupe");
    List<Formateur> formateurList = (List<Formateur>) request.getAttribute("formateur");

%>
    <jsp:include page="../sidbar.jsp" />


    <section class="home-section">
        <jsp:include page="../head.jsp" />
        <div class="content">
            <div class="container login">
                <div class="roww">
                    <div class="user-actions">
                        <form action="${pageContext.request.contextPath}/addSeance" method="post">
                            <div class="form_group">
                                <label>Date Debut<span>*</span></label>
                                <input type="datetime-local" class="form-control" name="datedebut" /><br>
                            </div>
                            <div class="form_group">
                                <label>Date Fin<span>*</span></label>
                                <input type="datetime-local" class="form-control" name="datefin" /><br>
                            </div>

                            <select name="salleid" class="form-select">
                                <option value="null">Sélectionnez une Salle</option>


                                <% for (Salle salle : sallList) { %>
                                <option value="<%= salle.getId() %>"><%= salle.getNomSalle() %></option>
                                <% } %>
                            </select><br>
                            <select name="groupeId" class="form-select">
                                <option value="null">Sélectionnez un Groupe</option>


                                <% for (Groupe groupe : groupList) { %>
                                <option value="<%= groupe.getId() %>"><%= groupe.getNomGroupe() %></option>
                                <% } %>
                            </select><br>
                            <select name="formateurid" class="form-select">
                                <option value="null">Sélectionnez un Formateur</option>


                                <% for (Formateur formateur : formateurList) { %>
                                <option value="<%= formateur.getId() %>"><%= formateur.getNom() %></option>
                                <% } %>
                            </select><br>
                            <div class="form_group group_3 ">
                                <button class="btn btn-primary" type="submit">Ajouter Seance</button>
                            </div>


                        </form>

                    </div>
                </div>
            </div>

        </div>

    </section>



</body>
</html>
