package controller.NewsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bo.NewsBO;

import java.io.IOException;

@WebServlet("/DeleteNews")
public class DeleteNews extends HttpServlet {

    private NewsBO newsBO = new NewsBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try{
            boolean check = newsBO.deleteNews(Integer.parseInt(id));
            if (check) {
                request.setAttribute("message", "Delete news successfully");
            } else {
                request.setAttribute("message", "Delete news failed");
            }
            request.getRequestDispatcher("/ListNews").forward(request, response);
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
