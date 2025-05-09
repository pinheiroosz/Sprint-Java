package br.com.fiap.dao;

import br.com.fiap.connections.dbConnection;
import br.com.fiap.model.Duvidas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuvidasDAO {

    public void create(Duvidas duvida) throws SQLException {
        String sql = "INSERT INTO C_duvidas_frequentes (Pergunta, Resposta, ID_Usuario, ID_Idioma) VALUES (?, ?, ?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, duvida.getPergunta());
            stmt.setString(2, duvida.getResposta());
            stmt.setLong(3, duvida.getIdUsuario());
            stmt.setLong(4, duvida.getIdIdioma());
            stmt.executeUpdate();
        }
    }

    public Duvidas readById(Long id) throws SQLException {
        String sql = "SELECT * FROM C_duvidas_frequentes WHERE ID_duvida = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Duvidas duvida = new Duvidas();
                    duvida.setId(rs.getLong("ID_duvida"));
                    duvida.setPergunta(rs.getString("Pergunta"));
                    duvida.setResposta(rs.getString("Resposta"));
                    duvida.setIdUsuario(rs.getLong("ID_Usuario"));
                    duvida.setIdIdioma(rs.getLong("ID_Idioma"));
                    return duvida;
                }
            }
        }
        return null;
    }

    public List<Duvidas> readAll() throws SQLException {
        String sql = "SELECT * FROM C_duvidas_frequentes";
        List<Duvidas> duvidasList = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Duvidas duvida = new Duvidas();
                duvida.setId(rs.getLong("ID_duvida"));
                duvida.setPergunta(rs.getString("Pergunta"));
                duvida.setResposta(rs.getString("Resposta"));
                duvida.setIdUsuario(rs.getLong("ID_Usuario"));
                duvida.setIdIdioma(rs.getLong("ID_Idioma"));
                duvidasList.add(duvida);
            }
        }
        return duvidasList;
    }

    public void update(Duvidas duvida) throws SQLException {
        String sql = "UPDATE C_duvidas_frequentes SET Pergunta = ?, Resposta = ?, ID_Usuario = ?, ID_Idioma = ? WHERE ID_duvida = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, duvida.getPergunta());
            stmt.setString(2, duvida.getResposta());
            stmt.setLong(3, duvida.getIdUsuario());
            stmt.setLong(4, duvida.getIdIdioma());
            stmt.setLong(5, duvida.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM C_duvidas_frequentes WHERE ID_duvida = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
