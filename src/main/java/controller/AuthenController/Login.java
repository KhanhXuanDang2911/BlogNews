package controller.AuthenController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.User;
import model.bo.AuthenBO;
import util.MD5;

import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    AuthenBO authenBO = new AuthenBO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath() + "/homepage");
            return;
        }
        req.getRequestDispatcher("/LoginSignUp/index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = authenBO.isValid(username, MD5.getMD5(password));

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/homepage");
        } else {
            response.sendRedirect(request.getContextPath() + "/Login?message=Invalid username or password");
        }
    }
}
