package controller.CommentController;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Comment;
import model.bo.CommentBO;

import java.io.IOException;
@WebServlet("/UpdateComment")
public class UpdateComment extends HttpServlet {
    private CommentBO commentBO = new CommentBO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Comment updatedComment = objectMapper.readValue(request.getReader(), Comment.class);

            boolean isSuccess = commentBO.updateComment(updatedComment);

            ResponseAPI responseAPI;
            if (isSuccess) {
                responseAPI = new ResponseAPI("success", "Comment updated successfully!", null);
            } else {
                responseAPI = new ResponseAPI("error", "Update comment failed!", null);
            }

            String jsonResponse = objectMapper.writeValueAsString(responseAPI);
            response.getWriter().write(jsonResponse);

        } catch (Exception e) {
            ResponseAPI apiResponse = new ResponseAPI("error", "An error occurred!", null);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            String jsonResponse = objectMapper.writeValueAsString(apiResponse);
            response.getWriter().write(jsonResponse);
            e.printStackTrace();
        }
    }
}