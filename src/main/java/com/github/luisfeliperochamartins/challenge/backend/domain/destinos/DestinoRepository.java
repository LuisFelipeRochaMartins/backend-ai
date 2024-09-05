package com.github.luisfeliperochamartins.challenge.backend.domain.destinos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer> {

	Optional<Destino> findByNomeIgnoreCase(String nome);
}
