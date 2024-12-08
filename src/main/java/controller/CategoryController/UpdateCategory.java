package controller.CategoryController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Category;
import model.bo.CategoryBO;

import java.io.IOException;

@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean check = categoryBO.updateCategory(new Category(id, name));
        if (check) {
            request.setAttribute("message", "Update category successfully");
        } else {
            request.setAttribute("message", "Update category failed");
        }
        request.getRequestDispatcher("/ListCategories").forward(request, response);
    }
}
