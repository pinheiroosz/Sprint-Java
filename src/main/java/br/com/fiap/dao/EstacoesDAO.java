package br.com.fiap.dao;

import br.com.fiap.connections.dbConnection;
import br.com.fiap.model.Estacoes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstacoesDAO {

    public void create(Estacoes estacao) throws SQLException {
        String sql = "INSERT INTO C_Estacoes (Nome_estacao, Status, ID_Usuario) VALUES (?, ?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estacao.getNomeEstacao());
            stmt.setString(2, estacao.getStatus());
            stmt.setLong(3, estacao.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    public Estacoes readById(Long id) throws SQLException {
        String sql = "SELECT * FROM C_Estacoes WHERE ID_Estacoes = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Estacoes estacao = new Estacoes();
                    estacao.setId(rs.getLong("ID_Estacoes"));
                    estacao.setNomeEstacao(rs.getString("Nome_estacao"));
                    estacao.setStatus(rs.getString("Status"));
                    estacao.setIdUsuario(rs.getLong("ID_Usuario"));
                    return estacao;
                }
            }
        }
        return null;
    }

    public List<Estacoes> readAll() throws SQLException {
        String sql = "SELECT * FROM C_Estacoes";
        List<Estacoes> estacoesList = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Estacoes estacao = new Estacoes();
                estacao.setId(rs.getLong("ID_Estacoes"));
                estacao.setNomeEstacao(rs.getString("Nome_estacao"));
                estacao.setStatus(rs.getString("Status"));
                estacao.setIdUsuario(rs.getLong("ID_Usuario"));
                estacoesList.add(estacao);
            }
        }
        return estacoesList;
    }

    public void update(Estacoes estacao) throws SQLException {
        String sql = "UPDATE C_Estacoes SET Nome_estacao = ?, Status = ?, ID_Usuario = ? WHERE ID_Estacoes = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estacao.getNomeEstacao());
            stmt.setString(2, estacao.getStatus());
            stmt.setLong(3, estacao.getIdUsuario());
            stmt.setLong(4, estacao.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM C_Estacoes WHERE ID_Estacoes = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
