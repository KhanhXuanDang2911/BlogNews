package model.bo;

import model.bean.User;
import model.dao.UserDAO;

public class AuthenBO {
    UserDAO userDAO = new UserDAO();
    public User isValid(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
