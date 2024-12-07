
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Component/header-admin.jsp"/>
<div class="content-admin">
    <div class="manage-users">
        <div class="manage-user__block-title manage-block">
            <h1 class="manage-user__title title">Add New Users</h1>
        </div>
        <div class="add-user add-block">
            <form class="add-user__form add-form">
                <div class="add-form__content">
                    <div class="name">
                        <label for="Name">Name</label>
                        <input type="text" name="Name" id="Name" placeholder="Enter name">
                    </div>
                    <div class="phone-email">
                        <div class="phone">
                            <label for="Phone">Phone</label>
                            <input type="number" name="Phone" id="Phone" placeholder="Enter phone">
                        </div>
                        <div class="email">
                            <label for="Email">Email</label>
                            <input type="email" name="Email" id="Email" placeholder="Enter email">
                        </div>
                    </div>
                    <div class="username-password">
                        <div class="username">
                            <label for="Username">Username</label>
                            <input type="text" name="Username" id="Username" placeholder="Enter username">
                        </div>
                        <div class="password">
                            <label for="Password">Password</label>
                            <input type="password" name="Password" id="Password" placeholder="Enter password">
                        </div>
                    </div>
                    <div class="role-balance">
                        <div class="role">
                            <label for="Role">Role</label>
                            <select name="Role" id="Role">
                                <option value="Teacher">User</option>
                                <option value="Student">Admin</option>
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
