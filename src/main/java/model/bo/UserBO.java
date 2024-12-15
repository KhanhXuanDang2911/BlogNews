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
        return userDAO.addUser(user);
    }

    public boolean updateUser(User user) {
        User existingUser = findUserById(user.getId());
        if (existingUser == null) {
            return false;
        }

        return userDAO.updateUser(user);
    }

    public boolean updateProfile(User user) {
        if("".equals(user.getPhone())){
            user.setPhone(null);
        }
        if("".equals(user.getEmail())){
            user.setEmail(null);
        }
        User existingUser = findUserById(user.getId());
        if (existingUser == null) {
            return false;
        }

        return userDAO.updateProfile(user);
    }

    public boolean deleteUser(long userId) {
        User existingUser = findUserById(userId);
        if (existingUser == null) {
            return false;
        }

        return userDAO.deleteUser(userId);
    }

    public List<User> searchUser(String name) {
        if (name == null) {
            name = "";
        }
        return userDAO.searchUserByName(name);
    }

    public User findUserById (long id){
        return userDAO.getUserById(id);
    }
}