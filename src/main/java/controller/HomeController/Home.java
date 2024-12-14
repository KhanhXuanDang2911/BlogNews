package controller.HomeController;

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

@WebServlet("/homepage")
public class Home extends HttpServlet {
    private NewsBO newsBO = new NewsBO();
    private CategoryBO categoryBO = new CategoryBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category_draft = request.getParameter("category_id");
        int category_id = 0;
        if (category_draft != null) {
            category_id = Integer.parseInt(category_draft);
        }
        List<News> listNews = newsBO.getListNews(0, null, category_id, null, "ACCEPT");
        System.out.println(listNews.size());
        List<News> featuredNews = newsBO.getListNews(0, null, 0, null, "ACCEPT");
        System.out.println(featuredNews.size());
        List<Category> listCategories = categoryBO.getListCategories();
        request.setAttribute("listNews", listNews);
        request.setAttribute("featuredNews", featuredNews);
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("/HomeView/index.jsp").forward(request, response);
    }
}
