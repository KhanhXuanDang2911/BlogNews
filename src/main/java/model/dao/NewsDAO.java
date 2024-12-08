package model.dao;
import model.bean.Category;
import model.bean.News;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO extends DBContext {
    public NewsDAO() {
        super();
    }

    //    id, title, content, author_id, status, image, published_at

    public List<News> getListNews(int id, String keyword, int idCategory){
        List<News> listNews = new ArrayList<News>();
        String sql = "select n.id, n.title, n.content, n.author_id, n.status, n.image, n.published_at, n.category_id, c.name\n" +
                "from news as n join category as c \n" +
                "on n.category_id = c.id where 1 = 1";
        if (idCategory > 0) {
            sql += " and n.category_id = " + idCategory;
        }
        if (id != 0)
            sql += " and n.id = " + id;
        if (keyword != null && !keyword.isEmpty()) {
            sql += " and n.title like '%" + keyword + "%'";
            sql += " and n.content like '%" + keyword + "%'";
        }
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int idNews = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int authorId = rs.getInt("author_id");
                String status = rs.getString("status");
                String image = rs.getString("image");
                Date publishedAt = rs.getDate("published_at");
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("name");
                listNews.add(new News(idNews, title, content, authorId, status, image, new java.util.Date(publishedAt.getTime()), new Category(categoryId, categoryName)));
            }
            return listNews;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean addNews(News news){
        String sql = "insert into news(title, content, author_id, status, image, published_at, category_id) values(?, ?, ?, ?, ?, ?, ?)";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setInt(3, news.getAuthorId());
            preparedStatement.setString(4, news.getStatus());
            preparedStatement.setString(5, news.getImage());
            preparedStatement.setDate(6, new Date(news.getPublishedAt().getTime()));
            preparedStatement.setInt(7, news.getCategory().getId());
            return preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNews(News news){
        String sql = "update news set title =?, content =?, author_id =?, status =?, image =?, category_id = ? where id =?";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setInt(3, news.getAuthorId());
            preparedStatement.setString(4, news.getStatus());
            preparedStatement.setString(5, news.getImage());
            preparedStatement.setInt(6, news.getCategory().getId());
            preparedStatement.setInt(7, news.getId());
            return preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNews(int id){
        String sql = "delete from news where id = " + id;
        try{
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql) > 0;
        }catch (Exception e){
            e.printStackTrace();
    }
        return false;
    }
}