package com.trofeuCaetano.Services;

import com.trofeuCaetano.Models.Jogo;
import com.trofeuCaetano.Repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    JogoRepository jogoRepository;

    public List<Jogo> mostrarTodosJogos() {
        return jogoRepository.findAll();
    }

    public Jogo mostrarJogoPeloId(Integer idJogo) {
        Optional<Jogo> jogo = jogoRepository.findById(idJogo);
        return jogo.orElseThrow();
    }

    public Jogo cadastrarJogo(Jogo jogo) {
        jogo.setIdJogo(null);
        return jogoRepository.save(jogo);
    }

    public void deletarJogo(Integer idJogo) { jogoRepository.deleteById(idJogo); }

    public Jogo editarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }
}
