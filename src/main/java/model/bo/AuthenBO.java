package model.bo;

import model.bean.User;
import model.dao.UserDAO;
import util.MD5;

public class AuthenBO {
    UserDAO userDAO = new UserDAO();
    public User isValid(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if(user != null && user.getPassword().equals(password) && user.isActive()){
            return user;
        }
        return null;
    }

    public boolean changePassword(String currentPassword, String newPassword, User user) {
        if(MD5.getMD5(currentPassword).equals(user.getPassword())){
            return userDAO.changePassword(user.getId(), MD5.getMD5(newPassword));
        }
        return false;
    }
}
