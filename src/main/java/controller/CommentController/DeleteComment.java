package controller.CommentController;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bo.CommentBO;

import java.io.IOException;
@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {

    private CommentBO commentBO = new CommentBO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Lấy thông tin từ request
            int commentId = Integer.parseInt(request.getParameter("id"));

            // Thực hiện xóa comment
            boolean isSuccess = commentBO.deleteComment(commentId);

            ResponseAPI responseAPI;
            if (isSuccess) {
                responseAPI = new ResponseAPI("success", "Comment deleted successfully!", null);
            } else {
                responseAPI = new ResponseAPI("error", "Delete comment failed!", null);
            }

            // Phản hồi JSON cho client
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