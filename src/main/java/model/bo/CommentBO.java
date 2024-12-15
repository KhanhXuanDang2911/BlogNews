package model.bo;

import model.bean.Comment;
import model.dao.CommentDAO;

import java.util.List;

public class CommentBO {

    private CommentDAO commentDAO = new CommentDAO();

    public List<Comment> getCommentByIdNews(int id_news){
        return commentDAO.getCommentByIdNews(id_news);
    }

    public Long addComment(Comment comment){
        return commentDAO.addComment(comment);
    }

    public boolean deleteComment(int id){
        return commentDAO.deleteComment(id);
    }

    public boolean updateComment(Comment comment){
        return commentDAO.updateComment(comment);
    }

    public String getContentOfCommentById(int id){
        return commentDAO.getContentOfCmt(id);
    }
}
