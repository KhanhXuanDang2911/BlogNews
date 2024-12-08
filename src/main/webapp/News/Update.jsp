<%@ page import="model.bean.News" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.bean.Category" %>
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
            <h1 class="manage-posts__title title">Update News</h1>
        </div>
        <%
            News news = (News) request.getAttribute("news");
            List<Category> listCategories = (List<Category>) request.getAttribute("listCategories");
        %>
        <div class="add-posts add-block">
            <form class="add-posts__form add-form" method="POST" enctype="multipart/form-data" action="<%=request.getContextPath()%>/UpdateNews">
                <div class="add-form__content">
                    <div class="id-posts">
                        <label for="id-news">ID</label>
                        <input type="text" name="id-news" id="id-news" value="<%=news.getId()%>" readonly>
                    </div>
                    <div class="title-posts">
                        <label for="Title-post">Title</label>
                        <input type="text" name="title" id="Title-post" placeholder="Enter title news" value="<%=news.getTitle()%>" required>
                    </div>
                    <div class="content-post">
                        <label for="Content-post">Content news</label>
                        <textarea name="content" id="Content-post" rows="50"
                                  placeholder="Enter content post" required><%=news.getContent()%></textarea>
                    </div>
                    <div class="category">
                        <label for="category">Category</label>
                        <select name="category_id" id="category" required>
                            <option value="<%=news.getCategory().getId()%>" selected><%=news.getCategory().getName()%></option>
                            <%
                                for (Category category : listCategories) {
                                    if(category.getId() != news.getCategory().getId()) { %>
                                        <option value="<%=category.getId()%>"><%=category.getName()%></option>
                                    <% }
                                } %>
                        </select>
                    </div>
                    <div class="status">
                        <label for="status">Status</label>
                        <select name="status" id="status" required>
                            <option value="<%=news.getStatus()%>"selected><%=news.getStatus()%></option>
                            <%
                                List<String> listStatus = new ArrayList<>();
                                listStatus.add("PENDING");
                                listStatus.add("ACCEPT");
                                listStatus.add("REJECTED");
                                listStatus.remove(news.getStatus());
                                for(String itemStatus : listStatus) { %>
                                    <option value="<%=itemStatus%>"><%=itemStatus%></option>
                                <% } %>
                        </select>
                    </div>
                    <div class="image">
                        <label for="image-news">Image</label>
                        <input type="file" name="image" id="image-news" placeholder="Choose image news">
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
