package controller.AuthenController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.User;
import model.bean.enums.Role;
import model.bo.UserBO;

import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {

    private UserBO userBO = new UserBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("LoginSignUp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setActive(true);
        user.setRole(Role.USER);

        try {
            boolean isSuccess = userBO.addUser(user);
            if (isSuccess) {
                response.sendRedirect("/login");
            }
            else {
                response.sendRedirect("/register");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}