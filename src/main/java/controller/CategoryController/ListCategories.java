package controller.CategoryController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Category;
import model.dao.CategoryDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ListCategories")
public class ListCategories extends HttpServlet {
    private CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategories;
        listCategories = categoryDAO.getListCategories();
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("/Categories/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
