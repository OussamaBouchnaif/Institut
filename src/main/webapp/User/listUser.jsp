<%@ page import="java.util.List" %>
<%@ page import="entity.Salle" %>
<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/4598e20a86.js" crossorigin="anonymous"></script>
    <title>Liste des Salles</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>

    <jsp:include page="../sidbar.jsp" />

    <section class="home-section">
        <jsp:include page="../head.jsp" />
        <div class="content">
            <div class="container">
                <%
                    List<User> users = (List<User>) request.getAttribute("users");
                    if (users != null) {
                %>
                <a href="${pageContext.request.contextPath}/addUser" class="btn btn-primary mt-5">Ajouter User</a>

                <table class="table table-bordered mt-5">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>prenom</th>
                        <th>Email</th>
                        <th>adress</th>
                        <th>Telephone</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (User user : users) { %>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getNom() %></td>
                        <td><%= user.getPrenom() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getAdresse() %></td>
                        <td><%= user.getNumeroTelephone() %></td>



                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/DeleteUser?id=<%= user.getId() %>">
                                <i class="fa-solid fa-trash text-danger"></i>
                            </a>
                        </td>
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/updateUser?id=<%= user.getId() %>">
                                <i class="fa-solid fa-pen-to-square text-warning"></i>
                            </a>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
            <%
                }
            %>

        </div>

    </section>




</body>
</html>
