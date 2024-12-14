package controller.CommentController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.User;
import model.bean.Comment;
import model.bo.CommentBO;

import java.io.IOException;
import java.util.Date;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
    private CommentBO commentBO = new CommentBO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id_news = Integer.parseInt(request.getParameter("id-news"));
            String content = request.getParameter("content");
            Comment comment = new Comment(0, (User) request.getSession().getAttribute("user"), id_news, content, new Date());
            boolean check = commentBO.addComment(comment);
            if (check){
                response.sendRedirect(request.getContextPath() + "/NewsDetail?id_news=" + id_news);
            }else{
                String message = "Comment failed!";
                response.sendRedirect(request.getContextPath() + "/NewsDetail?id_news=" + id_news + "&message=" + message);
            }
        }catch (Exception e){
            response.sendRedirect(request.getContextPath() + "/homepage");
            e.printStackTrace();
        }
    }
}
