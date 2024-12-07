package model.bo;

import model.bean.User;
import model.dao.UserDAO;

import java.util.*;

public class UserBO {

    private UserDAO userDAO = new UserDAO();

    public boolean addUser(User user){
        if (user.getId() != null && findUserById(user.getId()) != null){
            return false;
        }
        userDAO.addUser(user);
        return true;
    }

    public boolean updateUser(User user) {
        User existingUser = findUserById(user.getId());
        if (existingUser == null) {
            return false;
        }

        userDAO.updateUser(user);
        return true;
    }

    public boolean deleteUser(long userId) {
        User existingUser = findUserById(userId);
        if (existingUser == null) {
            return false;
        }

        userDAO.deleteUser(userId);
        return true;
    }

    public List<User> searchUser(String name) {
        return userDAO.searchUserByName(name);
    }

    public User findUserById (long id){
        return userDAO.getUserById(id);
    }
}