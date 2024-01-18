
<%@ page import="entity.Niveau" %>
<%@ page import="java.util.List" %>
<%@ page import="Services.NiveauService" %>
<%@ page import="Services.GroupeService" %>
<%@ page import="entity.Groupe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<jsp:include page="../sidbar.jsp" />

<section class="home-section">
    <jsp:include page="../head.jsp" />
    <div class="content">
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

    </div>

</section>




</body>
</html>
