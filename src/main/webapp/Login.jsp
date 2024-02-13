<%--
  Created by IntelliJ IDEA.
  User: Yassine
  Date: 19/01/2024
  Time: 01:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="link.jsp"/>
    <title>Login</title>
</head>
<body>
<div class="content">
    <div class="container login">
        <div class="roww">
            <div class="user-actions">
                <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
                    <div class="form_group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" class="form-control" required><br>
                    </div>

                    <div class="form_group">
                        <label for="password">Password:</label>
                        <input type="password" id="password" class="form-control" name="password" required><br>
                    </div>
                    <div class="form_group">
                        <input type="submit" class="btn btn-primary" class="form-control" value="Login">
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>

