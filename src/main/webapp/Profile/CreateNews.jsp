<%@ page import="model.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">

    <title>Create News</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            margin-top: 20px;
            background-color: #f2f6fc;
            color: #69707a;
        }

        .img-account-profile {
            height: 10rem;
        }

        .rounded-circle {
            border-radius: 50% !important;
        }

        .card {
            box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
        }

        .card .card-header {
            font-weight: 500;
        }

        .card-header:first-child {
            border-radius: 0.35rem 0.35rem 0 0;
        }

        .card-header {
            padding: 1rem 1.35rem;
            margin-bottom: 0;
            background-color: rgba(33, 40, 50, 0.03);
            border-bottom: 1px solid rgba(33, 40, 50, 0.125);
        }

        .form-control,
        .dataTable-input {
            display: block;
            width: 100%;
            padding: 0.875rem 1.125rem;
            font-size: 0.875rem;
            font-weight: 400;
            line-height: 1;
            color: #69707a;
            background-color: #fff;
            background-clip: padding-box;
            border: 1px solid #c5ccd6;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            border-radius: 0.35rem;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
        }

        .nav-borders .nav-link.active {
            color: #0061f2;
            border-bottom-color: #0061f2;
        }

        .nav-borders .nav-link {
            color: #69707a;
            border-bottom-width: 0.125rem;
            border-bottom-style: solid;
            border-bottom-color: transparent;
            padding-top: 0.5rem;
            padding-bottom: 0.5rem;
            padding-left: 0;
            padding-right: 0;
            margin-left: 1rem;
            margin-right: 1rem;
        }

        .btn-danger-soft {
            color: #000;
            background-color: #f1e0e3;
            border-color: #f1e0e3;
        }
    </style>
</head>

<body>
<div class="container-xl px-4 mt-4">
    <!-- Account page navigation-->
    <nav class="nav nav-borders">
        <a class="nav-link ms-0 active" href="<%=request.getContextPath()%>/UpdateProfile">Profile</a>
        <a class="nav-link" href="<%=request.getContextPath()%>/NewsHistory">News History</a>
        <a class="nav-link" href="<%=request.getContextPath()%>/ChangePassword">Change password</a>
        <a class="nav-link" href="<%=request.getContextPath()%>/homepage">Back to home</a>

    </nav>
    <hr class="mt-0 mb-4">
    <div class="row">
        <div class="col-lg-12">
            <!-- Create news card-->
            <%
                List<Category> listCategories = (List<Category>) request.getAttribute("listCategories");
                System.out.println(listCategories);
            %>
            <div class="card mb-4">
                <div class="card-header">Create News</div>
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/CreateNewsForUser" method="POST" enctype="multipart/form-data">
                        <div class="mb-3">
                            <label class="small mb-1" for="titleNews">Title</label>
                            <input class="form-control" id="titleNews" name="title" type="text"
                                   placeholder="Enter title news">
                        </div>
                        <div class="mb-3">
                            <label class="small mb-1" for="contentNews">Content</label>
                            <textarea class="form-control" id="contentNews" name="content" rows="20"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="category">Image</label>
                            <select name="category_id" id="category" required class ="form-control">
                                <%
                                    for (int i = 0; i < listCategories.size(); i++) {
                                        if(i == 0) { %>
                                <option value="<%=listCategories.get(i).getId()%>" selected><%=listCategories.get(i).getName()%></option>
                                <% } else { %>
                                <option value="<%=listCategories.get(i).getId()%>"><%=listCategories.get(i).getName()%></option>

                                <% } }%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="small mb-1" for="imageNews">Image</label>
                            <input class="form-control" id="imageNews" name="image" type="file"
                                   placeholder="Choose file">
                        </div>
                        <button class="btn btn-primary" type="submit">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
</script>
<script src="//cdn.ckeditor.com/4.22.1/full/ckeditor.js"></script>
<script>
    CKEDITOR.replace('content');
</script>
</body>

</html>