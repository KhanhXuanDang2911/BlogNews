package model.dao;

import model.bean.User;
import model.bean.Comment;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends DBContext{

    public List<Comment> getCommentByIdNews(int id_news){
        List<Comment> listComments = new ArrayList<Comment>();
        String sql = "SELECT * FROM comment as c join user as u on c.user_id = u.id " +
                "\nWHERE article_id = " + id_news;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                listComments.add(new Comment(
                        rs.getInt("id"),
                        new User(rs.getLong("user_id"), rs.getString("name"), rs.getString("avatar")),
                        id_news,
                        rs.getString("content"),
                        rs.getDate("createdAt")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listComments;
    }

    public boolean addComment(Comment comment){
        String sql = "insert into comment (user_id, article_id, content, createdAt) values(?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, comment.getAuthor().getId());
            preparedStatement.setInt(2, comment.getNews_id());
            preparedStatement.setString(3, comment.getContent());
            preparedStatement.setDate(4, new Date(comment.getCreated_at().getTime()));
            return preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteComment(int id){
        String sql = "delete from comment where id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateComment(Comment comment){
        String sql = "update comment set content = ? where id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, comment.getContent());
            preparedStatement.setInt(2, comment.getId());
            return preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
