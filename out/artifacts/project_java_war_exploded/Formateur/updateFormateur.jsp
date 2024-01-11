
<%@ page import="entity.Niveau" %>
<%@ page import="java.util.List" %>
<%@ page import="Services.NiveauService" %>
<%@ page import="Services.GroupeService" %>
<%@ page import="entity.Groupe" %>
<%@ page import="Services.EtudiantService" %>
<%@ page import="entity.Etudiant" %>
<%@ page import="Services.FormateurService" %>
<%@ page import="entity.Formateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>update Formateur</title>
    <link rel="stylesheet" href="../resource/Style/form.css">
</head>
<body>



<%
    String id = request.getParameter("id");
    long idE = Long.parseLong(id);
    FormateurService formateurService = FormateurService.getFormateur();
    Formateur formateur = formateurService.getFormateurById(idE);
%>

<div class="container login">
    <div class="roww">
        <div class="user-actions">
            <form action="${pageContext.request.contextPath}/updateFormateur" method="post">
                <input type="hidden" name="id" value="<%= idE %>">
                <div class="form_group">
                    <label>First Name<span>*</span></label>
                    <input type="text" class="form-control" name="nom" value="<%= formateur.getNom() %>" /><br>
                </div>
                <div class="form_group">
                    <label>Last Name  <span>*</span></label>
                    <input type="text" class="form-control" name="prenom" value="<%= formateur.getPrenom()%>"/><br>
                </div>
                <div class="form_group">
                    <label>Email<span>*</span></label>
                    <input type="text" class="form-control" name="email" value="<%=formateur.getEmail() %>" /><br>
                </div>
                <div class="form_group">
                    <label>adress<span>*</span></label>
                    <input type="text" class="form-control" name="adress" value="<%= formateur.getAdresse()%>" /><br>
                </div>
                <div class="form_group">
                    <label>Telephon<span>*</span></label>
                    <input type="text" class="form-control" name="tele" value="<%= formateur.getNumeroTelephone() %>" /><br>
                </div>
                <div class="form_group group_3 ">
                    <button class="btn btn-warning" type="submit">Update Etudiant</button>
                </div>


            </form>

        </div>
    </div>
</div>

</body>
</html>
