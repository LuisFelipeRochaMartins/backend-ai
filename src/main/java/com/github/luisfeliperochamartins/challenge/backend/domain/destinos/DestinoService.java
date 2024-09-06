package com.github.luisfeliperochamartins.challenge.backend.domain.destinos;

import com.github.luisfeliperochamartins.challenge.backend.ai.TextGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoService {

	private final DestinoRepository repository;
	private final TextGenerator generator;

	@Autowired
	public DestinoService(DestinoRepository repository, TextGenerator generator) {
		this.repository = repository;
		this.generator = generator;
	}

	public Destino insert(DestinoRecord record) {
		if (record.descricao() == null) {
			var destino = createDestinoWithDescription(record);
			var createdDestino = repository.save(destino);

			return createdDestino;
		}
		var destino = repository.save(new Destino(record));
		return destino;
	}

	private Destino createDestinoWithDescription(DestinoRecord record) {
		var descricao = generator.createText(record.nome());
		return new Destino(record.foto(), record.nome(), record.meta(), descricao, record.preco());
	}
}
