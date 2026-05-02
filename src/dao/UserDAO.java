package dao;

import db.DBConnection;
import model.User;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // 🔹 Login method
    public User login(String username, String password) {

        User user = null;

        String query = "SELECT u.user_id, u.username, u.password, r.role_id, r.role_name " +
                "FROM users u " +
                "JOIN roles r ON u.role_id = r.role_id " +
                "WHERE u.username = ? AND u.password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Role role = new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_name")
                );

                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        role
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}