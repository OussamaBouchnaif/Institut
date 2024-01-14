<%@ page import="Services.EtudiantService" %>
<%@ page import="entity.Etudiant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Paiement</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>
<jsp:include page="../head.jsp" />

<%
        Long id = (Long)request.getAttribute("id");
        Etudiant etudiant = (Etudiant)request.getAttribute("etudiant") ;
%>
<div class="container login ">
    <div class="roww">
        <div class="user-actions">
            <form action="${pageContext.request.contextPath}/paiementEtudiant?idE=<%= id %>" method="post">
                <input type="hidden" name="" value="<%= id %>" />
                <div class="form_group">
                    <label>First Name<span>*</span></label>
                    <input type="text" class="form-control" value="<%= etudiant.getNom() %>" name="nom" /><br>
                </div>
                <div class="form_group">
                    <label>Last Name  <span>*</span></label>
                    <input type="text" class="form-control" value="<%= etudiant.getPrenom()%>" name="prenom" /><br>
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
