<%@ page import="model.bean.News" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
<script>
    function showMessage(message) {
        alert(message);
    }
</script>
<div class="content-admin">
    <div class="manage-posts">
        <div class="manage-posts__block-title manage-block">
            <h1 class="manage-posts__title title">Manage news</h1>
            <a href="<%=request.getContextPath()%>/CreateNews" class="btn-dashboard btn__add-posts"><i
                    class="fa-solid fa-plus"></i>Add news</a>
        </div>
        <div class="table">
            <table class="custom-table table__users">
                <thead>
                <tr>
                    <th>ID news</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Status</th>
                    <th>Published at</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<News> listNews = (List<News>) request.getAttribute("listNews");
                    if (listNews != null && !listNews.isEmpty()) {
                        for (News news : listNews) {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String formattedDate = formatter.format(news.getPublishedAt());
                %>
                <tr>
                    <td><%=news.getId()%></td>
                    <td><%=news.getTitle()%></td>
                    <td><%=news.getAuthorId()%></td>
                    <td><%=news.getStatus()%></td>
                    <td><%=formattedDate%></td>
                    <td><%=news.getCategory().getName()%></td>
                    <td><a href="<%=request.getContextPath()%>/NewsDetail?id_news=<%=news.getId()%>" title="View news"><i class="fa-solid fa-eye"></i></a>
                        <a href="<%=request.getContextPath()%>/UpdateNews?id=<%=news.getId()%>" title="Update news"><i
                                class="fa-solid fa-pen"></i></a>
                        <a href="<%=request.getContextPath()%>/DeleteNews?id=<%=news.getId()%>" title="Delete news"><i class="fa-solid fa-trash"></i></a>
                    </td>
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
