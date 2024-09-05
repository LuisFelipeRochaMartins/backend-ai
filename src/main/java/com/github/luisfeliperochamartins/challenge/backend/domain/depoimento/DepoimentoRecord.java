package com.github.luisfeliperochamartins.challenge.backend.domain.depoimento;

import jakarta.validation.constraints.NotBlank;

public record DepoimentoRecord(@NotBlank String fotoUrl,
                               @NotBlank String depoimento,
                               @NotBlank String nomePessoa) {

	public DepoimentoRecord(Depoimento depoimento) {
		this(depoimento.getFotoUrl(), depoimento.getDepoimento(), depoimento.getNomePessoa());
	}
}
