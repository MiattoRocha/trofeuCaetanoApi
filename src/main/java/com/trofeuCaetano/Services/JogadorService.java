package com.trofeuCaetano.Services;

import com.trofeuCaetano.Models.Jogador;
import com.trofeuCaetano.Repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    public List<Jogador> mostrarTodosJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador mostrarJogadorPeloId(Integer idJogador) {
        Optional<Jogador> jogador = jogadorRepository.findById(idJogador);
        return jogador.orElseThrow();
    }

    public Jogador cadastrarJogador(Jogador jogador) {
        jogador.setIdJogador(null);
        return jogadorRepository.save(jogador);
    }

    public void deletarJogador(Integer idJogador) {
        jogadorRepository.deleteById(idJogador);
    }

    public Jogador editarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }
}
