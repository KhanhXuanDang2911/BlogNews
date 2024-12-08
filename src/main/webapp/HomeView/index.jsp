<%@ page import="model.bean.News" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.bean.Category" %>
<jsp:include page="/Component/header.jsp"/>
<!-- Main News Slider Start -->
<div class="container-fluid">
    <div class="row">
        <div class="col-12 px-0">
            <div class="owl-carousel main-carousel position-relative">
                <div class="position-relative overflow-hidden" style="height: 500px;">
                    <img class="img-fluid h-100" src="<%=request.getContextPath()%>/Images/slide1.jpg"
                         style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                               href="">Business</a>
                            <a class="text-white" href="">August 2024</a>
                        </div>
                    </div>
                </div>
                <div class="position-relative overflow-hidden" style="height: 500px;">
                    <img class="img-fluid h-100" src="<%=request.getContextPath()%>/Images/slide2.jpg"
                         style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                               href="">Business</a>
                            <a class="text-white" href="">August 2024</a>
                        </div>
                    </div>
                </div>
                <div class="position-relative overflow-hidden" style="height: 500px;">
                    <img class="img-fluid h-100" src="<%=request.getContextPath()%>/Images/slide3.jpg"
                         style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                               href="">Business</a>
                            <a class="text-white" href="">August 2024</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Main News Slider End -->

<%
    List<News> listNews = (List<News>) request.getAttribute("listNews");
    List<News> featuredNews = (List<News>) request.getAttribute("featuredNews");
    List<Category> listCategories = (List<Category>) request.getAttribute("listCategories");
%>
<!-- Featured News Slider Start -->
<div class="container-fluid pt-5 mb-3">
    <div class="container">
        <div class="section-title">
            <h4 class="m-0 text-uppercase font-weight-bold">Featured News</h4>
        </div>
        <div class="owl-carousel news-carousel carousel-item-4 position-relative">
            <%
                int size = Math.min(featuredNews.size(), 6);
                for (int i = 0; i < size; i++) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = formatter.format(featuredNews.get(i).getPublishedAt());
            %>
            <div class="position-relative overflow-hidden" style="height: 300px;">
                <img class="img-fluid h-100" src="<%=request.getContextPath()%>/<%=featuredNews.get(i).getImage()%>"
                     style="object-fit: cover;">
                <div class="overlay">
                    <div class="mb-2">
                        <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                           href=""><%=featuredNews.get(i).getCategory().getName()%>
                        </a>
                        <a class="text-white" href=""><small><%=formattedDate%>
                        </small></a>
                    </div>
                    <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold"
                       href="<%=request.getContextPath()%>/NewsDetail?id_news=<%=featuredNews.get(i).getId()%>"><%=featuredNews.get(i).getTitle()%>
                    </a>
                </div>
            </div>
            <% } %>
        </div>
    </div>
</div>
<!-- Featured News Slider End -->


<!-- News With Sidebar Start -->
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-8">
                <div class="row">
                    <div class="col-12">
                        <div class="section-title">
                            <h4 class="m-0 text-uppercase font-weight-bold">Latest News</h4>
                            <a class="text-secondary font-weight-medium text-decoration-none" href="<%=request.getContextPath()%>/homepage">View All</a>
                        </div>
                    </div>
                    <%
                        for (News news : listNews) {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            String formattedDate = formatter.format(news.getPublishedAt()); %>
                    <div class="col-lg-6">
                        <div class="position-relative mb-3">
                            <img class="img-fluid w-100" src="<%=request.getContextPath()%><%=news.getImage()%>"
                                 style="object-fit: cover;">
                            <div class="bg-white border border-top-0 p-4">
                                <div class="mb-2">
                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                                       href=""><%=news.getCategory().getName()%>
                                    </a>
                                    <a class="text-body" href=""><small><%=formattedDate%>
                                    </small></a>
                                </div>
                                <a class="h4 d-block mb-3 text-secondary text-uppercase font-weight-bold"
                                   href="<%=request.getContextPath()%>/NewsDetail?id_news=<%=news.getId()%>"><%=news.getTitle()%>
                                </a>
                                <div class="content" style="
                                     display: -webkit-box;
                                    -webkit-box-orient: vertical;
                                    overflow: hidden;
                                    text-overflow: ellipsis;
                                    -webkit-line-clamp: 3;
                                    line-clamp: 3;
                                    max-width: 400px; /* Đặt chiều rộng cho thẻ cha */">
                                    <%=news.getContent()%>
                                </div>

                            </div>
                            <div class="d-flex justify-content-between bg-white border border-top-0 p-4">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle mr-2" src="<%=request.getContextPath()%>/Images/user.jpg"
                                         width="25" height="25"
                                         alt="">
                                    <small>John Doe</small>
                                </div>
                                <div class="d-flex align-items-center">
                                    <small class="ml-3"><i class="far fa-eye mr-2"></i>12345</small>
                                    <small class="ml-3"><i class="far fa-comment mr-2"></i>123</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <% } %>
                </div>
            </div>
            <div class="col-4">
                <%--                Categories Start--%>
                <div class="mb-3">
                    <div class="section-title mb-0">
                        <h4 class="m-0 text-uppercase font-weight-bold">Categories</h4>
                    </div>
                    <div class="bg-white border border-top-0 p-3">
                        <div class="d-flex flex-wrap m-n1">
                            <%
                                for (Category category : listCategories) { %>
                                    <a href="<%=request.getContextPath()%>/homepage?category_id=<%=category.getId()%>" class="btn btn-sm btn-outline-secondary m-1"><%=category.getName()%></a>
                            <% } %>
                            <a href="<%=request.getContextPath()%>/homepage" class="btn btn-sm btn-outline-secondary m-1">All</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- News With Sidebar End -->
<jsp:include page="/Component/footer.jsp"/>
