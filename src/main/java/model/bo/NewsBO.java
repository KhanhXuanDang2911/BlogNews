package model.bo;

import model.bean.News;
import model.dao.NewsDAO;

import java.util.List;

public class NewsBO {

    private NewsDAO newsDAO = new NewsDAO();
    public List<News> getListNews(int id, String keyword, int idCategory, String username, String status){
        return newsDAO.getListNews(id, keyword, idCategory, username, status);
    }
    public boolean addNews(News news){
        news.setPublishedAt(new java.util.Date());
        return newsDAO.addNews(news);
    }
    public boolean updateNews(News news){
        return newsDAO.updateNews(news);
    }
    public boolean deleteNews(int id){
        return newsDAO.deleteNews(id);
    }
}
