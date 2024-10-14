package br.itb.projeto.sosmecanica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.sosmecanica.model.entity.Mecanico;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

}
