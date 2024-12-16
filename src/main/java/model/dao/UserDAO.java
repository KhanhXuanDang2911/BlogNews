package model.dao;

import model.bean.User;
import model.bean.enums.Role;

import java.sql.*;
import java.util.*;

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
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
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
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
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

    public boolean addUser(User user) {
        String sql = "INSERT INTO user (username, password, name, phone, email, role, is_active, avatar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getRole().toString());
            stmt.setBoolean(7, user.isActive());
            stmt.setString(8, user.getAvatar());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one record was inserted
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
        return false; // Return false if no records were inserted or an error occurred
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE user SET name = ?, phone = ?, email = ?, role = ?, is_active = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPhone());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole().toString());
            stmt.setBoolean(5, user.isActive());
            stmt.setLong(6, user.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one record was updated
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
        return false; // Return false if no records were updated or an error occurred
    }

    public boolean updateProfile(User user) {
        String sql = "UPDATE user SET name = ?, phone = ?, email = ?, avatar = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPhone());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAvatar());
            stmt.setLong(5, user.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one record was updated
        } catch (SQLException e) {
            System.out.println("Error updating user profile: " + e.getMessage());
        }
        return false; // Return false if no records were updated or an error occurred
    }

    public boolean deleteUser(long userId) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, userId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one record was deleted
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
        return false; // Return false if no records were deleted or an error occurred
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
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
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

    public boolean changePassword(long userId, String newPassword) {
        String sql = "UPDATE user SET password = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, newPassword);
            preparedStatement.setLong(2, userId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error changing password: " + e.getMessage());
        }
        return false;
    }
}
