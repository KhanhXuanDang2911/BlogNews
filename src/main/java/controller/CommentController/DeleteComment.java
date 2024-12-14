package controller.CommentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bo.CommentBO;

import java.io.IOException;

@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {

    private CommentBO commentBO = new CommentBO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        int id_news = Integer.parseInt(request.getParameter("id_news"));
        boolean isSuccess = commentBO.deleteComment(commentId);
        if (!isSuccess) {
            String message = "Delete comment failed";
            response.sendRedirect(request.getContextPath() + "/NewsDetail?id_news=" + id_news + "&message=" + message);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/NewsDetail?id_news=" + id_news);

    }
}
