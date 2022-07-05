package com.trofeuCaetano.demo.Models;

import javax.persistence.*;

@Entity
public class Apontamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idApontamento;

    @Column(nullable = false)
    private Integer tentativas;

    @ManyToOne
    @JoinColumn(name = "idJogador")
    private Jogador jogador;

    @ManyToOne
    @JoinColumn(name = "idJogo")
    private Jogo jogo;

    public Integer getIdApontamento() {
        return idApontamento;
    }

    public void setIdApontamento(Integer idApontamento) {
        this.idApontamento = idApontamento;
    }

    public Integer getTentativas() {
        return tentativas;
    }

    public void setTentativas(Integer tentativas) {
        this.tentativas = tentativas;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
