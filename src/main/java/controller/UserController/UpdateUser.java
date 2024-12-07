package controller.UserController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.User;
import model.bean.enums.Role;
import model.bo.UserBO;

import java.io.IOException;

@WebServlet("users/update")
public class UpdateUser extends HttpServlet {
    UserBO userBO = new UserBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdParam = request.getParameter("userId");
        try {
            long userId = Long.parseLong(userIdParam);
            User userCurrent = userBO.findUserById(userId);
            request.setAttribute("user", userCurrent);
            request.getRequestDispatcher("Users/Update.jsp").forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/users");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String role = request.getParameter("role");
            boolean isActive = Boolean.parseBoolean(request.getParameter("is_active"));
            String avatar = request.getParameter("avatar");

            User user = new User(userId, username, password, name, Role.valueOf(role), isActive, avatar);

            boolean isSuccess = userBO.updateUser(user);
            if (isSuccess) {
                System.out.println("User updated successfully");
            } else {
                System.out.println("User could not be updated");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("/users");
    }
}
