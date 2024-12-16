package controller.CommentController;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.User;
import model.bean.Comment;
import model.bo.CommentBO;

import java.io.IOException;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
    private final CommentBO commentBO = new CommentBO();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            Comment newCmt = objectMapper.readValue(request.getReader(), Comment.class);

            newCmt.setAuthor((User) request.getSession().getAttribute("user"));

            Long newCmtId = commentBO.addComment(newCmt);

            ResponseAPI responseAPI = new ResponseAPI(
                    newCmtId != null ? "success" : "error",
                    newCmtId != null ? "Comment added successfully!" : "Comment failed!",
                    newCmtId
            );

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
