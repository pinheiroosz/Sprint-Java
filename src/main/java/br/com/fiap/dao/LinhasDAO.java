package br.com.fiap.dao;

import br.com.fiap.connections.dbConnection;
import br.com.fiap.model.Linhas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinhasDAO {

    public void create(Linhas linha) throws SQLException {
        String sql = "INSERT INTO C_Linhas (Nome_linha, Status, ID_Usuario) VALUES (?, ?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, linha.getNomeLinha());
            stmt.setString(2, linha.getStatus());
            stmt.setLong(3, linha.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    public Linhas readById(Long id) throws SQLException {
        String sql = "SELECT * FROM C_Linhas WHERE ID_Linha = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Linhas linha = new Linhas();
                    linha.setId(rs.getLong("ID_Linha"));
                    linha.setNomeLinha(rs.getString("Nome_linha"));
                    linha.setStatus(rs.getString("Status"));
                    linha.setIdUsuario(rs.getLong("ID_Usuario"));
                    return linha;
                }
            }
        }
        return null;
    }

    public List<Linhas> readAll() throws SQLException {
        String sql = "SELECT * FROM C_Linhas";
        List<Linhas> linhasList = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Linhas linha = new Linhas();
                linha.setId(rs.getLong("ID_Linha"));
                linha.setNomeLinha(rs.getString("Nome_linha"));
                linha.setStatus(rs.getString("Status"));
                linha.setIdUsuario(rs.getLong("ID_Usuario"));
                linhasList.add(linha);
            }
        }
        return linhasList;
    }

    public void update(Linhas linha) throws SQLException {
        String sql = "UPDATE C_Linhas SET Nome_linha = ?, Status = ?, ID_Usuario = ? WHERE ID_Linha = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, linha.getNomeLinha());
            stmt.setString(2, linha.getStatus());
            stmt.setLong(3, linha.getIdUsuario());
            stmt.setLong(4, linha.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM C_Linhas WHERE ID_Linha = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
