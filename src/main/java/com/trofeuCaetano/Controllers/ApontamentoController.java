package com.trofeuCaetano.Controllers;

import com.trofeuCaetano.Models.Apontamento;
import com.trofeuCaetano.Services.ApontamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping()
public class ApontamentoController {

    @Autowired
    ApontamentoService apontamentoService;

    @GetMapping("/apontamentos")
    public List<Apontamento> mostrarApontamento() {
        List<Apontamento> apontamento = apontamentoService.mostarTodosApontamentos();
        return apontamento;
    }

    @GetMapping("/apontamentos/{idApontamento}")
    public ResponseEntity<Apontamento> mostrarApontamentoPeloId(@PathVariable Integer idApontamento) {
        Apontamento apontamento = apontamentoService.buscarApontamentoPeloId(idApontamento);
        return ResponseEntity.ok().body(apontamento);
    }

    @PostMapping("/apontamentos/jogador/{idJogador}/jogo/{idJogo}")
    public ResponseEntity<Apontamento> cadastrarApontamento(@PathVariable Integer idJogador,
                                                            @PathVariable Integer idJogo,
                                                            @RequestBody Apontamento apontamento) {
        apontamento = apontamentoService.cadastrarApontamento(apontamento, idJogador, idJogo);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(apontamento.getIdApontamento()).toUri();
        return ResponseEntity.created(novaUri).body(apontamento);
    }

    @DeleteMapping("/apontamentos/{idApontamento}")
    public ResponseEntity deletarApontamento(@PathVariable Integer idApontamento) {
        apontamentoService.deletarApontamento(idApontamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/apontamentos/{idApontamento}")
    public ResponseEntity<Apontamento> editarApontamento (@PathVariable Integer idApontamento, @RequestBody Apontamento apontamento){
        apontamento.setIdApontamento(idApontamento);
        apontamentoService.editarApontamento(apontamento, idApontamento);
        return ResponseEntity.ok().body(apontamento);
    }

    @GetMapping("/ApontamentoPorIntervaloData")
    public List<Apontamento> buscarPorIntervaloData(@RequestParam("data1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data1,
                                                @RequestParam("data2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data2){
        List<Apontamento> apontamentos = apontamentoService.buscarPorPeriodo(data1,data2);
        return apontamentos;
    }
}
