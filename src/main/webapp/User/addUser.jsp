<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
</head>
<body>

<jsp:include page="../sidbar.jsp" />
<section class="home-section">
    <jsp:include page="../head.jsp" />
    <div class="content">
        <div class="container">
            <form action="${pageContext.request.contextPath}/addUser" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required><br>
                <label for="name">Prenom:</label>
                <input type="text" id="prenom" name="name" required><br>

                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>
                <label for="email">Adress:</label>
                <input type="text" id="adress" name="email" required><br>
                <label for="email">Tele:</label>
                <input type="text" id="tele" name="email" required><br>

                <input type="submit" value="Add User">
            </form>
        </div>
    </div>
</section>


</body>
</html>
