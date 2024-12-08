package model.bo;

import model.bean.Category;
import model.dao.CategoryDAO;

import java.util.List;

public class CategoryBO {

    private CategoryDAO categoryDAO = new CategoryDAO();

    public List<Category> getListCategories(){
        return categoryDAO.getListCategories();
    }
    public boolean addCategory(Category category){
        return categoryDAO.addCategory(category);
    }
    public boolean updateCategory(Category category){
        return categoryDAO.updateCategory(category);
    }

    public boolean deleteCategory(int id){
        return categoryDAO.deleteCategory(id);
    }
}
