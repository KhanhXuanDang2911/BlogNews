<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Admin</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <!-- BOOTSTRAP -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <!-- google-font -->
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <!-- RESET CSS -->
    <link rel="stylesheet" href="../Css/reset.css">
    <!-- font-awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="../Css/header-admin.css">
    <link rel="stylesheet" href="../Css/users.css">
    <link rel="stylesheet" href="../Css/AddUser.css">
    <link rel="stylesheet" href="../Css/Categories.css">
</head>

<body>
<div class="side-bar">
    <div class="sidebar_user_info">
        <div class="icon_setting"></div>
        <div class="user_profle_side">
            <div class="user_img"><img class="img-user-dashboard" src="../img/user_img.jpg" alt="#"></div>
            <div class="user_info">
                <h6>John David</h6>
                <p><span class="online_animation"></span> Online</p>
            </div>
        </div>
    </div>
    <div class="general-block">
        <h3 class="general-title">General</h3>
    </div>

    <nav class="side-bar__nav">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/Users" class="nav__link"><i class="fa-solid fa-user"></i>Users</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/News" class="nav__link"><i class="fa-solid fa-file"></i>News</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/Categories" class="nav__link"><i class="fa-solid fa-book"></i>Categories</a>
            <li>
                <a href="${pageContext.request.contextPath}/Logout" class="nav__link"><i class="fa-solid fa-right-from-bracket"></i>Log out</a>
            </li>
        </ul>
    </nav>
    <script>
        const navLinks = document.querySelectorAll('.side-bar__nav .nav__link');
        const currentUrl = window.location.href;

        navLinks.forEach(link => {
            link.classList.remove('active__side-navbar');
        });

        navLinks.forEach(link => {
            if (currentUrl.includes(link.href)) {
                link.classList.add('active__side-bar');
            }
        });
    </script>
</div>