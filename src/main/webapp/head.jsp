<%--
  Created by IntelliJ IDEA.
  User: oussa
  Date: 14/01/2024
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/Style/style.css">
</head>
<body>

    <div class="head">
        <div class="home-content">
            <i class='bx bx-menu' ></i>

        </div>
        <div class="action">
            <div class="profile" onclick="menuToggle();">
                <img src="image/IMG_0390.JPG" alt="">
            </div>

            <div class="menu">
                <h3>
                    OUSSAMA BOUCHNAIF
                    <div>
                        Devlopper Web
                    </div>
                </h3>
                <ul>
                    <li>
                        <i class='bx bx-user'></i>
                        <a href="#">Profile</a>
                    </li>
                    <li>
                        <i class='bx bx-edit'></i>
                        <a href="#">Edit Account</a>
                    </li>
                    <li>
                        <i class='bx bx-log-out' ></i>
                        <a href="#">Log out</a>
                    </li>

                </ul>
            </div>
        </div>
        <script>
            function menuToggle(){
                const toggleMenu = document.querySelector('.menu');
                toggleMenu.classList.toggle('active')
            }
        </script>

    </div>
</body>
</html>
