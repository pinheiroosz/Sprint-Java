package br.com.fiap.dao;

import br.com.fiap.connections.dbConnection;
import br.com.fiap.model.EstacaoLinha;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstacaoLinhaDAO {

    public void create(EstacaoLinha estacaoLinha) throws SQLException {
        String sql = "INSERT INTO C_Estacao_Linha (ID_Estacoes, ID_Linha) VALUES (?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, estacaoLinha.getIdEstacoes());
            stmt.setLong(2, estacaoLinha.getIdLinha());
            stmt.executeUpdate();
        }
    }

    public EstacaoLinha readById(Long id) throws SQLException {
        String sql = "SELECT * FROM C_Estacao_Linha WHERE ID_Estacao_Linha = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    EstacaoLinha estacaoLinha = new EstacaoLinha();
                    estacaoLinha.setId(rs.getLong("ID_Estacao_Linha"));
                    estacaoLinha.setIdEstacoes(rs.getLong("ID_Estacoes"));
                    estacaoLinha.setIdLinha(rs.getLong("ID_Linha"));
                    return estacaoLinha;
                }
            }
        }
        return null;
    }

    public List<EstacaoLinha> readAll() throws SQLException {
        String sql = "SELECT * FROM C_Estacao_Linha";
        List<EstacaoLinha> estacaoLinhaList = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                EstacaoLinha estacaoLinha = new EstacaoLinha();
                estacaoLinha.setId(rs.getLong("ID_Estacao_Linha"));
                estacaoLinha.setIdEstacoes(rs.getLong("ID_Estacoes"));
                estacaoLinha.setIdLinha(rs.getLong("ID_Linha"));
                estacaoLinhaList.add(estacaoLinha);
            }
        }
        return estacaoLinhaList;
    }

    public void update(EstacaoLinha estacaoLinha) throws SQLException {
        String sql = "UPDATE C_Estacao_Linha SET ID_Estacoes = ?, ID_Linha = ? WHERE ID_Estacao_Linha = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, estacaoLinha.getIdEstacoes());
            stmt.setLong(2, estacaoLinha.getIdLinha());
            stmt.setLong(3, estacaoLinha.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM C_Estacao_Linha WHERE ID_Estacao_Linha = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
