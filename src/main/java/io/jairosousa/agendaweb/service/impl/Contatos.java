package io.jairosousa.agendaweb.service.impl;

import io.jairosousa.agendaweb.model.Contato;
import io.jairosousa.agendaweb.model.ContatoReposirory;
import io.jairosousa.agendaweb.model.Telefone;
import io.jairosousa.agendaweb.model.TelefoneReposirory;
import io.jairosousa.agendaweb.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 30/12/2021 - 07:12
 */
@Service
public class Contatos implements ContatoService {

    @Autowired
    private ContatoReposirory contatoReposirory;

    @Autowired
    private TelefoneReposirory telefoneReposirory;

    @Override
    public Iterable<Contato> buscarTodos() {
        return contatoReposirory.findAll();
    }

    @Override
    public Optional<Contato> buscarPorId(Long id) {
        return contatoReposirory.findById(id);
    }

    @Override
    public void inserir(Contato contato) {
        contatoReposirory.save(contato);
        Set<Telefone> telefones = contato.getTelefones().stream()
                .map(telefone -> {
                    telefone.setContato(contato);
                    return telefone;
                })
                .collect(Collectors.toSet());
        telefoneReposirory.saveAll(telefones);
    }

    @Override
    public void atualizar(Long id, Contato contato) {
        Optional<Contato> optionalContato = buscarPorId(id);
        if (optionalContato.isPresent()) {
            Contato contatoUpdate = optionalContato.get();
            updateData(contato, contatoUpdate);
            contatoReposirory.save(contatoUpdate);
        }
    }

    private void updateData(Contato contato, Contato contatoUpdate) {
        contatoUpdate.setEmail(contato.getEmail());
        contatoUpdate.setNome(contato.getNome());
    }

    @Override
    public void deletar(Long id) {
        Optional<Contato> contato = buscarPorId(id);
        contatoReposirory.delete(contato.get());
    }

}
