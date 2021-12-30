package io.jairosousa.agendaweb.controller;

import io.jairosousa.agendaweb.model.Telefone;
import io.jairosousa.agendaweb.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @Autor Jairo Nascimento
 * @Created 30/12/2021 - 07:20
 */
@RestController
@RequestMapping("telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping("/{id}")
    public ResponseEntity<Set<Telefone>> buscarTodosPorContatoId(@PathVariable Long id) {
        return ResponseEntity.ok(telefoneService.findAllByContatoId(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Telefone>> buscarTodos() {
        return ResponseEntity.ok(telefoneService.findAll());
    }

}
