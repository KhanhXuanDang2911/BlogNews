
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .manage-categories__title{
        font-size: 3rem !important;
    }
</style>
<jsp:include page="../Component/header-admin.jsp"/>
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
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <div class="name-category">
                                <label for="Name">Name Category</label>
                                <input type="text" name="Name" id="Name" placeholder="Enter name category">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="../html/manage-category.html" class="btn btn-primary">Confirm</a>
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">No</button>
                        </div>
                    </div>
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
                <tr>
                    <td>1</td>
                    <td>Data Science</td>
                    <td>
                        <!-- BUTTON TRIGGER UPDATE MODAL  -->
                        <button type="button" class="btn__modal" data-bs-toggle="modal"
                                data-bs-target="#modal__update-category" style="border: none;">
                            <i class="fa-solid fa-pen"></i>
                        </button>
                        <!--------------- MODAL UPDATE CHAPTER-------------- -->
                        <div class="modal fade modal__update" id="modal__update-category">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="btn-close"
                                                data-bs-dismiss="modal"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="name-category">
                                            <label for="Name">Name Category</label>
                                            <input type="text" name="Name" id="Name"
                                                   placeholder="Enter name category">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="../html/manage-category.html"
                                           class="btn btn-primary">Confirm</a>
                                        <button type="button" class="btn btn-danger"
                                                data-bs-dismiss="modal">No</button>
                                    </div>
                                </div>
                            </div>
                        </div>
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
