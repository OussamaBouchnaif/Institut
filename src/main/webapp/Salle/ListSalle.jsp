<%@ page import="java.util.List" %>
<%@ page import="entity.Salle" %>
<%@ page import="Services.SalleService" %>
<%@ page import="entity.Factory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Liste des Salles</title>
</head>
<body>
<jsp:include page="../sidbar.jsp" />
<section class="home-section">
    <jsp:include page="../head.jsp" />
    <div class="content">
        <div class="container">

            <a href="${pageContext.request.contextPath}/addSalle" class="btn btn-primary mt-5">Ajouter une Salle</a>

            <%
                List<Salle> salles = (List<Salle>) request.getAttribute("salles");
                if (salles != null) {

            %>

            <table id="salleTable" class="table table-hover mt-5" >
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nom de la Salle</th>
                    <th scope="col">Capacité</th>
                    <th scope="col" class="text-center" colspan="2">Actions</th>
                </tr>
                </thead>
                <tbody>
                <%for (Salle salle : salles) {
                %>
                <tr>
                    <td><%= salle.getId() %></td>
                    <td><%= salle.getNomSalle() %></td>
                    <td><%= salle.getCapacite() %></td>
                    <td class="text-center"><a href="${pageContext.request.contextPath}/deleteSalle?id=<%= salle.getId() %>"><i class="fa-solid fa-trash text-danger"></i></a></td>
                    <td class="text-center"><a href="${pageContext.request.contextPath}/updateSalle?id=<%= salle.getId() %>"><i class="fa-solid fa-pen-to-square text-warning"></i></a></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
            <%
            } else {
            %>
            <p>Aucune Salle disponible pour le moment.</p>
            <%
                }
            %>

        </div>

    </div>

</section>

</body>
</html>
