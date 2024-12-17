package controller.NewsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.News;
import model.bean.User;
import model.bo.NewsBO;

import java.io.IOException;
import java.util.List;

@WebServlet("/NewsHistory")
public class NewsHistory extends HttpServlet {
    private NewsBO newsBO = new NewsBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<News> listNews = newsBO.getListNews(0, null, 0, user.getUsername(), null);
        request.setAttribute("listNews", listNews);
        request.getRequestDispatcher("/Profile/NewsHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
