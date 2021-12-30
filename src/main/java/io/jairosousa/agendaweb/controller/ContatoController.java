package io.jairosousa.agendaweb.controller;

import io.jairosousa.agendaweb.model.Contato;
import io.jairosousa.agendaweb.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Autor Jairo Nascimento
 * @Created 30/12/2021 - 07:20
 */
@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public ResponseEntity<Contato> inserir(@RequestBody Contato contato) {
        contatoService.inserir(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(@PathVariable Long id, @RequestBody Contato contato) {
        contatoService.atualizar(id, contato);
        return ResponseEntity.status(HttpStatus.OK).body(contato);
    }

    @GetMapping
    public ResponseEntity<Iterable<Contato>> buscarTodos() {
        return ResponseEntity.ok(contatoService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contatoService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
