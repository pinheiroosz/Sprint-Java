package br.com.fiap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "C_Linhas")
public class Linhas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Linha")
    private Long id;

    @Column(name = "Nome_linha", nullable = false, unique = true, length = 50)
    private String nomeLinha;

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

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
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
