<%@ page import="java.util.List" %>
<%@ page import="entity.Niveau" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
    <title>Ajouter Niveau</title>
</head>
<body>

<jsp:include page="../head.jsp" />

<!-- Your modal structure -->
<div class="modal-body">
    <h5>Ajouter un niveau</h5>
    <!-- Your form -->
    <form action="${pageContext.request.contextPath}/addNiveau" method="post">
        <div class="form-group">
            <label>Nom du Niveau<span>*</span></label>
            <input type="text" class="form-control" name="nomNiveau" required /><br>
        </div>
        <div class="form-group group_3">
            <button class="btn btn-primary" type="submit">Ajouter Niveau</button>
        </div>
    </form>
</div>

</body>
</html>
