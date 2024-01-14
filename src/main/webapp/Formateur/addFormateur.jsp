
<%@ page import="entity.Niveau" %>
<%@ page import="java.util.List" %>
<%@ page import="Services.NiveauService" %>
<%@ page import="Services.GroupeService" %>
<%@ page import="entity.Groupe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Add Formateur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>
<jsp:include page="../head.jsp" />

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


<div class="container login">
    <div class="roww">
        <div class="user-actions">
            <form action="${pageContext.request.contextPath}/addFormateur" method="post">
                <div class="form_group">
                    <label>First Name<span>*</span></label>
                    <input type="text" class="form-control" name="nom" /><br>
                </div>
                <div class="form_group">
                    <label>Last Name  <span>*</span></label>
                    <input type="text" class="form-control" name="prenom" /><br>
                </div>
                <div class="form_group">
                    <label>Email<span>*</span></label>
                    <input type="text" class="form-control" name="email" /><br>
                </div>
                <div class="form_group">
                    <label>adress<span>*</span></label>
                    <input type="text" class="form-control" name="adress" /><br>
                </div>
                <div class="form_group">
                    <label>Telephon<span>*</span></label>
                    <input type="text" class="form-control" name="tele" /><br>
                </div>


                <div class="form_group group_3 ">
                    <button class="btn btn-primary" type="submit">Ajouter Formateur</button>
                </div>


            </form>

        </div>
    </div>
</div>

</body>
</html>
