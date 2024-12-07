
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Component/header-admin.jsp"/>
<div class="content-admin">
    <div class="manage-users">
        <div class="manage-user__block-title manage-block">
            <h1 class="manage-user__title title">Manage Users</h1>
            <a href="../html/add-users.html" class="btn-dashboard btn__add-users"><i
                    class="fa-solid fa-plus"></i>Add new user</a>
        </div>
        <div class="table">
            <table class="custom-table table__users">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>US123</td>
                    <td>Đặng Xuân Khánh</td>
                    <td>0912312412</td>
                    <td>caubesuuca123@gmail.com</td>
                    <td>xuankhanh2911</td>
                    <td>Admin</td>
                    <td><a href="../html/update-users.html"><i class="fa-solid fa-pen"></i></a>
                    </td>

                    <!-- ------------------------------------->
                </tr>

                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>10</b> out of <b>50</b> entries</div>
                <ul class="pagination">
                    <li class="page-item"><a href="#" class="page-link">Previous</a></li>
                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>

</html>
