package controller.AuthenController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.User;
import model.bo.AuthenBO;

import java.io.IOException;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
    private AuthenBO authenBO = new AuthenBO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("/Login");
        }
        else{
            if (authenBO.changePassword(currentPassword, newPassword, user)){
                response.sendRedirect("/Profile/ChangePassword.jsp?success=true");
            }
            else {
                response.sendRedirect("/Profile/ChangePassword.jsp?success=false");
            }
        }
    }
}