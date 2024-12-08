package controller.CommentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Comment;
import model.bo.CommentBO;

import java.io.IOException;

@WebServlet("/comments/add")
public class AddComment extends HttpServlet {
    private CommentBO commentBO = new CommentBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Comments/Add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long userId = (Long) request.getSession().getAttribute("id");
        long articleId = Long.parseLong(request.getParameter("article_id"));
        String content = request.getParameter("content");

        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setArticleId(articleId);
        comment.setContent(content);

        try {
            boolean isSuccess = commentBO.addComment(comment);
            if (isSuccess) {
                System.out.println("Comment added successfully");
            } else {
                System.out.println("Comment could not be added");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("/news");
    }
}
