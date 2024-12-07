
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .btn__add-posts{
        background-color: green;
    }
    .manage-posts__title{
        font-size: 3rem !important;
    }
</style>
<jsp:include page="../Component/header-admin.jsp"/>
<div class="content-admin">
    <div class="manage-posts">
        <div class="manage-posts__block-title manage-block">
            <h1 class="manage-posts__title title">Manage news</h1>
            <a href="../html/add-posts.html" class="btn-dashboard btn__add-posts"><i
                    class="fa-solid fa-plus"></i>Add new posts</a>
        </div>
        <div class="table">
            <table class="custom-table table__users">
                <thead>
                <tr>
                    <th>ID news</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>How to become the best developer</td>
                    <td>Dang Khanh</td>
                    <td><a href="##" title="View news"><i class="fa-solid fa-eye"></i></a>
                        <a href="#" title="Update news"><i
                                class="fa-solid fa-pen"></i></a>
                        <a href="" title="Delete news"><i class="fa-solid fa-trash"></i></a>
                    </td>
                </tr>

                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>10</b> out of <b>50</b> entries</div>
                <ul class="pagination">
                    <li class="page-item"><a href="#" class="page-link">Previous</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
