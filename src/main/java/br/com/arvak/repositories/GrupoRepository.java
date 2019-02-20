package br.com.arvak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arvak.domain.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

}
