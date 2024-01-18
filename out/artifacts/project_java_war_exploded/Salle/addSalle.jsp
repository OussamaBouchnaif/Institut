<%@ page import="java.util.List" %>
<%@ page import="entity.Salle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Ajouter Salle</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>

<%--<%--%>

<%--    List<Salle> salleList = (List<Salle>) request.getAttribute("salleList");--%>

<%--%>--%>
<jsp:include page="../head.jsp" />
<div class="container login">
    <div class="roww">
        <div class="user-actions">
            <form action="${pageContext.request.contextPath}/addSalle" method="post">
                <div class="form_group">
                    <label>Nom de la Salle<span>*</span></label>
                    <input type="text" class="form-control" name="nomSalle" required /><br>
                </div>
                <div class="form_group">
                    <label>Capacité de la Salle<span>*</span></label>
                    <input type="number" class="form-control" name="capacite" required /><br>
                </div>
                <div class="form_group group_3">
                    <button class="btn btn-primary" type="submit">Ajouter Salle</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
