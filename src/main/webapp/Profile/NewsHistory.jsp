<%@ page import="model.bean.News" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>News History Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
          integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
    <style>
        .table th,
        .table td {
            white-space: nowrap; /* Tránh xuống dòng không cần thiết */
            overflow: hidden; /* Ẩn phần nội dung thừa */
            text-overflow: ellipsis; /* Hiển thị dấu ... */
            font-size: 14px;
        }

        .table th:nth-child(2),
        .table td:nth-child(2) {
            max-width: 150px; /* Tăng độ rộng cho cột Title */
        }

        .table th:nth-child(7),
        .table td:nth-child(7) {
            max-width: 170px; /* Độ rộng vừa phải cho cột Action */
        }
        .table th:nth-child(5),
        .table td:nth-child(5) {
            max-width: 70px; /* Độ rộng vừa phải cho cột Action */
        }

        .action-btn {
            margin-right: 4px;
            padding: 6px 10px;
            border-radius: 4px;
            font-size: 0.8rem;
            display: inline-flex;
            align-items: center;
            text-decoration: none;
            color: white;
            border: 1px solid transparent;
            transition: all 0.3s ease;
        }

        .action-btn i {
            margin-right: 4px;
        }

        .btn-add {
            background-color: #198754;
            border-color: #198754;
        }

        .btn-add:hover {
            background-color: #157347;
            border-color: #146c43;
        }

        .btn-update {
            background-color: #fd7e14;
            border-color: #fd7e14;
        }

        .btn-update:hover {
            background-color: #dc6a0a;
            border-color: #cc5805;
        }

        .btn-view {
            background-color: #0d6efd;
            border-color: #0d6efd;
        }

        .btn-view:hover {
            background-color: #0a58ca;
            border-color: #09429b;
        }

        .btn-delete {
            background-color: #dc3545;
            border-color: #dc3545;
        }

        .btn-delete:hover {
            background-color: #bb2d3b;
            border-color: #b02a37;
        }
    </style>

</head>

<body>
<div class="container-xl px-4 mt-4">
    <nav class="nav nav-borders">
        <a class="nav-link ms-0 active" href="<%=request.getContextPath()%>/UpdateProfile">Profile</a>
        <a class="nav-link" href="<%=request.getContextPath()%>/NewsHistory">News History</a>
        <a class="nav-link" href="<%=request.getContextPath()%>/ChangePassword">Change password</a>
        <a class="nav-link" href="<%=request.getContextPath()%>/homepage">Back to home</a>
    </nav>
    <hr class="mt-0 mb-4">

    <%
        List<News> listNews = (List<News>) request.getAttribute("listNews");
    %>
    <!-- News history card -->
    <div class="card mb-4">
        <div class="card-header d-flex justify-content-between align-items-center">
            <span>News History</span>
            <a href="<%=request.getContextPath()%>//CreateNewsForUser" class="action-btn btn-add"><i class="fas fa-plus"></i>Create news</a>
        </div>
        <div class="card-body p-0">
            <!-- News history table -->
            <div class="table-responsive table-billing-history">
                <table class="table mb-0">
                    <thead>
                    <tr>
                        <th class="border-gray-200" scope="col">ID</th>
                        <th class="border-gray-200" scope="col">Title</th>
                        <th class="border-gray-200" scope="col">Author</th>
                        <th class="border-gray-200" scope="col">Status</th>
                        <th class="border-gray-200" scope="col">Published at</th>
                        <th class="border-gray-200" scope="col">Category</th>
                        <th class="border-gray-200" scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (News news : listNews) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate = formatter.format(news.getPublishedAt());%>
                    <tr>
                        <td><%=news.getId()%></td>
                        <td><%=news.getTitle()%></td>
                        <td><%=news.getAuthor().getName()%></td>
                        <% if (news.getStatus().equals("PENDING")){%>
                        <td><span class="badge bg-light text-dark">Pending</span></td>
                        <% } %>
                        <% if (news.getStatus().equals("ACCEPT")) {%>
                        <td><span class="badge bg-success text-dark">ACCEPT</span></td>
                        <% } %>
                        <% if (news.getStatus().equals("REJECTED")) {%>
                        <td><span class="badge bg-danger text-dark">REJECTED</span></td>
                        <% } %>
                        <td><%=formattedDate%></td>
                        <td><%=news.getCategory().getName()%></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/UpdateNewsForUser?id=<%=news.getId()%>" class="action-btn btn-update"><i class="fas fa-edit"></i>Update</a>
                            <a href="<%=request.getContextPath()%>/NewsDetail?id_news=<%=news.getId()%>" class="action-btn btn-view"><i class="fas fa-eye"></i>View</a>
                            <a href="<%=request.getContextPath()%>/DeleteNews?id=<%=news.getId()%>" class="action-btn btn-delete"><i class="fas fa-trash"></i>Delete</a>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    function showMessage(message) {
        alert(message);
    }
</script>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) { %>
<script>
    window.onload = function(){
        showMessage("<%=message%>");
    };
</script>
<% } %>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
