package br.com.fiap.dao;

import br.com.fiap.connections.dbConnection;
import br.com.fiap.model.Idioma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IdiomaDAO {

    public void create(Idioma idioma) throws SQLException {
        String sql = "INSERT INTO C_Idioma (Idioma, ID_Usuario) VALUES (?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idioma.getIdioma());
            stmt.setLong(2, idioma.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    public Idioma readById(Long id) throws SQLException {
        String sql = "SELECT * FROM C_Idioma WHERE ID_Idioma = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Idioma idioma = new Idioma();
                    idioma.setId(rs.getLong("ID_Idioma"));
                    idioma.setIdioma(rs.getString("Idioma"));
                    idioma.setIdUsuario(rs.getLong("ID_Usuario"));
                    return idioma;
                }
            }
        }
        return null;
    }

    public List<Idioma> readAll() throws SQLException {
        String sql = "SELECT * FROM C_Idioma";
        List<Idioma> idiomas = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Idioma idioma = new Idioma();
                idioma.setId(rs.getLong("ID_Idioma"));
                idioma.setIdioma(rs.getString("Idioma"));
                idioma.setIdUsuario(rs.getLong("ID_Usuario"));
                idiomas.add(idioma);
            }
        }
        return idiomas;
    }

    public void update(Idioma idioma) throws SQLException {
        String sql = "UPDATE C_Idioma SET Idioma = ?, ID_Usuario = ? WHERE ID_Idioma = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idioma.getIdioma());
            stmt.setLong(2, idioma.getIdUsuario());
            stmt.setLong(3, idioma.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM C_Idioma WHERE ID_Idioma = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
