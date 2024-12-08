<%@ page import="model.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .manage-categories__title{
        font-size: 3rem !important;
    }
</style>
<jsp:include page="../Component/header-admin.jsp"/>
<script>
    function showMessage(message) {
        alert(message);
    }
</script>
<div class="content-admin">
    <div class="manage-categories">
        <div class="manage-categories__block-title manage-block">
            <div class="manage-title-search">
                <h1 class="manage-categories__title title">Manage categories</h1>
            </div>
            <!-------Button trigger ADD NEW CATEGORY modal-------- -->
            <button type="button" class="btn-dashboard btn__add-categories" data-bs-toggle="modal"
                    data-bs-target="#modal__add-new-category" style="border: none;">
                <i class="fa-solid fa-plus"></i>Add new category
            </button>
            <!--------------- MODAL ADD NEW CATEGORY-------------- -->
            <div class="modal fade modal__add" id="modal__add-new-category">
                <div class="modal-dialog modal-dialog-centered">
                    <form class="modal-content" action="<%=request.getContextPath()%>/CreateCategory" method="post">
                        <div class="modal-header">
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <div class="name-category">
                                <label for="Name">Name Category</label>
                                <input type="text" name="name" id="Name" placeholder="Enter name category">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Confirm</button>
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">No</button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- --------------------------------------------------------------->

        </div>
        <div class="table">
            <table class="custom-table table__users" id="table-sort">
                <thead>
                <tr>
                    <th>ID Category</th>
                    <th>Name Category</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Category> listCategories = (List<Category>) request.getAttribute("listCategories");
                    if (listCategories!= null &&!listCategories.isEmpty()) {
                    for (Category category : listCategories) { %>
                <tr>
                    <td><%=category.getId()%></td>
                    <td><%=category.getName()%></td>
                    <td>
                        <!-- BUTTON TRIGGER UPDATE MODAL  -->
                        <button type="button" class="btn__modal" data-bs-toggle="modal"
                                data-bs-target="#modal__update-category" style="border: none;">
                            <i class="fa-solid fa-pen"></i>
                        </button>
                        <div class="modal fade modal__update" id="modal__update-category">
                            <div class="modal-dialog modal-dialog-centered">
                                <form class="modal-content" method="POST" action="<%=request.getContextPath()%>/UpdateCategory">
                                    <div class="modal-header">
                                        <button type="button" class="btn-close"
                                                data-bs-dismiss="modal"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="id-category">
                                            <label for="id-update">Name Category</label>
                                            <input type="text" name="id" id="id-update"
                                                   placeholder="Enter name category" readonly value="<%=category.getId()%>">
                                        </div>
                                        <div class="name-category">
                                            <label for="name-update">Name Category</label>
                                            <input type="text" name="name" id="name-update"
                                                   placeholder="Enter name category" required value="<%=category.getName()%>">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary">Confirm</button>
                                        <button type="button" class="btn btn-danger"
                                                data-bs-dismiss="modal">No</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <script>
                            function deleteCategory(id){
                                var choice = window.confirm("Are you sure you want to delete this category?");
                                if (choice) {
                                    window.location.href = "<%=request.getContextPath()%>/DeleteCategory?id=" + id;
                                }
                            }
                        </script>
                        <button style="outline: none; border: none; background-color: white" onclick="deleteCategory(<%=category.getId()%>)" type="button"><i class="fa-solid fa-trash"></i></button>
                </tr>
                <% }
                    } %>
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
<%
    String message = (String) request.getAttribute("message");
    if (message != null) { %>
<script>
    window.onload = function(){
        showMessage("<%=message%>");
    };
</script>
<% } %>
</body>
</html>
