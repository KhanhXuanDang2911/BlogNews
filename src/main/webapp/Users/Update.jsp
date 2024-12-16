<%@ page import="model.bean.User" %>
<%@ page import="model.bean.enums.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Component/header-admin.jsp"/>
<%User user = (User) request.getAttribute("user");%>
<div class="content-admin">
    <div class="manage-users">
        <div class="manage-user__block-title manage-block">
            <h1 class="manage-user__title title">Update User</h1>
        </div>
        <div class="add-user add-block">
            <form class="add-user__form add-form" action="<%= request.getContextPath() %>/UpdateUser" method="post">
                <input type="hidden" name="userId" id="userId" value="<%= user.getId() %>">

                <div class="add-form__content">
                    <div class="name">
                        <label for="Name">Name</label>
                        <input type="text" name="name" id="Name" value="<%= user.getName() %>" placeholder="Enter name">
                    </div>

                    <div class="phone-email">
                        <div class="phone">
                            <label for="Phone">Phone</label>
                            <input type="number" name="phone" id="Phone" <%if(user.getPhone() != null) {%> value="<%= user.getPhone() %>" <%}%> placeholder="Enter phone">
                        </div>
                        <div class="email">
                            <label for="Email">Email</label>
                            <input type="email" name="email" id="Email" <%if(user.getEmail() != null) {%> value="<%= user.getEmail() %>" <%}%> placeholder="Enter email">
                        </div>
                    </div>

                    <div class="role-balance">
                        <div class="role">
                            <label for="Role">Role</label>
                            <select name="role" id="Role">
                                <option value="USER" <%= user.getRole() == Role.USER ? "selected" : "" %>>User</option>
                                <option value="ADMIN" <%= user.getRole() == Role.ADMIN ? "selected" : "" %>>Admin</option>
                            </select>
                        </div>

                        <div class="status">
                            <label for="Status">Status</label>
                            <select name="is_active" id="Status">
                                <option value="true" <%= user.isActive() ? "selected" : "" %>>Active</option>
                                <option value="false" <%= !user.isActive() ? "selected" : "" %>>Inactive</option>
                            </select>
                        </div>
                    </div>

                    <div class="submit">
                        <input type="submit" value="Confirm">
                        <a href="./manage-user.html" class="btn__back">Back</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
