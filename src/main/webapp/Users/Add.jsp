<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Component/header-admin.jsp"/>

<div class="content-admin">
    <div class="manage-users">
        <div class="manage-user__block-title manage-block">
            <h1 class="manage-user__title title">Add New Users</h1>
        </div>
        <div class="add-user add-block">
            <form class="add-user__form add-form" action="<%= request.getContextPath() %>/CreateUser" method="post">
                <div class="add-form__content">
                    <div class="name">
                        <label for="Name">Name</label>
                        <input type="text" name="name" id="Name" placeholder="Enter name" required>
                    </div>

                    <div class="phone-email">
                        <div class="phone">
                            <label for="Phone">Phone</label>
                            <input type="number" name="phone" id="Phone" placeholder="Enter phone" required>
                        </div>
                        <div class="email">
                            <label for="Email">Email</label>
                            <input type="email" name="email" id="Email" placeholder="Enter email" required>
                        </div>
                    </div>

                    <div class="username-password">
                        <div class="username">
                            <label for="Username">Username</label>
                            <input type="text" name="username" id="Username" placeholder="Enter username" required>
                        </div>
                        <div class="password">
                            <label for="Password">Password</label>
                            <input type="password" name="password" id="Password" placeholder="Enter password" required>
                        </div>
                    </div>

                    <div class="role-balance">
                        <div class="role">
                            <label for="Role">Role</label>
                            <select name="role" id="Role" required>
                                <option value="USER">User</option>
                                <option value="ADMIN">Admin</option>
                            </select>
                        </div>
                        <div class="empty">
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