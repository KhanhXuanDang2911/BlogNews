package controller.CommentController;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bo.CommentBO;

import java.io.IOException;

@WebServlet("/ContentOfComment")
public class DetailComment extends HttpServlet {

    private CommentBO commentBO = new CommentBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            int commentId = Integer.parseInt(request.getParameter("id"));

            String comment = commentBO.getContentOfCommentById(commentId);

            ResponseAPI responseAPI;
            if (comment != null) {
                responseAPI = new ResponseAPI("success", "Comment retrieved successfully!", comment);
            } else {
                responseAPI = new ResponseAPI("error", "Comment not found!", null);
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
