package controller.NewsDetailController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Category;
import model.bean.News;
import model.bean.User;
import model.bean.Comment;
import model.bo.CategoryBO;
import model.bo.CommentBO;
import model.bo.NewsBO;

import java.io.IOException;
import java.util.List;

@WebServlet("/NewsDetail")
public class NewsDetail extends HttpServlet {
    private NewsBO newsBO = new NewsBO();
    private CategoryBO categoryBO = new CategoryBO();
    private CommentBO commentBO = new CommentBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_news = 0;
        if (request.getParameter("id_news") != null) {
            id_news = Integer.parseInt(request.getParameter("id_news"));
        }
        News news = newsBO.getListNews(id_news, null, 0, null, null).get(0);
        // check status
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            if (!news.getStatus().equals("ACCEPT")){ // filter -> not found
                response.sendRedirect(request.getContextPath() + "/homepage");
                return;
            }
        }
        else if (user.getId() == news.getAuthor().getId() || user.getRole().name().equalsIgnoreCase("ADMIN")) {
            // do nothing;
        }
        else if (user.getRole().name().equalsIgnoreCase("USER") && !news.getStatus().equals("ACCEPT")) {
            response.sendRedirect(request.getContextPath() + "/homepage"); // filter -> not found
            return;
        }
        List<Comment> listComments = commentBO.getCommentByIdNews(id_news);
        List<News> listNews = newsBO.getListNews(0, null, 0, null, "ACCEPT");
        List<Category> listCategories = categoryBO.getListCategories();
        request.setAttribute("listComments", listComments);
        request.setAttribute("listNews", listNews);
        request.setAttribute("listCategories", listCategories);
        request.setAttribute("news", news);
        request.getRequestDispatcher("/NewsDetail/index.jsp").forward(request, response);
    }
}
