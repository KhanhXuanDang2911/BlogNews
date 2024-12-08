package model.dao;

import model.bean.Category;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DBContext{

    public List<Category> getListCategories(){
        String sql = "SELECT * FROM category";
        List<Category> listCategories = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                listCategories.add(new Category(id, name));
            }
            return listCategories;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean addCategory(Category category){
        String sql = "insert into category(name) values(?)";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            return preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCategory(Category category){
        String sql = "update category set name = ? where id = ?";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getId());
            return preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCategory(int id){
        String sql = "delete from category where id = " + id;
        try{
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql) > 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
