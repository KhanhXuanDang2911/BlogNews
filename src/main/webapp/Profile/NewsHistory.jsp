<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>bs5 profile billing page - Bootdey.com</title>
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

        .fa-2x {
            font-size: 2em;
        }

        .table-billing-history th,
        .table-billing-history td {
            padding-top: 0.75rem;
            padding-bottom: 0.75rem;
            padding-left: 1.375rem;
            padding-right: 1.375rem;
        }

        .table> :not(caption)>*>*,
        .dataTable-table> :not(caption)>*>* {
            padding: 0.75rem 0.75rem;
            background-color: var(--bs-table-bg);
            border-bottom-width: 1px;
            box-shadow: inset 0 0 0 9999px var(--bs-table-accent-bg);
        }

        .border-start-primary {
            border-left-color: #0061f2 !important;
        }

        .border-start-secondary {
            border-left-color: #6900c7 !important;
        }

        .border-start-success {
            border-left-color: #00ac69 !important;
        }

        .border-start-lg {
            border-left-width: 0.25rem !important;
        }

        .h-100 {
            height: 100% !important;
        }
    </style>
</head>

<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
      integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />

<div class="container-xl px-4 mt-4">
    <!-- Account page navigation-->
    <nav class="nav nav-borders">
        <a class="nav-link ms-0" href="index.jsp">Profile</a>
        <a class="nav-link active" href="NewsHistory.jsp">News History</a>
        <a class="nav-link" href="ChangePassword.jsp">Change password</a>
        <a class="nav-link" href="CreateNews.jsp">Create news</a>
    </nav>
    <hr class="mt-0 mb-4">
    <!-- news history card-->
    <div class="card mb-4">
        <div class="card-header">News History</div>
        <div class="card-body p-0">
            <!-- news history table-->
            <div class="table-responsive table-billing-history">
                <table class="table mb-0">
                    <thead>
                    <tr>
                        <th class="border-gray-200" scope="col">ID</th>
                        <th class="border-gray-200" scope="col">Date</th>
                        <th class="border-gray-200" scope="col">Title</th>
                        <th class="border-gray-200" scope="col">Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>#39201</td>
                        <td>06/15/2021</td>
                        <td>Title 1</td>
                        <td><span class="badge bg-light text-dark">Pending</span></td>
                    </tr>
                    <tr>
                        <td>#38594</td>
                        <td>05/15/2021</td>
                        <td>Title 2</td>
                        <td><span class="badge bg-success">Success</span></td>
                    </tr>
                    <tr>
                        <td>#38223</td>
                        <td>04/15/2021</td>
                        <td>Title 3</td>
                        <td><span class="badge bg-success">Success</span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">

</script>
</body>

</html>