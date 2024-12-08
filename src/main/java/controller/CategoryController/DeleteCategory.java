package controller.CategoryController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bo.CategoryBO;

import java.io.IOException;

@WebServlet("/DeleteCategory")
public class DeleteCategory extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean check = categoryBO.deleteCategory(Integer.parseInt(id));
        if (check) {
            request.setAttribute("message", "Delete category successfully");
        } else {
            request.setAttribute("message", "Delete category failed");
        }
        request.getRequestDispatcher("/ListCategories").forward(request, response);
    }
}
