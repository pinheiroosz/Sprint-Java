package br.com.fiap.dao;

import br.com.fiap.connections.dbConnection;
import br.com.fiap.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void create(User user) throws SQLException {
        String sql = "INSERT INTO C_Usuario (Login, Senha) VALUES (?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());
            stmt.executeUpdate();
        }
    }

    public User readById(Long id) throws SQLException {
        String sql = "SELECT * FROM C_Usuario WHERE ID_Usuario = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong("ID_Usuario"));
                    user.setLogin(rs.getString("Login"));
                    user.setSenha(rs.getString("Senha"));
                    return user;
                }
            }
        }
        return null;
    }

    public List<User> readAll() throws SQLException {
        String sql = "SELECT * FROM C_Usuario";
        List<User> users = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID_Usuario"));
                user.setLogin(rs.getString("Login"));
                user.setSenha(rs.getString("Senha"));
                users.add(user);
            }
        }
        return users;
    }

    public void update(User user) throws SQLException {
        String sql = "UPDATE C_Usuario SET Login = ?, Senha = ? WHERE ID_Usuario = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());
            stmt.setLong(3, user.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM C_Usuario WHERE ID_Usuario = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
