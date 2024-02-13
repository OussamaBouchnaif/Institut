<%@ page import="entity.Etudiant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Etudiant</title>
</head>
<body>

<jsp:include page="../sidbar.jsp"/>

<section class="home-section">
    <jsp:include page="../head.jsp" />
    <div class="content">
        <div class="container ">

            <a href="${pageContext.request.contextPath}/addEtudiant" class="btn btn-primary">Ajouter un Etudiant</a>


            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalAddGroupe">
                Ajouter Groupe
            </button>

            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalAddNiveau">
                Ajouter Niveau
            </button>

            <%
                List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants");
                if (etudiants != null) {

            %>

            <table id="todoTable" class="table table-hover mt-5" >
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Adress</th>
                    <th scope="col">Tele</th>
                    <th scope="col">Groupe</th>
                    <th scope="col">Niveau</th>
                    <th scope="col" class="text-center" colspan="2"> Actions </th>
                </tr>
                </thead>
                <tbody>
                    <%for (Etudiant e : etudiants) {
                        %>
                <tr>
                    <td><%= e.getId() %></td>
                    <td><%= e.getNom() %></td>
                    <td><%= e.getPrenom() %></td>
                    <td><%= e.getAdresse() %></td>
                    <td><%= e.getNumtele() %></td>
                    <td><%= e.getGroupe() %></td>
                    <td><%= e.getNiveau() %></td>
                    <td class="text-center"><a href="${pageContext.request.contextPath}/paiementEtudiant?id=<%= e.getId() %>"><i class="fa-solid fa-money-bill text-warning"></i></a></td>
                    <td class="text-center"><a href="${pageContext.request.contextPath}/deleteEtudiant?id=<%= e.getId() %>"><i class="fa-solid fa-trash text-danger"></i></a></td>
                    <td class="text-center"><a href="${pageContext.request.contextPath}/updateEtudiant?id=<%= e.getId() %>"><i  class="fa-solid fa-pen-to-square text-warning"></i></a></td>

                </tr>
                    <%

                        }
                    %>
                <tbody>
            </table>
            <%
            } else {
            %>
            <p>Aucun Etudiant pour le moment.</p>
            <%
                }
            %>

        </div>

    </div>

    <!-- Modal for Adding Groupe -->
    <div class="modal fade" id="modalAddGroupe" tabindex="-1" role="dialog" aria-labelledby="modalAddGroupeTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalAddGroupeTitle">Groupe</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/addgroupe" method="post" class="mx-auto" >
                        <div class="form_group">
                            <label>Nom du Groupe<span>*</span></label>
                            <input type="text" class="form-control" name="nomGroupe" required />
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <!-- Modal for Adding Niveau -->
    <div class="modal fade" id="modalAddNiveau" tabindex="-1" role="dialog" aria-labelledby="modalAddNiveauTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalAddNiveauTitle">Niveau</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/addNiveau" method="post" class="mx-auto">
                        <div class="form_group">
                            <label>Nom du Niveau<span>*</span></label>
                            <input type="text" class="form-control" name="nomNiveau" required />
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</section>

</body>
</html>
