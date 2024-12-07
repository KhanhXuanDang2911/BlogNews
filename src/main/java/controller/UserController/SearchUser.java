package controller.UserController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.User;
import model.bo.UserBO;

import java.io.IOException;
import java.util.List;

@WebServlet("/users/search")
public class SearchUser extends HttpServlet {
    private UserBO userBO = new UserBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String searchName = request.getParameter("name");
            List<User> users = userBO.searchUser(searchName);

            request.setAttribute("users", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/Users/index.jsp").forward(request, response);
    }
}