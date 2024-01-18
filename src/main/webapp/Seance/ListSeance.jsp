<%@ page import="entity.Etudiant" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.util.List" %>
<%@ page import="Services.EtudiantService" %>
<%@ page import="entity.Factory" %>
<%@ page import="entity.Seance" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seance</title>
</head>
<body>
<jsp:include page="../sidbar.jsp" />
<section class="home-section">
    <jsp:include page="../head.jsp" />
    <div class="content">
        <div class="container">

            <a href="${pageContext.request.contextPath}/addSeance" class="btn btn-primary mt-5">Ajouter une Seance</a>

            <%
                List<Seance> seances = (List<Seance>) request.getAttribute("seances");
                if (seances != null) {

            %>

            <table id="todoTable" class="table table-hover mt-5" >
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">groupe</th>
                    <th scope="col">salle</th>
                    <th scope="col">formateur</th>
                    <th scope="col">Date debut</th>
                    <th scope="col">Date fin</th>
                    <th scope="col" class="text-center" colspan="2"> Actions </th>
                </tr>
                </thead>
                <tbody>
                    <%for (Seance s : seances) {
                    %>
                <tr>
                    <td><%= s.getId() %></td>
                    <td><%= s.getGroupe().getNomGroupe() %></td>
                    <td><%= s.getSalle().getNomSalle() %></td>
                    <td><%= s.getFormateur().getNom() + s.getFormateur().getPrenom() %></td>
                    <td><%= s.getDateFin() %></td>

                    <td class="text-center"><a href="${pageContext.request.contextPath}/deleteSeance?id=<%= s.getId() %>"><i class="fa-solid fa-trash text-danger"></i></a></td>
                    <td  class="text-center"><a href="${pageContext.request.contextPath}/updateSeance?id=<%= s.getId() %>"><i  class="fa-solid fa-pen-to-square text-warning"></i></a></td>

                </tr>
                    <%

                    }
                %>
                <tbody>
            </table>
            <%
            } else {
            %>
            <p>Aucun Seance pour le moment.</p>
            <%
                }
            %>

        </div>

    </div>

</section>

</body>
</html>
