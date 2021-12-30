package io.jairosousa.agendaweb.service;

import io.jairosousa.agendaweb.model.Contato;

import java.util.Optional;

/**
 * @Autor Jairo Nascimento
 * @Created 30/12/2021 - 07:11
 */
public interface ContatoService {

    Iterable<Contato> buscarTodos();

    Optional<Contato> buscarPorId(Long id);

    void inserir(Contato Contato);

    void atualizar(Long id, Contato Contato);

    void deletar(Long id);
}
