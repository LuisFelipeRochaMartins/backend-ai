package com.github.luisfeliperochamartins.challenge.backend.domain.depoimento;

import com.github.luisfeliperochamartins.challenge.backend.config.error.errors.NotFoundError;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/depoimentos")
public class DepoimentoController {

	private final DepoimentoRepository repository;

	@Autowired
	public DepoimentoController(DepoimentoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<Page<DepoimentoRecord>> getAll(@PageableDefault Pageable page) {
		var list = repository.findAll(page).map(DepoimentoRecord::new);

		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "/home")
	public ResponseEntity<List<DepoimentoRecord>> findThree(@PageableDefault Pageable page) {
		var list = repository.findThreeRandom().stream().map(DepoimentoRecord::new).toList();

		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<DepoimentoRecord> getById(@PathVariable Integer id) {
		var depoimento = repository.findById(id).orElseThrow(() -> new NotFoundError("Depoimento não encontrado!"));

		return ResponseEntity.ok(new DepoimentoRecord(depoimento));
	}

	@PostMapping
	public ResponseEntity<DepoimentoRecord> insert(@RequestBody @Valid  DepoimentoRecord record, UriComponentsBuilder uriBuilder) {
		var depoimento = repository.save(new Depoimento(record));

		var uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimento.getId()).toUri();

		return ResponseEntity.created(uri).body(new DepoimentoRecord(depoimento));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DepoimentoRecord> update(@RequestBody @Valid DepoimentoUpdateRecord record) {
		var depoimento = repository.findById(record.id()).orElseThrow(() -> new NotFoundError("Depoimento não encontrado!"));

		depoimento.update(record);
		return ResponseEntity.ok(new DepoimentoRecord(depoimento));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		var depoimento = repository.findById(id).orElseThrow(() -> new NotFoundError("Depoimento não encontrado!"));

		repository.delete(depoimento);

		return ResponseEntity.noContent().build();
	}
}
