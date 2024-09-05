package com.github.luisfeliperochamartins.challenge.backend.domain.depoimento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Integer> {

	Page<Depoimento> findAll(Pageable page);

	@Query("""
			SELECT d
		    FROM Depoimento d
		    ORDER BY RANDOM()
		    LIMIT 3
			""")
	List<Depoimento> findThreeRandom();
}
