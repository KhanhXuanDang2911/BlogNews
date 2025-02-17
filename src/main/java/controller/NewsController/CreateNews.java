package controller.NewsController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.bean.Category;
import model.bean.News;
import model.bean.User;
import model.bo.CategoryBO;
import model.bo.NewsBO;

import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet("/CreateNews")
public class CreateNews extends HttpServlet {
    private NewsBO newsBO = new NewsBO();
    private CategoryBO categoryBO = new CategoryBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategories = categoryBO.getListCategories();
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("/News/Add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        Long authorId = user.getId();
        String status = "ACCEPT";
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Part image =  request.getPart("image");
        String filePath = "/Images/" + System.currentTimeMillis() + "_" + image.getSubmittedFileName();
        String fileName = request.getServletContext().getRealPath(filePath);
        System.out.println(fileName);
        image.write(fileName);
        boolean check = newsBO.addNews(new News(0, title, content, new User(authorId, null), status, filePath, null, new Category(categoryId, null)));
        if (check) {
            request.setAttribute("message", "Add news successfully");
        } else {
            request.setAttribute("message", "Add news failed");
        }
        request.getRequestDispatcher("/ListNews").forward(request, response);
    }
}
