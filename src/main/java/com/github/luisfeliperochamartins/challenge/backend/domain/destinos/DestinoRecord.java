package com.github.luisfeliperochamartins.challenge.backend.domain.destinos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record DestinoRecord(@NotBlank String foto,
                            @NotBlank String nome,
                            @NotBlank BigDecimal preco) {

	public DestinoRecord(Destino destino) {
		this(destino.getFoto(), destino.getNome(), destino.getPreco());
	}
}
