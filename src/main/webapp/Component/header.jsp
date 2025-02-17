<%@ page import="model.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Blog News</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${pageContext.request.contextPath}/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${pageContext.request.contextPath}/Css/style.css" rel="stylesheet">
</head>

<body>
<!-- Header Start -->
<div class="container-fluid p-0">
    <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-2 py-lg-0 px-lg-5">
        <a href="#" class="navbar-brand d-block d-lg-none">
            <h1 class="m-0 display-4 text-uppercase text-primary">Biz<span
                    class="text-white font-weight-normal">News</span></h1>
        </a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between px-0 px-lg-3" id="navbarCollapse">
            <div class="navbar-nav mr-auto py-0">
                <a href="<%=request.getContextPath()%>/homepage" class="nav-item nav-link active">Home</a>
                <a href="<%=request.getContextPath()%>/homepage" class="nav-item nav-link">Contact</a>
            </div>
            <div class="input-group ml-auto d-none d-lg-flex" style="width: 100%; max-width: 300px;">
                <input type="text" class="form-control border-0" placeholder="Keyword">
                <div class="input-group-append">
                    <button class="input-group-text bg-primary text-dark border-0 px-3"><i
                            class="fa fa-search"></i></button>
                </div>
            </div>
            <% if (session.getAttribute("user") == null) { %>
            <a href="<%=request.getContextPath()%>/Login" class="nav-item nav-link">LOGIN</a>
            <% } else {
                User user = (User)session.getAttribute("user");
            %>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" style="margin-left: 18px; margin-right: 30px; outline: none"><img src="<%=request.getContextPath()%>/<%=user.getAvatar()%>" style="width: 30px; height: 30px; border-radius: 50%; object-fit: cover" alt="avatar"></a>
                <div class="dropdown-menu rounded-0 m-0">
                    <a href="<%=request.getContextPath()%>/UpdateProfile" class="dropdown-item">PROFILE</a>
                    <a href="<%=request.getContextPath()%>/Logout" class="dropdown-item">LOG OUT</a>
                    <% if (user.getRole().name().equalsIgnoreCase("admin")) { %>
                    <a href="<%=request.getContextPath()%>/Admin" class="dropdown-item">ADMIN PAGE</a>
                    <% } %>
                </div>
                <% } %>
            </div>
        </div>
    </nav>
</div>
<!-- Header End -->