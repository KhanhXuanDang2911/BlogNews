package model.bo;

import model.bean.Comment;
import model.dao.CommentDAO;

public class CommentBO {
    private CommentDAO commentDAO = new CommentDAO();

    public boolean addComment(Comment comment){

        return true;
    }
}
