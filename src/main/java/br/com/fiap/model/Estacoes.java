package br.com.fiap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "C_Estacoes")
public class Estacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Estacoes")
    private Long id;

    @Column(name = "Nome_estacao", nullable = false, unique = true, length = 50)
    private String nomeEstacao;

    @Column(name = "Status", nullable = false, length = 10)
    private String status;

    @Column(name = "ID_Usuario")
    private Long idUsuario;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
