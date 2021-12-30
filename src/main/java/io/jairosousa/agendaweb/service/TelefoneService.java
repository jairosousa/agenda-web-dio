package io.jairosousa.agendaweb.service;

import io.jairosousa.agendaweb.model.Telefone;

import java.util.List;
import java.util.Set;

/**
 * @Autor Jairo Nascimento
 * @Created 30/12/2021 - 09:10
 */
public interface TelefoneService {

    Set<Telefone> findAllByContatoId(Long id);

    Iterable<Telefone> findAll();
}
