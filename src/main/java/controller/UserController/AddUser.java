package controller.UserController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.User;
import model.bean.enums.Role;
import model.bo.UserBO;
import util.MD5;

import java.io.IOException;

@WebServlet("/CreateUser")
public class AddUser extends HttpServlet {
    private UserBO userBO = new UserBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Users/Add.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        boolean isActive = true;
        String avatar = request.getParameter("avatar");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5.getMD5(password));
        user.setName(name);
        user.setRole(Role.valueOf(role));
        user.setActive(isActive);
        user.setAvatar(avatar);
        user.setPhone(phone);
        user.setEmail(email);

        try {
            boolean isSuccess = userBO.addUser(user);
            if (isSuccess) {
                System.out.println("User added successfully");
            } else {
                System.out.println("User could not be added");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        response.sendRedirect("/SearchUser");
    }
}