package com.trofeuCaetano.Services;

import com.trofeuCaetano.Models.Apontamento;
import com.trofeuCaetano.Models.Jogador;
import com.trofeuCaetano.Models.Jogo;
import com.trofeuCaetano.Repositories.ApontamentoRepository;
import com.trofeuCaetano.Repositories.JogadorRepository;
import com.trofeuCaetano.Repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ApontamentoService {

    @Autowired
    ApontamentoRepository apontamentoRepository;

    @Autowired
    JogadorRepository jogadorRepository;

    @Autowired
    JogoRepository jogoRepository;

    public List<Apontamento> mostarTodosApontamentos() {
        return apontamentoRepository.findAll();
    }

    public Apontamento buscarApontamentoPeloId(Integer idApontamento) {
        Optional<Apontamento> apontamento = apontamentoRepository.findById(idApontamento);
        return apontamento.orElseThrow();
    }

    public void deletarApontamento(Integer idApontamento) {
        apontamentoRepository.deleteById(idApontamento);
    }

    public Apontamento cadastrarApontamento(Apontamento apontamento, Integer idJogador, Integer idJogo) {
        Optional<Jogador> jogador = jogadorRepository.findById(idJogador);
        Optional<Jogo> jogo = jogoRepository.findById(idJogo);

        apontamento.setIdApontamento(null);
        apontamento.setJogador(jogador.get());
        apontamento.setJogo(jogo.get());
        return apontamentoRepository.save(apontamento);
    }

    public Apontamento editarApontamento(Apontamento apontamento, Integer idApontamento) {
        Apontamento apontamentoAnterior = buscarApontamentoPeloId(idApontamento);
        Jogador jogador = apontamentoAnterior.getJogador();
        Jogo jogo = apontamentoAnterior.getJogo();

        apontamento.setJogador(jogador);
        apontamento.setJogo(jogo);
        return apontamentoRepository.save(apontamento);
    }

    public List<Apontamento> buscarPorPeriodo(Date data1, Date data2) {
        return apontamentoRepository.findByIntervaloData(data1, data2);
    }
}
