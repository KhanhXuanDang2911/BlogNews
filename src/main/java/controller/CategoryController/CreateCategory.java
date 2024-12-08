package controller.CategoryController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Category;
import model.bo.CategoryBO;

import java.io.IOException;

@WebServlet("/CreateCategory")
public class CreateCategory extends HttpServlet {

    private CategoryBO categoryBO = new CategoryBO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        boolean check = categoryBO.addCategory(new Category(0, name));
        if (check) {
            request.setAttribute("message", "Add category successfully");
        } else {
            request.setAttribute("message", "Add category failed");
        }
        request.getRequestDispatcher("/ListCategories").forward(request, response);
    }
}
