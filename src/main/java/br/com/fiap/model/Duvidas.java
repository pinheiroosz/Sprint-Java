package br.com.fiap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "C_duvidas_frequentes")
public class Duvidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_duvida")
    private Long id;

    @Column(name = "Pergunta", nullable = false, length = 100)
    private String pergunta;

    @Column(name = "Resposta", length = 800)
    private String resposta;

    @Column(name = "ID_Usuario")
    private Long idUsuario;

    @Column(name = "ID_Idioma")
    private Long idIdioma;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }
}
