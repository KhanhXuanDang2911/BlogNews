package controller.NewsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.News;
import model.bean.User;
import model.bo.NewsBO;

import java.io.IOException;

@WebServlet("/DeleteNews")
public class DeleteNews extends HttpServlet {

    private NewsBO newsBO = new NewsBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try{
            int id_news = Integer.parseInt(id);
            User user = (User) request.getSession().getAttribute("user");
            News news = newsBO.getListNews(id_news, null, 0, null, null).get(0);
            if (user.getRole().name().equalsIgnoreCase("USER") && news.getAuthor().getId() != (user.getId())) {
                response.sendRedirect( request.getContextPath() + "/homepage"); // filter -> not found
                return;
            }
            boolean check = newsBO.deleteNews(id_news);
            if (check) {
                request.setAttribute("message", "Delete news successfully");
            } else {
                request.setAttribute("message", "Delete news failed");
            }
            if (user.getRole().name().equalsIgnoreCase("ADMIN")) {
                response.sendRedirect(request.getContextPath() + "/ListNews");
            } else {
                response.sendRedirect(request.getContextPath() + "/NewsHistory");
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message", "Delete news failed");
            request.getRequestDispatcher("/ListNews").forward(request, response);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(request, response);
//    }
}
