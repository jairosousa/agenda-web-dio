package io.jairosousa.agendaweb.service.impl;

import io.jairosousa.agendaweb.model.Contato;
import io.jairosousa.agendaweb.model.ContatoReposirory;
import io.jairosousa.agendaweb.model.Telefone;
import io.jairosousa.agendaweb.model.TelefoneReposirory;
import io.jairosousa.agendaweb.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Autor Jairo Nascimento
 * @Created 30/12/2021 - 09:15
 */
@Service
public class Telefones implements TelefoneService {

    @Autowired
    private TelefoneReposirory telefoneReposirory;

    @Autowired
    private ContatoReposirory contatoReposirory;

    @Override
    public Set<Telefone> findAllByContatoId(Long id) {
        return telefoneReposirory.findByContato_Id(id);
    }

    @Override
    public Iterable<Telefone> findAll() {
        return telefoneReposirory.findAll();
    }
}
