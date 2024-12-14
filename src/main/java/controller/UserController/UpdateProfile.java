package controller.UserController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.User;
import model.bo.UserBO;

import java.io.IOException;

@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
    private UserBO userBO = new UserBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        request.setAttribute("message", message);
        request.getRequestDispatcher("Profile/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute("user");

        if (userSession != null) {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            User user = new User();
            user.setName(name);
            user.setPhone(phone);
            user.setEmail(email);
            user.setId(userSession.getId());

            if (userBO.updateProfile(user))   {
                userSession = userBO.findUserById(userSession.getId());
                session.setAttribute("user", userSession);
                String message = "Update profile successfully";
                response.sendRedirect(request.getContextPath() + "/UpdateProfile?message=" + message);
            }
            else {
                String message = "Update profile failed";
                response.sendRedirect(request.getContextPath() + "/UpdateProfile?message=" + message);
            }
        } else {
            response.sendRedirect("/Login");
        }
    }
}
