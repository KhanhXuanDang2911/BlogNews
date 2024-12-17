package controller.NewsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.bean.Category;
import model.bean.News;
import model.bean.User;
import model.bo.CategoryBO;
import model.bo.NewsBO;

import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet("/UpdateNewsForUser")
public class UpdateNewsForUser extends HttpServlet {

    private NewsBO newsBO = new NewsBO();
    private CategoryBO categoryBO = new CategoryBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = 0;
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/homepage");
        }
        News news = newsBO.getListNews(id, null, 0, null, null).get(0);
        if (!news.getAuthor().getId().equals(((User) request.getSession().getAttribute("user")).getId())) {
            response.sendRedirect(request.getContextPath() + "//ERROR404/index.jsp"); // filter -> not found
            return;
        }
        request.setAttribute("news", news);
        List<Category> listCategories = categoryBO.getListCategories();
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("/Profile/UpdateNews.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id-news"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        Long authorId = user.getId(); // Hardcode author id
        String status = newsBO.getListNews(id, null, 0, null, null).get(0).getStatus();
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Part image =  request.getPart("image");
        String filePath = null;
        if (image != null && image.getSize() > 0) {
            filePath = "/Images/" + System.currentTimeMillis() + "_" + image.getSubmittedFileName();
            String fileName = request.getServletContext().getRealPath(filePath);
            image.write(fileName);
        } else{
            filePath = newsBO.getListNews(id, null, 0, null, null).get(0).getImage();
        }
        boolean check = newsBO.updateNews(new News(id, title, content, new User(authorId, null), status, filePath, null, new Category(categoryId, null)));
        if (check) {
            request.setAttribute("message", "Update news successfully");
        } else {
            request.setAttribute("message", "Update news failed");
        }
        request.getRequestDispatcher("/NewsHistory").forward(request, response);
    }
}
