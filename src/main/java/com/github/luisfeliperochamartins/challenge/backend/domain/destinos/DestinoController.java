package com.github.luisfeliperochamartins.challenge.backend.domain.destinos;

import com.github.luisfeliperochamartins.challenge.backend.config.error.errors.NotFoundError;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/destinos")
public class DestinoController {

	private final DestinoRepository repository;

	@Autowired
	public DestinoController(DestinoRepository repository) {
		this.repository = repository;
	}

	@GetMapping(path = "/{nome}")
	public ResponseEntity<DestinoRecord> getByNome(@PathVariable String nome) {
		var destino = repository.findByNomeIgnoreCase(nome).orElseThrow(() -> new NotFoundError("Nenhum destino foi encontrado!"));

		return ResponseEntity.ok(new DestinoRecord(destino));
	}

	@GetMapping
	public ResponseEntity<Page<DestinoRecord>> getAll(@PageableDefault Pageable page) {
		var list = repository.findAll(page).map(DestinoRecord::new);

		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<DestinoRecord> insert(@RequestBody DestinoRecord record, UriComponentsBuilder uriBuilder) {
		var destino = repository.save(new Destino(record));

		var uri = uriBuilder.path("/destinos/{id}").buildAndExpand(destino.getId()).toUri();

		return ResponseEntity.created(uri).body(new DestinoRecord(destino));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DestinoRecord> update(@RequestBody DestinoUpdateRecord record) {
		var destino = repository.findById(record.id()).orElseThrow(() -> new NotFoundError("Nenhum destino foi encontrado!"));

		destino.update(record);
		return ResponseEntity.ok(new DestinoRecord(destino));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		var destino = repository.findById(id).orElseThrow(() -> new NotFoundError("Nenhum destino foi encontrado!"));

		repository.delete(destino);
		return ResponseEntity.noContent().build();
	}
}
