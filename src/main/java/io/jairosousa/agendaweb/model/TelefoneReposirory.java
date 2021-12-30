package io.jairosousa.agendaweb.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * @Autor Jairo Nascimento
 * @Created 30/12/2021 - 07:55
 */
public interface TelefoneReposirory extends CrudRepository<Telefone, Long> {

    Set<Telefone> findByContato_Id(Long id);
}
