package model.bean;

import model.bean.enums.Role;

public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email; // Added email field
    private Role role;
    private boolean isActive;
    private String avatar;

    public User() {}

    public User(Long id, String username, String password, String name, String phone, String email, Role role, boolean isActive, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email; // Initialize email
        this.role = role;
        this.isActive = isActive;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email; // Getter for email
    }

    public void setEmail(String email) {
        this.email = email; // Setter for email
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' + // Include email in the string
                ", role=" + role +
                ", isActive=" + isActive +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
