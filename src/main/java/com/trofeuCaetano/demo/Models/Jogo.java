package com.trofeuCaetano.demo.Models;

import jdk.jfr.Enabled;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Enabled
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJogo;

    @Column(nullable = false)
    private String nomeJogo;

    @Column(nullable = false)
    private String icone;
}
