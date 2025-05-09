package br.com.fiap.services;

import br.com.fiap.dao.DuvidasDAO;
import br.com.fiap.model.Duvidas;
import br.com.fiap.exceptions.EntityNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class DuvidasService {

    private final DuvidasDAO duvidasDAO = new DuvidasDAO();

    public void create(Duvidas duvida) throws SQLException {
        if (duvida.getPergunta() == null || duvida.getPergunta().isEmpty()) {
            throw new IllegalArgumentException("A pergunta é obrigatória.");
        }
        duvidasDAO.create(duvida);
    }

    public Duvidas readById(Long id) throws SQLException {
        Duvidas duvida = duvidasDAO.readById(id);
        if (duvida == null) {
            throw new EntityNotFoundException("Dúvida não encontrada.");
        }
        return duvida;
    }

    public List<Duvidas> readAll() throws SQLException {
        return duvidasDAO.readAll();
    }

    public void update(Duvidas duvida) throws SQLException {
        if (duvida.getId() == null) {
            throw new IllegalArgumentException("O ID da dúvida é obrigatório.");
        }
        duvidasDAO.update(duvida);
    }

    public void delete(Long id) throws SQLException {
        if (duvidasDAO.readById(id) == null) {
            throw new EntityNotFoundException("Dúvida não encontrada.");
        }
        duvidasDAO.delete(id);
    }
}
