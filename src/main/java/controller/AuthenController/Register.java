package controller.AuthenController;

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

@WebServlet("/Register")
public class Register extends HttpServlet {

    private UserBO userBO = new UserBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("LoginSignUp/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(MD5.getMD5(password));
        user.setActive(true);
        user.setRole(Role.USER);

        try {
            boolean isSuccess = userBO.addUser(user);
            if (isSuccess) {
                response.sendRedirect("/Login");
            }
            else {
                response.sendRedirect("/Register");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}