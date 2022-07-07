package com.trofeuCaetano.Controllers;

import com.trofeuCaetano.Models.Jogador;
import com.trofeuCaetano.Services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping()
public class JogadorController {

    @Autowired
    JogadorService jogadorService;

    @GetMapping("/jogadores")
    public List<Jogador> mostarTodosJogadores() {
        List<Jogador> jogadores = jogadorService.mostrarTodosJogadores();
        return jogadores;
    }

    @GetMapping("/jogadores/{idJogador}")
    public ResponseEntity<Jogador> mostrarJogadorPeloId(@PathVariable Integer idJogador) {
        Jogador jogador = jogadorService.mostrarJogadorPeloId(idJogador);
        return ResponseEntity.ok().body(jogador);
    }

    @PostMapping("/jogadores")
    public ResponseEntity<Jogador> cadastrarJogador(@RequestBody Jogador jogador)
    {

        jogador = jogadorService.cadastrarJogador(jogador);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(jogador.getIdJogador()).toUri();
        return ResponseEntity.created(novaUri).body(jogador);
    }

    @DeleteMapping("/jogadores/{idJogador}")
    public ResponseEntity deletarJogador (@PathVariable Integer idJogador) {
        jogadorService.deletarJogador(idJogador);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jogadores/{idJogador}")
    public ResponseEntity<Jogador> editarJogador (@PathVariable Integer idJogador, @RequestBody Jogador jogador) {
        jogador.setIdJogador(idJogador);
        jogadorService.editarJogador(jogador);
        return ResponseEntity.ok().body(jogador);
    }
}
