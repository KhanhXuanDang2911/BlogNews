<%@ page import="model.bean.News" %>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.Category" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.bean.Comment" %>
<%@ page import="model.bean.User" %>
<jsp:include page="../Component/header.jsp"/>
<!-- News With Sidebar Start -->
<div class="container-fluid" style="margin-top: 70px">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <%
                    List<Comment> listComments = (List<Comment>)request.getAttribute("listComments");
                     News news = (News) request.getAttribute("news");
                     List<News> listNews = (List<News>) request.getAttribute("listNews");
                     List<Category> listCategories = (List<Category>) request.getAttribute("listCategories");
                %>
                <!-- News Detail Start -->
                <div class="position-relative mb-3">
                    <img class="img-fluid w-100" src="<%=request.getContextPath()%><%=news.getImage()%>" style="object-fit: cover; height: 480px">
                    <div class="bg-white border border-top-0 p-4">
                        <div class="mb-3">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                               href=""><%=news.getCategory().getName()%></a>
                            <%
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                String formattedDate = formatter.format(news.getPublishedAt());
                            %>
                            <a class="text-body" href=""><%=formattedDate%></a>
                        </div>
                        <h1 class="mb-3 text-secondary text-uppercase font-weight-bold"><%=news.getTitle()%></h1>
                        <%=news.getContent()%>

                    </div>
                    <div class="d-flex justify-content-between bg-white border border-top-0 p-4">
                        <div class="d-flex align-items-center">
                            <img class="rounded-circle mr-2" src="<%=request.getContextPath()%>/<%=news.getAuthor().getAvatar()%>" width="25" height="25" alt="">
                            <span><%=news.getAuthor().getName()%></span>
                        </div>
                        <div class="d-flex align-items-center">
                            <span class="ml-3"><i class="far fa-eye mr-2"></i>12</span>
                            <span class="ml-3"><i class="far fa-comment mr-2"></i><%=listComments != null ? listComments.size() : 0%></span>
                        </div>
                    </div>
                </div>
                <!-- News Detail End -->

                <!-- Comment List Start -->
                <script>
                    function confirmDelete(event) {
                        const confirmed = confirm("Are you sure you want to delete this comment?");
                        if (!confirmed) {
                            event.preventDefault(); // Hủy hành động submit nếu người dùng nhấn "Cancel"
                        }
                        return confirmed; // Trả về true nếu người dùng nhấn "OK", form sẽ tiếp tục submit
                    }
                </script>

                <div class="mb-3">
                    <div class="section-title mb-0">
                        <h4 class="m-0 text-uppercase font-weight-bold"><%= listComments != null ? listComments.size() : 0 %> Comments</h4>
                    </div>
                    <% User userSession = (User) session.getAttribute("user"); %>
                    <div class="bg-white border border-top-0 p-4">
                        <% if (listComments != null && !listComments.isEmpty()) {
                            for (Comment comment : listComments) {
                                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                                String formattedDate1 = formatter1.format(comment.getCreated_at()); %>
                        <div class="media mb-4">
                            <img src="<%=request.getContextPath()%>/<%=comment.getAuthor().getAvatar()%>" alt="Avatar" class="img-fluid mr-3 mt-1" style="width: 45px;">
                            <div class="media-body">
                                <h6>
                                    <a class="text-secondary font-weight-bold" href="#"><%=comment.getAuthor().getName()%></a>
                                    <small><i><%=formattedDate1%></i></small>
                                </h6>
                                <p><%=comment.getContent()%></p>
                                <!-- Buttons for Edit and Delete -->
                                <% if ((userSession != null && userSession.getId() == comment.getAuthor().getId()) || userSession.getRole().name().equalsIgnoreCase("ADMIN")) {%>
                                <button class="btn btn-sm btn-warning" data-toggle="modal" data-target="#editCommentModal-<%=comment.getId()%>">
                                    <i class="fas fa-edit"></i> Edit
                                </button>
                                <form action="<%=request.getContextPath()%>/DeleteComment" method="POST" style="display: inline;" onsubmit="return confirmDelete(event);">
                                    <input type="hidden" name="id_news" value="<%=news.getId()%>">
                                    <input type="hidden" name="commentId" value="<%=comment.getId()%>">
                                    <button type="submit" class="btn btn-sm btn-danger">
                                        <i class="fas fa-trash-alt"></i> Delete
                                    </button>
                                </form>
                                <% }%>

                            </div>
                        </div>

                        <!-- Modal for Editing Comment -->
                        <div class="modal fade" id="editCommentModal-<%=comment.getId()%>" tabindex="-1" role="dialog" aria-labelledby="editCommentModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="editCommentModalLabel">Edit Comment</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <form action="<%=request.getContextPath()%>/UpdateComment" method="POST">
                                        <div class="modal-body">
                                            <input type="hidden" name="commentId" value="<%=comment.getId()%>">
                                            <input type="hidden" name="id_news" value="<%=news.getId()%>">
                                            <div class="form-group">
                                                <label for="edit-comment-content">Content</label>
                                                <textarea id="edit-comment-content" name="content" rows="4" class="form-control"><%=comment.getContent()%></textarea>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                            <button type="submit" class="btn btn-primary">Save Changes</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- End Modal -->
                        <% }
                        } else { %>
                        <p>No comments yet</p>
                        <% } %>
                    </div>
                </div>
                <!-- Comment List End -->


                <!-- Comment Form Start -->
                <div class="mb-3">
                    <div class="section-title mb-0">
                        <h4 class="m-0 text-uppercase font-weight-bold">Leave a comment</h4>
                    </div>
                    <div class="bg-white border border-top-0 p-4">
                        <form action="<%=request.getContextPath()%>/AddComment" method="POST">
                            <input type="hidden" name="id-news" readonly value="<%=news.getId()%>">
                            <div class="form-group">
                                <label for="message">Message *</label>
                                <textarea id="message" name="content" cols="30" rows="5" class="form-control"></textarea>
                            </div>
                            <div class="form-group mb-0">
                                <input type="submit" value="Leave a comment"
                                       class="btn btn-primary font-weight-semi-bold py-2 px-3">
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Comment Form End -->
            </div>
            <div class="col-4">
                <div class="mb-3">
                    <div class="section-title mb-0">
                        <h4 class="m-0 text-uppercase font-weight-bold">Trending News</h4>
                    </div>
                    <div class="bg-white border border-top-0 p-3">
                        <% for (News item : listNews) {
                            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                            String formattedDate1 = formatter1.format(item.getPublishedAt());
                        %>
                        <div class="d-flex align-items-center bg-white mb-3" style="height: 110px;">
                            <img class="img-fluid" src="<%=request.getContextPath()%><%=item.getImage()%>" alt="#"
                                style="width: 100px; height:100%; object-fit: cover"
                            >
                            <div
                                    class="w-100 h-100 px-3 d-flex flex-column justify-content-center border border-left-0">
                                <div class="mb-2">
                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-1 mr-2"
                                       href=""><%=item.getCategory().getName()%></a>
                                    <a class="text-body" href=""><small><%=formattedDate1%></small></a>
                                </div>
                                <div style="
                                     display: -webkit-box;
                                    -webkit-box-orient: vertical;
                                    overflow: hidden;
                                    text-overflow: ellipsis;
                                    -webkit-line-clamp: 3;
                                    line-clamp: 3;
                                    max-width: 400px; /* Đặt chiều rộng cho thẻ cha */">
                                    <a class="h6 m-0 text-secondary text-uppercase font-weight-bold" href="<%=request.getContextPath()%>/NewsDetail?id_news=<%=item.getId()%>"><%=item.getTitle()%></a>
                                </div>
                            </div>
                        </div>
                        <% } %>
                    </div>
                </div>
                <%--                Categories Start--%>
                <div class="mb-3">
                    <div class="section-title mb-0">
                        <h4 class="m-0 text-uppercase font-weight-bold">Categories</h4>
                    </div>
                    <div class="bg-white border border-top-0 p-3">
                        <div class="d-flex flex-wrap m-n1">
                            <%
                                for (Category category : listCategories) { %>
                            <a href="<%=request.getContextPath()%>/homepage?category_id=<%=category.getId()%>" class="btn btn-sm btn-outline-secondary m-1" style="text-transform: capitalize"><%=category.getName()%></a>
                            <% } %>
                            <a href="<%=request.getContextPath()%>/homepage" class="btn btn-sm btn-outline-secondary m-1">All</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    const navLinks = document.querySelectorAll('.navbar-nav .nav-link');

    navLinks.forEach(link => link.classList.remove('active'));

    const newsDetailLink = Array.from(navLinks).find(link => link.textContent.trim() === 'News Detail');
    if (newsDetailLink) {
        newsDetailLink.classList.add('active');
    }

</script>
<!-- News With Sidebar End -->
<jsp:include page="../Component/footer.jsp"/>
