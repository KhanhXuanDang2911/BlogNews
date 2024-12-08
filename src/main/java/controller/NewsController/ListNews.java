package controller.NewsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.News;
import model.bo.NewsBO;

import java.io.IOException;
import java.util.List;

@WebServlet("/ListNews")
public class ListNews extends HttpServlet {
    private NewsBO newsBO = new NewsBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> listNews = newsBO.getListNews(0, null, 0);
        request.setAttribute("listNews", listNews);
        request.getRequestDispatcher("/News/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
