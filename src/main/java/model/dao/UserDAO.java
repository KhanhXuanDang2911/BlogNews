package model.dao;

import model.bean.User;
import model.bean.enums.Role;

import java.util.*;
import java.sql.*;

public class UserDAO extends DBContext {

    public UserDAO() {
        super();
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setActive(rs.getBoolean("is_active"));
                user.setAvatar(rs.getString("avatar"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        }
        return null;
    }

    public User getUserById(long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setActive(rs.getBoolean("is_active"));
                user.setAvatar(rs.getString("avatar"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        }
        return null;
    }

    public void addUser(User user) {
        String sql = "INSERT INTO user (username, password, name, role, is_active, avatar) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getRole().toString());
            stmt.setBoolean(5, user.isActive());
            stmt.setString(6, user.getAvatar());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE user SET password = ?, name = ?, role = ?, is_active = ?, avatar = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getRole().toString());
            stmt.setBoolean(4, user.isActive());
            stmt.setString(5, user.getAvatar());
            stmt.setLong(6, user.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    public void deleteUser(long userId) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    public List<User> searchUserByName(String name) {
        String sql = "SELECT * FROM user WHERE name LIKE ?";
        List<User> users = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setActive(rs.getBoolean("is_active"));
                user.setAvatar(rs.getString("avatar"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error searching user: " + e.getMessage());
        }
        return users;
    }
}
