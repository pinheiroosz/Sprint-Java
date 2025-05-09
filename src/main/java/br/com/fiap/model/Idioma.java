package br.com.fiap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "C_Idioma")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Idioma")
    private Long id;

    @Column(name = "Idioma", nullable = false, length = 20)
    private String idioma;

    @Column(name = "ID_Usuario")
    private Long idUsuario;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
