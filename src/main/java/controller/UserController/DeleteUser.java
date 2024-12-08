package controller.UserController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bo.UserBO;

import java.io.IOException;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
    private UserBO userBO = new UserBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long userId = Long.parseLong(request.getParameter("userId"));

            boolean isSuccess = userBO.deleteUser(userId);
            if (isSuccess) {
                System.out.println("User deleted successfully");
            } else {
                System.out.println("User could not be deleted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        response.sendRedirect("/SearchUser");
    }
}
