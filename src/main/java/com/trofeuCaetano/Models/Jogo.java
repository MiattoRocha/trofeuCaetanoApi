package com.trofeuCaetano.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJogo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String icone;
}
