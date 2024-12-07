
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
        <div class="add-posts add-block">
            <form class="add-posts__form add-form">
                <div class="add-form__content">
                    <div class="title-posts">
                        <label for="Title-post">Title</label>
                        <input type="text" name="Title" id="Title-post" placeholder="Enter title posts" required>
                    </div>
                    <div class="content-post">
                        <label for="Content-post">Content news</label>
                        <textarea name="Content" id="Content-post" rows="50"
                                  placeholder="Enter content post"></textarea>
                    </div>
                    <div class="image">
                        <label for="image-news">Image</label>
                        <input type="file" name="Title" id="image-news" placeholder="Choose image news" required>
                    </div>
                    <div class="submit">
                        <input type="submit" value="Confirm">
                        <a href="#" class="btn__back">Back</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="//cdn.ckeditor.com/4.22.1/full/ckeditor.js"></script>
<script>
    CKEDITOR.replace('Content');
    config.height = 500;
</script>
</body>
</html>
