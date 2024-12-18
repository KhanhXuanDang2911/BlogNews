package controller.UserController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.bean.Category;
import model.bean.News;
import model.bean.User;
import model.bo.UserBO;

import java.io.IOException;

@MultipartConfig
@WebServlet("/UpdateAvatar")
public class UpdateAvatar extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
    private UserBO userBO = new UserBO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Long id = user.getId();
        Part avatar = request.getPart("avatar");
        String filePath = null;
        if (avatar != null && avatar.getSize() > 0) {
            filePath = "/Images/" + System.currentTimeMillis() + "_" + avatar.getSubmittedFileName();
            String fileName = request.getServletContext().getRealPath(filePath);
            avatar.write(fileName);
        } else {
            filePath = request.getParameter("old-image");
        }
        User userFromDB = userBO.findUserById(id);
        userFromDB.setAvatar(filePath);
        boolean check = userBO.updateUser(userFromDB);
        if (check) {
            String message = "Update avatar successfully";
            user.setAvatar(filePath);
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/UpdateProfile?message=" + message);
        } else {
            String message = "Update avatar failed";
            response.sendRedirect(request.getContextPath() + "/UpdateProfile?message=" + message);
        }
    }
}
