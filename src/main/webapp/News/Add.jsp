<%@ page import="model.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .manage-posts__title{
        font-size: 3rem !important;
    }
</style>
<jsp:include page="../Component/header-admin.jsp"/>
<div class="content-admin">
    <div class="manage-posts">
        <div class="manage-posts__block-title manage-block">
            <h1 class="manage-posts__title title">Add News</h1>
        </div>
        <%
            List<Category> listCategories = (List<Category>) request.getAttribute("listCategories");
        %>
        <div class="add-posts add-block">
            <form class="add-posts__form add-form" method="POST" enctype="multipart/form-data" action="<%=request.getContextPath()%>/CreateNews">
                <div class="add-form__content">
                    <div class="title-posts">
                        <label for="Title-post">Title</label>
                        <input type="text" name="title" id="Title-post" placeholder="Enter title posts" required>
                    </div>
                    <div class="content-post">
                        <label for="Content-post">Content news</label>
                        <textarea name="content" id="Content-post" rows="50"
                                  placeholder="Enter content post" required></textarea>
                    </div>
                    <div class="category">
                        <label for="category">Image</label>
                        <select name="category_id" id="category" required>
                            <%
                                for (int i = 0; i < listCategories.size(); i++) {
                                    if(i == 0) { %>
                            <option value="<%=listCategories.get(i).getId()%>" selected><%=listCategories.get(i).getName()%></option>
                            <% } else { %>
                            <option value="<%=listCategories.get(i).getId()%>"><%=listCategories.get(i).getName()%></option>

                            <% } }%>
                        </select>
                    </div>
                    <div class="image">
                        <label for="image-news">Image</label>
                        <input type="file" name="image" id="image-news" placeholder="Choose image news" required>
                    </div>
                    <div class="submit">
                        <input type="submit" value="Confirm">
                        <a href="<%=request.getContextPath()%>/ListNews" class="btn__back">Back</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="//cdn.ckeditor.com/4.22.1/full/ckeditor.js"></script>
<script>
    CKEDITOR.replace('content');
    config.height = 500;
</script>
</body>
</html>
