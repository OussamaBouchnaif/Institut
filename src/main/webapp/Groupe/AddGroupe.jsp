<%@ page import="java.util.List" %>
<%@ page import="entity.Groupe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Ajouter Groupe</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>

<jsp:include page="../head.jsp" />

<!-- Your modal structure -->
<div class="modal-body">
    <h5>Popover in a modal</h5>
    <!-- Your form -->
    <form action="${pageContext.request.contextPath}/addgroupe" method="post">
        <div class="form_group">
            <label>Nom du Groupe<span>*</span></label>
            <input type="text" class="form-control" name="nomGroupe" required /><br>
        </div>
        <div class="form_group group_3">
            <button class="btn btn-primary" type="submit">Ajouter Groupe</button>
        </div>
    </form>
</div>

</body>
</html>
