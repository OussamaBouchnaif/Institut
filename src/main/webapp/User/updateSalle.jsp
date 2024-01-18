<%@ page import="java.util.List" %>
<%@ page import="entity.Salle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
  <title>Modifier Salle</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>

<jsp:include page="../sidbar.jsp" />
<%
  Salle salle = (Salle) request.getAttribute("salle");

%>
<section class="home-section">
  <jsp:include page="../head.jsp" />
  <div class="content">
    <div class="container login">
      <div class="roww">
        <div class="user-actions">

          <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null && !errorMessage.isEmpty()) {
          %>
          <div class="alert alert-danger" role="alert">
            <%= errorMessage %>
          </div>
          <%
            }
          %>

          <form action="${pageContext.request.contextPath}/updateSalle" method="post">
            <div class="form_group">
              <label>ID de la Salle</label>
              <input type="text" class="form-control" name="id" value="<%= salle.getId() %>" readonly /><br>
            </div>
            <div class="form_group">
              <label>Nom de la Salle<span>*</span></label>
              <input type="text" class="form-control" name="nomSalle" value="<%= salle.getNomSalle() %>" required /><br>
            </div>
            <div class="form_group">
              <label>Capacité de la Salle<span>*</span></label>
              <input type="number" class="form-control" name="capacite" value="<%= salle.getCapacite() %>" required /><br>
            </div>
            <div class="form_group group_3">
              <button class="btn btn-primary" type="submit">Modifier Salle</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

</section>



</body>
</html>
