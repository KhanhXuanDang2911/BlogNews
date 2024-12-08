package controller.NewsDetailController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Category;
import model.bean.News;
import model.bo.CategoryBO;
import model.bo.NewsBO;

import java.io.IOException;
import java.util.List;

@WebServlet("/NewsDetail")
public class NewsDetail extends HttpServlet {
    private NewsBO newsBO = new NewsBO();
    private CategoryBO categoryBO = new CategoryBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_news = 0;
        if (request.getParameter("id_news") != null) {
            id_news = Integer.parseInt(request.getParameter("id_news"));
        }
        News news = newsBO.getListNews(id_news, null, 0).get(0);
        // check status

        List<News> listNews = newsBO.getListNews(0, null, 0);
        List<Category> listCategories = categoryBO.getListCategories();
        request.setAttribute("listNews", listNews);
        request.setAttribute("listCategories", listCategories);
        request.setAttribute("news", news);
        request.getRequestDispatcher("/NewsDetail/index.jsp").forward(request, response);
    }
}
