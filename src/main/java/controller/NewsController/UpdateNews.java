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
import model.bo.CategoryBO;
import model.bo.NewsBO;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@MultipartConfig
@WebServlet("/UpdateNews")
public class UpdateNews extends HttpServlet {
    private NewsBO newsBO = new NewsBO();
    private CategoryBO categoryBO = new CategoryBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        News news = newsBO.getListNews(id, null, 0).get(0);
        request.setAttribute("news", news);
        List<Category> listCategories = categoryBO.getListCategories();
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("/News/Update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id-news"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int authorId = 1; // Hardcode author id
        String status = request.getParameter("status");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Part image =  request.getPart("image");
        String filePath = null;
        if (image != null && image.getSize() > 0) {
            filePath = "/Images/" + System.currentTimeMillis() + "_" + image.getSubmittedFileName();
            String fileName = request.getServletContext().getRealPath(filePath);
            System.out.println(fileName);
            image.write(fileName);
        } else{
            filePath = newsBO.getListNews(id, null, 0).get(0).getImage();
        }
        boolean check = newsBO.updateNews(new News(id, title, content, authorId, status, filePath, null, new Category(categoryId, null)));
        if (check) {
            request.setAttribute("message", "Update news successfully");
        } else {
            request.setAttribute("message", "Update news failed");
        }
        request.getRequestDispatcher("/ListNews").forward(request, response);
    }
}
