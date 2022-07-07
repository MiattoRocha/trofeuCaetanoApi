package com.trofeuCaetano.Controllers;

import com.trofeuCaetano.Models.Jogo;
import com.trofeuCaetano.Services.JogoService;
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
public class JogoController {

    @Autowired
    JogoService jogoService;

    @GetMapping("/jogos")
    public List<Jogo> mostrarTodosJogos() {
      List<Jogo>  jogos = jogoService.mostrarTodosJogos();
      return jogos;
    }

    @GetMapping("/jogos/{idJogo}")
    public ResponseEntity<Jogo> mostrarJogoPeloId(@PathVariable Integer idJogo) {
        Jogo jogo = jogoService.mostrarJogoPeloId(idJogo);
        return ResponseEntity.ok().body(jogo);
    }

    @PostMapping("/jogos")
    public ResponseEntity<Jogo> cadastrarJogo(@RequestBody Jogo jogo) {
        jogo = jogoService.cadastrarJogo(jogo);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(jogo.getIdJogo()).toUri();
        return ResponseEntity.created(novaUri).body(jogo);
    }

    @DeleteMapping("/jogos/{idJogo}")
    public ResponseEntity deletarJogo(@PathVariable Integer idJogo){
        jogoService.deletarJogo(idJogo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/jogos/{idJogo}")
    public ResponseEntity<Jogo> editarJogo (@PathVariable Integer idJogo, @RequestBody Jogo jogo) {
        jogo.setIdJogo(idJogo);
        jogoService.editarJogo(jogo);
        return ResponseEntity.ok().body(jogo);
    }

}
