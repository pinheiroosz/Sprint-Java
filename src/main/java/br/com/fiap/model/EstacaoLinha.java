package br.com.fiap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "C_Estacao_Linha")
public class EstacaoLinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Estacao_Linha")
    private Long id;

    @Column(name = "ID_Estacoes")
    private Long idEstacoes;

    @Column(name = "ID_Linha")
    private Long idLinha;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEstacoes() {
        return idEstacoes;
    }

    public void setIdEstacoes(Long idEstacoes) {
        this.idEstacoes = idEstacoes;
    }

    public Long getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(Long idLinha) {
        this.idLinha = idLinha;
    }
}
