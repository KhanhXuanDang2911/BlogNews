<%@ page import="model.bean.User" %>
<%@ page import="java.util.*" %>
<%@ page import="model.bean.enums.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Component/header-admin.jsp"/>
<div class="content-admin">
    <div class="manage-users">
        <div class="manage-user__block-title manage-block">
            <h1 class="manage-user__title title">Manage Users</h1>
            <a href="<%= request.getContextPath() %>/CreateUser" class="btn-dashboard btn__add-users">
                <i class="fa-solid fa-plus"></i>Add new user
            </a>
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
                <%
                    List<User> listUsers;
                    listUsers = (List<User>) request.getAttribute("users");
                    if (listUsers != null && !listUsers.isEmpty()) {
                        for (User user : listUsers) {
                %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td>
                        <%= user.getName() %>
                    </td>

                    <td><%= user.getPhone() ==  null ? "Chưa cập nhật" : user.getPhone()%></td>
                    <td><%= user.getEmail() ==  null ? "Chưa cập nhật" : user.getEmail()%></td>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getRole() ==  Role.USER ? "User" : "Admin" %></td>
                    <td>
                        <a href="<%= request.getContextPath() %>/UpdateUser?id=<%= user.getId() %>" title="Update user">
                            <i class="fa-solid fa-pen"></i>
                        </a>
                        <a href="<%= request.getContextPath() %>/DeleteUser?id=<%= user.getId() %>"
                           title="Delete user"
                           onclick="return confirmDelete()">
                            <i class="fa-solid fa-trash"></i>
                        </a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
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
<script>
    function confirmDelete() {
        return confirm("Are you sure you want to delete this user?");
    }
</script>
</body>
</html>
